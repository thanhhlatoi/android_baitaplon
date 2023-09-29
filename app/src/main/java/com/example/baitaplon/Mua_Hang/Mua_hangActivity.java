package com.example.baitaplon.Mua_Hang;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.baitaplon.Danh_Muc.SanPham;
import com.example.baitaplon.R;

public class Mua_hangActivity extends AppCompatActivity {
    private ImageView img_add,img_tru,layout_img_gio;

    private TextView txt_sl;
    private int counter = 0;
    int itemCount = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mua_sp);

        Bundle bundle = getIntent().getExtras();
        if (bundle == null){
            return;
        }
        SanPham sanPham = (SanPham) bundle.get("img");
        ImageView img_muasp = findViewById(R.id.img_muasp);
        img_muasp.setImageResource(sanPham.getImg());
        SanPham sanPhamm = (SanPham) bundle.get("text_gtsp");
        TextView txt_gtsp = findViewById(R.id.txt_gtsp);
        txt_gtsp.setText(sanPhamm.getTvName());
        SanPham sanpham = (SanPham) bundle.get("text_giasp");
        TextView textView = findViewById(R.id.txt_giasp);
        textView.setText(sanpham.getTvName_gia());

        txt_sl = findViewById(R.id.txt_sl);
        img_add = findViewById(R.id.img_add);
        img_tru = findViewById(R.id.img_tru);
        img_add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                counter++;
                txt_sl.setText(Integer.toString(counter));
            }
        });
        img_tru.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                counter--;
                txt_sl.setText(Integer.toString(counter));
            }
        });
        //iten gio hang
        layout_img_gio = findViewById(R.id.layout_img_gio);
        layout_img_gio.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Mua_hangActivity.this, GiohangActivity.class);
                startActivity(intent);
            }
        });
        // them san pham

        AppCompatButton bt_them_vao_gio = findViewById(R.id.bt_them_gio_hang);
        bt_them_vao_gio.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                CartItem cartItem = new CartItem(R.drawable.img_1, sanPhamm.getTvName(), sanpham.getTvName_gia());
            }
        });

    }

}