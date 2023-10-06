package com.example.baitaplon.Main;

import static com.example.baitaplon.R.id.toolbartrang_chu;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.ViewFlipper;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.baitaplon.AdminActivity;
import com.example.baitaplon.Blog_lamdep.Bloglamdep_main;
import com.example.baitaplon.Main_Account.Account_main;
import com.example.baitaplon.R;
import com.example.baitaplon.SaleActivity;
import com.example.baitaplon.thongbao.ThongbaoActivity;
import com.example.baitaplon.thongbao.item_menu;
import com.example.baitaplon.Danh_Muc.surum;
import com.google.android.material.navigation.NavigationView;

import java.util.ArrayList;
import java.util.List;


public class MainActivity extends AppCompatActivity {
Toolbar toolbar;
ViewFlipper viewFlipper;
RecyclerView recyclerView;
NavigationView navigationView;
ListView listView;
DrawerLayout drawerLayout;
ArrayList<item_menu> arrayList;
MenuAdapter adapter;
ImageButton imageButton;
ImageView imageView;
ImageButton img_admin;


    @SuppressLint({"WrongViewCast", "MissingInflatedId"})
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        toolbar= findViewById(toolbartrang_chu);
        viewFlipper = findViewById(R.id.viewflipper_trangchu);
        navigationView = findViewById(R.id.navigationView);
        listView = findViewById(R.id.listviewmanhinhchinh);
        drawerLayout = findViewById(R.id.drawer_layout);
        //admin
        img_admin = findViewById(R.id.img_admin);
        img_admin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, AdminActivity.class);
                startActivity(intent);
            }
        });
        //thong bao
        imageView = findViewById(R.id.img_thongbao);
        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, ThongbaoActivity.class);
                startActivity(intent);
            }
        });

        ImageButton img_sp_mhc = findViewById(R.id.image_sp_mhc);

        img_sp_mhc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, surum.class);
                startActivity(intent);
            }
        });

        ImageButton img_acc = findViewById(R.id.image_tk_sp);

        img_acc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, Account_main.class);
                startActivity(intent);
            }
        });

        //chay anh
        recyclerView = findViewById(R.id.rcy_mhc);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this, RecyclerView.HORIZONTAL, false);
        recyclerView.setLayoutManager(linearLayoutManager);
        List<AnhMhc> anhMhcList = getMyPham();
        AnhMhc_Adapter adapter = new AnhMhc_Adapter(MainActivity.this,anhMhcList);
        adapter.setData(anhMhcList);
        recyclerView.setAdapter(adapter);

        chayanh();
        actionToolBar();
        actionMenu();
        AppCompatButton bt_sale = findViewById(R.id.bt_sale);
        bt_sale.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, SaleActivity.class);
                startActivity(intent);
            }
        });
     //ket thuc


    }
    private void chayanh() {
        List<Integer> danhSachAnh = new ArrayList<>();
        danhSachAnh.add(R.drawable.img_1212_199x374);
        danhSachAnh.add(R.drawable.img_1212);
        danhSachAnh.add(R.drawable.img_rectangle274);
        danhSachAnh.add(R.drawable.img_rectangle275);



        for (int i = 0; i < danhSachAnh.size(); i++) {
            ImageView imageView = new ImageView(getApplicationContext());
            imageView.setImageResource(danhSachAnh.get(i));
            imageView.setScaleType(ImageView.ScaleType.FIT_XY);
            viewFlipper.addView(imageView);
        }

        viewFlipper.setFlipInterval(3000);
        viewFlipper.setActivated(true);
        Animation slideIn = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.sile_in_right);
        Animation slideOut = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.sile_out_right);
        viewFlipper.setInAnimation(slideIn);
        viewFlipper.setOutAnimation(slideOut);
        viewFlipper.startFlipping();
    }
    private void actionToolBar(){
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        toolbar.setNavigationIcon(R.drawable.ic_action_menuu);
        toolbar.setNavigationOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {

                drawerLayout.openDrawer(GravityCompat.START);
            }
        });

    }
    private void actionMenu(){
        arrayList = new ArrayList<>();
        arrayList.add(new item_menu("Giới Thiệu",R.drawable.ic_action_add));
        arrayList.add(new item_menu("NASKIN BEAUTY",R.drawable.ic_action_add));
        arrayList.add(new item_menu("Sản Phẩm Mới",R.drawable.ic_action_add));
        arrayList.add(new item_menu("Sản Phẩm Khuyến Mãi",R.drawable.ic_action_add));
        arrayList.add(new item_menu("Vận Chuyển",R.drawable.ic_action_add));
        arrayList.add(new item_menu("Chính Sách Đổi Trả",R.drawable.ic_action_add));
        adapter = new MenuAdapter(this,R.layout.dong_item,arrayList);
        listView.setAdapter(adapter);
    }
    private List<AnhMhc> getMyPham() {
        List<AnhMhc> ListAnh = new ArrayList<>();
        ListAnh.add(new AnhMhc(R.drawable.img_9d9c1c7a81d0d1e,"300.000","400.000"));
        ListAnh.add(new AnhMhc(R.drawable.img_9d9c1c7a81d0d1e,"400.000","400.000"));
        ListAnh.add(new AnhMhc(R.drawable.img_9d9c1c7a81d0d1e,"500.000","450.000"));
        ListAnh.add(new AnhMhc(R.drawable.img_9d9c1c7a81d0d1e,"600.000","430.000"));
        ListAnh.add(new AnhMhc(R.drawable.img_9d9c1c7a81d0d1e,"700.000","330.000"));
        ListAnh.add(new AnhMhc(R.drawable.img_9d9c1c7a81d0d1e,"800.000","110.000"));
        ListAnh.add(new AnhMhc(R.drawable.img_9d9c1c7a81d0d1e,"700.000","660.000"));
        ListAnh.add(new AnhMhc(R.drawable.img_9d9c1c7a81d0d1e,"500.000","220.000"));
        ListAnh.add(new AnhMhc(R.drawable.img_9d9c1c7a81d0d1e,"900.000","110.000"));
        ListAnh.add(new AnhMhc(R.drawable.img_9d9c1c7a81d0d1e,"300.000","330.000"));
        ListAnh.add(new AnhMhc(R.drawable.img_9d9c1c7a81d0d1e,"100.000","110.000"));
        return ListAnh;
    }
}

