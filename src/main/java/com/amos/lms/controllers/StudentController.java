package com.amos.lms.controllers;

import java.security.Principal;

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
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.amos.lms.dto.StudentDTO;
import com.amos.lms.entities.Books;
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
		
		return "redirect:/students?success";
		
	}
	
	@GetMapping("/edit-student/{id}")
	public  String editStudent(@PathVariable Long id,Model model,Principal principal) {
		
		UserDetails userDetails = userDetailsService.loadUserByUsername(principal.getName());
		model.addAttribute("userdata", userDetails);
		
		Student student = studentService.getStudentById(id);
		model.addAttribute("student", student);
		
		
		return "edit-student";
		
	}
	
	@PostMapping("/update-student")
    public String updateStudent(@RequestParam("id") Long id, @ModelAttribute Student student, Model model,RedirectAttributes redirectAttributes) {
        if (id != null) {
            // Update existing book
            Student existingStudent = studentService.getStudentById(id);
            if (existingStudent != null) {
                existingStudent.setStudent_regno (student.getStudent_regno());
                existingStudent.setFullname(student.getFullname());
                existingStudent.setEmail(student.getEmail());
                existingStudent.setNational_id(student.getNational_id());
                existingStudent.setPhone(student.getPhone());
                existingStudent.setDate_of_birth(student.getDate_of_birth());
                existingStudent.setGender(student.getGender());
                existingStudent.setSchool_id(student.getSchool_id());
                existingStudent.setYear_of_study(student.getYear_of_study());
                existingStudent.setDepartment(student.getDepartment());
                existingStudent.setCourse(student.getCourse());
                
                studentService.updateStudent(existingStudent);
                redirectAttributes.addFlashAttribute("successMessage", "Book updated successfully!");
            } else {
            	 redirectAttributes.addFlashAttribute("errorMessage", "Book not found!!");
            }
        } else {
            // Handle case where book ID is not present or invalid
        	 redirectAttributes.addFlashAttribute("errorMessage", "invalid Book id!");
        }
        return "redirect:/students?update";
    }
	
	
	@GetMapping("/delete/{id}")
	public String deleteStudent(@PathVariable(value = "id") Long id) {
		
		studentService.deleteStudentById(id);
		
		return "redirect:/students";
		
	}
	
}
