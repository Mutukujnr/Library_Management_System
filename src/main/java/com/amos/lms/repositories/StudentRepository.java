package com.amos.lms.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.amos.lms.entities.Student;
import java.util.List;


@Repository
public interface StudentRepository extends JpaRepository<Student, Long>{

//	Student findByRegno(String student_regno);
	
//	Optional<Student> findByStudentRegno(String student_regno);
	
	
}
