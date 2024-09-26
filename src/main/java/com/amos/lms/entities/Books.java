package com.amos.lms.entities;

import java.sql.Date;
import java.time.LocalDate;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "books")
public class Books {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY )
	private Long book_id;
	
	private String title;
	
	private String authors;
	

	private String isbn;
	
	private String publisher;
	
	
	private Date publication_date;
	
	private String edition;
	
	private String language;
	
	private String category;
	
	private int quantity;
	
	@Column(columnDefinition = "varchar(255) default 'available'")
	private String status;
	
	@OneToMany(mappedBy = "book", cascade = CascadeType.ALL)
	private List<IssueBook> issueBook;


	

	public Books() {
		super();
	}



	public Books(String title, String authors, String isbn, String publisher, Date publication_date,
			String edition, String language, String category, int quantity, String status, List<IssueBook> issueBook) {
		super();
		this.title = title;
		this.authors = authors;
		this.isbn = isbn;
		this.publisher = publisher;
		this.publication_date = publication_date;
		this.edition = edition;
		this.language = language;
		this.category = category;
		this.quantity = quantity;
		this.status = status;
		this.issueBook = issueBook;
	}



	public Long getId() {
		return book_id;
	}

	public void setId(Long id) {
		this.book_id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getAuthors() {
		return authors;
	}

	public void setAuthors(String authors) {
		this.authors = authors;
	}

	public String getIsbn() {
		return isbn;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	public String getPublisher() {
		return publisher;
	}

	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}

	public Date getPublication_date() {
		return publication_date;
	}

	public void setPublication_date(Date publication_date) {
		this.publication_date = publication_date;
	}

	public String getEdition() {
		return edition;
	}

	public void setEdition(String edition) {
		this.edition = edition;
	}

	public String getLanguage() {
		return language;
	}

	public void setLanguage(String language) {
		this.language = language;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public List<IssueBook> getIssueBook() {
		return issueBook;
	}

	public void setIssueBook(List<IssueBook> issueBook) {
		this.issueBook = issueBook;
	}
	
	
	
	
	
	
	
		
}
