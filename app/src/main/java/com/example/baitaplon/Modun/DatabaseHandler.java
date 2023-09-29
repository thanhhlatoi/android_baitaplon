package com.example.baitaplon.Modun;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.example.baitaplon.Danh_Muc.SanPham;

import java.util.ArrayList;
import java.util.List;

public class DatabaseHandler extends SQLiteOpenHelper {
    private static final String DATABASE_NAME = "DBMyPham";
    private static final int DATABASE_VERSION = 1;
    public static final String TABLE_NAME = "Login";

    public static final String KEY_ID = "id";
    public static final String KEY_NAME = "username";
    public static final String KEY_PASSWORD = "password";
    public static final String KEY_PHONE_NUMBER = "phone_number";
    public static final String TABLE_NAME_IMG_SP = "SanPham";
    public static final String KEY_ID_SP = "issp";
    public static final String KEY_IMG_SP = "img_sp";
    public static final String KEY_IMG_TYPE = "img_maLoai"; // Sửa tên cột
    public static final String KEY_IMG_TEN_SP = "tensp";
    public static final String KEY_IMG_GIA_SP = "giasp";
    public static final String KEY_IMG_MOTA = "mota_sp";
    private List<SanPhamModel> imageList;




    public DatabaseHandler(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String create_users_table = String.format("CREATE TABLE %s(%s INTEGER PRIMARY KEY, %s TEXT, %s TEXT, %s TEXT)",
                TABLE_NAME, KEY_ID, KEY_NAME, KEY_PASSWORD, KEY_PHONE_NUMBER);
        db.execSQL(create_users_table);

        String create_product_table = String.format("CREATE TABLE %s(%s INTEGER PRIMARY KEY AUTOINCREMENT, %s TEXT, %s TEXT, %s TEXT, %s TEXT, %s TEXT)",
                TABLE_NAME_IMG_SP, KEY_ID_SP, KEY_IMG_SP, KEY_IMG_TYPE, KEY_IMG_TEN_SP, KEY_IMG_GIA_SP, KEY_IMG_MOTA);
        db.execSQL(create_product_table);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        String drop_users_table = String.format("DROP TABLE IF EXISTS %s", TABLE_NAME);
        db.execSQL(drop_users_table);

        String drop_product_table = String.format("DROP TABLE IF EXISTS %s", TABLE_NAME_IMG_SP);
        db.execSQL(drop_product_table);

        onCreate(db);
    }
    public List<SanPhamModel> getSanPham() {
        List<SanPhamModel> sanPhamList = new ArrayList<>();
        SQLiteDatabase db = this.getReadableDatabase();
        String[] columns = {KEY_IMG_SP, KEY_IMG_TYPE, KEY_IMG_TEN_SP, KEY_IMG_GIA_SP, KEY_IMG_MOTA};
        Cursor cursor = db.query(TABLE_NAME_IMG_SP, columns, null, null, null, null, null);
        if (cursor.moveToFirst()) {
            do {
                int temp_img = cursor.getColumnIndex(KEY_IMG_SP);
                String imageSP = cursor.getString(temp_img);

                int temp_type = cursor.getColumnIndex(KEY_IMG_TYPE);
                String imageType = cursor.getString(temp_type);

                int temp_ten = cursor.getColumnIndex(KEY_IMG_TEN_SP);
                String imageTen = cursor.getString(temp_ten);

                int temp_gia = cursor.getColumnIndex(KEY_IMG_GIA_SP);
                String imageGia = cursor.getString(temp_gia);

                int temp_mota = cursor.getColumnIndex(KEY_IMG_MOTA);
                String imageMota = cursor.getString(temp_mota);

                SanPhamModel sanPham = new SanPhamModel(imageSP,imageType, imageTen, imageGia, imageMota);
                sanPhamList.add(sanPham);
            } while (cursor.moveToNext());
        }
        cursor.close();
        db.close();

        return sanPhamList;
    }


}
