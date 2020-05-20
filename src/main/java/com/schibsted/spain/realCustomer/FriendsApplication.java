package com.schibsted.spain.realCustomer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@EntityScan("com.schibsted.spain.realCustomer")

@SpringBootApplication
public class FriendsApplication {
  public static void main(String[] args) {
    SpringApplication.run(FriendsApplication.class, args);
  }
}
