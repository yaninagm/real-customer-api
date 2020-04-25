package com.schibsted.spain.friends.service;

import com.schibsted.spain.friends.dto.UserDto;
import com.schibsted.spain.friends.model.User;
import com.schibsted.spain.friends.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;
    public List<User> getUser(){
        List<User> users = userRepository.findAll();
        return users;
    }

    public User putUser(UserDto userDto){
        User user = userRepository.getOne(userDto.getId());
        user.setUserName(userDto.getName());
        userRepository.save(user);
        return user;
    }
}
