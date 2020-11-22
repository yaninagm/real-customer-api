package com.schibsted.spain.friends.model;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;

public class ProductIdintify {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String urlQr;
    private String dinamicUrl;
    private Date dateCreated;
    private String descripction;

    public ProductIdintify(Long id, String name, String urlQr, String dinamicUrl, Date dateCreated, String descripction) {
        this.id = id;
        this.name = name;
        this.urlQr = urlQr;
        this.dinamicUrl = dinamicUrl;
        this.dateCreated = dateCreated;
        this.descripction = descripction;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUrlQr() {
        return urlQr;
    }

    public void setUrlQr(String urlQr) {
        this.urlQr = urlQr;
    }

    public String getDinamicUrl() {
        return dinamicUrl;
    }

    public void setDinamicUrl(String dinamicUrl) {
        this.dinamicUrl = dinamicUrl;
    }

    public Date getDateCreated() {
        return dateCreated;
    }

    public void setDateCreated(Date dateCreated) {
        this.dateCreated = dateCreated;
    }

    public String getDescripction() {
        return descripction;
    }

    public void setDescripction(String descripction) {
        this.descripction = descripction;
    }
}
