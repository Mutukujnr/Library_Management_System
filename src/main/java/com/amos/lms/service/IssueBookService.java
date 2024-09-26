package com.amos.lms.service;

import java.util.List;

import com.amos.lms.entities.IssueBook;

public interface IssueBookService {

	 IssueBook issueBook(Long studentId, Long bookId);

	List<IssueBook> issuedBooks();
	
	long getIssuedBooksCount();
}
