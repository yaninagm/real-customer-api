package com.schibsted.spain.friends.legacy;

import com.schibsted.spain.friends.model.Recording;
import com.schibsted.spain.friends.service.CustomerEntrance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/ping")
public class Ping {

  @GetMapping
  String customerEntrance(
  ) throws Exception {
      System.out.println("PONG");
      return "PONG";
  }
}
