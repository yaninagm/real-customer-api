package com.schibsted.spain.friends.controller;

import com.schibsted.spain.friends.dto.RecordingDto;
import com.schibsted.spain.friends.service.CustomerEntrance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/customerEntrance")
public class RecordingController {

    @Autowired
    private CustomerEntrance customerEntrance;

  @PostMapping
  Object createCustomerEntrance(
          @RequestBody RecordingDto recording
  ) throws Exception {
      return customerEntrance.saveNewCustomerEntrance(recording);
  }

    @GetMapping
    Object getCustomerEntrance(
    ) throws Exception {
        return  customerEntrance.getCustomerEntrance();
    }
}