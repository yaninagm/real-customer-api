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
    private String urlQrId;
    private String dinamicUrl;
    private Date dateCreated;
    private String description;


    public ProductIdintify(Long id, String name, String urlQrId, String dinamicUrl, Date dateCreated, String description) {
        this.id = id;
        this.name = name;
        this.urlQrId = urlQrId;
        this.dinamicUrl = dinamicUrl;
        this.dateCreated = dateCreated;
        this.description = description;
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

    public String getUrlQrId() {
        return urlQrId;
    }

    public void setUrlQrId(String urlQrId) {
        this.urlQrId = urlQrId;
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
