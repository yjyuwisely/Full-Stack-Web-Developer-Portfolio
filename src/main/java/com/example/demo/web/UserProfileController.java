package com.example.demo.web;

import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import com.example.demo.model.User;
import com.example.demo.service.UserService;

@Controller
public class UserProfileController {

    @Autowired
    private UserService userService;

    // GET method to show profile page
    @GetMapping("/profile")
    public String showProfilePage(Model model, Principal principal) {
        String email = principal.getName(); // get the authenticated user's email
        User user = userService.findByEmail(email); // retrieve the user's data from the database
        model.addAttribute("user", user); // add the user object to the model
        return "profile";
    }
    
    

	/*
	 * @PostMapping("/profile") public String updateProfile(@ModelAttribute("user")
	 * User user) { userService.updateUser(user); // update the user's data in the
	 * database return "redirect:/profile?success"; // redirect the user back to the
	 * profile page with a success message } }
	 */
    
@PostMapping("/profile")
public String updateProfile(@ModelAttribute("user") User user, BindingResult result, Model model) {
    if (result.hasErrors()) {
        return "profile";
    }
    userService.updateUser(user); // Update the user's data in the database
    return "redirect:/profile";
}
}

/*
 * @Controller public class UserProfileController {
 * 
 * // GET method to show profile page
 * 
 * @GetMapping("/profile") public String showProfilePage() { return "profile"; }
 * 
 * @GetMapping("/profile") public String showProfilePage(Model model, Principal
 * principal) { String email = principal.getName(); // get the authenticated
 * user's email User user = UserService.findByEmail(email); // retrieve the
 * user's data from the database model.addAttribute("user", user); // add the
 * user object to the model return "profile"; }
 * 
 * @PostMapping("/profile") public String updateProfile(@ModelAttribute("user")
 * User user) { UserService.updateUser(user); // update the user's data in the
 * database return "redirect:/profile?success"; // redirect the user back to the
 * profile page with a success message } }
 */
	/*
	 * @GetMapping("/profile") public String showProfilePage(Model model, Principal
	 * principal) { String email = principal.getName(); // get the authenticated
	 * user's email User user = UserService.findByEmail(email); // retrieve the
	 * user's data from the database model.addAttribute("user", user); // add the
	 * user object to the model return "profile"; }
	 */
	/*
	 * // POST method to handle form submission
	 * 
	 * @PostMapping("") public String handleProfileUpdate(@ModelAttribute
	 * UserProfile userProfile) { // update the user profile // ... return
	 * "redirect:/profile"; }
	 */

/*
 * @Controller //@RequestMapping(value ="/profile", method = RequestMethod.GET)
 * 
 * @RequestMapping("/profile") public class UserProfileController {
 * 
 * @Autowired private UserProfileRepository userProfileRepository;
 */
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
	
	/*
	 * @PostMapping("") public String handleProfileUpdate(@ModelAttribute
	 * UserProfile userProfile) { // update the user profile
	 * userProfileRepository.save(userProfile); return "redirect:/profile"; }
	 */
	
	/*//에러 떴다 -> post 방식 사용해야 한다.
	 * @GetMapping("") public String showProfilePage() { return "profile"; }
	 */

	/*
	 * @Autowired private UserProfileRepository userProfileRepository;
	 * 
	 * @GetMapping("/{id}") public String getProfile(@PathVariable("id") Long id,
	 * Model model) { UserProfile userProfile =
	 * userProfileRepository.findById(id).orElse(null);
	 * model.addAttribute("userProfile", userProfile); return "userProfile"; }
	 * 
	 * //editUserProfile.html
	 * 
	 * @GetMapping("/edit/{id}") public String editProfile(@PathVariable("id") Long
	 * id, Model model) { UserProfile userProfile =
	 * userProfileRepository.findById(id).orElse(null);
	 * model.addAttribute("userProfile", userProfile); return "editUserProfile"; }
	 * 
	 * @PostMapping("/update/{id}") public String updateProfile(@PathVariable("id")
	 * Long id, @ModelAttribute UserProfile userProfile) { userProfile.setId(id);
	 * userProfileRepository.save(userProfile); return "redirect:/profile/" + id; }
	 */
//}


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