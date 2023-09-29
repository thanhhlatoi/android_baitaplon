package com.example.baitaplon.Modun;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.example.baitaplon.Modun.MyDatabaseContract;

public class MyDatabaseHelper extends SQLiteOpenHelper {
    public MyDatabaseHelper(Context context) {
        super(context, MyDatabaseContract.DATABASE_NAME, null, MyDatabaseContract.DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        // Tạo bảng và định nghĩa cấu trúc của bảng ở đây
        String SQL_CREATE_PRODUCTS_TABLE = "CREATE TABLE " +
                MyDatabaseContract.ProductEntry.TABLE_NAME + " (" +
                MyDatabaseContract.ProductEntry._ID + " INTEGER PRIMARY KEY, " +
                MyDatabaseContract.ProductEntry.COLUMN_NAME + " TEXT NOT NULL, " +
                MyDatabaseContract.ProductEntry.COLUMN_PRICE + " REAL NOT NULL);";

        db.execSQL(SQL_CREATE_PRODUCTS_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // Nếu bạn muốn nâng cấp cơ sở dữ liệu, thực hiện các thay đổi tại đây
    }
}
