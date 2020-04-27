package com.schibsted.spain.friends.model;
import javax.persistence.*;

@Entity
@Table(name = "recording")
public class Recording {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String embeddingImage;
    private String position;
    private String image;
    private Long userId;

    @Column (name = "id", nullable = true)
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Column (name = "embedding_image", nullable = true)
    public String getEmbeddingImage() {
        return embeddingImage;
    }

    public void setEmbeddingImage(String embeddingImage) {
        this.embeddingImage = embeddingImage;
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

    @Column (name = "user_id", nullable = true)
    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    @Override
    public String toString() {
        return "Recording{" +
                "id=" + id +
                ", embedding_image='" + embeddingImage + '\'' +
                ", position='" + position + '\'' +
                '}';
    }
}
