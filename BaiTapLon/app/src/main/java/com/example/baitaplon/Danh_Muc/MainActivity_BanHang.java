package com.example.baitaplon.Danh_Muc;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import com.example.baitaplon.R;

import org.w3c.dom.Text;

public class MainActivity_BanHang extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_ban_hang);

        Bundle bundle = getIntent().getExtras();
        if (bundle == null){
            return;
        }
        SanPham sanPham = (SanPham) bundle.get("san_pham");
        TextView textView_1 = findViewById(R.id.txthihi);
        textView_1.setText(sanPham.getTvName());
    }
}