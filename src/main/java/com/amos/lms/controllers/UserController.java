package com.amos.lms.controllers;

import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.amos.lms.dto.UserDTO;
import com.amos.lms.service.UserService;

@Controller
public class UserController {
	
	@Autowired
	private UserDetailsService userDetailsService;
	
	@Autowired
	private UserService userService;
	
	@GetMapping("/home")
	public String getHomePage(Model model, Principal principal) {
		
		UserDetails userDetails = userDetailsService.loadUserByUsername(principal.getName());
		model.addAttribute("userdata", userDetails);
		return "home";
	}
	
	@GetMapping("/login")
	public String getLoginPage(@ModelAttribute("user") UserDTO userDTO) {
		
		return "Login";
	}
	
	@GetMapping("/register")
	public String getRegisterPage(@ModelAttribute("user") UserDTO userDTO) {
		
		
		return "register";
	}
	
	@PostMapping("/register")
	public String registerUser(@ModelAttribute("user") UserDTO userDTO) {
		
		userService.save(userDTO);
		return "redirect:/register?success";
	}

}
