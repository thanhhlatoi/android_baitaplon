package com.example.baitaplon.login_logout;

public class Login {
    int id;

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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPhone_number() {
        return phone_number;
    }

    public void setPhone_number(String phone_number) {
        this.phone_number = phone_number;
    }

    public Login(int id, String username, String password, String phone_number) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.phone_number = phone_number;
    }

    String username;
    String password;
    String phone_number;
}
