package com.amos.lms.service;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.amos.lms.entities.Users;
import com.amos.lms.repositories.UserRepository;

@Service
public class CustomUserDetailsService implements UserDetailsService {

	@Autowired
	private UserRepository userRepository;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

		Users user = userRepository.findByUsername(username);
		
		if(user == null) {
			throw new UsernameNotFoundException(username +" not found");
		}
		return new CustomUserDetails(user.getUsername(), user.getPassword(), authorities(), user.getFullname());
	}
	
	public Collection<? extends GrantedAuthority> authorities(){
		return List.of(new SimpleGrantedAuthority("USER"));
	}

}
