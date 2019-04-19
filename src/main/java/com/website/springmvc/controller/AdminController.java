package com.website.springmvc.controller;

import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.website.springmvc.entities.Category;
import com.website.springmvc.entities.User;
import com.website.springmvc.service.CategoryService;
import com.website.springmvc.service.ProductService;
import com.website.springmvc.service.UserService;

@Controller
@Transactional
public class AdminController {

	@Autowired
	private UserService userService;
	
	@Autowired
	private ProductService productService;
	
	@Autowired
	private CategoryService categoryService;
	
	@RequestMapping(value = "/admin", method = RequestMethod.GET)
	public String adminPage(Model model, Principal principal) {
		
		User user = userService.getUserByUserName(principal.getName());
		System.out.println("User: " +user.getUserName());
		
		model.addAttribute("users", userService.getAllUser(null, null));
		model.addAttribute("products", productService.getAll(null));
		model.addAttribute("categories", categoryService.getAll());
		
		return "adminPage";
	}
	
	@RequestMapping(value = "/admin/getListUser", method = RequestMethod.GET)
	public String getListUser(Model model, Principal principal) {
		
		User user = userService.getUserByUserName(principal.getName());
		System.out.println("User: " +user.getUserName());
		
		model.addAttribute("users", userService.getAllUser(0, 0));
		
		return "userManagement";
	}
	
	@RequestMapping(value = "/admin/getUser", method = RequestMethod.GET)
	public ModelAndView getUser(@RequestParam("id") Long id, @RequestParam("role") String role,
			ModelAndView model, Principal principal) {
		
		User user = userService.getUserByUserName(principal.getName());
		System.out.println("User: " +user.getUserName());
		
		model.setViewName("userDetail");
		model.addObject("user", userService.getById(id));
		model.addObject("role", role);
		
		return model;
	}
	
	
	@RequestMapping(value = "/admin/addAdmin", method = RequestMethod.GET)
	public String addAdmin(Principal principal, Model model) {
		
		User user = userService.getUserByUserName(principal.getName());
		System.out.println("User: " +user.getUserName());
		
		model.addAttribute("user", new User());
		
		return "adminDetail";
	}
	
	@RequestMapping(value = "/admin/saveAdmin", method = RequestMethod.POST)
	public String saveAdmin(Principal principal, @ModelAttribute("user") User user) {
		
		User u = userService.getUserByUserName(principal.getName());
		System.out.println("User: " +u.getUserName());
		
		userService.add(user);
		
		return "redirect:/admin/getListUser";
	}
	
	@RequestMapping(value = "/admin/getListCategory", method = RequestMethod.GET)
	public String getListCategory(Principal principal, Model model) {
		
		User user = userService.getUserByUserName(principal.getName());
		System.out.println("User: " +user.getUserName());
		
		model.addAttribute("categories", categoryService.getAll());
		
		return "categoryManagement";
	}
	
	@RequestMapping(value = "/admin/addCategory", method = RequestMethod.GET)
	public String addCategory(Principal principal, Model model) {
		
		User user = userService.getUserByUserName(principal.getName());
		System.out.println("User: " +user.getUserName());
		
		model.addAttribute("category", new Category());
		
		return "categoryDetail";
	}
	
	@RequestMapping(value = "/admin/saveCategory", method = RequestMethod.POST)
	public String save(@ModelAttribute("category") Category category, Principal principal) {
		
		User user = userService.getUserByUserName(principal.getName());
		System.out.println("User: " +user.getUserName());
		
		categoryService.add(category);
		
		return "redirect:/admin/getListCategory";
	}
	
//	@RequestMapping(value = "/admin/getCategory", method = RequestMethod.GET)
//	public String getCategory(Principal principal, Model model, 
//			@RequestParam(value = "id") Long id) {
//		
//		User user = userService.getUserByUserName(principal.getName());
//		System.out.println("User: " +user.getUserName());
//		
//		model.addAttribute("category", categoryService.getCategoryByID(id));
//		
//		return "categoryDetail";
//	}
	
	@RequestMapping(value = "/admin/getListProduct", method = RequestMethod.GET)
	public String getListProduct(Principal principal, Model model) {
		
		User user = userService.getUserByUserName(principal.getName());
		System.out.println("User: " +user.getUserName());
		
		model.addAttribute("products", productService.getAll(null));
		model.addAttribute("categories", categoryService.getAll());
		
		return "productManagement";
	}
	
	@RequestMapping(value = "/admin/getProduct", method = RequestMethod.GET)
	public String getProduct(Principal principal, Model model, 
			@RequestParam(value = "id") Long id, @RequestParam(value = "role") String role) {
		
		User user = userService.getUserByUserName(principal.getName());
		System.out.println("User: " +user.getUserName());
		
		model.addAttribute("product", productService.getById(id));
		model.addAttribute("role", role);
		
		return "productDetailManagement";
	}
	
	// Done Done Done Done Done Done Done Done Done Done Done Done Done Done Done Done Done Done Done Done Done Done
	
//	@RequestMapping(value = "/admin/getListCart", method = RequestMethod.GET)
//	public String getListCart(Principal principal, Model model) {
//		
//		User user = userService.getUserByUserName(principal.getName());
//		System.out.println("User: " +user.getUserName());
//		
//		model.addAttribute("carts", cartService.getAll());
//		
//		return "cartManagement";
//	}
//	
//	@RequestMapping(value = "/admin/getCart", method = RequestMethod.GET)
//	public String getCart(Principal principal, Model model, 
//			@RequestParam(value = "id") Long id, @RequestParam(value = "role") String role) {
//		
//		User user = userService.getUserByUserName(principal.getName());
//		System.out.println("User: " +user.getUserName());
//		
//		model.addAttribute("cart", cartService.getCartByID(id));
//		model.addAttribute("role", role);
//		
//		return "cartDetail";
//	}
}
