package com.amos.lms.dto;

import java.time.LocalDate;

public class IssueBookDTO {
	private Long id;
	private String fullname;
	private String student_regno;
	private String year_of_study;
	private String department;
	private String course;
	private String title;
	private String isbn;
	private LocalDate issueDate;
	private LocalDate returnDate;

	public IssueBookDTO() {
		super();
	}

	public IssueBookDTO(Long id, String fullname, String student_regno, String year_of_study, String department,
			String course, String title, String isbn, LocalDate issueDate, LocalDate returnDate) {
		super();
		this.id = id;
		this.fullname = fullname;
		this.student_regno = student_regno;
		this.year_of_study = year_of_study;
		this.department = department;
		this.course = course;
		this.title = title;
		this.isbn = isbn;
		this.issueDate = issueDate;
		this.returnDate = returnDate;
	}
	
	

	public IssueBookDTO(Long id, String fullname, String student_regno) {
		super();
		this.id = id;
		this.fullname = fullname;
		this.student_regno = student_regno;
	}

	
	
	
	public IssueBookDTO(String title, String isbn) {
		super();
		
		this.title = title;
		this.isbn = isbn;
	}

	public String getYear_of_study() {
		return year_of_study;
	}

	public void setYear_of_study(String year_of_study) {
		this.year_of_study = year_of_study;
	}

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	public String getCourse() {
		return course;
	}

	public void setCourse(String course) {
		this.course = course;
	}

	public Long getIssueId() {
		return id;
	}

	public void setIssueId(Long id) {
		this.id = id;
	}

	public String getFullname() {
		return fullname;
	}

	public void setFullname(String fullname) {
		this.fullname = fullname;
	}

	public String getStudent_regno() {
		return student_regno;
	}

	public void setStudent_regno(String student_regno) {
		this.student_regno = student_regno;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getIsbn() {
		return isbn;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	public LocalDate getIssueDate() {
		return issueDate;
	}

	public void setIssueDate(LocalDate issueDate) {
		this.issueDate = issueDate;
	}

	public LocalDate getReturnDate() {
		return returnDate;
	}

	public void setReturnDate(LocalDate returnDate) {
		this.returnDate = returnDate;
	}

}
