package com.amos.lms.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.amos.lms.dto.IssueBookDTO;
import com.amos.lms.entities.IssueBook;

import jakarta.transaction.Transactional;

@Repository
public interface IssueBookRepository extends JpaRepository<IssueBook,Long>{

	 @Query("SELECT new com.amos.lms.dto.IssueBookDTO(ib.id, s.fullname, s.student_regno, s.year_of_study,s.department, s.course, b.book_id,b.title, b.isbn,b.category, ib.issueDate, ib.returnDate) " +
	           "FROM IssueBook ib " +
	           "JOIN ib.student s " +
	           "JOIN ib.book b")
	    List<IssueBookDTO> findAllIssuedBooks();
	
//	 @Query("SELECT ib from IssueBook ib ib.student.id, ib.student.fullname, ib.student.student_regno, ib.student.year_of_study, ib.student.department, ib.student.course,  ib.book.title,  ib.book.isbn, ib.issueDate, ib.returnDate") 
//	         
//	    List<IssueBook> findAllIssuedBooks();
	 
	 @Query("SELECT new com.amos.lms.dto.IssueBookDTO(ib.id, s.student_id, s.fullname, s.student_regno) " +
	           "FROM IssueBook ib " +
	           "JOIN ib.student s ")
	    List<IssueBookDTO> getStudents();
	 
	 @Query("SELECT new com.amos.lms.dto.IssueBookDTO(ib.id, b.book_id, b.title, b.isbn,b.category) " +
	           "FROM IssueBook ib " +
	           "JOIN ib.book b")
	    List<IssueBookDTO> getBooks();
	 
	 
	 @Modifying
	 @Transactional
	 @Query("DELETE FROM IssueBook ib where ib.student.student_id = :student_id AND ib.book.book_id = :book_id")
		void deleteBookByIdAndStudentId(@Param("student_id") Long student_id, @Param("book_id") Long book_id);
	 
	 
//	 Optional<IssueBook> findByStudentRegnoAndIsbn(String student_regno, String isbn);
}
