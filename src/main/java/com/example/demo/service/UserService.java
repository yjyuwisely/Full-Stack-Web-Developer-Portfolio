package com.example.demo.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.example.demo.dto.UserRegistrationDto;
import com.example.demo.model.User;
import com.example.demo.repository.UserRepository;


  public interface UserService extends UserDetailsService {
  
  User save(UserRegistrationDto registrationDto);
  
  List<User> getAll(); }
 

/*
 * @Service
 * 
 * @Transactional
 * 
 * @RequiredArgsConstructor public class UserService implements
 * UserDetailsService {
 * 
 * private final UserRepository memberRepository;
 * 
 * public User saveUser(User user){ validateDuplicateMember(user); return
 * UserRepository.save(user); }
 * 
 * private void validateDuplicateMember(User user){ User findMember =
 * UserRepository.findByEmail(user.getEmail()); if(findMember != null){ throw
 * new IllegalStateException("이미 가입된 회원입니다."); } }
 * 
 * @Override public UserDetails loadUserByUsername(String email) throws
 * UsernameNotFoundException {
 * 
 * User member = UserRepository.findByEmail(email);
 * 
 * if(findMember == null){ throw new UsernameNotFoundException(email); }
 * 
 * return User.builder() .username(user.getEmail())
 * .password(user.getPassword()) .roles(user.getRole().toString()) .build(); }
 * 
 * }
 */