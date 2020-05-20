package com.api.realCustomer.service;

import com.api.realCustomer.model.User;
import com.api.realCustomer.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.List;

@Service
public class LoginService {

    @Autowired
    private UserRepository userRepository;



    public  void signUp(String username, String password){
        System.out.println("[method:signUp][userName: "+ username + "]");
        String passHashed = securePass(password);
        User newUser = new User(username, passHashed);
        userRepository.save(newUser);
    }

    public  void signIn(String username, String password){
        System.out.println("[method:signIn][userName: "+ username + " ]");

        List<User> users = userRepository.findByUserName(username);
        if(users.isEmpty())
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "User or password incorrect");
        if (users.size() > 1 )
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "");
        User user = users.iterator().next();
        String passHashed = securePass(password);
        if(!passHashed.equals(user.getPassword()))
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "User or password incorrect");

    }

    public String securePass(String passwordToHash){
        String generatedPassword = null;
        try {
            MessageDigest md = MessageDigest.getInstance("SHA-1");
            byte[] bytes = md.digest(passwordToHash.getBytes());
            StringBuffer sb = new StringBuffer();
            for (final byte b : bytes) {
                sb.append(String.format("%02x", b));
            }
            generatedPassword = sb.toString().toUpperCase();

        }
        catch (NoSuchAlgorithmException e)
        {
            e.printStackTrace();
        }
        return generatedPassword;
    }
}
