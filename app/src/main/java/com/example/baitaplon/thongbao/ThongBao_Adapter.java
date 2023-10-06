package com.example.baitaplon.thongbao;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.baitaplon.R;

import java.util.List;

public class ThongBao_Adapter extends  RecyclerView.Adapter<ThongBao_Adapter.Thongbao_view> {
    private List<ThongBao> listthongbao;
    public ThongBao_Adapter(List<ThongBao> listthongbao){
        this.listthongbao = listthongbao;
    }
    public void setData_Thongbao(List<ThongBao> listthongbao) {
        this.listthongbao = listthongbao;
        notifyDataSetChanged();
    }
    @NonNull
    @Override
    public Thongbao_view onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_thongbao,parent,false);
        return new ThongBao_Adapter.Thongbao_view(view);
    }

    @Override
    public void onBindViewHolder(@NonNull Thongbao_view holder, int position) {
        if(listthongbao == null){
            return;
        }
        holder.text1.setText(listthongbao.get(position).getText1());
        holder.text2.setText(listthongbao.get(position).getText2());
        holder.text3.setText(listthongbao.get(position).getText3());
    }

    @Override
    public int getItemCount() {
        if(listthongbao != null){
            return listthongbao.size();
        }
        return 0;
    }

    public class Thongbao_view extends RecyclerView.ViewHolder{
        private TextView text1;
        private TextView text2;
        private TextView text3;
        public Thongbao_view(@NonNull View itemView) {
            super(itemView);
            text1 = itemView.findViewById(R.id.text1);
            text2 = itemView.findViewById(R.id.text2);
            text3 = itemView.findViewById(R.id.text3);

        }
    }
}
