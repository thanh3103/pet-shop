package com.website.springmvc.util;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

import com.website.springmvc.entities.User;
import com.website.springmvc.user.MySocialUserDetails;

public class SecurityUtil {
	// Tự động đăng nhập.
	public static void logInUser(User user) {
		MySocialUserDetails userDetails = new MySocialUserDetails(user);
		Authentication authentication = new UsernamePasswordAuthenticationToken(userDetails, null,
				userDetails.getAuthorities());
		SecurityContextHolder.getContext().setAuthentication(authentication);
	}
}
