package com.example.baitaplon.Danh_Muc;

import java.io.Serializable;

public class SanPham implements Serializable {
    private String tvName;
    private int img;
    private String tvName_gia;

    public String getTvName() {
        return tvName;
    }

    public void setTvName(String tvName) {
        this.tvName = tvName;
    }

    public int getImg() {
        return img;
    }

    public void setImg(int img) {
        this.img = img;
    }

    public String getTvName_gia() {
        return tvName_gia;
    }

    public void setTvName_gia(String tvName_gia) {
        this.tvName_gia = tvName_gia;
    }

    public SanPham(String tvName, int img, String tvName_gia) {
        this.tvName = tvName;
        this.img = img;
        this.tvName_gia = tvName_gia;

    }
}