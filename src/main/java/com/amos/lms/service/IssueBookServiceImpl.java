package com.amos.lms.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.amos.lms.entities.Books;
import com.amos.lms.entities.IssueBook;
import com.amos.lms.entities.Student;
import com.amos.lms.exceptions.ResourceNotFoundException;
import com.amos.lms.repositories.BookRepository;
import com.amos.lms.repositories.IssueBookRepository;
import com.amos.lms.repositories.StudentRepository;

@Service
public class IssueBookServiceImpl implements IssueBookService{

	@Autowired
	private IssueBookRepository issueBookRepository;
	
	@Autowired
	private StudentRepository studentRepository;
	
	@Autowired
	private BookRepository bookRepository;
	
	@Override
	public IssueBook issueBook(Long studentId, Long bookId) {
		Optional<Student> studentOpt = studentRepository.findById(studentId);
        Optional<Books> bookOpt = bookRepository.findById(bookId);

        if (!studentOpt.isPresent()) {
            throw new ResourceNotFoundException("student not found");
        }
        
        if(!bookOpt.isPresent()) {
        	  throw new ResourceNotFoundException("book not found");
        }

       Student student = studentOpt.get();
        Books book = bookOpt.get();

        if (!"available".equals(book.getStatus()) || book.getQuantity() <= 0) {
        	  throw new ResourceNotFoundException("book is not available");
        }

        IssueBook issuedBook = new IssueBook();
        issuedBook.setStudent(student);
        issuedBook.setBook(book);
      

        book.setQuantity(book.getQuantity() - 1);
        
            book.setStatus("issued");
        

        bookRepository.save(book);
        

        return issueBookRepository.save(issuedBook);

	}

	@Override
	public List<IssueBook> issuedBooks() {
		
		return issueBookRepository.findAll();
	}

	@Override
	public long getIssuedBooksCount() {
		
		return issueBookRepository.count();
	}


}
