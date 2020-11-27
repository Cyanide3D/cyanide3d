package com.defiant.cyanide3d.models;

import javax.persistence.*;

@Entity
@Table(name = "news")
public class News {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic
    private int id;
    @Basic
    private String name;
    @Basic
    private String body;
    @Basic
    @Column(name = "description")
    private String description;
    @Basic
    private String date;
    @Basic
    private String author;

    public News(int id, String name, String body, String description, String date, String author) {
        this.id = id;
        this.name = name;
        this.body = body;
        this.description = description;
        this.date = date;
        this.author = author;

    }

    public News() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }
}
