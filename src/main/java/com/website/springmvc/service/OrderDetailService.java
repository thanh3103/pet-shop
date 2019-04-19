package com.website.springmvc.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.website.springmvc.DAO.DAO;
import com.website.springmvc.DAO.OrderDetailDAO;
import com.website.springmvc.entities.OrderDetail;

@Transactional
@Service
public class OrderDetailService {
	@Autowired
	OrderDetailDAO orderDetailDAO;
	
	public OrderDetail add(OrderDetail orderDetail) {
		return orderDetailDAO.add(orderDetail);
	}
	
}
