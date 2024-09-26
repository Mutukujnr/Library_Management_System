package com.amos.lms.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.amos.lms.entities.Books;
import com.amos.lms.repositories.BookRepository;
import com.amos.lms.repositories.IssueBookRepository;
import com.amos.lms.repositories.StudentRepository;

import jakarta.transaction.Transactional;

@Service
public class ReturnBookServiceImpl implements ReturnBookService{
	
	@Autowired
	private StudentRepository studentRepository;
	
	@Autowired
	private BookRepository bookRepository;
	
	@Autowired
	private IssueBookRepository issueBookRepository;

	
	@Transactional
	@Override
	public void returnBook(Long student_id, Long book_id) {
		
Optional<Books> optBook = bookRepository.findById(book_id);
		
		if(optBook.isPresent()) {
			

			Books book = optBook.get();
			book.setQuantity(book.getQuantity() + 1);
			book.setStatus("available");
			
			bookRepository.save(book);
		
		issueBookRepository.deleteBookByIdAndStudentId(student_id, book_id);
		
		
		
		}
		
	}
}

	

	

	
     

