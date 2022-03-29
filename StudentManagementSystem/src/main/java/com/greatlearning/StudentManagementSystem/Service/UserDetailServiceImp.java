package com.greatlearning.StudentManagementSystem.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.greatlearning.StudentManagementSystem.Entity.Users;
import com.greatlearning.StudentManagementSystem.Repository.UserRepository;
import com.greatlearning.StudentManagementSystem.security.MyUserDetails;

public class UserDetailServiceImp implements UserDetailsService {

	public UserDetailServiceImp() {

	}

	@Autowired
	UserRepository userRepository;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Users user = userRepository.getUserByUserName(username);
		if (user == null) {
			throw new UsernameNotFoundException("UserName not found");
		}
		return new MyUserDetails(user);
	}

}
