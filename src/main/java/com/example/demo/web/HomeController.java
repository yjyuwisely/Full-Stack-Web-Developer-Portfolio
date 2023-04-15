package com.example.demo.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

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
	
	
	/* @GetMapping("/example") public String example() { return "example"; } */
	 
	/*
	 * @GetMapping("/registration") public String registration() { return
	 * "registration"; }
	 */
}
