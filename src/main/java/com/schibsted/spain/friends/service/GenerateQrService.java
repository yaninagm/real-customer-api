package com.schibsted.spain.friends.service;

import com.schibsted.spain.friends.model.ProductIdentifier;
import com.schibsted.spain.friends.repository.ProductIdentifierRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class GenerateQrService {
    @Autowired
    ProductIdentifierRepository productIdentifierRepository;

    public String getDinamicUrl(String urlQrId) {
        Date newDate = new Date();
        ProductIdentifier productIdentifier = productIdentifierRepository.findByUrlQrId(urlQrId).get(0);


        String qrForUse = "https://api.qrserver.com/v1/create-qr-code/?size=150x150&data=ENCODEURL(https://qr-generator-redirect.herokuapp.com/qrByProduct/?id="+urlQrId+")";
        /*
        ProductIdentifier productIdentifier = new ProductIdentifier(
                1L,
                "terreno",
                "420971002",
                "https://www.remax.com.ar/es-ar/propiedades/cabana/venta/el-carrizal/barrio-el-coral/420971002-109?LFPNNSource=RecentlyListedOfficeProperties&cKey=420971002-109",
                newDate,
                "description");
*/
        //https://api.qrserver.com/v1/create-qr-code/?size=150x150&data=ENCODEURL(https://www.remax.com.ar/es-ar/propiedades/cabana/venta/el-carrizal/barrio-el-coral/420971002-109?LFPNNSource=RecentlyListedOfficeProperties&cKey=420971002-109",
        //                "https://api.qrserver.com/v1/create-qr-code/?size=150x150&data=ENCODEURL(https://www.remax.com.ar/es-ar/propiedades/cabana/venta/el-carrizal/barrio-el-coral/420971002-109?LFPNNSource=RecentlyListedOfficeProperties&cKey=420971002-109",
        return productIdentifier.getDinamicUrl();
    }
}