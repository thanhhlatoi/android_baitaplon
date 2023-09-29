package com.example.baitaplon;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.baitaplon.Danh_Muc.SanPham;
import com.example.baitaplon.Main.AnhMhc;

public class SaleActivity extends AppCompatActivity {
    private ImageView item_sale_img;
    private TextView item_sale_giaspcu,item_sale_giaspmoi;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sale);
       // item_sale_img = findViewById(R.id.item_sale_img);
        item_sale_giaspcu =findViewById(R.id.item_sale_giaspcu);
        item_sale_giaspmoi = findViewById(R.id.item_sale_giaspmoi);


        Bundle bundle = getIntent().getExtras();
        if (bundle == null){
            return;
        }
        AnhMhc anhMhc = (AnhMhc) bundle.get("img");
        item_sale_img = findViewById(R.id.item_sale_img);
        item_sale_img.setImageResource(anhMhc.getResourceId());
    }
}