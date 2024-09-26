package com.amos.lms.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.amos.lms.dto.IssueBookDTO;
import com.amos.lms.repositories.IssueBookRepository;

@Service
public class IssuedBooksServiceImpl implements IssuedBooksService {
	
	
	@Autowired
	private IssueBookRepository bookRepository;

	@Override
	public List<IssueBookDTO> getAllIssuedBooks() {
		
		return bookRepository. findAllIssuedBooks();
	}

	@Override
	public List<IssueBookDTO> getStudentsWithBooks() {
		
		return bookRepository.getStudents();
	}

	@Override
	public List<IssueBookDTO> getIssuedBooks() {
		
		return bookRepository.getBooks();
	}

}
