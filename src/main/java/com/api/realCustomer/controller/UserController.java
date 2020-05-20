package com.api.realCustomer.controller;

import com.api.realCustomer.dto.UserDto;
import com.api.realCustomer.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
@CrossOrigin(origins="http://localhost:4200")
public class UserController {

    @Autowired
    private UserService userService;
    @GetMapping
    Object getUser(
    ) throws Exception {
        return  userService.getUser();
    }
    @PostMapping
    Object putUser(
            @RequestBody UserDto userDto
            ) throws Exception {
        return userService.putUser(userDto);
    }
}
