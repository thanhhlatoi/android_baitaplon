package com.example.baitaplon.Blog_lamdep;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.baitaplon.R;

import java.util.List;

public class Blog_Adapter extends RecyclerView.Adapter<Blog_Adapter.BlogView>{
    private List<Blog> mBlog;


    public void setData(List<Blog> list){
        this.mBlog = list;
        notifyDataSetChanged();
    }
    @NonNull
    @Override
    public BlogView onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_blog,parent,false);
        return new BlogView(view);
    }

    @Override
    public void onBindViewHolder(@NonNull BlogView holder, int position) {
        Blog blog = mBlog.get(position);
        if (blog == null){
            return;
        }
        holder.imgBloag.setImageResource(blog.getResourceId_1());
        holder.tvTitle.setText(blog.getTitle());
    }

    @Override
    public int getItemCount() {
        if(mBlog != null){
            return mBlog.size();
        }
        return 0;
    }

    public class BlogView extends RecyclerView.ViewHolder{
        private ImageView imgBloag;
        private TextView tvTitle;
        private Button btBlog;


        public BlogView(@NonNull View itemView) {
            super(itemView);
            imgBloag = itemView.findViewById(R.id.img_blog1);
            tvTitle = itemView.findViewById(R.id.txt_blog1);
        }
    }
}

