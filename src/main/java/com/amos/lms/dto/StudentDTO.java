package com.amos.lms.dto;

import java.time.LocalDate;
import java.util.Date;

public class StudentDTO {

private String student_regno;
	
	private String fullname;
	
	private String email;
	
	private String national_id;
	
	private String phone;
	
	private LocalDate date_of_birth;
	
	private String gender;
	
	private String school_id;
	
	private String year_of_study;
	
	private String department;
	
	private String course;
	
	

	public StudentDTO() {
		super();
	}



	public StudentDTO(String student_regno, String fullname, String email, String national_id, String phone,
			LocalDate date_of_birth, String gender, String school_id, String year_of_study, String department,
			String course) {
		super();
		this.student_regno = student_regno;
		this.fullname = fullname;
		this.email = email;
		this.national_id = national_id;
		this.phone = phone;
		this.date_of_birth = date_of_birth;
		this.gender = gender;
		this.school_id = school_id;
		this.year_of_study = year_of_study;
		this.department = department;
		this.course = course;
	}



	public String getStudent_regno() {
		return student_regno;
	}



	public void setStudent_regno(String student_regno) {
		this.student_regno = student_regno;
	}



	public String getFullname() {
		return fullname;
	}



	public void setFullname(String fullname) {
		this.fullname = fullname;
	}



	public String getEmail() {
		return email;
	}



	public void setEmail(String email) {
		this.email = email;
	}



	public String getNational_id() {
		return national_id;
	}



	public void setNational_id(String national_id) {
		this.national_id = national_id;
	}



	public String getPhone() {
		return phone;
	}



	public void setPhone(String phone) {
		this.phone = phone;
	}



	public LocalDate getDate_of_birth() {
		return date_of_birth;
	}



	public void setDate_of_birth(LocalDate date_of_birth) {
		this.date_of_birth = date_of_birth;
	}



	public String getGender() {
		return gender;
	}



	public void setGender(String gender) {
		this.gender = gender;
	}



	public String getSchool_id() {
		return school_id;
	}



	public void setSchool_id(String school_id) {
		this.school_id = school_id;
	}



	public String getYear_of_study() {
		return year_of_study;
	}



	public void setYear_of_study(String year_of_study) {
		this.year_of_study = year_of_study;
	}



	public String getDepartment() {
		return department;
	}



	public void setDepartment(String department) {
		this.department = department;
	}



	public String getCourse() {
		return course;
	}



	public void setCourse(String course) {
		this.course = course;
	}
	
	
	
	
	
	
}
