package com.defiant.cyanide3d.models;

import javax.persistence.*;

@Entity
@Table(name = "user_avatar")
public class UserAvatar {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic
    private int id;
    @Column(name = "avatar_url")
    String avatarUrl;
    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "user_id")
    private User user;

    public UserAvatar(){

    }

    public UserAvatar(String avatarUrl, User user) {
        this.avatarUrl = avatarUrl;
        this.user = user;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAvatarUrl() {
        return avatarUrl;
    }

    public void setAvatarUrl(String avatarUrl) {
        this.avatarUrl = avatarUrl;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
