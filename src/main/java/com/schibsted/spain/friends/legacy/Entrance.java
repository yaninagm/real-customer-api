package com.schibsted.spain.friends.legacy;

import com.schibsted.spain.friends.model.Recording;
import com.schibsted.spain.friends.service.CustomerEntrance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/customerEntrance")
public class Entrance {

    @Autowired
    private CustomerEntrance customerEntrance;

  @PostMapping
  void createCustomerEntrance(
          @RequestBody Recording recording
  ) throws Exception {
      System.out.println("[method:entrance] [username: "+recording.getEmbedding_image()+"]");
      customerEntrance.createCustomerEntrance(recording);
  }

    @GetMapping
    Object getCustomerEntrance(
    ) throws Exception {
        System.out.println("[method:entrance] [username: ");
        return  customerEntrance.getCustomerEntrance();
    }
}
