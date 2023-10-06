package com.example.baitaplon.Danh_Muc;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.example.baitaplon.AdminActivity;
import com.example.baitaplon.Modun.Database;
import com.example.baitaplon.R;
import com.example.baitaplon.admin_adapter;

import java.util.ArrayList;

public class surum extends AppCompatActivity {

    private RecyclerView rcv_sanpham;
    public static Database database;
    ArrayList<SanPham> arraySanPham;
    admin_adapter adapter;
    AppCompatButton bt_admin;

    private boolean isRecyclerViewVisible = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activityserum);

        // Tao bang CT_SanPham
            database = new Database(this, "Quanly.sqlite", null, 1);
            database.QueryData("CREATE TABLE IF NOT EXISTS CT_SanPham(Id_sp INTEGER PRIMARY KEY AUTOINCREMENT,Id INTEGER,Id_gh INTEGER, FOREIGN KEY (Id) REFERENCES SanPham(Id), FOREIGN KEY (Id_gh) REFERENCES GioHang(Id_gh))");
        // hien thi san pham
        rcv_sanpham = findViewById(R.id.rcy_sanpham);
        AppCompatButton button_sanpham = findViewById(R.id.bt_sanpham);

        GridLayoutManager gridLayoutManager = new GridLayoutManager(this, 2);
        rcv_sanpham.setLayoutManager(gridLayoutManager);
        // Khởi tạo adapter và thiết lập cho RecyclerView
        arraySanPham = new ArrayList<>();
        adapter = new admin_adapter(surum.this, arraySanPham);
        adapter.setIsInAdminActivity(false);
        rcv_sanpham.setAdapter(adapter);
        // Lấy danh sách sản phẩm từ cơ sở dữ liệu
        getSanPham();
        button_sanpham.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Hiển thị thông báo khi nút được nhấn
                Toast.makeText(surum.this, "Mở lên thành công", Toast.LENGTH_SHORT).show();
            }
        });
        // Nút admin
        bt_admin = findViewById(R.id.bt_admin);
        bt_admin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(surum.this, AdminActivity.class);
                startActivity(intent);
            }
        });
    }
    private void getSanPham() {
        // Truy vấn dữ liệu từ cơ sở dữ liệu
        SQLiteDatabase db = database.getWritableDatabase();
        Cursor cursor = db.rawQuery("SELECT Id, Ten, Gia, HinhAnh FROM SanPham", null);

        if (cursor != null) {
            int idColumnIndex = cursor.getColumnIndex("Id");
            int tenColumnIndex = cursor.getColumnIndex("Ten");
            int giaColumnIndex = cursor.getColumnIndex("Gia");
            int hinhColumnIndex = cursor.getColumnIndex("HinhAnh");

            while (cursor.moveToNext()) {
                int id = cursor.getInt(idColumnIndex);
                String ten = cursor.getString(tenColumnIndex);
                String gia = cursor.getString(giaColumnIndex);
                byte[] hinh = cursor.getBlob(hinhColumnIndex);
                // Hiển thị hoặc sử dụng dữ liệu của từng cột ở đây
                arraySanPham.add(new SanPham(id, ten, gia, hinh));
            }
            cursor.close();
            adapter.notifyDataSetChanged();
        }
    }
}
