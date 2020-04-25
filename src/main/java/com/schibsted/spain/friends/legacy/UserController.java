package com.schibsted.spain.friends.legacy;

import com.schibsted.spain.friends.dto.UserDto;
import com.schibsted.spain.friends.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
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
