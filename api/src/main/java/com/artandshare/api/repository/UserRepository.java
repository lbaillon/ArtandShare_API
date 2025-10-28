package com.artandshare.api.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.artandshare.api.model.User;

@Repository
public interface UserRepository extends CrudRepository<User, Long> {

  
} 
