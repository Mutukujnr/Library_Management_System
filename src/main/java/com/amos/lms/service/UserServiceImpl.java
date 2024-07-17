package com.amos.lms.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.amos.lms.dto.UserDTO;
import com.amos.lms.entities.Users;
import com.amos.lms.repositories.UserRepository;

@Service
public class UserServiceImpl implements UserService{

	
	private UserRepository userRepository;
	
	
	
	
	public UserServiceImpl(UserRepository userRepository) {
		super();
		this.userRepository = userRepository;
	}


	@Autowired
	PasswordEncoder passwordEncoder;
	
	@Override
	public Users findByUsername(String username) {
		
		return userRepository.findByUsername(username);
	}
	

	@Override
	public Users save(UserDTO userDTO) {
		
		Users users = new Users(userDTO.getFullname(), userDTO.getUsername(), passwordEncoder.encode(userDTO.getPassword()), userDTO.getContact());
		
		return userRepository.save(users);
	}

}
