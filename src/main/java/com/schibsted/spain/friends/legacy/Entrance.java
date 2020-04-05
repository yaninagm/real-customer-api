package com.schibsted.spain.friends.legacy;

import com.schibsted.spain.friends.service.CustomerEntrance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/customerEntrance")
public class Entrance {

    @Autowired
    private CustomerEntrance customerEntrance;

  @PostMapping
  void customerEntrance(
          @RequestBody String username
  ) throws Exception {
      System.out.println("[method:entrance] [username: "+username+"]");
      customerEntrance.customerEntrance(username);
  }
}
