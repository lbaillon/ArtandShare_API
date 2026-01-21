package com.artandshare.api.users.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.artandshare.api.users.model.User;
import com.artandshare.api.users.repository.UserRepository;


import lombok.Data;

@Data
@Service
public class UserService {
  @Autowired
  private UserRepository userRepository;

  @Autowired
  private PasswordEncoderService passwordEncoderService;

  public Optional<User> getUser(final String id){
        if(id==null){
      throw new RuntimeException("Id must not be null");
    }
    return userRepository.findById(id);
  }

  public Iterable<User> getUsers(){
    return userRepository.findAll();
  }

  public void deleteUser(final String id){
            if(id==null){
      throw new RuntimeException("Id must not be null");
    }
    userRepository.deleteById(id);
  }

  public User saveUser(User user){
    String hashed = passwordEncoderService.hashPassword(user.getPassword());
    user.setPassword(hashed);
    User savedUser = userRepository.save(user);
    return savedUser;
  }

}
