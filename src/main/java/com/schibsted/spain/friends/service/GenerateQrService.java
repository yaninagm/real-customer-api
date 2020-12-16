package com.schibsted.spain.friends.service;

import com.schibsted.spain.friends.model.ProductIdentifier;
import com.schibsted.spain.friends.repository.ProductIdentifierRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.Objects;

@Service
public class GenerateQrService {
    @Autowired
    ProductIdentifierRepository productIdentifierRepository;

    public ProductIdentifier createNewProductIdentifyQr(ProductIdentifier productIdentifier) {
        Date newDate = new Date();
        System.out.println(">>>>>>>>>>> " + productIdentifier.getDinamicUrl());
        productIdentifier.setDateCreated(newDate);
        System.out.println("antes del save");
        ProductIdentifier productIdentifierOld =
                productIdentifierRepository.findByUrlQrId(productIdentifier.getUrlQrId());
        if(Objects.nonNull(productIdentifierOld))
            productIdentifierRepository.deleteById(productIdentifierOld.getId());
        productIdentifierRepository.save(productIdentifier);
        return productIdentifier;
    }

    public String getDinamicUrl(String urlQrId) {
        ProductIdentifier productIdentifier = productIdentifierRepository.findByUrlQrId(urlQrId);
        return productIdentifier.getDinamicUrl();
    }

    public String getProductIdentifier(String urlQrId) {
        ProductIdentifier productIdentifier = productIdentifierRepository.findByUrlQrId(urlQrId);
        return "https://api.qrserver.com/v1/create-qr-code/?size=150x150&data=https://qr-generator-redirect.herokuapp.com/qrByProduct?id="+urlQrId;
    }

}