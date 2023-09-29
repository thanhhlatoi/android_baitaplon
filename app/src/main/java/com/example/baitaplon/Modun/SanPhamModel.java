package com.example.baitaplon.Modun;

public class SanPhamModel {
    private String img_sp;
    private String  img_maLoai;
    private String tensp;
    private String giasp;
    private String mota_sp;

    public String getImg_sp() {
        return img_sp;
    }

    public void setImg_sp(String img_sp) {
        this.img_sp = img_sp;
    }

    public String getImg_maLoai() {
        return img_maLoai;
    }

    public void setImg_maLoai(String img_maLoai) {
        this.img_maLoai = img_maLoai;
    }

    public String getTensp() {
        return tensp;
    }

    public void setTensp(String tensp) {
        this.tensp = tensp;
    }

    public String getGiasp() {
        return giasp;
    }

    public void setGiasp(String giasp) {
        this.giasp = giasp;
    }

    public String getMota_sp() {
        return mota_sp;
    }

    public void setMota_sp(String mota_sp) {
        this.mota_sp = mota_sp;
    }

    public SanPhamModel(String img_sp, String img_maLoai, String tensp, String giasp, String mota_sp) {
        this.img_sp = img_sp;
        this.img_maLoai = img_maLoai;
        this.tensp = tensp;
        this.giasp = giasp;
        this.mota_sp = mota_sp;
    }
}
