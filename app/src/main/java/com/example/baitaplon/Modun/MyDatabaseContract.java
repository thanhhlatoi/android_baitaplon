package com.example.baitaplon.Modun;

import android.provider.BaseColumns;

public class MyDatabaseContract {
    public static final String DATABASE_NAME = "my_database.db";
    public static final int DATABASE_VERSION = 1;

    public static class ProductEntry implements BaseColumns {
        public static final String TABLE_NAME = "products";
        public static final String COLUMN_NAME = "name";
        public static final String COLUMN_PRICE = "price";
    }
}
