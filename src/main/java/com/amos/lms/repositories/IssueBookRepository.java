package com.amos.lms.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.amos.lms.dto.IssueBookDTO;
import com.amos.lms.entities.IssueBook;

@Repository
public interface IssueBookRepository extends JpaRepository<IssueBook,Long>{

	 @Query("SELECT new com.amos.lms.dto.IssueBookDTO(ib.id, s.fullname, s.student_regno, s.year_of_study,s.department, s.course, b.title, b.isbn, ib.issueDate, ib.returnDate) " +
	           "FROM IssueBook ib " +
	           "JOIN ib.student s " +
	           "JOIN ib.book b")
	    List<IssueBookDTO> findAllIssuedBooks();
	 
	 @Query("SELECT new com.amos.lms.dto.IssueBookDTO(ib.id, s.fullname, s.student_regno) " +
	           "FROM IssueBook ib " +
	           "JOIN ib.student s ")
	    List<IssueBookDTO> getStudents();
	 
	 @Query("SELECT new com.amos.lms.dto.IssueBookDTO(ib.id,  b.title, b.isbn) " +
	           "FROM IssueBook ib " +
	           "JOIN ib.book b")
	    List<IssueBookDTO> getBooks();
}
