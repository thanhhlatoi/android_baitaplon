package com.example.baitaplon.Danh_Muc;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.baitaplon.BanhangActivity;
import com.example.baitaplon.R;

import java.util.List;


public class SanPham_Adapter extends RecyclerView.Adapter<SanPham_Adapter.SanPhamView> {
    private List<SanPham> sanPhamList;
    private Context mContext;


    public SanPham_Adapter(Context mcontext , List<SanPham> sanPhamList) {
        this.mContext = mcontext;
        this.sanPhamList = sanPhamList;

    }

    public void setData_SanPham(List<SanPham> sanPhamList) {
        this.sanPhamList = sanPhamList;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public SanPhamView onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_sanpham,parent,false);
       return new SanPhamView(view);
    }

    @Override
    public void onBindViewHolder(@NonNull SanPhamView holder, int position) {
     final SanPham sanPham = sanPhamList.get(position);
        if(sanPhamList == null){
            return;
        }
        holder.image_sanpham.setImageResource(sanPhamList.get(position).getImg());
        holder.tvName.setText(sanPhamList.get(position).getTvName());
        holder.tvName_gia.setText(sanPhamList.get(position).getTvName_gia());
        holder.linearLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                OnClick(sanPham);
            }

            private void OnClick(SanPham sanPham) {
                Intent intent = new Intent(mContext, BanhangActivity.class);
                Bundle bundle = new Bundle();
                bundle.putSerializable("img",sanPham );
                bundle.putSerializable("text",sanPham );
                bundle.putSerializable("gia",sanPham );
                intent.putExtras(bundle);
                mContext.startActivity(intent);
            }
        });
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
            private LinearLayout linearLayout;

        public SanPhamView(@NonNull View itemView) {
            super(itemView);
            linearLayout = itemView.findViewById(R.id.layout_sanpham);
            image_sanpham = itemView.findViewById(R.id.img_sanpham2);
            tvName = itemView.findViewById(R.id.txt_ten);
            tvName_gia = itemView.findViewById(R.id.txt_gia);

        }
    }
}
