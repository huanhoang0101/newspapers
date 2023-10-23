package com.newspapers.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
//import javax.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name="newspaper_detail")
public class NewspaperDetail {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "content", nullable = false)
    private String content;
    @JoinColumn(name="newspaper_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    @JsonIgnore
    private Newspaper newspaperId;

    public NewspaperDetail() {
    }

    public NewspaperDetail(String content, Newspaper newspaperId) {
        this.content = content;
        this.newspaperId = newspaperId;
    }
}
