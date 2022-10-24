package com.basic.service.impl;

import com.basic.domain.Role;
import com.basic.domain.User;
import com.basic.repository.UserRepository;
import com.basic.service.AppUserDetail;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Set;
import java.util.concurrent.Callable;
import java.util.stream.Collectors;


@Service
public class UserService implements UserDetailsService {

	private static final Logger logger = LogManager.getLogger(UserService.class);


	@Autowired
	UserRepository userRepository;

	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
		User user=userRepository.findByEmail(email);
			if (user.equals(null)){
				throw new UsernameNotFoundException("User not found!!");
			}
		logger.info("user {}="+user);
		return new org.springframework.security.core.userdetails.User(user.getEmail(),user.getPassword(),getAuthorities(user.getRoles()));
	}

	private Collection<? extends GrantedAuthority> getAuthorities(Set<Role> roles) {
		List<GrantedAuthority> authorities = new ArrayList<>();
		for (Role role: roles) {
			authorities.add(new SimpleGrantedAuthority(role.getName()));
			roles.stream()
					.map(p -> new SimpleGrantedAuthority(p.getName()))
					.forEach(authorities::add);
		}
		return authorities;


	}



}
