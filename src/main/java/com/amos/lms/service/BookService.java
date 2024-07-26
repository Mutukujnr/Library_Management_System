package com.amos.lms.service;

import java.awt.print.Book;
import java.util.List;

import org.springframework.data.domain.Page;

import com.amos.lms.dto.BookDTO;
import com.amos.lms.entities.Books;
import com.amos.lms.entities.Student;

public interface BookService {

	Books saveBook(BookDTO bookDTO);
	
	List<Books> getAllBooks();
	
	Books getBookById(Long id);
	
	void deleteBookById(Long id);
	
	long getTotalBooks();
	
	Books updateBook(Books existingBook);
	
	Page<Books> findPage(int pageNo, int pageSize, String sortBy);
}
