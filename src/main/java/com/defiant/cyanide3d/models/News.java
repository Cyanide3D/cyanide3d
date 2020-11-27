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

    public News(int id, String name, String body) {
        this.id = id;
        this.name = name;
        this.body = body;

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
}
