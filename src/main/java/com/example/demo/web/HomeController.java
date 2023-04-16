package com.example.demo.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.security.core.context.SecurityContextHolder;

@Controller
public class HomeController {

	@GetMapping("/")
	public String home() { // index()
		return "index";
		// return "redirect:/index.html";
	}

	@GetMapping("/login")
	public String login() {
		return "login";
	}
	
	//main.html에 로그인한 이메일 주소 뜨게 한다.
	@GetMapping("/main")
	public String mainPage(Model model) {
	    // get the authenticated user's email
	    org.springframework.security.core.Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
	    String email = authentication.getName();
	    
	    // add the email to the model
	    model.addAttribute("email", email);
	    
	    return "main";
	}
	
	
	/*
	 * @GetMapping("/main") public String showMainPage(Model model) {
	 * //Authentication authentication =
	 * SecurityContextHolder.getContext().getAuthentication();
	 * org.springframework.security.core.Authentication authentication =
	 * SecurityContextHolder.getContext().getAuthentication(); String email =
	 * authentication.getName(); model.addAttribute("message", "Welcome, " + email +
	 * ". You have successfully logged in!"); return "main"; }
	 */

    
	/* @GetMapping("/example") public String example() { return "example"; } */
	 
	/*
	 * @GetMapping("/registration") public String registration() { return
	 * "registration"; }
	 */
}
