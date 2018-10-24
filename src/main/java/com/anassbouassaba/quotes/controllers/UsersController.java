package com.anassbouassaba.quotes.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.anassbouassaba.quotes.dtos.CreateUserDto;
import com.anassbouassaba.quotes.dtos.UserDto;
import com.anassbouassaba.quotes.entities.User;
import com.anassbouassaba.quotes.repositories.UserRepository;

@RestController
@RequestMapping("users")
public class UsersController {
  @Autowired
  private UserRepository userRepository;
  
  public UserDto create(@RequestBody CreateUserDto body) {
    User user = new User();
    user.setFullName(body.getFullName());
    user.setUsername(body.getUsername());
    user.setPassword(body.getPassword());
    
    userRepository.save(user);
    
    return new UserDto(user);
  }
}
