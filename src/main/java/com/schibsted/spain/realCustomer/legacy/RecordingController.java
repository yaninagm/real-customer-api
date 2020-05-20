package com.schibsted.spain.realCustomer.legacy;

import com.schibsted.spain.realCustomer.dto.RecordingDto;
import com.schibsted.spain.realCustomer.service.CustomerEntrance;
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
