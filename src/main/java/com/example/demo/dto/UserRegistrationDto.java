package com.example.demo.dto;

//Data transfer object (DTO), formerly known as value objects or VO, 
//is a design pattern used to transfer data between software application subsystems.

//회원 가입 화면으로부터 넘어오는 가입정보를 담을 dto
public class UserRegistrationDto {

	private String firstName;
	private String lastName;
	private String email;
	private String password;

	public UserRegistrationDto() {

	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
}