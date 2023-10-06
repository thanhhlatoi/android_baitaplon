package com.example.baitaplon.login_logout;
import static com.example.baitaplon.Danh_Muc.surum.database;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.baitaplon.Main.MainActivity;
import com.example.baitaplon.Modun.Database;
import com.example.baitaplon.R;

public class Login_MainActivity extends AppCompatActivity {
       private   AppCompatButton bt_dky,bt_login_dangnhap;
       private Database database;
    private EditText text_login_password,text_login_username;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_main);
        bt_dky = findViewById(R.id.bt_dangky);
        bt_dky.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Login_MainActivity.this, DKy_MainActivity.class);
                startActivity(intent);
            }
        });
        // tao bang database
//        Database database = new Database(Login_MainActivity.this,"QuanLy.sqlite",null,3);
//        database.QueryData("CREATE TABLE IF NOT EXISTS TaiKhoan(Id INTEGER PRIMARY KEY AUTOINCREMENT, username VARCHAR(250), password VARCHAR(50), name VARCHAR(50), number VARCHAR(50),datetime VARCHAR(50), role INTEGER(2) )");

        // dang nhap
        text_login_username = findViewById(R.id.text_login_uesrname);
        text_login_password = findViewById(R.id.text_login_password);
        bt_login_dangnhap = findViewById(R.id.bt_login_dangnhap);
        database = new Database(Login_MainActivity.this,"Quanly.sqlite",null,1);
        bt_login_dangnhap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String username = text_login_username.getText().toString();
                String password = text_login_password.getText().toString();
                boolean isAuthenticated = authenticateUser(username, password);

                if (isAuthenticated) {
                    // Đăng nhập thành công, chuyển đến màn hình chính
                    Intent intent = new Intent(Login_MainActivity.this, MainActivity.class);
                    startActivity(intent);
                    Toast.makeText(Login_MainActivity.this,"dang nhap thanh cong",Toast.LENGTH_SHORT).show();
                    finish(); // Đóng màn hình đăng nhập
                } else {
                    // Đăng nhập không thành công, hiển thị thông báo lỗi
                    Toast.makeText(Login_MainActivity.this, "Đăng nhập không thành công!", Toast.LENGTH_SHORT).show();
                }


            }

            private boolean authenticateUser(String username, String password) {
                SQLiteDatabase db = database.getReadableDatabase();
                Cursor cursor = db.rawQuery("SELECT * FROM TaiKhoan WHERE username = ? AND password = ?", new String[]{username, password});

                boolean isAuthenticated = cursor.moveToFirst();
                cursor.close();
                return isAuthenticated;
            }
        });
    }
}