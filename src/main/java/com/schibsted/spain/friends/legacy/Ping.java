package com.schibsted.spain.friends.legacy;

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
