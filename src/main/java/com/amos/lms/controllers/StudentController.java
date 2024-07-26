package com.amos.lms.controllers;

import java.security.Principal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.amos.lms.dto.StudentDTO;
import com.amos.lms.entities.Student;
import com.amos.lms.service.StudentService;

@Controller
public class StudentController {
	
	@Autowired
	private UserDetailsService userDetailsService;
	
	
	@Autowired
	private StudentService studentService;

	@GetMapping("/students")
	public  String studentsPage(
			@RequestParam(defaultValue = "0")  int pageNo,
			@RequestParam(defaultValue = "5")  int pageSize,
			@RequestParam(defaultValue = "fullname")  String sortBy,
			@ModelAttribute("students") StudentDTO studentDTO, Model model, Principal principal) {
		
		UserDetails userDetails = userDetailsService.loadUserByUsername(principal.getName());
		model.addAttribute("userdata", userDetails);
		
		
		Page<Student> studentPage =  studentService.findPage(pageNo, pageSize, sortBy);
		model.addAttribute("studentPage", studentPage);
		model.addAttribute("sortBy", sortBy);
		return "manage-students";
		
	}
	
	
	
	@PostMapping("/add-student")
	public  String addStudent(@ModelAttribute("students") StudentDTO studentDTO) {
		
		studentService.saveStudent(studentDTO);
		
		return "redirect:/manage-students?success";
		
	}
	
	@GetMapping("/student/{id}")
	public  String editStudent(@PathVariable(value = "id") Long id,Model model) {
		
		Student student = studentService.getStudentById(id);
		model.addAttribute("student", student);
		
		
		return "edit-student";
		
	}
	
	@GetMapping("/update-student")
	public  String updateStudent(@ModelAttribute("students") StudentDTO studentDTO) {
		
		studentService.saveStudent(studentDTO);
		
		return "redirect:/students?success";
		
	}
	
	
	@GetMapping("/delete/{id}")
	public String deleteStudent(@PathVariable(value = "id") Long id) {
		
		studentService.deleteStudentById(id);
		
		return "redirect:/manage-students?success";
		
	}
	
}
