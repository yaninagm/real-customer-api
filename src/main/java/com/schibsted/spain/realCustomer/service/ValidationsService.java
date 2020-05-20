package com.schibsted.spain.realCustomer.service;

import com.schibsted.spain.realCustomer.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
public class ValidationsService {

    @Autowired
    private UserRepository userRepository;

    public void validateUserName(String username){
        if (!username.matches("[a-zA-Z0-9]+") )
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Username and password must be alphanumeric");
        if (!(username.length() >= 5  && username.length() < 10))
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Username must be into 5 to 10 characters");

    }
    public void validatePassword(String password){
        if (!password.matches("[a-zA-Z0-9]+"))
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Username and password must be alphanumeric");
        if (!(password.length() >= 8  && password.length() < 12))
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Password must be into 8 to 10 characters ");
    }

    public void validateIfUserExist(String username){
        if(!(userRepository.findByUserName(username).isEmpty()))
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "User already exist");
    }
}
