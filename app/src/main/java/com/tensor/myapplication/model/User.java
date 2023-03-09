package com.tensor.myapplication.model;

public class User {

    String uid = "";
    String username = "";
    String email = "";
    String bio = "";

    public User(String uid, String username, String email, String bio, String photo) {
        this.uid = uid;
        this.username = username;
        this.email = email;
        this.bio = bio;
        this.photo = photo;
    }

    public User(String uid, String username, String email, String bio, String photo, String password) {
        this.uid = uid;
        this.username = username;
        this.email = email;
        this.bio = bio;
        this.photo = photo;
        this.password = password;
    }

    public User(){};

    String photo = "";
    String password = "";

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
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

    public String getBio() {
        return bio;
    }

    public void setBio(String bio) {
        this.bio = bio;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
