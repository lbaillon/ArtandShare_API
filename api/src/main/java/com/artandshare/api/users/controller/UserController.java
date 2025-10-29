package com.artandshare.api.users.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import com.artandshare.api.users.model.User;
import com.artandshare.api.users.service.UserService;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;



@RestController
public class UserController {

  @Autowired
  private UserService userService;

  @GetMapping("/users")
  public Iterable<User> getUsers(){
    return userService.getUsers();
  }

  @GetMapping("/user/{id}")
  public User getUser(@PathVariable("id") final long id){
    Optional<User> user = userService.getUser(id);
    if(user.isPresent()){
      return user.get();
    }else{
      return null;
    }
  }

  @PostMapping("/user")
  public User creatUser(@RequestBody User user){
    return userService.saveUser(user);
  }

  @DeleteMapping("/user/{id}")
  public void deleteUser(@PathVariable("id") final long id){
    userService.deleteUser(id);
  }

  

  }
  


