package com.example.demo.dto;

//Data transfer object (DTO), formerly known as value objects or VO, 
//is a design pattern used to transfer data between software application subsystems.
//회원 가입 화면으로부터 넘어오는 가입정보를 담을 dto
public class UserRegistrationDto {

	private String name;
	private String phone;
	private String email;
	private String password;

	public UserRegistrationDto() {
	}

	public String getname() {
		return name;
	}

	public void setname(String name) {
		this.name = name;
	}

	public String getphone() {
		return phone;
	}

	public void setphone(String phone) {
		this.phone = phone;
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