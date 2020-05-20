package com.api.realCustomer.service;

import com.api.realCustomer.dto.UserDto;
import com.api.realCustomer.model.User;
import com.api.realCustomer.repository.UserRepository;
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
