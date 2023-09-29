package com.example.baitaplon.Mua_Hang;

public class GioHang {
    private int item_giohang_img;
    private String item_giohang_tensp;

   private String item_giohang_giasp;

    public int getItem_giohang_img() {
        return item_giohang_img;
    }

    public void setItem_giohang_img(int item_giohang_img) {
        this.item_giohang_img = item_giohang_img;
    }

    public String getItem_giohang_tensp() {
        return item_giohang_tensp;
    }

    public void setItem_giohang_tensp(String item_giohang_tensp) {
        this.item_giohang_tensp = item_giohang_tensp;
    }

    public String getItem_giohang_giasp() {
        return item_giohang_giasp;
    }

    public void setItem_giohang_giasp(String item_giohang_giasp) {
        this.item_giohang_giasp = item_giohang_giasp;
    }

    public GioHang(int item_giohang_img, String item_giohang_tensp, String item_giohang_giasp) {
        this.item_giohang_img = item_giohang_img;
        this.item_giohang_tensp = item_giohang_tensp;
        this.item_giohang_giasp = item_giohang_giasp;
    }
}
