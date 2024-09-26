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
import org.springframework.web.bind.annotation.RequestParam;

import com.amos.lms.dto.IssueBookDTO;
import com.amos.lms.service.BookService;
import com.amos.lms.service.IssuedBooksService;
import com.amos.lms.service.ReturnBookService;
import com.amos.lms.service.StudentService;

@Controller
public class IssuedBooksController {

	@Autowired
	private UserDetailsService userDetailsService;
	
	@Autowired
    private IssuedBooksService issuedBookService;
	
	@Autowired
	ReturnBookService returnBookService;

	@Autowired
	private StudentService studentService;
	
	@Autowired
	private BookService bookService;

    @GetMapping("/issuedBooks")
    public String getAllIssuedBooks(Model model,Principal principal) {
    	
    	UserDetails userDetails = userDetailsService.loadUserByUsername(principal.getName());
		model.addAttribute("userdata", userDetails);
		
    	model.addAttribute("issuedBooks", issuedBookService.getAllIssuedBooks());
    	
    	model.addAttribute("students", issuedBookService.getStudentsWithBooks());
    	
    	model.addAttribute("books", issuedBookService.getAllIssuedBooks());
    	
        return "issuedBooksForm";
    }
    
    
    @GetMapping("/issued-books")
    public String viewIssuedBooks(Model model,Principal principal) {
    	UserDetails userDetails = userDetailsService.loadUserByUsername(principal.getName());
		model.addAttribute("userdata", userDetails);
    	
     	model.addAttribute("issuedBooks", issuedBookService.getAllIssuedBooks());
    	 return "issued-books";
    }
   
	@PostMapping("/return")
	public String returnBook(@RequestParam("student_id") Long student_id,@RequestParam("book_id") Long book_id,Model model) {
		
		returnBookService.returnBook(student_id, book_id);
		return "redirect:/issuedBooks?success";
	}
}
