package com.schibsted.spain.friends.legacy;

import com.schibsted.spain.friends.config.Constants;
import com.schibsted.spain.friends.repository.FriendshipRequestRepository;
import com.schibsted.spain.friends.repository.UserRepository;
import com.schibsted.spain.friends.service.FriendshipService;
import com.schibsted.spain.friends.service.LoginService;
import com.schibsted.spain.friends.service.ValidationsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
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


