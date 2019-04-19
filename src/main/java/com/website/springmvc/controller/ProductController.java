package com.website.springmvc.controller;

import java.io.UnsupportedEncodingException;
import java.math.BigDecimal;
import java.security.Principal;
import java.util.Base64;
import java.util.Iterator;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.commons.CommonsMultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.website.springmvc.entities.Category;
import com.website.springmvc.entities.Order;
import com.website.springmvc.entities.OrderDetail;
import com.website.springmvc.entities.Product;
import com.website.springmvc.entities.User;
import com.website.springmvc.service.CategoryService;
import com.website.springmvc.service.ProductService;
import com.website.springmvc.service.UserService;

@Controller
@RequestMapping(value = "/product")
public class ProductController {

	@Autowired
	private ProductService productService;

	@Autowired
	private CategoryService categoryService;

	@Autowired
	private UserService userService;

	@RequestMapping(value = "/", method = RequestMethod.GET, headers = "Accept=application/json")
	public ModelAndView getProducts(@RequestParam(defaultValue = "0") Integer page, Integer offset,
			Principal principal) {
		ModelAndView model = new ModelAndView();

		String userName = principal.getName();
		System.out.println("User Name: " + userName);

		offset = (page - 1) * 5;

		List<Product> list = productService.getAll(offset);
		Long count = productService.count();
		Long pages = count / 5;
		
		Iterator<Product> productIter = list.iterator();
		while (productIter.hasNext()) {
			Product product = productIter.next();
			Long id = product.getCategory().getId();
			Category category = categoryService.getById(id);
			product.setCategory(category);
		}

		model.addObject("pages", pages);
		model.addObject("count", count);
		model.addObject("offset", offset);

		model.setViewName("product");
		model.addObject("products", list);
		model.addObject("categories", categoryService.getAll());
//		List<Category> listCategories = categoryService.getAll();
//		model.addObject("category", categoryService.getById(id);
		
		return model;
	}

	@RequestMapping(value = "/pet", method = RequestMethod.GET)
	public ModelAndView showProductByCategory(HttpSession session, @RequestParam("name") String name,
			@RequestParam(defaultValue = "0") Integer page, Integer offset) {
		ModelAndView model = new ModelAndView("category");
		Category category = categoryService.getByName(name);

		offset = (page - 1) * 6;
		List<Product> products = (List<Product>) productService.getByCategory(category, offset);
		Iterator<Product> productIter = products.iterator();
		while (productIter.hasNext()) {
			Product product = productIter.next();
			Long id = product.getUser().getId();
			User user = userService.getById(id);
			product.setUser(user);
		}

		Long count = productService.count();

		Long pages = (long) products.size() / 6;

		model.addObject("pages", pages);
		model.addObject("count", count);
		model.addObject("offset", offset);

		model.addObject("products", products);
		model.addObject("category", category);
		model.addObject("categories", categoryService.getAll());
		return model;
	}

	@RequestMapping(value = "/addProduct", method = RequestMethod.GET)
	public ModelAndView addProduct() {
		ModelAndView model = new ModelAndView();
		model.setViewName("productDetail");
		model.addObject("product", new Product());
		model.addObject("categories", categoryService.getAll());
		return model;
	}

	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public String saveProduct(@ModelAttribute("product") Product product, HttpServletRequest request,
			@RequestParam("fileUpload") CommonsMultipartFile[] fileUpload) throws Exception {
		if (product.getId() == null) {
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
		} else {
			if (fileUpload != null && fileUpload.length > 0) {
				for (CommonsMultipartFile aFile : fileUpload) {

					System.out.println("Saving file: " + aFile.getOriginalFilename());

					product.setImages(aFile.getBytes());
					byte[] encodeBase64 = Base64.getEncoder().encode(aFile.getBytes());
					String base64Encoded = new String(encodeBase64, "UTF-8");
					product.setBase64ImageFile(base64Encoded);
				}
			}
			productService.update(product);
		}

		return "redirect:/product/";
	}

	@RequestMapping(value = "/getProduct", method = RequestMethod.GET)
	public ModelAndView getProduct(@RequestParam("id") Long id, @RequestParam("mode") String mode,
			@RequestParam("name") String name, @ModelAttribute("product") Product product, ModelAndView model,
			HttpServletRequest request) throws UnsupportedEncodingException {
		model.setViewName("productDetail");
		model.addObject("categories", categoryService.getAll());
		model.addObject("category", categoryService.getByName(name));
		model.addObject("product", productService.getById(id));
		model.addObject("mode", mode);
		return model;
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public void delete(@PathVariable("id") Long id) {
		productService.deleteById(id);
	}

	@RequestMapping(value = "/cart", method = RequestMethod.GET)
	public ModelAndView viewCart() {
		ModelAndView model = new ModelAndView("cart1");
		model.addObject("categories", categoryService.getAll());

		return model;
	}

	@RequestMapping(value = "/search", method = RequestMethod.POST)
	public ModelAndView getProduct(@RequestParam("categoryID") Long id, @RequestParam("searchForm") String search) {

		ModelAndView model = new ModelAndView();

		System.out.println(id);
		System.out.println(search);

		List<Product> list = productService.getProductSearchCriteria(search, id);

		model.setViewName("category");
		model.addObject("products", list);

		return model;
	}

	@RequestMapping(value = "/add", method = RequestMethod.GET)
	public String addCart(@RequestParam("id") Long id, @RequestParam("name") String categoryName, HttpSession session) {

		ModelAndView mav = new ModelAndView();
		Order order = (Order) session.getAttribute("order");
		if (order == null) {
			order = new Order();
		}
		Product product = productService.getById(id);
		if (product != null) {
			order = createOrderDetail(order, product);
		}
		int countCart = order.getListOrderDetail().size();
		session.setAttribute("countCart", countCart);
		session.setAttribute("order", order);
		mav.addObject("order", order);
		return "redirect:/product/pet?name=" + categoryName;
	}

	private Order createOrderDetail(Order order, Product product) {
		List<OrderDetail> details = order.getListOrderDetail();
		boolean isExit = false;
		BigDecimal totalPrice = new BigDecimal(0);
		for (OrderDetail detail : details) {
			if (detail.getProduct().getId().equals(product.getId())) {
				detail.setQuantity(detail.getQuantity() + 1);
				detail.setTotal(new BigDecimal(detail.getQuantity()).multiply(product.getPrice()));
				isExit = true;
			}
			totalPrice = totalPrice.add(detail.getTotal());
		}
		if (isExit == false) {
			OrderDetail orderDetail = new OrderDetail();
			orderDetail.setProduct(product);
			orderDetail.setQuantity(1);
			orderDetail.setTotal(product.getPrice());
			details.add(orderDetail);
			totalPrice = totalPrice.add(orderDetail.getTotal());
		}
		order.setListOrderDetail(details);
		order.setTotalPrice(totalPrice);
		return order;
	}

	@RequestMapping(value = "/remove")
	public String removeCart(@RequestParam Long id, HttpSession session, Product product, Order order) {
		order = (Order) session.getAttribute("order");
		int countCart = (int) session.getAttribute("countCart");
		if (order != null) {
			order = removeCartItem(order, id);
			session.setAttribute("countCart", countCart - 1);
			session.setAttribute("order", order);
		}
		return "redirect:/product/cart";
	}

	@RequestMapping(value = "/removeCart")
	public String removeCartOnIndex(@RequestParam Long id, @RequestParam("name") String categoryName,
			HttpSession session, Product product, Order order) {
		order = (Order) session.getAttribute("order");
		int countCart = (int) session.getAttribute("countCart");
		if (order != null) {
			order = removeCartItem(order, id);
			session.setAttribute("countCart", countCart - 1);
			session.setAttribute("order", order);
		}
		return "redirect:/product/pet?name=" + categoryName;
	}

	private Order removeCartItem(Order order, Long id) {
		List<OrderDetail> details = order.getListOrderDetail();
		BigDecimal total = new BigDecimal(0);
		Iterator<OrderDetail> detailIter = details.iterator();
		while (detailIter.hasNext()) {
			OrderDetail detail = detailIter.next();
			if (detail.getProduct().getId().equals(id)) {
				detailIter.remove();
				continue;
			}
			total = total.add(detail.getProduct().getPrice().multiply(new BigDecimal(detail.getQuantity())));
			order.setTotalPrice(total);
		}
		if (details.isEmpty())
			order.setTotalPrice(new BigDecimal(0));
		order.setListOrderDetail(details);
		return order;
	}

	@RequestMapping(value = "/update")
	public ModelAndView updateCart(@RequestParam Long id, @RequestParam int quantity, HttpSession session) {
		ModelAndView mav = new ModelAndView("cart");
		Order order = (Order) session.getAttribute("order");
		if (order != null) {
			BigDecimal total = updateCartItem(order, id, quantity);
			order.setTotalPrice(total);
			session.setAttribute("order", order);
		}
		mav.addObject("order", order);
		return mav;
	}

	private BigDecimal updateCartItem(Order order, Long id, int quantity) {
		List<OrderDetail> details = order.getListOrderDetail();
		BigDecimal total = new BigDecimal(0);
		for (OrderDetail detail : details) {
			if (detail.getProduct().getId().equals(id)) {
				detail.setQuantity(quantity);
				detail.setTotal(new BigDecimal(detail.getQuantity()).multiply(detail.getProduct().getPrice()));
			}
			total = total.add(detail.getProduct().getPrice().multiply(new BigDecimal(detail.getQuantity())));
		}
		return total;
	}
}
