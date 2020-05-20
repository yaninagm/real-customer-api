package com.api.realCustomer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@EntityScan("com.api.realCustomer")

@SpringBootApplication
public class FriendsApplication {
  public static void main(String[] args) {
    SpringApplication.run(FriendsApplication.class, args);
  }
}
