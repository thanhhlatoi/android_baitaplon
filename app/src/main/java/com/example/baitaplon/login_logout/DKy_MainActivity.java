package com.example.baitaplon.login_logout;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.baitaplon.Danh_Muc.SanPham;
import com.example.baitaplon.Modun.Database;
import com.example.baitaplon.R;

import java.util.ArrayList;

public class DKy_MainActivity extends AppCompatActivity {
    private EditText text_dky_pq,text_dky_username, text_dky_password, text_dky_SDT,text_dky_datetime,text_dky_name;
    private AppCompatButton bt_dky_dangnhap;
    private  Database database;
    ArrayList<TaiKhoan> listTaiKhoan;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.dkytk_main);
        text_dky_username = findViewById(R.id.text_dky_username);
        text_dky_password = findViewById(R.id.text_dky_password);
        text_dky_SDT = findViewById(R.id.text_dky_SDT);
        text_dky_datetime = findViewById(R.id.text_dky_datetime);
        text_dky_pq = findViewById(R.id.text_dky_pq);
        text_dky_name = findViewById(R.id.text_dky_name);

        bt_dky_dangnhap = findViewById(R.id.bt_dky_dangnhap);
        database = new Database(DKy_MainActivity.this, "Quanly.sqlite", null, 1);
        database.QueryData("CREATE TABLE IF NOT EXISTS TaiKhoan (id INTEGER PRIMARY KEY AUTOINCREMENT, username VARCHAR(250), password VARCHAR(50), name VARCHAR(50), number VARCHAR(50), datetime VARCHAR(50), role INTEGER)");
        // dang ky tk
        bt_dky_dangnhap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Lấy dữ liệu từ các trường nhập liệu
                String username = text_dky_username.getText().toString().trim();
                String password = text_dky_password.getText().toString().trim();
                String name = text_dky_name.getText().toString().trim();
                String number = text_dky_SDT.getText().toString().trim();
                String datetime = text_dky_datetime.getText().toString().trim();
                String pq = text_dky_pq.getText().toString().trim();

                // Kiểm tra xem tất cả các trường nhập liệu có dữ liệu hợp lệ hay không
                if (username.isEmpty() || password.isEmpty() || name.isEmpty() || number.isEmpty() || datetime.isEmpty() || pq.isEmpty()) {
                    Toast.makeText(DKy_MainActivity.this, "Vui lòng điền đầy đủ thông tin!", Toast.LENGTH_SHORT).show();
                } else {
                    // Thêm tài khoản vào cơ sở dữ liệu
                    boolean result = database.INSERT_TAIKHOAN(username, password, name, number, datetime, pq);
                    if (result) {
                        // Thành công, hiển thị thông báo
                       // updateTaiKhoan();
                        Toast.makeText(DKy_MainActivity.this, "Thêm tài khoản thành công!", Toast.LENGTH_SHORT).show();
                    } else {
                        // Thất bại, hiển thị thông báo
                        Toast.makeText(DKy_MainActivity.this, "Thêm tài khoản thất bại!", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });
    }
    private void updateTaiKhoan(){
        listTaiKhoan.clear();
        Cursor cursor = database.GetData("SELECT * FROM TaiKhoan");
        if (cursor != null) {
            while (cursor.moveToNext()) {
                listTaiKhoan.add(new TaiKhoan(
                        cursor.getInt(0),
                        cursor.getString(1),
                        cursor.getString(2),
                        cursor.getString(3),
                        cursor.getString(4),
                        cursor.getString(5),
                        cursor.getString(6)
                ));
            }
            cursor.close();
        }
    }
}

