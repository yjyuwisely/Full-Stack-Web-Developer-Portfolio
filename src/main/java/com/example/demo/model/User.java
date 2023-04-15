package com.example.demo.model;

import java.util.Collection;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.persistence.JoinColumn;

/* The User class in your code represents a user account, 
	which has attributes such as firstName, lastName, email, password, and roles. 
	This class is used to 1) store user information in a database, 2) authenticate users, 
	and 3) authorize access to protected resources in your application.
*/

// 회원 정보를 저장하는 User 엔티티를 만든다. 관리할 회원 정보: fisrtName, lastName, email, password
@Entity //JPA를 사용할 클래스를 명시하며, 테이블과 매핑하는 역할
//email을 통해 유일하게 구분, 동일한 값이 데이터베이스에 들어올 수 없도록 unique 속성을 지정
@Table(name = "user", uniqueConstraints = @UniqueConstraint(columnNames = "email"))
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "firstname") //first_name
	private String firstName;

	@Column(name = "lastname") //last_name
	private String lastName;

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

	/*
	 * public User() {
	 * 
	 * }
	 */
	
	//roles의 값으로 USER, ADMIN 2개를 입력한다.
	/*
	 * public enum roles{ USER, ADMIN }
	 */
	
	public User(String firstName, String lastName, String email, String password, Collection<Role> roles) {

		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.password = password;
		/* this.roles = roles; */
	}

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
	 * public Collection<Role> getRoles() { return roles; } public void
	 * setRoles(Collection<Role> roles) { this.roles = roles; }
	 */

}