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


private String            videoUrl ;
    private String            title ;
    private String speaker ;

    public ProductIdintify(Long id, String name, String urlQr, String dinamicUrl, Date dateCreated, String descripction) {
        this.id = id;
        this.name = name;
        this.urlQr = urlQr;
        this.dinamicUrl = dinamicUrl;
        this.dateCreated = dateCreated;
        this.descripction = descripction;
        this.videoUrl = "https://www.youtube.com/watch?v=PsaFVLr8t4E";
        this.title = "Conference Opening Keynote";
        this.speaker =  "Conference Opening Keynote";
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

    public String getVideoUrl() {
        return videoUrl;
    }

    public void setVideoUrl(String videoUrl) {
        this.videoUrl = videoUrl;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getSpeaker() {
        return speaker;
    }

    public void setSpeaker(String speaker) {
        this.speaker = speaker;
    }
}
