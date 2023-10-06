package com.example.baitaplon.Mua_Hang;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.baitaplon.Danh_Muc.SanPham;
import com.example.baitaplon.Modun.Database;
import com.example.baitaplon.R;

import java.util.ArrayList;

public class Mua_hangActivity extends AppCompatActivity {
    private ImageView img_add,img_tru,layout_img_gio;
    private TextView txt_sl;
    private int counter = 0;
    public static Database database;
    private TextView txt_gtsp,txt_giasp,txt_mota;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mua_sp);
        txt_giasp = findViewById(R.id.txt_giasp);
        txt_gtsp = findViewById(R.id.txt_gtsp);
        txt_mota = findViewById(R.id.txt_mota);
        img_add = findViewById(R.id.img_add);
        img_tru = findViewById(R.id.img_tru);
        txt_sl = findViewById(R.id.txt_sl);
// nhan hinh anh
       byte[] byteArray = getIntent().getByteArrayExtra("image_data");
        Bitmap bitmap = BitmapFactory.decodeByteArray(byteArray, 0, byteArray.length);
        ImageView imageView = findViewById(R.id.img_muasp); // Thay thế bằng ID của ImageView của bạn
        imageView.setImageBitmap(bitmap);
        //nhan ten va gia
        String productName = getIntent().getStringExtra("product_name");
        txt_gtsp.setText(productName);
        String productGia = getIntent().getStringExtra("productGia");
        txt_giasp.setText(productGia);
        String mota = getIntent().getStringExtra("mota");
        txt_mota.setText(mota);

        // nut tang giam
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
        // tao bang sql
        //tao bang
        database = new Database(this,"Quanly.sqlite",null,1);
        database.QueryData("CREATE TABLE IF NOT EXISTS GioHang(Id_gh INTEGER PRIMARY KEY AUTOINCREMENT,Tensp VARCHAR(250),SoLuong INT,KichCo VARCHAR(20),id INTEGER,FOREIGN KEY(id) REFERENCES TaiKhoan(id))");

        // them san pham
        AppCompatButton bt_them_vao_gio = findViewById(R.id.bt_them_gio_hang);
        bt_them_vao_gio.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String tensp = txt_gtsp.getText().toString().trim();
                String SoLuong = txt_sl.getText().toString().trim();
                String KichCo = txt_mota.getText().toString().trim();
                boolean insertSuccess = database.INSERT_GIOHANG(tensp, SoLuong, KichCo);

                if (insertSuccess) {
                    // Chèn dữ liệu thành công, bạn có thể thông báo cho người dùng
                    Toast.makeText(Mua_hangActivity.this, "Chèn dữ liệu thành công", Toast.LENGTH_SHORT).show();
                } else {
                    // Chèn dữ liệu không thành công, bạn có thể thông báo cho người dùng
                    Toast.makeText(Mua_hangActivity.this, "Chèn dữ liệu không thành công", Toast.LENGTH_SHORT).show();
                }
            }
        });

    }

}