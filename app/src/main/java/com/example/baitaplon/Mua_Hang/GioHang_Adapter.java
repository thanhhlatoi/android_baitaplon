package com.example.baitaplon.Mua_Hang;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.baitaplon.Danh_Muc.SanPham;
import com.example.baitaplon.Danh_Muc.SanPham_Adapter;
import com.example.baitaplon.R;

import org.w3c.dom.Text;

import java.util.List;

public class GioHang_Adapter extends RecyclerView.Adapter<GioHang_Adapter.GioHangView> {
    private List<GioHang> gioHangList;
    private Context context;

   // public GioHang_Adapter(List<GioHang> gioHangList, Context context) {
   //     this.gioHangList = gioHangList;
   //     this.context = context;
   // }

    public GioHang_Adapter(List<GioHang> gioHangList) {
        this.gioHangList = gioHangList;
     //   this.context = context;
    }

    public void setData_GioHang(List<GioHang> gioHangList) {
        this.gioHangList = gioHangList;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public GioHangView onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_giohang,parent,false);
        return new GioHangView(view);
    }

    @Override
    public void onBindViewHolder(@NonNull GioHangView holder, int position) {
        GioHang gioHang = gioHangList.get(position);
        if(gioHangList == null){
            return;
        }
        holder.item_giohang_img.setImageResource(gioHangList.get(position).getItem_giohang_img());
        holder.item_giohang_tensp.setText(gioHangList.get(position).getItem_giohang_tensp());
        holder.item_giohang_giasp.setText(gioHangList.get(position).getItem_giohang_giasp());
    }

    @Override
    public int getItemCount() {
        if(gioHangList != null){
            return gioHangList.size();
        }
        return 0;
    }

    public class GioHangView extends RecyclerView.ViewHolder {
        private ImageView item_giohang_img;
        private TextView item_giohang_tensp;
        private TextView item_giohang_giasp;
        public GioHangView(@NonNull View itemView) {
            super(itemView);
            item_giohang_img = itemView.findViewById(R.id.item_giohang_img);
            item_giohang_tensp = itemView.findViewById(R.id.item_giohang_tensp);
            item_giohang_giasp = itemView.findViewById(R.id.item_giohang_giasp);
        }
    }
}
