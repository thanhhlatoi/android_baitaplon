package com.example.baitaplon.Modun;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.database.sqlite.SQLiteStatement;

import androidx.annotation.Nullable;

public class Database extends SQLiteOpenHelper {
    public Database(@Nullable Context context, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }
    public void QueryData(String sql){
        SQLiteDatabase database = getWritableDatabase();
        database.execSQL(sql);
    }
    public Cursor GetData(String sql){
        SQLiteDatabase database = getReadableDatabase();
        return   database.rawQuery(sql,null);
    }
    //them du lieu bang
    public boolean INSERT_SANPHAM(String ten, String gia, byte[] hinh, String mota, String maloai){
        SQLiteDatabase database = getWritableDatabase();
        String sql = "INSERT INTO SanPham VALUES(null, ? , ? ,?, ?, ?)";
        SQLiteStatement statement = database.compileStatement(sql);
        statement.clearBindings();
        statement.bindString(1, ten);
        statement.bindString(2, gia);
        statement.bindBlob(3, hinh);
        statement.bindString(4, mota);
        statement.bindString(5, maloai);
        statement.executeInsert();
        return false;
    }
    //sua du lieu
    public boolean UPDATE_SANPHAM(int id, String ten, String gia, byte[] hinh, String mota, String maloai) {
        SQLiteDatabase database = getWritableDatabase();
        String sql = "UPDATE SanPham SET Ten = ?, Gia = ?, HinhAnh = ?, MoTa = ?, MaLoai = ? WHERE Id = ?";
        SQLiteStatement statement = database.compileStatement(sql);
        statement.bindString(1, ten);
        statement.bindString(2, gia);
        statement.bindBlob(3, hinh);
        statement.bindString(4, mota);
        statement.bindString(5, maloai);
        statement.bindLong(6, id); // Đặt giá trị của Id để cập nhật dựa trên Id
        statement.executeUpdateDelete();
        return true;
    }
    //xoa du lieu
    public boolean DELETE_SANPHAM(int id) {
        SQLiteDatabase database = getWritableDatabase();
        String sql = "DELETE FROM SanPham WHERE Id = ?";
        SQLiteStatement statement = database.compileStatement(sql);
        statement.bindLong(1, id); // Đặt giá trị của Id để xóa bản ghi dựa trên Id
        statement.executeUpdateDelete();
        return true;
    }
    // them du lieu vao TaiKhoan
    public boolean INSERT_TAIKHOAN(String username, String password, String name, String number,String datetime,String role){
        SQLiteDatabase database = getWritableDatabase();
        String sql = "INSERT INTO TaiKhoan VALUES(null, ? , ? ,?, ?, ?,?)";
        SQLiteStatement statement = database.compileStatement(sql);
        statement.clearBindings();
        statement.bindString(1, username);
        statement.bindString(2, password);
        statement.bindString(3, name);
        statement.bindString(4, number);
        statement.bindString(5, datetime);
        statement.bindString(6, role);
        long b = statement.executeInsert();
        if (b != -1) {
            return true;
        }
        return false;
    }
    // them du lieu vao dgio hang
    public boolean INSERT_GIOHANG(String Tensp, String SoLuong , String KichCo){
        SQLiteDatabase database = getWritableDatabase();
        String sql = "INSERT INTO GioHang VALUES(null,?,?,?,null)";
        SQLiteStatement statement = database.compileStatement(sql);
        statement.clearBindings();
        statement.bindString(1,Tensp);
        statement.bindString(2,SoLuong);
        statement.bindString(3,KichCo);
        long b = statement.executeInsert();
        if (b != -1) {
            return true;
        }
        return false;
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {

    }
    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }


}

