package com.website.springmvc.controller;

import java.security.Principal;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.social.connect.Connection;
import org.springframework.social.connect.ConnectionFactoryLocator;
import org.springframework.social.connect.UsersConnectionRepository;
import org.springframework.social.connect.web.ProviderSignInUtils;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.website.springmvc.DAO.MyUserAccountDAO;
import com.website.springmvc.entities.Order;
import com.website.springmvc.entities.User;
import com.website.springmvc.form.MyUserAccountForm;
import com.website.springmvc.service.CategoryService;
import com.website.springmvc.service.ProductService;
import com.website.springmvc.service.UserService;
import com.website.springmvc.util.SecurityUtil;

@Controller
@Transactional
@EnableWebMvc
public class MainController {

	@Autowired
	private UserService userService;

	@Autowired
	private CategoryService categoryService;

	@Autowired
	private MyUserAccountDAO myUserAccountDAO;

	@Autowired
	private ConnectionFactoryLocator connectionFactoryLocator;

	@Autowired
	private UsersConnectionRepository connectionRepository;

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public ModelAndView index(HttpSession session) {
		ModelAndView model = new ModelAndView("index");
		Order order = (Order) session.getAttribute("order");
		model.addObject("categories", categoryService.getAll());
		model.addObject("order", order);

		try {
			UserDetails userDetails = (UserDetails) SecurityContextHolder.getContext().getAuthentication()
					.getPrincipal();
			if (userDetails != null) {
				System.out.println(userDetails.getPassword());
				System.out.println(userDetails.getUsername());
				System.out.println(userDetails.isEnabled());

				model.addObject("userDetails", userDetails);
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		return model;
	}

	// Người dùng login bằng mạng xã hội,
	// nhưng không cho phép ứng dụng xem các thông tin cơ bản
	// ứng dụng sẽ chuyển hướng về trang /signin.
	@RequestMapping(value = { "/signin" }, method = RequestMethod.GET)
	public String signInPage(Model model) {
		return "redirect:/login";
	}

	@RequestMapping(value = { "/signup" }, method = RequestMethod.GET)
	public String signupPage(WebRequest request, Model model) {
		ProviderSignInUtils providerSignInUtils = new ProviderSignInUtils(connectionFactoryLocator,
				connectionRepository);

		// Nếu người dùng đăng nhập bằng mạng xã hội (Social),
		// Lấy ra thông tin mạng xã hội.
		Connection<?> connection = providerSignInUtils.getConnectionFromSession(request);
		MyUserAccountForm myForm = null;
		if (connection != null) {
			myForm = new MyUserAccountForm(connection);
		} else {
			myForm = new MyUserAccountForm();
		}
		model.addAttribute("myForm", myForm);
		return "signup";
	}

	@RequestMapping(value = { "/signup" }, method = RequestMethod.POST)
	public String signupSave(WebRequest request, Model model,
			@ModelAttribute("myForm") @Validated MyUserAccountForm accountForm, BindingResult result,
			final RedirectAttributes redirectAttributes) {
		// Nếu validate có lỗi.
		if (result.hasErrors()) {
			return "signup";
		}
		User registered = null;

		try {
			registered = myUserAccountDAO.registerNewUserAccount(accountForm);
		} catch (Exception ex) {
			ex.printStackTrace();
			model.addAttribute("errorMessage", "Error " + ex.getMessage());
			return "signup";
		}

		if (accountForm.getSignInProvider() != null) {
			ProviderSignInUtils providerSignInUtils = new ProviderSignInUtils(connectionFactoryLocator,
					connectionRepository);
			// Nếu người dùng đăng nhập bởi mạng xã hội. Phương thức này
			// lưu thông tin mạng xã hội vào bảng UserConnection.
			providerSignInUtils.doPostSignUp(String.valueOf(registered.getId()), request);
		}
		// Sau khi đăng ký xong, đăng nhập vào.
		SecurityUtil.logInUser(registered);
		return "redirect:/userInfo";
	}

	// @RequestMapping(value = { "/userInfo" }, method = RequestMethod.GET)
	// public String userInfoPage(WebRequest request, Model model) {
	// return "userInfo";
	// }

	// @RequestMapping(value = "/", method = RequestMethod.POST)
	// public ModelAndView index(@RequestParam("userName") String userName,
	// @RequestParam("passWord") String passWord, Principal pricipal) {
	// ModelAndView model = new ModelAndView("index");
	// System.out.println(pricipal);
	// System.out.println(userName);
	// return model;
	// }

	@RequestMapping(value = "/userInfo", method = RequestMethod.GET, headers = "Accept=application/json")
	public ModelAndView getStudents(ModelAndView model, Principal principal) {

		String userName = principal.getName();
		System.out.println("User Name: " + userName);

		model.setViewName("userInfoPage");
		model.addObject("user", userService.getUserByUserName(userName));

		return model;
	}

	// @RequestMapping(value = { "/", "/welcome" }, method = RequestMethod.GET)
	// public ModelAndView welcomePage() {
	// ModelAndView model = new ModelAndView();
	//
	// model.setViewName("welcomePage");
	// model.addObject("title", "Welcome");
	// model.addObject("message", "This is welcome page!");
	//
	// return model;
	// }

//	@RequestMapping(value = "/admin", method = RequestMethod.GET)
//	public String adminPage(Model model) {
//		return "adminPage";
//	}

	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String loginPage(Model model) {

		return "login";
	}

	@RequestMapping(value = "/logoutSuccessful", method = RequestMethod.GET)
	public String logoutSuccessfulPage(Model model) {
		model.addAttribute("title", "Logout");
		return "logoutSuccessfulPage";
	}

	@RequestMapping(value = "/403", method = RequestMethod.GET)
	public String accessDenied(Model model, Principal principal) {

		if (principal != null) {
			model.addAttribute("message",
					"Hi " + principal.getName() + "<br> You do not have permission to access this page!");
		} else {
			model.addAttribute("msg", "You do not have permission to access this page!");
		}
		return "403Page";
	}

}
