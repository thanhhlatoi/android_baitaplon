package com.example.baitaplon.Danh_Muc;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

import com.example.baitaplon.Blog_lamdep.Blog;
import com.example.baitaplon.Main.AnhMhc;
import com.example.baitaplon.Main_Account.Account_main;
import com.example.baitaplon.Blog_lamdep.Bloglamdep_main;
import com.example.baitaplon.Modun.DatabaseHandler;
import com.example.baitaplon.Modun.SanPhamModel;
import com.example.baitaplon.R;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class surum extends AppCompatActivity {
    private SanPham_Adapter sanPham_Adapter;
    private RecyclerView rcv_danhmuc;
    private RecyclerView rcv_sanpham;
    private DanhMuc_Adapter danhMucAdapter;
    private List<SanPham> sanPhamList;
    private boolean isRecyclerViewVisible = false; // Biến để kiểm tra trạng thái của RecyclerView


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activityserum);
        ImageButton imageButton_home = findViewById(R.id.img_homesp);
        ImageButton imageButton_b = findViewById(R.id.image_tk_sp);
        ImageButton imageButton_blog = findViewById(R.id.image_feed_sp);
        AppCompatButton button_danhmuc = findViewById(R.id.bt_danhmuc);
        AppCompatButton button_sanpham = findViewById(R.id.bt_sanpham);
        imageButton_b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(surum.this, Account_main.class);
                startActivity(intent);
            }
        });
        imageButton_home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
        imageButton_blog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(surum.this, Bloglamdep_main.class);
                startActivity(intent);
            }
        });


        //bt danh muc
        rcv_danhmuc = findViewById(R.id.rcy_data);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        RecyclerView.ItemDecoration itemDecoration = new DividerItemDecoration(this,DividerItemDecoration.HORIZONTAL);
        rcv_danhmuc.addItemDecoration(itemDecoration);
        button_danhmuc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                rcv_danhmuc.setLayoutManager(linearLayoutManager);
                if (!isRecyclerViewVisible) {
                    // Nếu RecyclerView chưa hiển thị, hãy hiển thị nó
                    isRecyclerViewVisible = true;
                    rcv_danhmuc.setVisibility(View.VISIBLE);
                    danhMucAdapter = new DanhMuc_Adapter(getDanhMuc());
                    rcv_danhmuc.setAdapter(danhMucAdapter);
                } else {
                    // Nếu RecyclerView đang hiển thị, hãy ẩn nó
                    isRecyclerViewVisible = false;
                    rcv_danhmuc.setVisibility(View.GONE);
                }
            }
        });

        //bt san pham
        rcv_sanpham = findViewById(R.id.rcy_sanpham);
        GridLayoutManager gridLayoutManager = new GridLayoutManager(this, 2);
        rcv_sanpham.setLayoutManager(gridLayoutManager);
        button_sanpham.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                rcv_sanpham.setLayoutManager(gridLayoutManager);
                if (!isRecyclerViewVisible) {
                    // Nếu RecyclerView chưa hiển thị, hãy hiển thị nó
                    isRecyclerViewVisible = true;
                    rcv_sanpham.setVisibility(View.VISIBLE);
                    List<SanPhamModel> sanPhamList = getSanPham();
                    SanPham_Adapter sanPham_Adapter = new SanPham_Adapter(surum.this ,sanPhamList);
                    sanPham_Adapter.setData_SanPham(sanPhamList);
                    rcv_sanpham.setAdapter(sanPham_Adapter);

                }

                else {
                    // Nếu RecyclerView đang hiển thị, hãy ẩn nó
                    isRecyclerViewVisible = false;
                    rcv_sanpham.setVisibility(View.GONE);
                }
            }
        });

        //bt gia
    /*    AppCompatButton bt_sapxep = findViewById(R.id.bt_sapxep);
        bt_sapxep.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("NotifyDataSetChanged")
            @Override
            public void onClick(View view) {
                sortSanPhamList(getSanPham());
                sanPham_Adapter.notifyDataSetChanged();
            }

            private void sortSanPhamList(List<SanPham> sanPhamList) {
                int n = sanPhamList.size();
                for (int i = 1; i < n; i++) {
                    SanPham key = sanPhamList.get(i);
                    int j = i - 1;
                    double giaKey = extractDouble(key.getTvName_gia());

                    while (j >= 0 && extractDouble(sanPhamList.get(j).getTvName_gia()) > giaKey) {
                        sanPhamList.set(j + 1, sanPhamList.get(j));
                        j = j - 1;
                    }
                    sanPhamList.set(j + 1, key);
                }
            }


            private double extractDouble(String s) {
                try {
                    s = s.replace("d", "").trim(); // Loại bỏ 'd' và khoảng trắng
                    return Double.parseDouble(s);
                } catch (NumberFormatException e) {
                    // Xử lý lỗi khi không thể chuyển đổi thành số, ví dụ: "Không xác định"
                    return 0.0; // Hoặc giá trị mặc định khác tùy theo trường hợp
                }
            }
        });   */
        //sale

        //ket thuc
    }

    private List<DanhMuc> getDanhMuc() {
        // Ở đây, bạn cần thay thế phần này để tạo danh sách thực tế của bạn từ nguồn dữ liệu nào đó.
        List<DanhMuc> danhMucList = new ArrayList<>();
        danhMucList.add(new DanhMuc("Sữa Rửa Mặt"));
        return danhMucList;
    }

    public List<SanPhamModel> getSanPham() {
        List<SanPhamModel> sanPhamList = new ArrayList<>();
      //  sanPhamList.add(new SanPhamModel(, "Loại sản phẩm", "Tên sản phẩm 1", "300.000", "Mô tả sản phẩm 1"));
       // sanPhamList.add(new SanPhamModel(R.drawable.img_image12, "Loại sản phẩm", "Tên sản phẩm 2", "430.000", "Mô tả sản phẩm 2"));

        // Thêm các đối tượng SanPham vào danh sách
       /* sanPhamList.add(new SanPham("Kem Dưỡng Ẩm Klairs Midnight Blue Claming",R.drawable.img_image11,"300000"));
        sanPhamList.add(new SanPham("kem chong nansg",R.drawable.img_image12,"430000"));
        sanPhamList.add(new SanPham("surum",R.drawable.img_image13_138x127,"280000"));
        sanPhamList.add(new SanPham("Tinh Chất Dear Klairs Dưỡng Ẩm",R.drawable.img_rectangle114_8,"332000"));
        sanPhamList.add(new SanPham("son",R.drawable.img_rectangle116,"300000"));
        sanPhamList.add(new SanPham("300.000d",R.drawable.img_rectangle116_162x147,"400000"));
        sanPhamList.add(new SanPham("300.000d",R.drawable.img_rectangle255_286x331,"300000"));
        sanPhamList.add(new SanPham("300.000d",R.drawable.img_rectangle258,"530000"));
        sanPhamList.add(new SanPham("300.000d",R.drawable.img_rectangle238,"360000"));
        sanPhamList.add(new SanPham("300.000d",R.drawable.img_rectangle238_1,"200000"));
        sanPhamList.add(new SanPham("300.000d",R.drawable.img_rectangle238_2,"550000"));
        sanPhamList.add(new SanPham("300.000d",R.drawable.img_9d9c1c7a81d0d1e,"250000"));
        sanPhamList.add(new SanPham("300.000d",R.drawable.img_rectangle238_3,"230000"));
        sanPhamList.add(new SanPham("300.000d",R.drawable.img_9d9c1c7a81d0d1e,"330000"));
        sanPhamList.add(new SanPham("300.000d",R.drawable.img_image11,"310000"));
        sanPhamList.add(new SanPham("300.000d",R.drawable.img_image11,"312000"));
        sanPhamList.add(new SanPham("300.000d",R.drawable.img_image11,"398000"));
        sanPhamList.add(new SanPham("300.000d",R.drawable.img_image11,"350000"));
        sanPhamList.add(new SanPham("300.000d",R.drawable.img_image11,"360000"));
        sanPhamList.add(new SanPham("300.000d",R.drawable.img_image11,"390000"));
        sanPhamList.add(new SanPham("300.000d",R.drawable.img_image11,"302000"));
        sanPhamList.add(new SanPham("300.000d",R.drawable.img_image11,"391000"));
        sanPhamList.add(new SanPham("300.000d",R.drawable.img_image11,"600000"));
        sanPhamList.add(new SanPham("300.000d",R.drawable.img_image11,"700000"));  */
        return sanPhamList;
    }


}
