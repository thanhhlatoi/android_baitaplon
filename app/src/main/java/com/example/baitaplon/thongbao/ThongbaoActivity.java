package com.example.baitaplon.thongbao;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.baitaplon.R;

import java.util.ArrayList;
import java.util.List;

public class ThongbaoActivity extends AppCompatActivity {
    RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_thongbao);
        recyclerView = findViewById(R.id.ryc_thongbao);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this, RecyclerView.VERTICAL, false);
        recyclerView.setLayoutManager(linearLayoutManager);
        List<ThongBao> thongBaoList = getThongbao();
        ThongBao_Adapter adapter = new ThongBao_Adapter(thongBaoList);
        adapter.setData_Thongbao(thongBaoList);
        recyclerView.setAdapter(adapter);
    }
    private List<ThongBao> getThongbao() {

         List<ThongBao> thongBaoList = new ArrayList<>();
         thongBaoList.add(new ThongBao("thanh11421","asasd","asdadww"));
         thongBaoList.add(new ThongBao("asa","asd  ","askjda"));
         return thongBaoList;

    }
}
