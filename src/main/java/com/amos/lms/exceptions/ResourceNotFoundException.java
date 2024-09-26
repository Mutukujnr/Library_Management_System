package com.amos.lms.exceptions;

import com.amos.lms.entities.IssueBook;

public class ResourceNotFoundException extends RuntimeException {

	public ResourceNotFoundException(String message) {
		super(message);
		
	}
}
