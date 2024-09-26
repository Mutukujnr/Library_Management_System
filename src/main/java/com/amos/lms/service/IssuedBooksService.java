package com.amos.lms.service;

import java.util.List;

import com.amos.lms.dto.IssueBookDTO;

public interface IssuedBooksService {
	 List<IssueBookDTO> getAllIssuedBooks();
	 
	 List<IssueBookDTO> getStudentsWithBooks();
	 
	 List<IssueBookDTO> getIssuedBooks();
}
