package com.amos.lms.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.amos.lms.repositories.BookRepository;
import com.amos.lms.repositories.IssueBookRepository;
import com.amos.lms.repositories.StudentRepository;

@Service
public class ReturnBookServiceImpl {
	
	@Autowired
	private StudentRepository studentRepository;
	
	@Autowired
	private BookRepository bookRepository;
	
	@Autowired
	private IssueBookRepository issueBookRepository;

	/*
	 * @Override public void deleteByRegNoAndIsbn(String student_regno, String isbn)
	 * {
	 * 
	 * issueBookRepository.deleteByRegNoAndIsbn(student_regno, isbn);
	 * 
	 * }
	 */

	

	
     
}
