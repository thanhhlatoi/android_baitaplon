package com.example.baitaplon.login_logout;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.baitaplon.Modun.DatabaseHandler;
import com.example.baitaplon.R;

public class DKy_MainActivity extends AppCompatActivity {
    private EditText text_dky_username, text_dky_password, text_dky_SDT;
    private AppCompatButton bt_dky_dangnhap;
    private DatabaseHandler dbHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.dkytk_main);
        text_dky_username = findViewById(R.id.text_dky_username);
        text_dky_password = findViewById(R.id.text_dky_password);
        text_dky_SDT = findViewById(R.id.text_dky_SDT);
        bt_dky_dangnhap = findViewById(R.id.bt_dky_dangnhap);
        dbHelper = new DatabaseHandler(this);
        bt_dky_dangnhap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String username = text_dky_username.getText().toString();
                String password = text_dky_password.getText().toString();
                String SDT = text_dky_SDT.getText().toString();

                // Thêm thông tin người dùng vào cơ sở dữ liệu
                if (username.length() > 0 && password.length() > 0) {
                    addUserToDatabase(username, password, SDT);
                    Toast.makeText(DKy_MainActivity.this, "Đăng ký thành công", Toast.LENGTH_SHORT).show();
                    finish(); // Kết thúc màn hình đăng ký và quay lại màn hình đăng nhập
                } else {
                    Toast.makeText(DKy_MainActivity.this, "Vui lòng điền đầy đủ thông tin", Toast.LENGTH_SHORT).show();
                }
            }

            private void addUserToDatabase(String username, String password, String sdt) {
                SQLiteDatabase db = dbHelper.getWritableDatabase();
                ContentValues values = new ContentValues();
                values.put(DatabaseHandler.KEY_NAME, username);
                values.put(DatabaseHandler.KEY_PASSWORD, password);
                values.put(DatabaseHandler.KEY_PHONE_NUMBER, sdt);
                db.insert(DatabaseHandler.TABLE_NAME, null, values);
                db.close();
            }
        });
    }
}
