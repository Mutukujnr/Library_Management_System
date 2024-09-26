package com.amos.lms.service;

import com.amos.lms.dto.UserDTO;
import com.amos.lms.entities.Users;

public interface UserService {
	
	public Users findByUsername(String username);
	
	Users save(UserDTO userDTO);

}
