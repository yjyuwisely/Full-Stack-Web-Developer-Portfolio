package com.example.demo.model;

//import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/*UserProfile class is a hypothetical class that you can create to represent additional information about a user, 
such as their profile picture, address, phone number, or any other custom fields that you want to store. */

/* UserProfile is used as a model attribute to bind form data and 
display the user's profile information in the userProfile.html view.*/

@Entity
public class UserProfile {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	private String email;

	private String firstName;

	private String lastName;

	private String password;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	
	/*
	 * public Collection<Role> getRoles() { return roles; }
	 * 
	 * public void setRoles(Collection<Role> roles) { this.roles = roles; }
	 */
	 
}