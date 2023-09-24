package com.example.baitaplon.login_logout;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.baitaplon.R;

public class Login_MainActivity extends AppCompatActivity {
    AppCompatButton bt_dky;
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
        
    }
}