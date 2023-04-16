package com.example.demo.web;

import org.apache.tomcat.util.net.openssl.ciphers.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import antlr.StringUtils;
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
	
	@GetMapping("/main")
	public String showMainPage(Model model) {
		//Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
	    org.springframework.security.core.Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
	    String email = authentication.getName();
	    model.addAttribute("message", "Welcome, " + email + ". You have successfully logged in!");
	    return "main";
	}
	
	/* @GetMapping("/example") public String example() { return "example"; } */
	 
	/*
	 * @GetMapping("/registration") public String registration() { return
	 * "registration"; }
	 */
}
