package com.example.baitaplon;

import static androidx.core.app.ActivityCompat.startActivityForResult;
import static androidx.core.content.ContextCompat.startActivity;
import static com.example.baitaplon.Danh_Muc.surum.database;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.baitaplon.Danh_Muc.SanPham;
import com.example.baitaplon.Mua_Hang.Mua_hangActivity;

import java.io.ByteArrayOutputStream;
import java.util.List;

public class admin_adapter extends RecyclerView.Adapter<admin_adapter.AdminView> {
    private boolean isInAdminActivity = true;
    private Context context;
    private List<SanPham> sanPhamAdmin;



    public void setIsInAdminActivity(boolean isInAdminActivity) {
        this.isInAdminActivity = isInAdminActivity;
        notifyDataSetChanged(); // Thông báo cho Adapter cập nhật giao diện người dùng
    }

    public admin_adapter(Context context, List<SanPham> sanPhamAdmin ) {
        this.context = context;
        this.sanPhamAdmin = sanPhamAdmin;

    }


    @NonNull
    @Override
    public AdminView onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view;
        if (isInAdminActivity) {
            view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_sanpham_admin, parent, false);
        } else {
            view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_sanpham, parent, false);
        }
        return new AdminView(view);
    }

    @Override
    public void onBindViewHolder(@NonNull AdminView holder, int position) {
        SanPham sanPham = sanPhamAdmin.get(position);
        if (sanPham == null){
            return;
        }
        if (isInAdminActivity) {
            // chuyen byte[] sang bitmap
            byte[] hinhAnh = sanPham.getHinh();
            Bitmap bitmap = BitmapFactory.decodeByteArray(hinhAnh,0,hinhAnh.length);
            holder.item_img_sanpham.setImageBitmap(bitmap);
            holder.item_txt_ten.setText(sanPham.getTen());
            holder.item_txt_gia.setText(sanPham.getGia());
            holder.item_txt_mota.setText(sanPham.getMota());
            holder.item_txt_maloai.setText(sanPham.getMaloai());
            holder.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    holder.itemView.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            // Tạo AlertDialog.Builder
                            AlertDialog.Builder builder = new AlertDialog.Builder(context);
                            builder.setTitle("Sửa thông tin sản phẩm");

                            // Tạo layout cho dialog (bạn có thể tạo một layout XML tùy chỉnh)
                            View dialogLayout = LayoutInflater.from(context).inflate(R.layout.custom_dialog_layout, null);
                            builder.setView(dialogLayout);

                            // Tạo các EditText để nhập thông tin mới
                            EditText editTen = dialogLayout.findViewById(R.id.editTen);
                            EditText editGia = dialogLayout.findViewById(R.id.editGia);
                            EditText editMoTa = dialogLayout.findViewById(R.id.editMoTa);
                            EditText editMaLoai = dialogLayout.findViewById(R.id.editMaLoai);
                            // Thiết lập dữ liệu ban đầu cho các EditText
                            editTen.setText(sanPham.getTen());
                            editGia.setText(sanPham.getGia());
                            editMoTa.setText(sanPham.getMota());
                            editMaLoai.setText(sanPham.getMaloai());
                            // Thêm nút "Lưu" vào dialog
                            builder.setPositiveButton("Lưu", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialogInterface, int i) {
                                    // Lấy thông tin mới từ các EditText
                                    String newTen = editTen.getText().toString();
                                    String newGia = editGia.getText().toString();
                                    String newMoTa = editMoTa.getText().toString();
                                    String newMaLoai = editMaLoai.getText().toString();

                                    // Thực hiện lưu thông tin mới vào cơ sở dữ liệu (sử dụng UPDATE_SANPHAM)
                                    database.UPDATE_SANPHAM(
                                            sanPham.getId(), // Truyền ID sản phẩm để xác định sản phẩm cần cập nhật
                                            newTen,
                                            newGia,
                                            hinhAnh, // Giữ nguyên hình ảnh cũ hoặc cập nhật nếu cần
                                            newMoTa,
                                            newMaLoai
                                    );
                                    // Cập nhật danh sách sản phẩm sau khi lưu
                                    updateProductList();
                                }
                            });
                            // them nut "xoa" vao dialog
                            // Thêm nút "Xóa" vào dialog
                            builder.setNeutralButton("Xóa", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialogInterface, int i) {
                                    // Gọi phương thức DELETE_SANPHAM để xóa sản phẩm
                                    boolean isDeleted = database.DELETE_SANPHAM(sanPham.getId());
                                    if (isDeleted) {
                                        // Xóa thành công, cập nhật danh sách sản phẩm sau khi xóa
                                        Toast.makeText(context, "Xóa sản phẩm thất bại", Toast.LENGTH_SHORT).show();
                                        updateProductList();
                                    } else {
                                        // Xóa không thành công, thông báo cho người dùng
                                        Toast.makeText(context, "Xóa sản phẩm thất bại", Toast.LENGTH_SHORT).show();
                                    }
                                }
                            });

                            // Thêm nút "Hủy" vào dialog
                            builder.setNegativeButton("Hủy", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialogInterface, int i) {
                                    // Đóng dialog khi click "Hủy"
                                    dialogInterface.dismiss();
                                }
                            });

                            // Hiển thị dialog
                            builder.create().show();
                        }
                    });
                }
            });
        }else {
            byte[] hinhAnh = sanPham.getHinh();
            Bitmap bitmap = BitmapFactory.decodeByteArray(hinhAnh,0,hinhAnh.length);
            holder.item_img_sp.setImageBitmap(bitmap);
            holder.item_txt_tensp.setText(sanPham.getTen());
            holder.item_txt_giasp.setText(sanPham.getGia());
            holder.item_layout_sanpham.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
   //               Chuyển đổi hình ảnh thành byte array
                    ByteArrayOutputStream stream = new ByteArrayOutputStream();
                    bitmap.compress(Bitmap.CompressFormat.PNG, 100, stream);
                    byte[] byteArray = stream.toByteArray();
                    String productName = sanPham.getTen();
                    String productGia = sanPham.getGia();
                    String mota = sanPham.getMota();
// Truyền byte array qua Intent
                    Intent intent = new Intent(context, Mua_hangActivity.class);
                    intent.putExtra("image_data", byteArray);
                    intent.putExtra("product_name", productName);
                    intent.putExtra("productGia", productGia);
                    intent.putExtra("mota", mota);

                    context.startActivity(intent);

                }
            });
        }
    }

    @Override
    public int getItemCount() {
        if(sanPhamAdmin != null){
            return sanPhamAdmin.size();
        }
        return 0;
    }
    public void updateProductList(){

        notifyDataSetChanged();
    }
    public class AdminView extends RecyclerView.ViewHolder {
        private ImageView item_img_sanpham;
        private TextView item_txt_ten,item_txt_gia,item_txt_mota,item_txt_maloai;
        private ImageView item_img_sp;
        private TextView item_txt_tensp;
        private TextView item_txt_giasp;
        private LinearLayout item_layout_sanpham;
        public AdminView(@NonNull View itemView) {
            super(itemView);
            if(isInAdminActivity){
                item_img_sanpham = itemView.findViewById(R.id.item_img_sanpham);
                item_txt_ten = itemView.findViewById(R.id.item_txt_ten);
                item_txt_gia = itemView.findViewById(R.id.item_txt_gia);
                item_txt_maloai = itemView.findViewById(R.id.item_txt_maloai);
                item_txt_mota = itemView.findViewById(R.id.item_txt_mota);
            }else {
                item_img_sp = itemView.findViewById(R.id.item_img_sp);
                item_txt_tensp = itemView.findViewById(R.id.item_txt_tensp);
                item_txt_giasp = itemView.findViewById(R.id.item_txt_giasp);
                item_layout_sanpham = itemView.findViewById(R.id.item_layout_sanpham);
            }
        }
    }
}
