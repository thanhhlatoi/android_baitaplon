package com.example.baitaplon.Danh_Muc;

import java.io.Serializable;

public class SanPham implements Serializable {
    private int Id;
    private String Ten;
    private String Gia;
    private byte[]  hinh;
    private String Mota;
    private String Maloai;

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public String getTen() {
        return Ten;
    }

    public void setTen(String ten) {
        Ten = ten;
    }

    public String getGia() {
        return Gia;
    }

    public void setGia(String gia) {
        Gia = gia;
    }

    public byte[] getHinh() {
        return hinh;
    }

    public void setHinh(byte[] hinh) {
        this.hinh = hinh;
    }

    public String getMota() {
        return Mota;
    }

    public void setMota(String mota) {
        Mota = mota;
    }

    public String getMaloai() {
        return Maloai;
    }

    public void setMaloai(String maloai) {
        Maloai = maloai;
    }

    public SanPham(int id, String ten, String gia, byte[] hinh, String mota, String maloai) {
        Id = id;
        Ten = ten;
        Gia = gia;
        this.hinh = hinh;
        Mota = mota;
        Maloai = maloai;
    }

    public SanPham(int id, String ten, String gia, byte[] hinh) {
        Id = id;
        Ten = ten;
        Gia = gia;
        this.hinh = hinh;
    }
}