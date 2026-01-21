package com.artandshare.api.users.service;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class PasswordEncoderService {
  private final BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder(12);

  public String hashPassword(String rawPassword){
    return passwordEncoder.encode(rawPassword);
  }

  public boolean checkPassword(String rawPassword, String hashedPassword) {
    return passwordEncoder.matches(rawPassword, hashedPassword);
  }
}
