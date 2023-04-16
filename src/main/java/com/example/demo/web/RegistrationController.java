package com.example.demo.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.dto.UserRegistrationDto;
import com.example.demo.service.UserService;

@Controller
@RequestMapping("/registration")
// a Spring MVC controller that handles POST requests to the "/register" URL.
public class RegistrationController {
	private UserService userService;
	public RegistrationController(UserService userService) {
		super();
		this.userService = userService;
	}

	@ModelAttribute("user")
	public UserRegistrationDto userRegistrationDto() {
		return new UserRegistrationDto();
	}

	@GetMapping
	public String showRegistrationForm() {
		return "registration";
	}

	@PostMapping
	public String registerUserAccount(@ModelAttribute("user") UserRegistrationDto registrationDto) {

		userService.save(registrationDto);
		return "/login"; //회원 가입 후에 로그인 페이지로 이동한다.
		// return "redirect:/index"; 
		/* return "redirect:/registration?success"; */
		
	}
}