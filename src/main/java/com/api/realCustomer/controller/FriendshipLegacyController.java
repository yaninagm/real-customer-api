package com.api.realCustomer.controller;

import com.api.realCustomer.config.Constants;
import com.api.realCustomer.repository.FriendshipRequestRepository;
import com.api.realCustomer.repository.UserRepository;
import com.api.realCustomer.service.FriendshipService;
import com.api.realCustomer.service.LoginService;
import com.api.realCustomer.service.ValidationsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;

@RestController
@RequestMapping("/friendship")
public class FriendshipLegacyController {
  @Autowired
  FriendshipService friendshipService;
  @Autowired
  UserRepository userRepository;
  @Autowired
  FriendshipRequestRepository friendShipRequestRepository;
  @Autowired
  ValidationsService validationsService;
  @Autowired
  LoginService loginService;

  @PostMapping("/request")
  void requestFriendship(
      @RequestParam("usernameFrom") String usernameFrom,
      @RequestParam("usernameTo") String usernameTo,
      @RequestHeader("X-Password") String password
  ) {
    System.out.println("[method:requestFriendship] [usernameFrom: "+usernameFrom+"] [usernameTo: "+usernameTo +"]");

    loginService.signIn(usernameFrom, password);
    if(userRepository.findByUserName(usernameTo).isEmpty())
        throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "The provider usernameTo doesn't exist");
    friendshipService.requestFriendship(usernameFrom, usernameTo);
  }

  @PostMapping("/accept")
  void acceptFriendship(
      @RequestParam("usernameFrom") String usernameFrom,
      @RequestParam("usernameTo") String usernameTo,
      @RequestHeader("X-Password") String password
  ) {
    System.out.println("[method:acceptFriendship] [usernameFrom: "+usernameFrom+"] [usernameTo: "+usernameTo +"]");
    loginService.signIn(usernameFrom, password);
    friendshipService.changeStatusFriendshipRequest(usernameFrom, usernameTo, Constants.STATUS_ACCEPTED);

  }

  @PostMapping("/decline")
  void declineFriendship(
      @RequestParam("usernameFrom") String usernameFrom,
      @RequestParam("usernameTo") String usernameTo,
      @RequestHeader("X-Password") String password
  ) {
    System.out.println("[method:acceptFriendship] [usernameFrom: "+usernameFrom+"] [usernameTo: "+usernameTo +"]");
    loginService.signIn(usernameFrom, password);
    friendshipService.changeStatusFriendshipRequest(usernameFrom, usernameTo, Constants.STATUS_DECLINED);

  }

  @GetMapping("/list")
  Object listFriends(
      @RequestParam("username") String username,
      @RequestHeader("X-Password") String password
  ) {
    System.out.println("[method:listFriends] [username: "+username+"]");
    loginService.signIn(username, password);

    ArrayList <String> friends = friendshipService.getAcceptFriendshipRequest(username);

    return friends;
  }

}


