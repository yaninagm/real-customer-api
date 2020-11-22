package com.schibsted.spain.friends.service;

import com.schibsted.spain.friends.model.ProductIdintify;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class GenerateQr {
    public ProductIdintify getProduct(String id){
        Date newDate = new Date();
        ProductIdintify productIdintify = new ProductIdintify(1L,"terreno",
                "https://api.qrserver.com/v1/create-qr-code/?size=150x150&data=ENCODEURL(https://www.remax.com.ar/es-ar/propiedades/cabana/venta/el-carrizal/barrio-el-coral/420971002-109?LFPNNSource=RecentlyListedOfficeProperties&cKey=420971002-109",
                "https://api.qrserver.com/v1/create-qr-code/?size=150x150&data=ENCODEURL(https://www.remax.com.ar/es-ar/propiedades/cabana/venta/el-carrizal/barrio-el-coral/420971002-109?LFPNNSource=RecentlyListedOfficeProperties&cKey=420971002-109",
                newDate,
                "description");
        return productIdintify;
    }
}