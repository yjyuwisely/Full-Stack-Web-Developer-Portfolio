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

	private String name;

	private String phone;

	private String password;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getname() {
		return name;
	}

	public void setname(String name) {
		this.name = name;
	}

	public String getphone() {
		return phone;
	}

	public void setphone(String phone) {
		this.phone = phone;
	}

	public String getemail() {
		return email;
	}

	public void setemail(String email) {
		this.email = email;
	}

	public String getpassword() {
		return password;
	}

	public void setpassword(String password) {
		this.password = password;
	}
	/*
	 * public Collection<Role> getRoles() { return roles; }
	 * 
	 * public void setRoles(Collection<Role> roles) { this.roles = roles; }
	 */
}