package com.schibsted.spain.friends.controller;


import com.schibsted.spain.friends.dto.UserDto;
import com.schibsted.spain.friends.model.ProductIdentifier;
import com.schibsted.spain.friends.service.GenerateQrService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/qrByProduct")
public class GenerateQrController {

    @Autowired
    private GenerateQrService generateQrService;


    @GetMapping("/{urlQrId}")
    Object getCustomerEntrance(
            @PathVariable String urlQrId
    )throws Exception {
        return  generateQrService.getDinamicUrl(urlQrId);
    }

    @PostMapping()
    Object createProductIdentifier(
            @RequestBody ProductIdentifier productIdentifier
    ) throws Exception {
        return generateQrService.createNewProductIdentifyQr(productIdentifier);
    }
}