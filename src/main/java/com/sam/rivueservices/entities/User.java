package com.sam.rivueservices.entities;


import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;
import java.util.List;

@Document
public class User {

    @Id
    private String id;

    private String name;
    private String username;
    private String email;
    private String password;
    private Boolean isAdmin;
    private Date created_at = new Date();
    private List<Rivue> rivues;

    public User(String id, String name, String username, String email, String password, Boolean isAdmin, Date created_at, List<Rivue> rivues) {
        this.id = id;
        this.name = name;
        this.username = username;
        this.email = email;
        this.password = password;
        this.isAdmin = isAdmin;
        this.created_at = created_at;
        this.rivues = rivues;
    }

    public User() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Boolean getAdmin() {
        return isAdmin;
    }

    public void setAdmin(Boolean admin) {
        isAdmin = admin;
    }

    public List<Rivue> getRivues() {
        return rivues;
    }

    public void setRivues(List<Rivue> rivues) {
        this.rivues = rivues;
    }

    @Override
    public String toString() {
        return "User{" +
            "id='" + id + '\'' +
            ", name='" + name + '\'' +
            ", username='" + username + '\'' +
            ", email='" + email + '\'' +
            ", password='" + password + '\'' +
            ", isAdmin=" + isAdmin +
            ", created_at=" + created_at +
            ", rivues=" + rivues +
            '}';
    }
}
