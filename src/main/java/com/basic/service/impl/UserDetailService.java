package com.basic.service.impl;

import com.basic.repository.UserRepository;
import com.basic.service.UserDetails;
import org.springframework.beans.factory.annotation.Autowired;

import com.basic.domain.User;
import org.springframework.stereotype.Service;


@Service
public class UserDetailService implements UserDetails {

	@Autowired
	UserRepository userRepository;

	@Override
	public User findByEmail(String email) {
		User user=userRepository.findByEmail(email);
		return user;
	}

}
