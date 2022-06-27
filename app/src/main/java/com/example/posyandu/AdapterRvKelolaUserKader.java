package com.example.posyandu;

import android.content.Context;
import android.content.Intent;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.PopupMenu;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class AdapterRvKelolaUserKader extends RecyclerView.Adapter<AdapterRvKelolaUserKader.ViewHolder> {
    private ArrayList<ModelKelolaUserKader> dataItem;
    private Context context;

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView textTanggalLahir;
        TextView textNama;
        TextView textJenisKelamin;
        TextView textNoTelepon;
        TextView textOptionsMenu;
        LinearLayout linearLayout_item_user_kader;


        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            textNama = itemView.findViewById(R.id.text_nama_user);
            textNoTelepon = itemView.findViewById(R.id.text_no_telepon);
            textOptionsMenu = itemView.findViewById(R.id.text_option_menu);
            linearLayout_item_user_kader = itemView.findViewById(R.id.ll_user_kader);
        }
    }

    AdapterRvKelolaUserKader(Context context, ArrayList<ModelKelolaUserKader> dataItem){
        this.context = context;
        this.dataItem = dataItem;
    }

    @NonNull
    @Override
    public AdapterRvKelolaUserKader.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item_user_kader,parent,false);
        return new AdapterRvKelolaUserKader.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        TextView textNama = holder.textNama;
        TextView textNoTelepon = holder.textNoTelepon;
//        TextView textTanggal = holder.textTanggal;
//        TextView textStatus = holder.textStatus;

        textNama.setText(dataItem.get(position).getNama());
        textNoTelepon.setText(dataItem.get(position).getNo_telepon());
//        textTanggal.setText(dataItem.get(position).getTanggal());
//        textStatus.setText(dataItem.get(position).getStatus());

        holder.textOptionsMenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                PopupMenu popupMenu = new PopupMenu(view.getContext(), holder.textOptionsMenu);
                popupMenu.inflate(R.menu.options_menu);
                popupMenu.setGravity(Gravity.END);
                popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                    @Override
                    public boolean onMenuItemClick(MenuItem menuItem) {
                        switch (menuItem.getItemId()){
                            case R.id.option_lihat:
                                Toast.makeText(context, "Lihat", Toast.LENGTH_SHORT).show();
//                                Intent intent = new Intent(context, LihatJadwalActivity.class);
//                                intent.putExtra("NAMA", dataItem.get(position).getNama());
//                                intent.putExtra("TELEPON", dataItem.get(position).getNo_telepon());
//                                intent.putExtra("JK", dataItem.get(position).getJenis_kelamin());
//                                context.startActivity(intent);
                                return true;
                            case R.id.option_edit:
                                Toast.makeText(context, "Edit", Toast.LENGTH_SHORT).show();
//                                Intent intent2 = new Intent(context, EditJadwalActivity.class);
//                                intent2.putExtra("NAMA", dataItem.get(position).getNama());
//                                intent2.putExtra("TELEPON", dataItem.get(position).getNo_telepon());
//                                intent2.putExtra("JK", dataItem.get(position).getJenis_kelamin());
//                                context.startActivity(intent2);
                                return true;
                            case R.id.option_hapus:
                                Toast.makeText(context, "Hapus", Toast.LENGTH_SHORT).show();
                                return true;
                            default:
                                return false;
                        }
                    }
                });
                popupMenu.show();
            }
        });
    }

    @Override
    public int getItemCount() {
        return dataItem.size();
    }

    void setFilter(ArrayList<ModelKelolaUserKader> filterModel){
        dataItem = new ArrayList<>();
        dataItem.addAll(filterModel);
        notifyDataSetChanged();
    }
}
