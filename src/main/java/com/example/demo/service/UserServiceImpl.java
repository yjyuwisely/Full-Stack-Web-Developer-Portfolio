package com.example.demo.service;

import java.util.List;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import com.example.demo.dto.UserRegistrationDto;
import com.example.demo.model.User;
import com.example.demo.repository.UserRepository;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.stream.Collectors;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

@Service
public class UserServiceImpl implements UserService { //부모의 메소드를 반드시 오버라이딩(재정의)해야 한다.

	private UserRepository userRepository;

	@Autowired
	private BCryptPasswordEncoder passwordEncoder;

	public UserServiceImpl(UserRepository userRepository) {
		super();
		this.userRepository = userRepository;
	}

	@Override
	public User save(UserRegistrationDto registrationDto) {

		User user = new User(registrationDto.getname(), registrationDto.getphone(), registrationDto.getemail(),
				passwordEncoder.encode(registrationDto.getpassword()));

		return userRepository.save(user);
	}

	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
		User user = userRepository.findByEmail(email);
		if (user == null) {
			throw new UsernameNotFoundException(email);
		}
		return new org.springframework.security.core.userdetails.User(user.getemail(), user.getpassword(),
				Collections.emptyList()); // roles 설정 안 했으므로 emptyList()이다.
	}

	@Override
	public List<User> getAll() {

		return userRepository.findAll();
	}
	
	// This method should retrieve a User object from the database based on the provided email address.
    @Override
    public User findByEmail(String email) {
        return userRepository.findByEmail(email);
    }
    
    //    This will update the user's data in the database when the form is submitted.
    // update the corresponding User object in the database with the new data.
    @Override
    public void updateUser(User user) {
        userRepository.save(user);
    }
}
/*
 * @Service public class UserServiceImpl implements UserService {
 * 
 * @Autowired private UserRepository userRepository;
 * 
 * @Autowired private BCryptPasswordEncoder passwordEncoder;
 * 
 * @Override
 * 
 * @Transactional public User save(UserRegistrationDto registrationDto) { User
 * user = new User(registrationDto.getFirstName(),
 * registrationDto.getLastName(), registrationDto.getEmail(),
 * passwordEncoder.encode(registrationDto.getPassword())); return
 * userRepository.save(user); }
 * 
 * @Override public List<User> getAll() { return userRepository.findAll(); }
 * 
 * @Override public UserDetails loadUserByUsername(String username) throws
 * UsernameNotFoundException { User user = userRepository.findByEmail(username);
 * if (user == null) { throw new
 * UsernameNotFoundException("Invalid username or password."); }
 */

// The getAuthority method will return an empty list,
// which means that the user has no authorities (i.e., roles).
/*
 * private List<Object> getAuthority(User user) { return
 * Collections.emptyList(); }
 */
// }
/*
 * List<GrantedAuthority> authorities = new ArrayList<>(); authorities.add(new
 * SimpleGrantedAuthority("ROLE_USER")); return new
 * org.springframework.security.core.userdetails.User(user.getEmail(),
 * user.getPassword(), authorities); }
 */
//}
/*
 * @Service public class UserServiceImpl implements UserService {
 * 
 * @Autowired private UserRepository userRepository;
 * 
 * 
 * @Autowired private BCryptPasswordEncoder passwordEncoder;
 * 
 * 
 * public UserServiceImpl(UserRepository userRepository) { super();
 * this.userRepository = userRepository; }
 * 
 * 
 * @Override public User save(UserRegistrationDto registrationDto) {
 * 
 * User user = new User(registrationDto.getFirstName(),
 * registrationDto.getLastName(), registrationDto.getEmail(),
 * passwordEncoder.encode(registrationDto.getPassword()));
 * //deleted:Arrays.asList(newRole("ROLE_USER"))
 * 
 * return userRepository.save(user); }
 * 
 * 
 * // [1] The 'loadUserByUsername' method retrieves the user details from the
 * database // based on the email id entered by the user during login, // and
 * creates a UserDetails object that is used by Spring Security // to perform
 * the authentication and authorization.
 * 
 * // [2] The 'UserDetails' object contains the user's email id, password, and
 * authorities/roles.
 * 
 * // 과정: the 'loadUserByUsername' method retrieves the user details // based on
 * the email id, and checks if the user exists in the database. // If the user
 * exists, it creates a UserDetails object with the user's email id, password,
 * and authorities. // Finally, it returns the UserDetails object to Spring
 * Security.
 * 
 * @Override public UserDetails loadUserByUsername(String email) throws
 * UsernameNotFoundException {
 * 
 * User user = userRepository.findByEmail(email); if (user == null) { throw new
 * UsernameNotFoundException("Invalid username or password."); } return new
 * org.springframework.security.core.userdetails.User(user.getEmail(),
 * user.getPassword(), getAuthority(user)); //I deleted
 * mapRolesToAuthorities(user.getRoles())); }
 * 
 * //지금 시점에서 (230416) 내가 users의 역할 구분(users, admin)을 안 했으니까 아래 코드를 쓴다. //return
 * a set of SimpleGrantedAuthority objects with a single authority ROLE_USER
 * private Collection<? extends GrantedAuthority> getAuthority(User user) {
 * List<GrantedAuthority> authorities = Arrays.asList(new
 * SimpleGrantedAuthority("ROLE_USER")); return authorities; }
 * 
 * @Override public List<User> getAll() {
 * 
 * return userRepository.findAll(); }
 * 
 * }
 */

//새로 추가함
/*
 * private Set<SimpleGrantedAuthority> getAuthority(User user) {
 * Set<SimpleGrantedAuthority> authorities = new HashSet<>();
 * authorities.add(new SimpleGrantedAuthority(user.getRole().getName())); return
 * authorities; }
 */
/*
 * @Override
 * 
 * @Transactional public User save(UserRegistrationDto registrationDto) { User
 * user = new User(registrationDto.getFirstName(),
 * registrationDto.getLastName(), registrationDto.getEmail(),
 * passwordEncoder.encode(registrationDto.getPassword()), new
 * Role("ROLE_USER")); return userRepository.save(user); }
 */

/*
 * @Override public UserDetails loadUserByUsername(String username) throws
 * UsernameNotFoundException {
 * 
 * User user = userRepository.findByEmail(username); if (user == null) { throw
 * new UsernameNotFoundException("Invalid username or password."); } return new
 * org.springframework.security.core.userdetails.User(user.getEmail(),
 * user.getPassword(), mapRolesToAuthorities(user.getRoles())); }
 */

/*
 * private Collection<? extends GrantedAuthority>
 * mapRolesToAuthorities(Collection<Role> roles) {
 * 
 * return roles.stream().map(role -> new
 * SimpleGrantedAuthority(role.getName())).collect(Collectors.toList()); }
 */

/*
 * //겹치니까 지움
 * 
 * @Override public UserDetails loadUserByUsername(String username) throws
 * UsernameNotFoundException { // TODO Auto-generated method stub return null; }
 */