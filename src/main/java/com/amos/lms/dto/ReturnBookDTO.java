package com.amos.lms.dto;

public class ReturnBookDTO {

	 private String student_regno;
	    private String isbn;
		public ReturnBookDTO(String student_regno, String isbn) {
			super();
			this.student_regno = student_regno;
			this.isbn = isbn;
		}
		
		
		
		
		public ReturnBookDTO() {
			super();
		}




		public String getStudentRegno() {
			return student_regno;
		}
		public void setStudentRegno(String studentRegno) {
			this.student_regno = studentRegno;
		}
		public String getIsbn() {
			return isbn;
		}
		public void setIsbn(String isbn) {
			this.isbn = isbn;
		}
	    
	    
}
