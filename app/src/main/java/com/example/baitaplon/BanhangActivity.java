package com.example.baitaplon;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.baitaplon.Danh_Muc.SanPham;

import org.w3c.dom.Text;

public class BanhangActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_banhang);
        Bundle bundle = getIntent().getExtras();
        if (bundle == null){
            return;
        }
        SanPham sanPham = (SanPham) bundle.get("img");
        SanPham sp = (SanPham) bundle.get("text");
        ImageView img = findViewById(R.id.img_mathang);
        TextView textView = findViewById(R.id.thanh1);
        
        img.setImageResource(sanPham.getImg());
        textView.setText(sanPham.getTvName());
    }
}