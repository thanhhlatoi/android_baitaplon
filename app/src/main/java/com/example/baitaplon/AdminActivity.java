package com.example.baitaplon;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.baitaplon.Danh_Muc.SanPham;
import com.example.baitaplon.Modun.Database;
import com.example.baitaplon.Mua_Hang.Mua_hangActivity;

import java.io.ByteArrayOutputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

public class AdminActivity extends AppCompatActivity {
    RecyclerView ryc_admin;
    EditText txt_tensp, txt_giasp, txt_motasp, txt_maloaisp;
    AppCompatButton bt_chonanh, bt_themsp, bt_suasp, bt_xoasp;
    ImageView img_sp;
    int REQUEST_CODE_FOLDER = 123;
    private Database database;
    ArrayList<SanPham> arraySanPham;
    admin_adapter adapter;
   // List<SanPham> sanPhamAdmin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin);
        img_sp = findViewById(R.id.img_sp);
        txt_tensp = findViewById(R.id.txt_tensp);
        txt_giasp = findViewById(R.id.txt_giasp);
        txt_motasp = findViewById(R.id.txt_motasp);
        txt_maloaisp = findViewById(R.id.txt_maloaisp);
        bt_xoasp = findViewById(R.id.bt_xoasp);

        ryc_admin = findViewById(R.id.ryc_admin);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this, RecyclerView.VERTICAL, false);
        ryc_admin.setLayoutManager(linearLayoutManager);
        // Khởi tạo adapter và thiết lập cho RecyclerView
        arraySanPham = new ArrayList<>();
        adapter = new admin_adapter(this, arraySanPham);
        ryc_admin.setAdapter(adapter);
        adapter.setIsInAdminActivity(true);


        // Khởi tạo và truy vấn cơ sở dữ liệu
        database = new Database(this, "Quanly.sqlite", null, 1);
        database.QueryData("CREATE TABLE IF NOT EXISTS SanPham(Id INTEGER PRIMARY KEY AUTOINCREMENT, Ten VARCHAR(250), Gia VARCHAR(50), HinhAnh BLOB,Mota VARCHAR(250), Maloai VARCHAR(250))");

        // Thêm sản phẩm
        bt_themsp = findViewById(R.id.bt_themsp);
        bt_themsp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Chuyển dữ liệu từ ImageView sang mảng byte[]
                BitmapDrawable bitmapDrawable = (BitmapDrawable) img_sp.getDrawable();
                Bitmap bitmap = bitmapDrawable.getBitmap();
                ByteArrayOutputStream byteArray = new ByteArrayOutputStream();
                bitmap.compress(Bitmap.CompressFormat.PNG, 100, byteArray);
                byte[] hinhAnh = byteArray.toByteArray();
                // Thêm sản phẩm vào cơ sở dữ liệu
                 database.INSERT_SANPHAM(
                        txt_tensp.getText().toString().trim(),
                        txt_giasp.getText().toString().trim(),
                        hinhAnh,
                        txt_motasp.getText().toString().trim(),
                        txt_maloaisp.getText().toString().trim()
                );
                Toast.makeText(AdminActivity.this, "Thêm sản phẩm thành công", Toast.LENGTH_LONG).show();
               updateSanPhamList();
            }
        });
        //sua san pham
        bt_suasp = findViewById(R.id.bt_suasp);
                bt_suasp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int productId = 1;
                BitmapDrawable bitmapDrawable = (BitmapDrawable) img_sp.getDrawable();
                Bitmap bitmap = bitmapDrawable.getBitmap();
                ByteArrayOutputStream byteArray = new ByteArrayOutputStream();
                bitmap.compress(Bitmap.CompressFormat.PNG, 100, byteArray);
                byte[] hinhAnh = byteArray.toByteArray();
                boolean result = database.UPDATE_SANPHAM(
                        productId,
                        txt_tensp.getText().toString().trim(),
                        txt_giasp.getText().toString().trim(),
                        hinhAnh,
                        txt_motasp.getText().toString().trim(),
                        txt_maloaisp.getText().toString().trim()
                );

                if (result) {
                    Toast.makeText(AdminActivity.this, "Cập nhật sản phẩm thành công", Toast.LENGTH_LONG).show();
                  //  updateSanPhamList();
                } else {
                    Toast.makeText(AdminActivity.this, "Cập nhật sản phẩm thất bại", Toast.LENGTH_LONG).show();
                }

            }
        });
        // Mở file ảnh
        bt_chonanh = findViewById(R.id.bt_chonanh);
        bt_chonanh.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Intent.ACTION_PICK);
                intent.setType("image/*");
                startActivityForResult(intent, REQUEST_CODE_FOLDER);
            }
        });
        // Khởi tạo danh sách sản phẩm và cập nhật RecyclerView
       updateSanPhamList();
    }

    // Phương thức cập nhật danh sách sản phẩm và cập nhật RecyclerView
   private void updateSanPhamList() {
            arraySanPham.clear(); // Xóa dữ liệu cũ
            Cursor cursor = database.GetData("SELECT * FROM SanPham");
            if (cursor != null) {
                while (cursor.moveToNext()) {
                    arraySanPham.add(new SanPham(
                            cursor.getInt(0),
                            cursor.getString(1),
                            cursor.getString(2),
                            cursor.getBlob(3),
                            cursor.getString(4),
                            cursor.getString(5)
                    ));
                }
                cursor.close();
        }
        adapter.notifyDataSetChanged(); // Cập nhật lại RecyclerView
    }


//hinh anh
    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == REQUEST_CODE_FOLDER && resultCode == RESULT_OK && data != null){
            Uri uri = data.getData();
            try {
                InputStream inputStream = getContentResolver().openInputStream(uri);
                Bitmap bitmap = BitmapFactory.decodeStream(inputStream);
                img_sp.setImageBitmap(bitmap);
            } catch (FileNotFoundException e) {
                throw new RuntimeException(e);
            }
        }


    }


//    @Override
//    protected void onStart() {
//        super.onStart();
//        //updateSanPhamList();
//    }
}
