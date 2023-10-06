package com.example.baitaplon.login_logout;

public class TaiKhoan {
    private int Id;
    private String username;
    private String password;
    private String name;

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getDatetiem() {
        return datetiem;
    }

    public void setDatetiem(String datetiem) {
        this.datetiem = datetiem;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public TaiKhoan(int id, String username, String password, String name, String number, String datetiem, String role) {
        Id = id;
        this.username = username;
        this.password = password;
        this.name = name;
        this.number = number;
        this.datetiem = datetiem;
        this.role = role;
    }

    private String number;
    private String datetiem;
    private String role;


}
