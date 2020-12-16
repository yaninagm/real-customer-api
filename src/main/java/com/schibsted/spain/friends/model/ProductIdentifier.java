package com.schibsted.spain.friends.model;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "product_identifier")
public class ProductIdentifier {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String urlQrId;
    private String dinamicUrl;
    private Date dateCreated;
    private String description;


    public ProductIdentifier(Long id, String name, String urlQrId, String dinamicUrl, Date dateCreated, String description) {
        this.id = id;
        this.name = name;
        this.urlQrId = urlQrId;
        this.dinamicUrl = dinamicUrl;
        this.dateCreated = dateCreated;
        this.description = description;
    }

    public ProductIdentifier() {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Column(name = "name", nullable = true)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Column(name = "url_qr_id", nullable = true)
    public String getUrlQrId() {
        return urlQrId;
    }

    public void setUrlQrId(String urlQrId) {
        this.urlQrId = urlQrId;
    }

    @Column(name = "dinamic_url", nullable = true)
    public String getDinamicUrl() {
        return dinamicUrl;
    }

    public void setDinamicUrl(String dinamicUrl) {
        this.dinamicUrl = dinamicUrl;
    }

    @Column(name = "date_created", nullable = true)
    public Date getDateCreated() {
        return dateCreated;
    }

    public void setDateCreated(Date dateCreated) {
        this.dateCreated = dateCreated;
    }

    @Column(name = "description", nullable = true)
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "ProductIdentifier{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", urlQrId='" + urlQrId + '\'' +
                ", dinamicUrl='" + dinamicUrl + '\'' +
                ", dateCreated=" + dateCreated +
                ", description='" + description + '\'' +
                '}';
    }
}
