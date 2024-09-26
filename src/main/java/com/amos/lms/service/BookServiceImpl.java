package com.amos.lms.service;

import java.awt.print.Book;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.amos.lms.dto.BookDTO;
import com.amos.lms.entities.Books;
import com.amos.lms.repositories.BookRepository;


@Service
public class BookServiceImpl implements BookService{
	
	@Autowired
	private BookRepository bookRepository;

	@Override
	public Books saveBook(BookDTO bookDTO) {
		
		Books books = new Books(bookDTO.getTitle(),bookDTO.getAuthors(),bookDTO.getIsbn(),bookDTO.getPublisher(),bookDTO.getPublication_date(),bookDTO.getEdition(),bookDTO.getLanguage(),bookDTO.getCategory(),bookDTO.getQuantity(),bookDTO.getStatus(),bookDTO.getIssueBook());
		
		return bookRepository.save(books);
	}

	@Override
	public List<Books> getAllBooks() {
	
		return bookRepository.findAll();
	}

	@Override
	public Books getBookById(Long id) {
		
		Books book = null;
		
		Optional<Books> option = bookRepository.findById(id);
		if(option.isPresent()) {
			book = option.get();
		}
		
		return book;
	}

	@Override
	public void deleteBookById(Long id) {
		
		
		bookRepository.deleteById(id);
	}

	@Override
	public long getTotalBooks() {
		
		return bookRepository.count();
	}

	@Override
	public Page<Books> findPage(int pageNo, int pageSize, String sortBy) {
		Sort sort = Sort.by(Sort.Direction.ASC, sortBy);
		Pageable pageable = PageRequest.of(pageNo, pageSize, sort);
		
		return bookRepository.findAll(pageable);
		
	}

	@Override
	public Books updateBook(Books book) {
//		Books book = new Books(bookDTO.getTitle(),bookDTO.getAuthors(),bookDTO.getIsbn(),bookDTO.getPublisher(),bookDTO.getPublication_date(),bookDTO.getEdition(),bookDTO.getLanguage(),bookDTO.getCategory(),bookDTO.getQuantity(),bookDTO.getStatus());
		
		return bookRepository.save(book);
	}

}
