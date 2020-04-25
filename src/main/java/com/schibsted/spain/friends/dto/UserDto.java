package com.schibsted.spain.friends.dto;

public class UserDto {

    private Long id;
    private String name;
    private String lastname;
    private String username;
    private String image;

    public UserDto(Long id, String name, String lastname, String username, String image) {
        this.id = id;
        this.name = name;
        this.lastname = lastname;
        this.username = username;
        this.image = image;
    }

    public UserDto(Long id, String image) {
        this.id = id;
        this.image = image;
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

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }
}
