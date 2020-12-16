package com.schibsted.spain.friends.controller;


import com.schibsted.spain.friends.dto.UserDto;
import com.schibsted.spain.friends.model.ProductIdentifier;
import com.schibsted.spain.friends.service.GenerateQrService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/productIdentifier")
public class GenerateQrController {

    @Autowired
    private GenerateQrService generateQrService;


    @GetMapping("/dinamicUrl/{urlQrId}")
    Object getDinamicUrl(
            @PathVariable String urlQrId
    )throws Exception {
        return  generateQrService.getDinamicUrl(urlQrId);
    }

    @GetMapping("/qrImage/{urlQrId}")
    Object getProductIdentifier(
            @PathVariable String urlQrId
    )throws Exception {
        return  generateQrService.getProductIdentifier(urlQrId);
    }

    @PostMapping()
    Object createProductIdentifier(
            @RequestBody ProductIdentifier productIdentifier
    ) throws Exception {
        return generateQrService.createNewProductIdentifyQr(productIdentifier);
    }
}