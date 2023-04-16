package com.example.demo.web;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.dto.UserFormDto;
import com.example.demo.dto.UserRegistrationDto;
import com.example.demo.service.UserService;

@Controller
@RequestMapping("/registration")
// a Spring MVC controller that handles POST requests to the "/register" URL.
public class RegistrationController {
	@Autowired
	private UserService userService;

	// an example of dependency injection
	// By injecting the UserService object into the RegistrationController,
	// the controller can use the methods of the UserService object
	// to perform user registration and validation logic.
	public RegistrationController(UserService userService) {
		super(); // calls the constructor of the parent class.
		this.userService = userService;
	}

	@ModelAttribute("user")
	// a type, a method
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
		return "/login"; // 회원 가입 후에 로그인 페이지로 이동한다.
		// return "redirect:/index";
		/* return "redirect:/registration?success"; */
	}
}