package com.amos.lms.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.amos.lms.service.ReturnBookService;


@Controller
public class ReturnBookController {
	
	
//	@Autowired
//    private ReturnBookService returnBookService;
	
	    /*@PostMapping("/returnBook")
	    public String returnBook(@RequestBody ReturnBookDTO returnBookDTO, Model model) {
	    	
	    	boolean isReturned = returnBookService.returnBook(returnBookDTO);
	    	
	    	 if (isReturned) {
	    		 model.addAttribute("bookReturned", "success");
	    		 return "redirect:/returnBook?success";
	    	 }else {
	    		 model.addAttribute("bookReturned", "success");
	    		 return "redirect:/returnBook?error";
	    	 }
	    }*/
	    	
	/*
	 * if (isReturned) { return ResponseEntity.ok("Book returned successfully"); }
	 * else { return
	 * ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Error returning the book"
	 * ); }
	 */
	
	}

