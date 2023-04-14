package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.UserProfile;
import com.example.demo.repository.UserProfileRepository;

@Service
public class UserProfileService {

  @Autowired
  private UserProfileRepository userProfileRepository;

  public UserProfile getUserProfileByEmail(String email) {
    return userProfileRepository.findByEmail(email);
  }

  public void saveUserProfile(UserProfile userProfile) {
    userProfileRepository.save(userProfile);
  }
}