package com.example.baitaplon.Main_Account;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

import com.example.baitaplon.Blog_lamdep.Bloglamdep_main;
import com.example.baitaplon.R;

public class Account_main extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_account_main);


        ImageButton img_feed5 = findViewById(R.id.image_feed_5);
        ImageButton imageButton = findViewById(R.id.image_home_5);
        imageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
        img_feed5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Account_main.this, Bloglamdep_main.class);
                startActivity(intent);
            }
        });
    }
}