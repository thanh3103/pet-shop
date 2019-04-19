package com.website.springmvc.controller;

import java.security.Principal;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.website.springmvc.entities.OrderDetail;
import com.website.springmvc.entities.User;
import com.website.springmvc.entities.Order;
import com.website.springmvc.service.OrderDetailService;
import com.website.springmvc.service.OrderService;
import com.website.springmvc.service.UserService;

@Controller
@RequestMapping(value = "/order")
public class OrderController {

	@Autowired
	private OrderService orderService;

	@Autowired
	private UserService userService;

	@Autowired
	private OrderDetailService detailService;

	@RequestMapping(value = "/addOrder", method = RequestMethod.GET)
	public ModelAndView addOrder(HttpSession session, Order order, Principal principal) {
		ModelAndView model = new ModelAndView();
		String username = principal.getName();
		User user = userService.getUserByUserName(username);
		order = (Order) session.getAttribute("order");
		Date date = new Date();
		order.setCreateDate(date);
		order.setUser(user);
		if (order.getId() == null) {
			order = orderService.add(order);
		} else {
			orderService.update(order);
		}
		List<OrderDetail> orderDetails = order.getListOrderDetail();
		Iterator<OrderDetail> detailIter = orderDetails.iterator();
		while (detailIter.hasNext()) {
			OrderDetail detail = detailIter.next();
			detail.setOrder(order);
			detailService.add(detail);
		}
		model.addObject("order", order);
		model.setViewName("order");
		session.removeAttribute("countCart");
		session.removeAttribute("order");
		return model;
	}

}
