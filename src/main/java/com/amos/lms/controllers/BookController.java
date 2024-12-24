package com.amos.lms.controllers;

import java.security.Principal;

import com.amos.lms.service.PdfGenerator;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.amos.lms.dto.BookDTO;
import com.amos.lms.entities.Books;
import com.amos.lms.service.BookService;

@Controller
public class BookController {

	@Autowired
	private UserDetailsService userDetailsService;

	@Autowired
	private BookService bookService;

	@Autowired
	private PdfGenerator pdfGenerator;

	@GetMapping("/books")
	public String allBooks(@RequestParam(defaultValue = "0") int pageNo, @RequestParam(defaultValue = "5") int pageSize,
			@RequestParam(defaultValue = "title") String sortBy, @ModelAttribute("books") BookDTO bookDTO, Model model,
			Principal principal) {

		UserDetails userDetails = userDetailsService.loadUserByUsername(principal.getName());
		model.addAttribute("userdata", userDetails);

		Page<Books> page = bookService.findPage(pageNo, pageSize, sortBy);
		model.addAttribute("bookPage", page);

		model.addAttribute(sortBy, sortBy);

		return "manage-books";
	}

	@PostMapping("/add-book")
	public String saveBook(@ModelAttribute("books") BookDTO bookDTO) {

		bookService.saveBook(bookDTO);
		return "redirect:/books?success";
	}

	@GetMapping("/editBook/{id}")
	public String editBook(@PathVariable Long id, Model model, Principal principal) {

		UserDetails userDetails = userDetailsService.loadUserByUsername(principal.getName());
		model.addAttribute("userdata", userDetails);

		Books book = bookService.getBookById(id);
		model.addAttribute("book", book);

		return "edit-book";
	}

	@PostMapping("/updateBook")
    public String updateBook(@RequestParam("id") Long id, @ModelAttribute Books book, Model model,RedirectAttributes redirectAttributes) {
        if (id != null) {
            // Update existing book
            Books existingBook = bookService.getBookById(id);
            if (existingBook != null) {
                existingBook.setTitle(book.getTitle());
                existingBook.setAuthors(book.getAuthors());
                existingBook.setIsbn(book.getIsbn());
                existingBook.setPublisher(book.getPublisher());
                existingBook.setPublication_date(book.getPublication_date());
                existingBook.setEdition(book.getEdition());
                existingBook.setLanguage(book.getLanguage());
                existingBook.setCategory(book.getCategory());
                
                bookService.updateBook(existingBook);
                redirectAttributes.addFlashAttribute("successMessage", "Book updated successfully!");
            } else {
            	 redirectAttributes.addFlashAttribute("errorMessage", "Book not found!!");
            }
        } else {
            // Handle case where book ID is not present or invalid
        	 redirectAttributes.addFlashAttribute("errorMessage", "invalid Book id!");
        }
        return "redirect:/books?update";
    }

	@GetMapping("/deleteBook/{id}")
	public String deletetBook(@PathVariable(value = "id") Long id) {

		bookService.deleteBookById(id);
		return "redirect:/books";
	}

	@GetMapping("/downloadBooksReport")
	public String bookDownload(HttpSession session) {

		//ApplicationContext ac = SpringApplication.run(LibraryManagementSystemApplication .class, args);

		//PdfGenerator pdf = ac.getBean("pdfGenerator",PdfGenerator.class);

		boolean generatePdfReport = pdfGenerator.generatePdfReport();

		if (generatePdfReport){
			session.setAttribute("succMsg","Report successfully downloaded. Locate it in Your Desktop Folder");
		}else {
			session.setAttribute("errMsg","Error! Report not downloaded");
		}
		return "redirect:/books";
	}

}
