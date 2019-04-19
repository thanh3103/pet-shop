package com.website.springmvc.controller;

import java.io.UnsupportedEncodingException;
import java.security.Principal;
import java.util.Base64;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.commons.CommonsMultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.website.springmvc.entities.Product;
import com.website.springmvc.entities.User;
import com.website.springmvc.service.CategoryService;
import com.website.springmvc.service.ProductService;
import com.website.springmvc.service.UserService;

@Controller
@RequestMapping(value = "/user")
public class UserController {

	@Autowired
	private CategoryService categoryService;

	@Autowired
	private UserService userService;

	@Autowired
	private ProductService productService;

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public ModelAndView loadUser(Principal principal) {
		ModelAndView model = new ModelAndView("user");
		String username = principal.getName();
		model.addObject("categories", categoryService.getAll());
		model.addObject("user", userService.getUserByUserName(username));
		return model;
	}

	@RequestMapping(value = "/post", method = RequestMethod.GET)
	public ModelAndView postPetSales(Principal principal) {
		ModelAndView model = new ModelAndView("postPet");
		model.addObject("product", new Product());
		String username = principal.getName();
		model.addObject("categories", categoryService.getAll());
		model.addObject("user", userService.getUserByUserName(username));
		return model;
	}

	@RequestMapping(value = "/post/save", method = RequestMethod.POST)
	public String save(Principal principal, @ModelAttribute("product") Product product,
			@RequestParam("fileUpload") CommonsMultipartFile[] fileUpload) throws UnsupportedEncodingException {
		String username = principal.getName();
		User user = userService.getUserByUserName(username);
		product.setUser(user);
		if (product.getId() == null)
			if (fileUpload != null && fileUpload.length > 0) {
				for (CommonsMultipartFile aFile : fileUpload) {

					System.out.println("Saving file: " + aFile.getOriginalFilename());

					product.setImages(aFile.getBytes());
					byte[] encodeBase64 = Base64.getEncoder().encode(aFile.getBytes());
					String base64Encoded = new String(encodeBase64, "UTF-8");
					product.setBase64ImageFile(base64Encoded);
					productService.add(product);
			}
		}
		return "redirect:/user/";
	}
	
	@RequestMapping(value = "/edit", method = RequestMethod.GET)
	public ModelAndView editUser(@RequestParam("username") String username) {
		ModelAndView model = new ModelAndView("userEdit");
		User user = userService.getUserByUserName(username);
		model.addObject("user", user);
		model.addObject("categories", categoryService.getAll());
		return model;
	}
	
	@RequestMapping(value = "edit/save", method = RequestMethod.POST)
	public String saveEditUser(@ModelAttribute("user") User user, Principal principal) {
		user.setUserName(principal.getName());
		user.setUserRole("ROLE_USER");
		userService.update(user);
		return "redirect:/user/";
	}
}
