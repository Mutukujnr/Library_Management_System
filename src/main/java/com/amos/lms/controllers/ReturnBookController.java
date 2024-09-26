package com.amos.lms.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.amos.lms.dto.IssueBookDTO;
import com.amos.lms.service.ReturnBookService;


//@Controller
public class ReturnBookController {
	
	@Autowired
	private ReturnBookService returnBookService;
	
	

	}

