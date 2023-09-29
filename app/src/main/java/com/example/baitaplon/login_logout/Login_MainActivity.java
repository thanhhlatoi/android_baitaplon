package com.example.baitaplon.login_logout;
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
import com.example.baitaplon.Modun.DatabaseHandler;
import com.example.baitaplon.R;

public class Login_MainActivity extends AppCompatActivity {
       private   AppCompatButton bt_dky,bt_login_dangnhap;
    private DatabaseHandler dbHelper;
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

        // dang nhap
        text_login_username = findViewById(R.id.text_login_uesrname);
        text_login_password = findViewById(R.id.text_login_password);
        bt_login_dangnhap = findViewById(R.id.bt_login_dangnhap);
        dbHelper = new DatabaseHandler(this);
        bt_login_dangnhap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String username = text_login_username.getText().toString();
                String password = text_login_password.getText().toString();

                // Kiểm tra thông tin đăng nhập với cơ sở dữ liệu
                if (isValidLogin(username, password)) {
                    Intent intent = new Intent(Login_MainActivity.this, MainActivity.class);
                    startActivity(intent);
                } else {
                    // Đăng nhập không thành công, hiển thị thông báo lỗi
                    Toast.makeText(Login_MainActivity.this, "Đăng nhập không thành công. Vui lòng kiểm tra tên đăng nhập và mật khẩu.", Toast.LENGTH_SHORT).show();
                }
            }

            private boolean isValidLogin(String username, String password) {
                SQLiteDatabase db = dbHelper.getReadableDatabase();
                String[] projection = {DatabaseHandler.KEY_NAME, DatabaseHandler.KEY_PASSWORD};
                String selection = DatabaseHandler.KEY_NAME + " = ? AND " + DatabaseHandler.KEY_PASSWORD + " = ?";
                String[] selectionArgs = {username, password};

                Cursor cursor = db.query(DatabaseHandler.TABLE_NAME, projection, selection, selectionArgs, null, null, null);
                int count = cursor.getCount();
                cursor.close();

                return count > 0;
            }
        });
    }
}