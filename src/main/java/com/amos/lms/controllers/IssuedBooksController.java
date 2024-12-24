package com.amos.lms.controllers;

import java.security.Principal;
import java.util.List;

import com.amos.lms.service.*;
import jakarta.servlet.http.HttpSession;
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

@Controller
public class IssuedBooksController {

	@Autowired
	private UserDetailsService userDetailsService;
	
	@Autowired
    private IssuedBooksService issuedBookService;
	
	@Autowired
	ReturnBookService returnBookService;

    @Autowired
    IssuedBooksPdfGenerator pdfGenerator;

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

    @GetMapping("/downloadIssuedBooksReport")
    public String issuedBooksDownload(HttpSession session) {

        //ApplicationContext ac = SpringApplication.run(LibraryManagementSystemApplication .class, args);

        //PdfGenerator pdf = ac.getBean("pdfGenerator",PdfGenerator.class);

        boolean generatePdfReport = pdfGenerator.generatePdfReport();

        if (generatePdfReport){
            session.setAttribute("succMsg","Report successfully downloaded. Locate it in Your Desktop Folder");
        }else {
            session.setAttribute("errMsg","Error! Report not downloaded");
        }
        return "redirect:/issued-books";
    }
}
