package com.amos.lms.entities;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class IssueBook {

	 @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private Long id;

	    @ManyToOne(fetch = FetchType.LAZY)
	    @JoinColumn(name = "student_id", nullable = false)
	    private Student student;

	    @ManyToOne(fetch = FetchType.LAZY)
	    @JoinColumn(name = "book_id", nullable = false)
	    private Books book;

	    private LocalDate issueDate;
	    
	    private LocalDate returnDate;
	    
	    
	    

		public IssueBook() {
			super();
		}




		public IssueBook(Student student, Books book, LocalDate issueDate, LocalDate returnDate) {
			super();
			this.student = student;
			this.book = book;
			this.issueDate = issueDate;
			this.returnDate = returnDate;
		}




		public Long getId() {
			return id;
		}




		public void setId(Long id) {
			this.id = id;
		}




		public Student getStudent() {
			return student;
		}




		public void setStudent(Student student) {
			this.student = student;
		}




		public Books getBook() {
			return book;
		}




		public void setBook(Books book) {
			this.book = book;
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
