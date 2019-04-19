package com.website.springmvc.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.website.springmvc.DAO.UserRoleDAO;
import com.website.springmvc.entities.UserRole;

@Service
@Transactional
public class UserRoleService {

	@Autowired
	private UserRoleDAO userRoleDAO;
	
	public List<UserRole> getUserRoles(Long id){
		return userRoleDAO.getUserRoles(id);
	}
	
	public UserRole add(UserRole userRole) {
		return userRoleDAO.add(userRole);
	}
}
