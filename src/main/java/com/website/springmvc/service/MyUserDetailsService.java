package com.website.springmvc.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.social.security.SocialUserDetails;
import org.springframework.stereotype.Service;

import com.website.springmvc.DAO.MyUserAccountDAO;
import com.website.springmvc.entities.User;
import com.website.springmvc.entities.UserRole;
import com.website.springmvc.user.MySocialUserDetails;

@Service
public class MyUserDetailsService implements UserDetailsService {

	@Autowired
	private UserService userService;

	@Autowired
	private UserRoleService userRoleService;

	@Autowired
	private MyUserAccountDAO myUserAccountDAO;

	public MyUserDetailsService() {

	}

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		if (username.length() > 3) {
			User user = userService.getUserByUserName(username);
			System.out.println("UserInfo= " + user);

			if (user == null) {
				throw new UsernameNotFoundException("User " + username + " was not found in the database");
			}
			Long id = user.getId();
			// [USER,ADMIN,..]
			List<UserRole> roles = userRoleService.getUserRoles(id);
			List<GrantedAuthority> grantList = new ArrayList<GrantedAuthority>();
			if (roles != null) {
				for (UserRole role : roles) {
					// ROLE_USER, ROLE_ADMIN,..
					GrantedAuthority authority = new SimpleGrantedAuthority(role.getRoleName());
					grantList.add(authority);
					System.out.println(authority);
				}
			}
			UserDetails userDetails = (UserDetails) new org.springframework.security.core.userdetails.User(user.getUserName(), user.getPassWord(), grantList);
			return userDetails;
		} else {
			Long id = Long.valueOf(username);
			User user = myUserAccountDAO.findById(id);
			if (user == null)
				throw new UsernameNotFoundException("No user found with userName: " + username);
			SocialUserDetails principal = new MySocialUserDetails(user);
			return principal;
		}

	}
}
