package com.example.demo.dto;

//Data transfer object (DTO), formerly known as value objects or VO, 
//is a design pattern used to transfer data between software application subsystems.

//회원 가입 화면으로부터 넘어오는 가입정보를 담을 dto
public class UserRegistrationDto {

	private String firstname;
	private String lastname;
	private String email;
	private String password;

	public UserRegistrationDto() {

	}

	public String getfirstname() {
		return firstname;
	}

	public void setfirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getlastname() {
		return lastname;
	}

	public void setlastname(String lastname) {
		this.lastname = lastname;
	}

	public String getemail() {
		return email;
	}

	public void setemail(String email) {
		this.email = email;
	}

	public String getpassword() {
		return password;
	}

	public void setpassword(String password) {
		this.password = password;
	}
}