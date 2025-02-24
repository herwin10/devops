package com.example4052hdash.h_dash.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="login")
public class login {
    @Id
    private String Email;
    private String password;
    public login() {
    }
    public login(String email, String password) {
        Email = email;
        this.password = password;
    }
    public String getEmail() {
        return Email;
    }
    public void setEmail(String email) {
        Email = email;
    }
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }



}
