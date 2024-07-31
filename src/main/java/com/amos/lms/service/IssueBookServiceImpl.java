package com.amos.lms.service;

import java.awt.print.Book;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.amos.lms.entities.Books;
import com.amos.lms.entities.IssueBook;
import com.amos.lms.entities.Student;
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
	public String issueBook(Long studentId, Long bookId) {
		Optional<Student> studentOpt = studentRepository.findById(studentId);
        Optional<Books> bookOpt = bookRepository.findById(bookId);

        if (!studentOpt.isPresent()) {
            return "Student  not found!";
        }
        
        if(!bookOpt.isPresent()) {
        	return "book not found";
        }

       Student student = studentOpt.get();
        Books book = bookOpt.get();

        if (!"available".equals(book.getStatus()) || book.getQuantity() <= 0) {
            return "Book is not available!";
        }

        IssueBook issuedBook = new IssueBook();
        issuedBook.setStudent(student);
        issuedBook.setBook(book);
        issuedBook.setIssueDate(LocalDate.now());

        book.setQuantity(book.getQuantity() - 1);
        if (book.getQuantity() == 0) {
            book.setStatus("issued");
        }

        bookRepository.save(book);
        issueBookRepository.save(issuedBook);

        return "Book issued successfully!";

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
