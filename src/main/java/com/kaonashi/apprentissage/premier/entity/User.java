package com.kaonashi.apprentissage.premier.entity;

import java.sql.Date;

public class User {
    private Integer user_id;
    private String username;
    private String password;
    private String lastname;
    private String firstname;
    private String email;
    private java.sql.Date registration_date;

    public Integer getUser_id() {
        return user_id;
    }

    public void setUser_id(Integer user_id) {
        this.user_id = user_id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public java.sql.Date getRegistration_date() {
        return registration_date;
    }

    public void setRegistration_date(java.sql.Date registration_date) {
        this.registration_date = registration_date;
    }

    @Override
    public String toString() {
        return "User toString: \n" +
                "\nID: " + user_id +
                "\nUsername: " + username +
                "\nPassword: " + password +
                "\nLastname: " + lastname +
                "\nFirstname: " + firstname +
                "\nEmail: " + email +
                "\nRegistration_date: " + registration_date;
    }
}
