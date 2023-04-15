package com.example.demo.dto;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;

public class UserFormDto {
	@NotBlank(message = "이름은 필수 입력 값입니다.")
	private String firstName;
	
	@NotBlank(message = "성은 필수 입력 값입니다.")
	private String lastName;
	
	@NotEmpty(message = "이메일은 필수 입력 값입니다.")
	@Email(message = "이메일 형식으로 입력해주세요.")
	private String email;
	
	@NotEmpty(message = "비밀번호는 필수 입력 값입니다.")
	private String password;
}
