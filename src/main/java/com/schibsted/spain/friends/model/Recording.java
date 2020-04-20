package com.schibsted.spain.friends.model;
import javax.persistence.*;

@Entity
@Table(name = "recording")
public class Recording {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String embedding_image;
    private String position;
    private String image;

    @Column (name = "id", nullable = true)
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Column (name = "embedding_image", nullable = true)
    public String getEmbedding_image() {
        return embedding_image;
    }

    public void setEmbedding_image(String embedding_image) {
        this.embedding_image = embedding_image;
    }

    @Column (name = "position", nullable = true)
    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    @Column (name = "image", nullable = true)
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
