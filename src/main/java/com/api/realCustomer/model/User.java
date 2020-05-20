package com.api.realCustomer.model;

import javax.persistence.*;

@Entity
@Table(name = "user")
public class User {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String userName;
    private String password;
    private String image;
    private Long entranceByDay;
    private Long entranceByMonth;
    private Long historyEntrance;
    private String embeddingImage;

    public User() {
    }

    public User(String userName, String imagee) {
        this.userName = userName;
        this.image = image;
    }

    public User(String userName, String image, String embeddingImage) {
        this.userName = userName;
        this.image = image;
        this.entranceByDay = 0L;
        this.entranceByMonth = 0L;
        this.historyEntrance = 0L;
        this.embeddingImage = embeddingImage;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Column (name = "user_name", nullable = true)
    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    @Column (name = "password", nullable = true)
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }


    @Column (name = "entrance_by_day", nullable = true)
    public Long getEntranceByDay() {
        return entranceByDay;
    }

    public void setEntranceByDay(Long entranceByDay) {
        this.entranceByDay = entranceByDay;
    }

    @Column (name = "entrance_by_month", nullable = true)
    public Long getEntranceByMonth() {
        return entranceByMonth;
    }

    public void setEntranceByMonth(Long entranceByMonth) {
        this.entranceByMonth = entranceByMonth;
    }

    @Column (name = "history_entrance", nullable = true)
    public Long getHistoryEntrance() {
        return historyEntrance;
    }

    public void setHistoryEntrance(Long historyEntrance) {
        this.historyEntrance = historyEntrance;
    }

    @Column(name = "embedding_image", nullable =  true)
    public String getEmbeddingImage() {
        return embeddingImage;
    }

    public void setEmbeddingImage(String embeddingImage) {
        this.embeddingImage = embeddingImage;
    }

    @Override
    public String toString() {
        return super.toString();
    }

}
