package com.example.demo.web;

import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import com.example.demo.model.User;
import com.example.demo.repository.UserRepository;
import com.example.demo.service.UserService;

@Controller
public class UserProfileController {

	@Autowired
	private UserService userService;

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private PasswordEncoder passwordEncoder;

	// GET method to show profile page
	@GetMapping("/profile")
	public String showProfilePage(Model model, Principal principal) {
		String email = principal.getName(); // get the authenticated user's email
		User user = userService.findByEmail(email); // retrieve the user's data from the database
		model.addAttribute("user", user); // add the user object to the model
		return "profile";
	}

	@PostMapping("/update-profile")
	public String updateProfile(@RequestParam("phone") String phone, @RequestParam("password") String password,
			Principal principal) {
		User user = userRepository.findByEmail(principal.getName());
		user.setname(phone);
		if (!password.isEmpty()) {
			user.setpassword(passwordEncoder.encode(password));
		}
		userRepository.save(user);
		return "redirect:/profile";
	}
}
	/*
	 * @PostMapping("/profile") public String updateProfile(@ModelAttribute("user")
	 * User user) { userService.updateUser(user); // update the user's data in the
	 * database return "redirect:/profile?success"; // redirect the user back to the
	 * profile page with a success message } }
	 */
	/*
	 * @PostMapping("/profile") public String updateProfile(@ModelAttribute("user")
	 * User user, BindingResult result, Model model) { if (result.hasErrors()) {
	 * return "profile"; } userService.updateUser(user); // Update the user's data
	 * in the database return "redirect:/profile"; }
	 */


/*
 * //에러 떴다 -> post 방식 사용해야 한다.
 * 
 * @GetMapping("") public String showProfilePage() { return "profile"; }
 */

/* 이전 코드 */
/*
 * @Controller public class UserProfileController {
 * 
 * @Autowired private UserProfileService userProfileService;
 * 
 * @GetMapping("/profile") public String showUserProfile(Model model,
 * Authentication authentication) { String userEmail =
 * authentication.getFirstName(); UserProfile userProfile =
 * userProfileService.getUserProfileByEmail(userEmail);
 * model.addAttribute("userProfile", userProfile); return "userProfile"; }
 * 
 * @PostMapping("/profile") public String saveUserProfile(@ModelAttribute
 * UserProfile userProfile, Authentication authentication) { String userEmail =
 * authentication.getFirstName(); UserProfile existingUserProfile =
 * userProfileService.getUserProfileByEmail(userEmail);
 * existingUserProfile.setFirstName(userProfile.getFirstName());
 * existingUserProfile.setPassword(userProfile.getPassword());
 * userProfileService.saveUserProfile(existingUserProfile); return
 * "redirect:/profile"; }
 * 
 * }
 */