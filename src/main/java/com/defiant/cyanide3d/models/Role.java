package com.defiant.cyanide3d.models;

import org.springframework.security.core.GrantedAuthority;
import javax.persistence.*;

@Entity
@Table(name = "user_role")
public class Role implements GrantedAuthority {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic
    private int id;
    @Basic
    private String authority;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "user_id")
    private User user;

    public Role(){

    }

    public Role(String authority, User user) {
        this.authority = authority;
        this.user = user;
    }

    @Override
    public String getAuthority() {
        return authority;
    }

    public void setAuthority(String authority) {
        this.authority = authority;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
