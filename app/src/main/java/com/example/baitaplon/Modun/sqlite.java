package com.example.baitaplon.Modun;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class sqlite extends SQLiteOpenHelper {

    public sqlite(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }
    public void QueryData( String sql){
        SQLiteDatabase data= getWritableDatabase();
        data.execSQL(sql);
    }
    public Cursor getData(String sql){
        SQLiteDatabase data= getReadableDatabase();
        return data.rawQuery(sql, null);
    }
    public void insertData(String tbl_dky, ContentValues values) {
        SQLiteDatabase database = getWritableDatabase();
        database.insert(tbl_dky, null, values);
        database.close();
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }

}
