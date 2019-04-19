package com.website.springmvc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.website.springmvc.entities.Category;
import com.website.springmvc.service.CategoryService;
import com.website.springmvc.service.ProductService;


@Controller
@RequestMapping (value = "/category")
public class CategoryController {
	
	@Autowired
	private CategoryService categoryService;
	
	@Autowired
	private ProductService productService;
	
	@RequestMapping (value = "/", method = RequestMethod.GET, headers = "Accept=application/json")
	public ModelAndView onload() {
		ModelAndView model = new ModelAndView();
		model.setViewName("category");
		model.addObject("categories", categoryService.getAll());
		return model;
	}
	
	@RequestMapping(value = "/addCategory", method = RequestMethod.GET)
	public ModelAndView addCategory() {
		ModelAndView model = new ModelAndView();
		model.setViewName("categoryDetail");
		model.addObject("category", new Category());
		return model;
	}
	
	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public String save(@ModelAttribute("category") Category category) {
		if (category.getId() == null) {
			categoryService.add(category);
		} else {
			categoryService.update(category);
		}
		return "redirect:/category/";
	}
	
	@RequestMapping(value = "/getCategory", method = RequestMethod.GET)
	public ModelAndView getCategory(@RequestParam("id") Long id, @RequestParam("mode") String mode, ModelAndView model) {
		model.setViewName("productCategory");
		model.addObject("products", productService.getList(id));
		model.addObject("mode", mode);
		return model;
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public void delete(@PathVariable("id") Long id) {
		categoryService.deleteById(id);
	}
	
	/*@RequestMapping(value = "/test", method = RequestMethod.GET)
	public ModelAndView getProductsByCategory(@RequestParam("id") Long id) {
		ModelAndView model = new ModelAndView();
		model.setViewName("productCategory");
		model.addObject("products", productService.getList(id));
		return model;
	}*/
}
