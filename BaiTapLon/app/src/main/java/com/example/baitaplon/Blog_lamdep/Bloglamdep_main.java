package com.example.baitaplon.Blog_lamdep;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

import com.example.baitaplon.Blog_lamdep.Blog;
import com.example.baitaplon.Blog_lamdep.Blog_Adapter;
import com.example.baitaplon.R;

import java.util.ArrayList;
import java.util.List;

public class Bloglamdep_main extends AppCompatActivity {
RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bloglamdep_main);
        //tra ve
        ImageButton imgbt_home = findViewById(R.id.image_home_1);
        imgbt_home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
        ImageButton imgbtacc_2 = findViewById(R.id.image_tk_2);
        imgbtacc_2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });


        recyclerView = findViewById(R.id.rcy_bloglamdep);
        GridLayoutManager gridLayoutManager = new GridLayoutManager(this, 2);
        recyclerView.setLayoutManager(gridLayoutManager);
        // Lấy danh sách Blog từ phương thức getBloglamdep
        List<Blog> blogList = getBloglamdep();
        // Sử dụng Adapter mới với danh sách Blog
        Blog_Adapter adapter = new Blog_Adapter();
        adapter.setData(blogList);
        // Đặt adapter cho RecyclerView
        recyclerView.setAdapter(adapter);
    }
    private List<Blog> getBloglamdep() {
        List<Blog> blogList = new ArrayList<>();
        blogList.add(new Blog(R.drawable.img_rectangle148, "Make up kiểu mùa hè năng động"));
        blogList.add(new Blog(R.drawable.img_rectangle149, "Chăm sóc hiệu quả cho da dầu"));
        blogList.add(new Blog(R.drawable.img_rectangle150, "Trang điểm má hồng kiểu Nhật"));
        blogList.add(new Blog(R.drawable.img_rectangle151, "Chăm sóc da sau 20 tuổi"));
        blogList.add(new Blog(R.drawable.img_rectangle152, "Lựa chọn son phù hợp tông da"));
        blogList.add(new Blog(R.drawable.img_rectangle153, "Giữ dáng trong mua đông lạnh giá"));
        blogList.add(new Blog(R.drawable.img_rectangle153, "Giữ dáng trong mua đông lạnh giá"));
        blogList.add(new Blog(R.drawable.img_rectangle153, "Giữ dáng trong mua đông lạnh giá"));
        blogList.add(new Blog(R.drawable.img_rectangle153, "Giữ dáng trong mua đông lạnh giá"));
        blogList.add(new Blog(R.drawable.img_rectangle153, "Giữ dáng trong mua đông lạnh giá"));
        return blogList;
    }

}
