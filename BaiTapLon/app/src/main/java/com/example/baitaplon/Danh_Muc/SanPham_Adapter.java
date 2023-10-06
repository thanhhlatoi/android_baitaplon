package com.example.baitaplon.Danh_Muc;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.baitaplon.R;

import java.util.List;


public class SanPham_Adapter extends RecyclerView.Adapter<SanPham_Adapter.SanPhamView> {
    private List<SanPham> sanPhamList;
    public void setData_SanPham( List<SanPham> sanPhamList) {
        this.sanPhamList = sanPhamList;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public SanPhamView onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_sanpham,parent,false);
       return new SanPham_Adapter.SanPhamView(view);
    }

    @Override
    public void onBindViewHolder(@NonNull SanPhamView holder, int position) {
       final SanPham sanPham;
        sanPham = sanPhamList.get(position);
        if( sanPhamList == null){
            return;
        }
        holder.image_sanpham.setImageResource(sanPham.getImg());
        holder.tvName.setText(sanPham.getTvName());
        holder.tvName_gia.setText(sanPham.getTvName_gia());
    }

    @Override
    public int getItemCount() {
        if(sanPhamList != null){
            return sanPhamList.size();
        }
        return 0;
    }

    public class SanPhamView extends RecyclerView.ViewHolder {
            private TextView tvName;
            private TextView tvName_gia;
            private ImageView image_sanpham;
            private  RecyclerView rcylayout;
        public SanPhamView(@NonNull View itemView) {
            super(itemView);
            rcylayout = itemView.findViewById(R.id.rcy_sanpham);
            image_sanpham = itemView.findViewById(R.id.img_sanpham);
            tvName = itemView.findViewById(R.id.txt_ten);
            tvName_gia = itemView.findViewById(R.id.txt_gia);

        }
    }
}
