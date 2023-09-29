package com.example.baitaplon.Main;


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
import androidx.recyclerview.widget.RecyclerView.ViewHolder;

import com.example.baitaplon.Danh_Muc.surum;
import com.example.baitaplon.R;
import com.example.baitaplon.SaleActivity;

import java.util.List;

public class AnhMhc_Adapter extends RecyclerView.Adapter<AnhMhc_Adapter.AnhMhcView> {
    private Context mContext;
    private List<AnhMhc> mAnhMhc;

    public AnhMhc_Adapter(Context context, List<AnhMhc> mAnhMhc) {
        this.mContext = context;
        this.mAnhMhc = mAnhMhc;
    }

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
       final AnhMhc anhMhc = mAnhMhc.get(position);
        if(anhMhc ==  null){
            return;
        }
        holder.img_Sanpham.setImageResource(anhMhc.getResourceId());
        holder.tvTitle.setText(anhMhc.getTitle());
        holder.gia_moi.setText(anhMhc.getTitle_gm());
        holder.linearlayout_sale.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Onclick(anhMhc);
            }

            private void Onclick(AnhMhc anhMhc) {
                Intent intent = new Intent(mContext, SaleActivity.class);
                Bundle bundle = new Bundle();
                bundle.putSerializable("img",anhMhc);
                intent.putExtras(bundle);
                mContext.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        if (mAnhMhc != null){
            return mAnhMhc.size();
        }
        return 0;
    }

    public class AnhMhcView extends ViewHolder{
        private LinearLayout linearlayout_sale;
        private ImageView img_Sanpham;
        private TextView tvTitle;
        private TextView gia_moi;
        public AnhMhcView(@NonNull View itemView) {
           super(itemView);
            linearlayout_sale = itemView.findViewById(R.id.linearlayout_sale);
           img_Sanpham = itemView.findViewById(R.id.img_sanpham1);
           tvTitle = itemView.findViewById(R.id.tv_title);
           gia_moi = itemView.findViewById(R.id.gia_moi);
       }
   }

}
