package com.example.baitaplon.Mua_Hang;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.graphics.Bitmap;
import android.os.Bundle;

import com.example.baitaplon.Modun.Database;
import com.example.baitaplon.R;
import java.util.ArrayList;
import java.util.List;

public class GiohangActivity extends AppCompatActivity {

    private RecyclerView ryc_themsp;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_giohang);
        ryc_themsp = findViewById(R.id.ryc_themsp);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this, RecyclerView.HORIZONTAL, false);
        ryc_themsp.setLayoutManager(linearLayoutManager);
        List<GioHang> gioHangList = getGioHang();
        GioHang_Adapter adapter = new GioHang_Adapter(gioHangList);
        adapter.setData_GioHang(gioHangList);
        ryc_themsp.setAdapter(adapter);


    }
    private List<GioHang> getGioHang() {
        List<GioHang> dsgiohang = new ArrayList<>();
        //dsgiohang.add(new GioHang(R.drawable.img_9d9c1c7a81d0d1e,"sua tam","300000"));
        return dsgiohang;
    }
}