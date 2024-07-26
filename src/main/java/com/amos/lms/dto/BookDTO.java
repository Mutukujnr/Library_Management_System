package com.amos.lms.dto;

import java.time.LocalDate;

import org.springframework.format.annotation.DateTimeFormat;

public class BookDTO {

private String title;
	
	private String authors;
	

	private String isbn;
	
	private String publisher;
	
	@DateTimeFormat(pattern = "MM-dd-yyyy")
	private LocalDate publication_date;
	
	private String edition;
	
	private String language;
	
	private String category;
	
	private int quantity;
	
	private String status;
	
	
	

	public BookDTO() {
		super();
	}




	public BookDTO(String title, String authors, String isbn, String publisher, LocalDate publication_date,
			String edition, String langauge, String category, int quantity, String status) {
		super();
		this.title = title;
		this.authors = authors;
		this.isbn = isbn;
		this.publisher = publisher;
		this.publication_date = publication_date;
		this.edition = edition;
		this.setLanguage(langauge);
		this.category = category;
		this.quantity = quantity;
		this.status = status;
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




	public String getLanguage() {
		return language;
	}




	public void setLanguage(String language) {
		this.language = language;
	}




	public LocalDate getPublication_date() {
		return publication_date;
	}




	public void setPublication_date(LocalDate publication_date) {
		this.publication_date = publication_date;
	}




	public String getEdition() {
		return edition;
	}




	public void setEdition(String edition) {
		this.edition = edition;
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
	
	
	
}
