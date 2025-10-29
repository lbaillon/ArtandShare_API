package com.artandshare.api.users.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.artandshare.api.users.model.User;

@Repository
public interface UserRepository extends CrudRepository<User, Long> {

  
} 
