package com.schibsted.spain.friends.legacy;

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
  void createCustomerEntrance(
          @RequestBody RecordingDto recording
  ) throws Exception {
      customerEntrance.createCustomerEntrance(recording);
  }

    @GetMapping
    Object getCustomerEntrance(
    ) throws Exception {
        return  customerEntrance.getCustomerEntrance();
    }
}
