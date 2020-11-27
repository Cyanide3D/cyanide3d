package com.defiant.cyanide3d.models;

import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "users")
public class User implements UserDetails {

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.EAGER)
    private List<Role> authorities;
    @NotEmpty(message = "Password should not be empty")
    @Basic
    private String password;
    @NotEmpty(message = "Username should not be empty")
    @Size(min = 4, max = 10, message = "Username should be between 4 and 8")
    @Basic
    private String username;
    @Basic
    @Column(name = "expired")
    boolean accountNonExpired;
    @Basic
    @Column(name = "locked")
    private boolean accountNonLocked;
    @Basic
    @Column(name = "credentialsexpired")
    private boolean credentialsNonExpired;
    @Basic
    @Column(name = "enabled")
    private boolean enabled;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "nameuser")
    private String nameuser;
    @OneToOne(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.EAGER)
    private UserAvatar avatarUrl;
    @NotEmpty(message = "EMail should not be empty")
    @Email(message = "Not valid email")
    @Column(name = "email")
    String email;

    public User(){

    }

    public User(String password, String username, boolean accountNonExpired, boolean accountNonLocked, boolean credentialsNonExpired, boolean enabled, String nameuser, String email) {
        authorities = new ArrayList<>();
        this.password = password;
        this.username = username;
        this.accountNonExpired = accountNonExpired;
        this.accountNonLocked = accountNonLocked;
        this.credentialsNonExpired = credentialsNonExpired;
        this.enabled = enabled;
        this.nameuser = nameuser;
        this.id = id;
        this.email = email;
    }

    @Override
    public List<Role> getAuthorities() {
        return authorities;
    }

    public void setAuthorities(List<Role> authorities) {
        this.authorities = authorities;
    }

    @Override
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @Override
    public boolean isAccountNonExpired() {
        return accountNonExpired;
    }

    public void setAccountNonExpired(boolean accountNonExpired) {
        this.accountNonExpired = accountNonExpired;
    }

    @Override
    public boolean isAccountNonLocked() {
        return accountNonLocked;
    }

    public void setAccountNonLocked(boolean accountNonLocked) {
        this.accountNonLocked = accountNonLocked;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return credentialsNonExpired;
    }

    public void setCredentialsNonExpired(boolean credentialsNonExpired) {
        this.credentialsNonExpired = credentialsNonExpired;
    }

    @Override
    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNameuser() {
        return nameuser;
    }

    public void setNameuser(String nameuser) {
        this.nameuser = nameuser;
    }

    public UserAvatar getAvatarUrl() {
        return avatarUrl;
    }

    public void setAvatarUrl(UserAvatar avatarUrl) {
        this.avatarUrl = avatarUrl;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
