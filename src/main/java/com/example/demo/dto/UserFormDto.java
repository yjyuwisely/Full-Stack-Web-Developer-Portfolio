package com.example.demo.dto;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
//DTO란 Data Transfer Object의 약자로, 계층 간 데이터 전송을 위해 도메인 모델 대신 사용되는 객체
public class UserFormDto {
	@NotBlank(message = "이름은 필수 입력 값입니다.")
	private String name;
	
	@NotBlank(message = "휴대폰 번호는 필수 입력 값입니다.")
	private String phone;
	
	@NotEmpty(message = "이메일은 필수 입력 값입니다.")
	@Email(message = "이메일 형식으로 입력해주세요.")
	private String email;
	
	@NotEmpty(message = "비밀번호는 필수 입력 값입니다.")
	private String password;
}
