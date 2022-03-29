package com.greatlearning.StudentManagementSystem.security;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.greatlearning.StudentManagementSystem.Entity.Roles;
import com.greatlearning.StudentManagementSystem.Entity.Users;

public class MyUserDetails implements UserDetails {

	@Autowired
	private Users users;

	public MyUserDetails(Users user) {
		this.users = user;
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		List<Roles> roles = users.getRoles();
		List<SimpleGrantedAuthority> authority = new ArrayList<>();
		for (Roles role : roles) {
			authority.add(new SimpleGrantedAuthority(role.getName()));
		}
		return authority;
	}

	@Override
	public String getPassword() {
		// TODO Auto-generated method stub
		return users.getPassword();
	}

	@Override
	public String getUsername() {
		// TODO Auto-generated method stub
		return users.getUsername();
	}

	@Override
	public boolean isAccountNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isEnabled() {
		// TODO Auto-generated method stub
		return true;
	}

}
