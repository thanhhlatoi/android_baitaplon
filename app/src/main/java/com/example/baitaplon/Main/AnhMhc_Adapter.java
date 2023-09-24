package com.example.baitaplon.Main;


import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.ViewHolder;

import com.example.baitaplon.R;

import java.util.List;

public class AnhMhc_Adapter extends RecyclerView.Adapter<AnhMhc_Adapter.AnhMhcView> {
    private List<AnhMhc> mAnhMhc;
    public void setData (List<AnhMhc> list){
        this.mAnhMhc = list;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public AnhMhcView onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_anhmhc, parent, false);
        return new AnhMhcView(view);
    }

    @Override
    public void onBindViewHolder(@NonNull AnhMhcView holder, int position) {
        AnhMhc anhMhc = mAnhMhc.get(position);
        if(anhMhc ==  null){
            return;
        }
        holder.img_Sanpham.setImageResource(anhMhc.getResourceId());
        holder.tvTitle.setText(anhMhc.getTitle());
        holder.gia_moi.setText(anhMhc.getTitle_gm());
    }

    @Override
    public int getItemCount() {
        if (mAnhMhc != null){
            return mAnhMhc.size();
        }
        return 0;
    }

    public class AnhMhcView extends ViewHolder{
        private ImageView img_Sanpham;
        private TextView tvTitle;
        private TextView gia_moi;
        public AnhMhcView(@NonNull View itemView) {
           super(itemView);
           img_Sanpham = itemView.findViewById(R.id.img_sanpham1);
           tvTitle = itemView.findViewById(R.id.tv_title);
           gia_moi = itemView.findViewById(R.id.gia_moi);
       }
   }

}
