package com.amos.lms.service;

import java.util.List;

import org.springframework.data.domain.Page;

import com.amos.lms.dto.StudentDTO;
import com.amos.lms.entities.Student;

public interface StudentService {

	Student saveStudent(StudentDTO studentDTO);
	
	List<Student> allStudents();
	
	Student getStudentById(Long id);
	
	Student updateStudent(Student existingStudent);
	
	void deleteStudentById(Long id);
	
	
	Page<Student> findPage(int pageNo, int pageSize, String sortBy);
	
	long  getStudentCount();
}
