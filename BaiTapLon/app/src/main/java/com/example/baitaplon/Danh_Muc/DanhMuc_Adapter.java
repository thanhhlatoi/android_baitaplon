package com.example.baitaplon.Danh_Muc;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.baitaplon.R;

import java.util.List;

public class DanhMuc_Adapter extends RecyclerView.Adapter<DanhMuc_Adapter.DanhMucView>{
    private List<DanhMuc> danhMucList;
    public DanhMuc_Adapter(List<DanhMuc> danhMucList) {

        this.danhMucList = danhMucList;
        notifyDataSetChanged();
    }
    @NonNull
    @Override
    public DanhMucView onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_danhmuc,parent,false);
        return new DanhMucView(view);
    }

    @Override
    public void onBindViewHolder(@NonNull DanhMucView holder, int position) {
        DanhMuc danhmuc =danhMucList.get(position);
        if( danhMucList == null){
            return;
        }
        holder.tvName.setText(danhmuc.getName());
    }

    @Override
    public int getItemCount() {
        if(danhMucList != null){
            return danhMucList.size();
        }
        return 0;
    }

    public class DanhMucView extends RecyclerView.ViewHolder{
        private TextView tvName;

        public DanhMucView(@NonNull View itemView) {
            super(itemView);
            tvName = itemView.findViewById(R.id.txt_danhmuc);
        }
    }
}
