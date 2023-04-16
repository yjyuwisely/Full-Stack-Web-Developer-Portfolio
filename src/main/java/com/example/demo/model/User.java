package com.example.demo.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

/* The User class in your code represents a user account, 
	which has attributes such as firstname, lastname, email, password, and roles. 
	This class is used to 1) store user information in a database, 2) authenticate users, 
	and 3) authorize access to protected resources in your application.*/

// 회원 정보를 저장하는 User 엔티티를 만든다. 관리할 회원 정보: name, phone, email, password
@Entity // JPA를 사용할 클래스를 명시하며, 테이블과 매핑하는 역할
//email을 통해 유일하게 구분, 동일한 값이 데이터베이스에 들어올 수 없도록 unique 속성을 지정
@Table(name = "user", uniqueConstraints = @UniqueConstraint(columnNames = "email"))
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "name")
	private String name;

	/* @Column(name = "lastname") */
	private String phone;

	@Column(unique = true)
	private String email;
	private String password;

	/*
	 * @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	 * 
	 * @JoinTable(name = "users_roles", joinColumns = @JoinColumn(name = "user_id",
	 * referencedColumnName = "id"), inverseJoinColumns = @JoinColumn(name =
	 * "role_id", referencedColumnName = "id"))
	 */

	/* private Collection<Role> roles; */

	// adding a default constructor with no arguments to the User class
	// will allow Hibernate to instantiate objects of the class during database
	// queries
	public User() {
	}

	// roles의 값으로 USER, ADMIN 2개를 입력한다.
	/*
	 * public enum roles{ USER, ADMIN }
	 */

	// deleted: Collection<Role> roles
	public User(String name, String phone, String email, String password) {
		this.name = name;
		this.phone = phone;
		this.email = email;
		this.password = password;
		/* this.roles = roles; */
	}

	// MySQL에 숫자로 저장됨
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
	 * public Collection<Role> getRoles() { return roles; } public void
	 * setRoles(Collection<Role> roles) { this.roles = roles; }
	 */
}