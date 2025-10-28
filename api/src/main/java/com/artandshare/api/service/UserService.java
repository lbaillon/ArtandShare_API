package com.artandshare.api.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.artandshare.api.model.User;
import com.artandshare.api.repository.UserRepository;

import lombok.Data;

@Data
@Service
public class UserService {
  @Autowired
  private UserRepository userRepository;

  public Optional<User> getUser(final long id){
    return userRepository.findById(id);
  }

  public Iterable<User> getUsers(){
    return userRepository.findAll();
  }

  public void deleteUser(final long id){
    userRepository.deleteById(id);
  }

  public User saveUser(User user){
    User savedUser = userRepository.save(user);
    return savedUser;
  }

}
