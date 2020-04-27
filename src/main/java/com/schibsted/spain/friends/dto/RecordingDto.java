package com.schibsted.spain.friends.dto;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Arrays;

public class RecordingDto {
    private Long id;
    @JsonProperty("embedding_image")
    private double[] embeddingImage;
    private String position;
    private String image;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public double[] getEmbeddingImage() {
        return embeddingImage;
    }

    public void setEmbeddingImage(double[] embeddingImage) {
        this.embeddingImage = embeddingImage;
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
        return "RecordingDto{" +
                "id=" + id +
                ", embeddingImage=" + Arrays.toString(embeddingImage) +
                ", position='" + position + '\'' +
                ", image='" + image + '\'' +
                '}';
    }
}
