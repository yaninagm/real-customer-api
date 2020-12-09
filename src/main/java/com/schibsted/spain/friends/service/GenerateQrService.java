package com.schibsted.spain.friends.service;

import com.schibsted.spain.friends.model.ProductIdentifier;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class GenerateQrService {
    public ProductIdentifier getProduct(String id) {
        Date newDate = new Date();
        ProductIdentifier productIdentifier = new ProductIdentifier(
                1L,
                "terreno",
                "420971002",
                "https://www.remax.com.ar/es-ar/propiedades/cabana/venta/el-carrizal/barrio-el-coral/420971002-109?LFPNNSource=RecentlyListedOfficeProperties&cKey=420971002-109",
                newDate,
                "description");

        //https://api.qrserver.com/v1/create-qr-code/?size=150x150&data=ENCODEURL(https://www.remax.com.ar/es-ar/propiedades/cabana/venta/el-carrizal/barrio-el-coral/420971002-109?LFPNNSource=RecentlyListedOfficeProperties&cKey=420971002-109",
        //                "https://api.qrserver.com/v1/create-qr-code/?size=150x150&data=ENCODEURL(https://www.remax.com.ar/es-ar/propiedades/cabana/venta/el-carrizal/barrio-el-coral/420971002-109?LFPNNSource=RecentlyListedOfficeProperties&cKey=420971002-109",
        return productIdentifier;
    }
}