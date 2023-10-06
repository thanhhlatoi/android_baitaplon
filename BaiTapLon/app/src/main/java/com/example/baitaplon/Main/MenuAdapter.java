package com.example.baitaplon.Main;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.baitaplon.R;
import com.example.baitaplon.item_menu;

import java.util.List;

public class MenuAdapter extends BaseAdapter {

    private Context context;
    private int layout;
    private List<com.example.baitaplon.item_menu> list;

    public MenuAdapter(Context context, int layout, List<item_menu> list) {
        this.context = context;
        this.layout = layout;
        this.list = list;
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int i) {
        return list.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    private class ViewHolder {
        TextView tv;
        ImageView img;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        ViewHolder viewHolder;
        if (view == null) {
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view = inflater.inflate(layout, null);
            viewHolder = new ViewHolder();
            viewHolder.tv = (TextView) view.findViewById(R.id.tenitem);
            viewHolder.img = (ImageView) view.findViewById(R.id.imgicon_1);
            view.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) view.getTag();
        }
        viewHolder.tv.setText(list.get(i).tenItem);
        viewHolder.img.setImageResource(list.get(i).icon); // Đặt hình ảnh từ tài nguyên dựa trên ID
        return view;
    }
}
