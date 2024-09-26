package com.amos.lms.controllers;

import java.security.Principal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.amos.lms.dto.UserDTO;
import com.amos.lms.entities.Books;
import com.amos.lms.entities.IssueBook;
import com.amos.lms.entities.Student;
import com.amos.lms.service.BookService;
import com.amos.lms.service.IssueBookService;
import com.amos.lms.service.StudentService;
import com.amos.lms.service.UserService;

@Controller
public class UserController {
	
	@Autowired
	private UserDetailsService userDetailsService;
	
	@Autowired
	private StudentService studentService;
	
	@Autowired
	private BookService bookService;
	
	@Autowired
	private IssueBookService issueBookService;
	
	@Autowired
	private UserService userService;
	
	@GetMapping("/home")
	public String getHomePage(Model model, Principal principal) {
		
		UserDetails userDetails = userDetailsService.loadUserByUsername(principal.getName());
		model.addAttribute("userdata", userDetails);
		
		List<Student> allStudents = studentService.allStudents();
		model.addAttribute("allstudents", allStudents);
		
		List<Books> books = bookService.getAllBooks();
		model.addAttribute("books", books);
		
		List<IssueBook> issuedBooks = issueBookService.issuedBooks();
		model.addAttribute("issuedBooks", issuedBooks);
		
		model.addAttribute("studentCount", studentService.getStudentCount());
		
		model.addAttribute("bookCount", bookService.getTotalBooks());
		
		model.addAttribute("issuedBooksCount", issueBookService.getIssuedBooksCount());
		
		return "home";
	}
	
	@GetMapping("/login")
	public String getLoginPage(@ModelAttribute("user") UserDTO userDTO) {
		
		return "login2";
	}
	
	@GetMapping("/register")
	public String getRegisterPage(@ModelAttribute("user") UserDTO userDTO) {
		
		
		return "register2";
	}
	
	@PostMapping("/register")
	public String registerUser(@ModelAttribute("user") UserDTO userDTO) {
		
		userService.save(userDTO);
		return "redirect:/login?success";
	}

}
