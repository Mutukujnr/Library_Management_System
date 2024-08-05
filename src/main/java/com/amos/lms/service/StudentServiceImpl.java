package com.amos.lms.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.amos.lms.dto.StudentDTO;
import com.amos.lms.entities.Student;
import com.amos.lms.repositories.StudentRepository;


@Service
public class StudentServiceImpl implements StudentService{
	
	@Autowired
	private StudentRepository studentRepository;

	@Override
	public Student saveStudent(StudentDTO studentDTO) {
		
		Student student = new Student(studentDTO.getStudent_regno(),studentDTO.getFullname(),studentDTO.getEmail(),studentDTO.getNational_id(),studentDTO.getPhone(),studentDTO.getDate_of_birth(),studentDTO.getGender(),studentDTO.getSchool_id(),studentDTO.getYear_of_study(),studentDTO.getDepartment(),studentDTO.getCourse(), studentDTO.getIssueBook());
		
		return studentRepository.save(student);
	}

	@Override
	public List<Student> allStudents() {
		
		
		return studentRepository.findAll();
	}

	@Override
	public Student getStudentById(Long id) {
		
		Student student = null;
		
		Optional<Student> option = studentRepository.findById(id);
		
		if(option.isPresent()) {
			
			student = option.get();
		}
		
		return student;
	}

	@Override
	public void deleteStudentById(Long id) {
		studentRepository.deleteById(id);
		
	}

	@Override
	public Page<Student> findPage(int pageNo, int pageSize, String sortBy) {
		
		Sort sort = Sort.by(Sort.Direction.ASC, sortBy);
		Pageable pageable = PageRequest.of(pageNo, pageSize, sort);
		
		return studentRepository.findAll(pageable);
	}

	@Override
	public long getStudentCount() {
		
		return studentRepository.count();
		
	}

	@Override
	public Student updateStudent(Student existingStudent) {
		
		return studentRepository.save(existingStudent);
	}

}
