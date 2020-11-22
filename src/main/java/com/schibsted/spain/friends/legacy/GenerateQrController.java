package com.schibsted.spain.friends.legacy;


import com.schibsted.spain.friends.service.GenerateQr;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/qrByProduct")
public class GenerateQrController {

    @Autowired
    private GenerateQr generateQr;


    @GetMapping("/{id}")
    Object getCustomerEntrance(
            @PathVariable String id
    )throws Exception {
        return  generateQr.getProduct(id);
    }
}