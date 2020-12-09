package com.schibsted.spain.friends.legacy;


import com.schibsted.spain.friends.service.GenerateQrService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/qrByProduct")
public class GenerateQrController {

    @Autowired
    private GenerateQrService generateQrService;


    @GetMapping("/{id}")
    Object getCustomerEntrance(
            @PathVariable String id
    )throws Exception {
        return  generateQrService.getDinamicUrl(id);
    }
}