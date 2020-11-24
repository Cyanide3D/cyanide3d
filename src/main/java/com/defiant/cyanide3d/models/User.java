package com.defiant.cyanide3d.models;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "table usr")
public class User {
    @Id
    int id;
    String username;
    String login;
    String password;
//    @ElementCollection(targetClass = Role.class, fetch = FetchType.EAGER)
//    //@CollectionTable(name = "usr_role", joinColumns = @JoinColumn(name = "id"))
//    @Enumerated(EnumType.STRING)
//    private Set<Role> roles;
//
//    public Set<Role> getRoles() {
//        return roles;
//    }

//    public void setRoles(Set<Role> roles) {
//        this.roles = roles;
//    }

    public User(int id, String username, String login, String password) {
        this.id = id;
        this.username = username;
        this.login = login;
        this.password = password;
    }

    public User() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
