package com.amos.lms.dto;

public class UserDTO {
	
	private String fullname;
	
private String username;
	
	private String password;
	
	private Long contact;
	
	
	
	

	public UserDTO() {
		super();
	}

	public UserDTO(String fullname, String username, String password, Long contact) {
		super();
		this.setFullname(fullname);
		this.username = username;
		this.password = password;
		this.contact = contact;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Long getContact() {
		return contact;
	}

	public void setContact(Long contact) {
		this.contact = contact;
	}

	public String getFullname() {
		return fullname;
	}

	public void setFullname(String fullname) {
		this.fullname = fullname;
	}
	
	

}
