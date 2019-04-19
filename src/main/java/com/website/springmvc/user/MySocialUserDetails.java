package com.website.springmvc.user;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.social.security.SocialUserDetails;

import com.website.springmvc.entities.User;

public class MySocialUserDetails implements SocialUserDetails {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private List<GrantedAuthority> list = new ArrayList<GrantedAuthority>();
	private User user;

	public MySocialUserDetails(User user) {
		this.user = user;
		String role = user.getUserRole();
		GrantedAuthority grant = new SimpleGrantedAuthority(role);
		this.list.add(grant);
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return list;
	}

	@Override
	public String getPassword() {
		return user.getPassWord();
	}

	@Override
	public String getUsername() {
		return user.getUserName();
	}

	@Override
	public boolean isAccountNonExpired() {
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}

	@Override
	public boolean isEnabled() {
		return true;
	}

	@Override
	public String getUserId() {
		return String.valueOf(this.user.getId());		
	}

}
