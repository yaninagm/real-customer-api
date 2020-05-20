package com.api.realCustomer.model;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "friendshiprequest")
public class FriendshipRequest {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String userFrom;
    private String userTo;
    private String status;
    private Date dateCreated;
    private Date dateLastModified;


    @Column(name = "user_from", nullable = true)
    public String getUserFrom() {
        return userFrom;
    }

    public void setUserFrom(String userFrom) {
        this.userFrom = userFrom;
    }

    @Column(name = "user_to", nullable = true)
    public String getUserTo() {
        return userTo;
    }

    public void setUserTo(String userTo) {
        this.userTo = userTo;
    }

    @Column(name = "status", nullable = true)
    public String getStatus() {
        return status;
    }
    public void setStatus(String status) {
        this.status = status;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Column(name = "date_created", nullable = true)
    public Date getDateCreated() {
        return dateCreated;
    }

    public void setDateCreated(Date dateCreated) {
        this.dateCreated = dateCreated;
    }

    @Column(name = "date_last_modified", nullable = true)
    public Date getDateLastModified() {
        return dateLastModified;
    }

    public void setDateLastModified(Date dateLastModified) {
        this.dateLastModified = dateLastModified;
    }


    public FriendshipRequest() {
    }

    public FriendshipRequest(String userFrom, String userTo, String status, Date dateCreated, Date dateLastModified) {
        this.userFrom = userFrom;
        this.userTo = userTo;
        this.status = status;
        this.dateCreated = dateCreated;
        this.dateLastModified = dateLastModified;
    }

    @Override
    public String toString() {
        return "FriendshipRequest{" +
                "id=" + id +
                ", userFrom='" + userFrom + '\'' +
                ", userTo='" + userTo + '\'' +
                ", status='" + status + '\'' +
                ", dateCreated=" + dateCreated +
                ", dateLastModified=" + dateLastModified +
                '}';
    }
}
