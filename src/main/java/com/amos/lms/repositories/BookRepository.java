package com.amos.lms.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.amos.lms.entities.Books;

@Repository
public interface BookRepository extends JpaRepository<Books,Long>{

	Books findByIsbn(String isbn);
	
	Optional<Books> findBookByIsbn(String isbn);
}
