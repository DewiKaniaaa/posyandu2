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

public class AdapterRvLaporanListBayi extends RecyclerView.Adapter<AdapterRvLaporanListBayi.ViewHolder> {
    private ArrayList<ModelBayi> dataItem;
    private Context context;

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView textNama;
        TextView textBeratBadan;
        TextView textOptionsMenu;
        LinearLayout linearLayout_item_laporan_bayi;


        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            textNama = itemView.findViewById(R.id.text_nama_bayi);
            linearLayout_item_laporan_bayi = itemView.findViewById(R.id.ll_laporan_bayi);
            textOptionsMenu = itemView.findViewById(R.id.text_option_menu);
        }
    }

    AdapterRvLaporanListBayi(Context context, ArrayList<ModelBayi> dataItem){
        this.context = context;
        this.dataItem = dataItem;
    }

    @NonNull
    @Override
    public AdapterRvLaporanListBayi.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item_laporan_bayi,parent,false);
        return new AdapterRvLaporanListBayi.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        TextView textNama = holder.textNama;
//        TextView textBeratBadan = holder.textBeratBadan;
//        TextView textTanggal = holder.textTanggal;
//        TextView textStatus = holder.textStatus;

        textNama.setText(dataItem.get(position).getNama());
//        textBeratBadan.setText(dataItem.get(position).getBerat_badan());
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
                                Intent intent = new Intent(context, LaporanLihatBayiActivity.class);
//                                intent.putExtra("JADWAL", dataItem.get(position).getJadwal());
//                                intent.putExtra("TANGGAL", dataItem.get(position).getTanggal());
//                                intent.putExtra("STATUS", dataItem.get(position).getStatus());
                                context.startActivity(intent);
                                return true;
                            case R.id.option_edit:
                                Toast.makeText(context, "Edit", Toast.LENGTH_SHORT).show();
                                Intent intent2 = new Intent(context, LaporanEditBayiActivity.class);
//                                intent2.putExtra("JADWAL", dataItem.get(position).getJadwal());
//                                intent2.putExtra("TANGGAL", dataItem.get(position).getTanggal());
//                                intent2.putExtra("STATUS", dataItem.get(position).getStatus());
                                context.startActivity(intent2);
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

    void setFilter(ArrayList<ModelBayi> filterModel){
        dataItem = new ArrayList<>();
        dataItem.addAll(filterModel);
        notifyDataSetChanged();
    }
}
