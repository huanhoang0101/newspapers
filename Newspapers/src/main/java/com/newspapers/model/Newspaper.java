package com.newspapers.model;

import jakarta.persistence.*;
//import javax.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name="newspaper")
public class Newspaper {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column(name = "title", nullable = false)
    private String title;

    @Column(name = "description", nullable = false)
    private String description;

    @Column(name = "img")
    private String img;

    @Column(name = "content", columnDefinition="TEXT")
    private String content;

    @Column(name = "created_date")
    private String created_date;

    public Newspaper() {
    }

    public Newspaper(String title, String description, String img) {
        this.title = title;
        this.description = description;
        this.img = img;
    }

    public Newspaper(String title, String description, String img, String content, String created_date) {
        this.title = title;
        this.description = description;
        this.img = img;
        this.content = content;
        this.created_date = created_date;
    }
}
