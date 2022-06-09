package com.test.task.model;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "quotes")
public class Quotes {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "title")
    private String title;
    @Column(name = "quote")
    private String quote;
    @Column(name = "likes")
    private Integer likes;
    @Column(name = "dislike")
    private Integer dislike;
    @ManyToOne
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    private User user;
}
