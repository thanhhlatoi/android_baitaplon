package com.example.baitaplon.Danh_Muc;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

import com.example.baitaplon.Blog_lamdep.Blog;
import com.example.baitaplon.Main.AnhMhc;
import com.example.baitaplon.Main_Account.Account_main;
import com.example.baitaplon.Blog_lamdep.Bloglamdep_main;
import com.example.baitaplon.R;

import java.util.ArrayList;
import java.util.List;

public class surum extends AppCompatActivity {
    private RecyclerView rcv_danhmuc;
    private RecyclerView rcv_sanpham;
    private DanhMuc_Adapter danhMucAdapter;
    private boolean isRecyclerViewVisible = false; // Biến để kiểm tra trạng thái của RecyclerView


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activityserum);
        //ImageButton imageButton_
        ImageButton imageButton_sp = findViewById(R.id.imageArrowright);
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
                    List<SanPham> sanPhamList = getSanPham();
                    SanPham_Adapter sanPham_Adapter = new SanPham_Adapter(surum.this, getSanPham());
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
    }

    private List<DanhMuc> getDanhMuc() {
        // Ở đây, bạn cần thay thế phần này để tạo danh sách thực tế của bạn từ nguồn dữ liệu nào đó.
        List<DanhMuc> danhMucList = new ArrayList<>();
        danhMucList.add(new DanhMuc("Sữa Rửa Mặt"));
        return danhMucList;
    }

    private List<SanPham> getSanPham() {
        List<SanPham> sanPhamList = new ArrayList<>();
        // Thêm các đối tượng SanPham vào danh sách
        sanPhamList.add(new SanPham("sua rua mat",R.drawable.img_image11,"300.000d"));
        sanPhamList.add(new SanPham("kem chong nang",R.drawable.img_image12,"430.000d"));
        sanPhamList.add(new SanPham("surum",R.drawable.img_image13_138x127,"280.000d"));
        sanPhamList.add(new SanPham("300.000d",R.drawable.img_rectangle114_8,"300.000d"));
        sanPhamList.add(new SanPham("300.000d",R.drawable.img_rectangle116,"300.000d"));
        sanPhamList.add(new SanPham("300.000d",R.drawable.img_rectangle116_162x147,"400.000d"));
        sanPhamList.add(new SanPham("300.000d",R.drawable.img_rectangle255_286x331,"300.000d"));
        sanPhamList.add(new SanPham("300.000d",R.drawable.img_rectangle258,"530.000d"));
        sanPhamList.add(new SanPham("300.000d",R.drawable.img_rectangle238,"360.000d"));
        sanPhamList.add(new SanPham("300.000d",R.drawable.img_rectangle238_1,"200.000d"));
        sanPhamList.add(new SanPham("300.000d",R.drawable.img_rectangle238_2,"550.000d"));
        sanPhamList.add(new SanPham("300.000d",R.drawable.img_9d9c1c7a81d0d1e,"250.000d"));
        sanPhamList.add(new SanPham("300.000d",R.drawable.img_rectangle238_3,"230.000d"));
        sanPhamList.add(new SanPham("300.000d",R.drawable.img_9d9c1c7a81d0d1e,"330.000d"));
        sanPhamList.add(new SanPham("300.000d",R.drawable.img_image11,"300.000d"));
        sanPhamList.add(new SanPham("300.000d",R.drawable.img_image11,"300.000d"));
        sanPhamList.add(new SanPham("300.000d",R.drawable.img_image11,"300.000d"));
        sanPhamList.add(new SanPham("300.000d",R.drawable.img_image11,"300.000d"));
        sanPhamList.add(new SanPham("300.000d",R.drawable.img_image11,"300.000d"));
        sanPhamList.add(new SanPham("300.000d",R.drawable.img_image11,"300.000d"));
        sanPhamList.add(new SanPham("300.000d",R.drawable.img_image11,"300.000d"));
        sanPhamList.add(new SanPham("300.000d",R.drawable.img_image11,"300.000d"));
        sanPhamList.add(new SanPham("300.000d",R.drawable.img_image11,"300.000d"));
        sanPhamList.add(new SanPham("300.000d",R.drawable.img_image11,"300.000d"));
        return sanPhamList;
    }
}
