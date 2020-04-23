package com.schibsted.spain.friends.dto;
import java.util.List;

public class RecordingDto {
    private Long id;
    private List embedding_image;
    private String position;
    private String image;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setEmbedding_image(List embedding_image) {
        this.embedding_image = embedding_image;
    }

    public List getEmbedding_image() {
        return embedding_image;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getImage() {
        return image;
    }
    public void setImage(String image) {
        this.image = image;
    }

    @Override
    public String toString() {
        return "Recording{" +
                "id=" + id +
                ", embedding_image='" + embedding_image + '\'' +
                ", position='" + position + '\'' +
                '}';
    }
}
