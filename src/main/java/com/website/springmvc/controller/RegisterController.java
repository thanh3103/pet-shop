package com.website.springmvc.controller;

import java.util.HashSet;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.website.springmvc.entities.User;
import com.website.springmvc.entities.UserRole;
import com.website.springmvc.service.UserRoleService;
import com.website.springmvc.service.UserService;

@Controller
@Transactional
@RequestMapping(value = "/register")
public class RegisterController {

	@Autowired
	private UserService userService;

	@Autowired
	private UserRoleService userRoleService;

	// @RequestMapping(value = "/", method = RequestMethod.GET)
	// public String loadRegister() {
	// return "register";
	// }

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public ModelAndView register() {
		ModelAndView model = new ModelAndView("register");
		model.addObject("user", new User());
		return model;
	}

	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public String saveUser(@ModelAttribute("user") User user) {
		user.setActive(true);
		UserRole userRole = new UserRole();
		userRole.setRoleName("ROLE_USER");
		Set<UserRole> userRoles = new HashSet<UserRole>();
		userRoles.add(userRole);
		user.setRoles(userRoles);
		user.setUserRole("ROLE_USER");
		if (user.getId() == null) {
			userService.add(user);
		}
		userRole.setUser(user);
		userRoleService.add(userRole);
		return "redirect:/";
	}

	@RequestMapping(value = "/register", method = RequestMethod.GET)
	@Transactional
	@ResponseBody
	public String checkUser(@RequestParam(required = false, value = "email") String email,
			@RequestParam(required = false, value = "userName") String username,
			@RequestParam(required = false, value = "firstName") String firstName,
			@RequestParam(required = false, value = "lastName") String lastName,
			@RequestParam(required = false, value = "age") String age,
			@RequestParam(required = false, value = "passWord") String passWord,
			@RequestParam(required = false, value = "phoneNo") String phoneNo, HttpServletResponse response,
			HttpServletRequest request) {

		String kq = "";
		while (true) {
			if (email == null)
				break;
			Pattern p = Pattern.compile(
					"^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@" + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$");
			Matcher m = p.matcher(email);
			if (email.isEmpty() == false) {
				if (m.find()) {
					if (userService.validateEmail(email)) {
						kq = "You can use this email";
					} else {
						kq = "This email already exists";
					}
				} else {
					kq = "Invalid email";
				}
			} else {
				kq = "Please input email";
			}
			break;
		}
		while (true) {
			if (username == null)
				break;
			if (username.isEmpty() == false) {
				if (userService.validateUser(username)) {
					kq = "You can use this username";
				} else {
					kq = "This username already exists";
				}
			} else {
				kq = "Please input username";
			}
			break;
		}
		while (true) {
			if (firstName == null)
				break;
			if (firstName.isEmpty() == true)
				kq = "Please input first name";
			break;
		}
		while (true) {
			if (lastName == null)
				break;
			if (lastName.isEmpty() == true)
				kq = "Please input last name";
			break;
		}
		while (true) {
			if (passWord == null)
				break;
			if (passWord.isEmpty() == true)
				kq = "Please input password";
			break;
		}
		while (true) {
			if (age == null)
				break;
			try {
				if (age.isEmpty() == false) {
					Long ageLong = Long.valueOf(age);
					if (ageLong < 6 || ageLong > 100)
						kq = "Please input age between 6 and 100";
				} else
					kq = "Please input age";
			} catch (NumberFormatException e) {
				kq = "Invalid age";
			}
			break;
		}
		while (true) {
			if (phoneNo == null)
				break;
			Pattern p1 = Pattern.compile("^0{0,1}[1-9]{1}[0-9]{7,11}$");
			Matcher m1 = p1.matcher(phoneNo);
			try {
				if (phoneNo.isEmpty() == false) {
					if (m1.find() == false)
						kq = "Wrong phone number";
				} else
					kq = "Please input phone number";
			} catch (Exception e) {
				kq = "Invalid phone number";
			}
			break;
		}
		return kq;
	}
}
