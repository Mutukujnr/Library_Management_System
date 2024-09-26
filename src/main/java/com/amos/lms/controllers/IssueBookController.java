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
import org.springframework.web.bind.annotation.RequestParam;

import com.amos.lms.entities.IssueBook;
import com.amos.lms.service.BookService;
import com.amos.lms.service.IssueBookService;
import com.amos.lms.service.StudentService;

@Controller
public class IssueBookController {

    @Autowired
    private IssueBookService issueBookService;
    
    @Autowired
    private StudentService studentService;
    

	@Autowired
	private UserDetailsService userDetailsService;
    
    @Autowired
    private BookService bookService;

    @GetMapping("/issueBookForm")
    public String showIssueBookForm(Model model,Principal principal) {
        model.addAttribute("students", studentService.allStudents());
        model.addAttribute("books", bookService.getAllBooks());
        
        UserDetails userDetails = userDetailsService.loadUserByUsername(principal.getName());
		model.addAttribute("userdata", userDetails);
        
        return "issueBookForm";
    }

    @PostMapping("/issueBook")
    public String issueBook(@RequestParam Long studentId, @RequestParam Long bookId, @ModelAttribute("issuedBook") IssueBook issueBook, Model model) {
        IssueBook message = issueBookService.issueBook(studentId, bookId);
        model.addAttribute("message", message);
        return "redirect:/issueBookForm?success";
    }
}
