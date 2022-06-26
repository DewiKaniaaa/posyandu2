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

public class AdapterRvKelolaJadwal extends RecyclerView.Adapter<AdapterRvKelolaJadwal.ViewHolder> {
    private ArrayList<ModelJadwal> dataItem;
    private Context context;

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView textJadwal;
        TextView textTanggal;
        TextView textStatus;
        TextView textOptionsMenu;
        LinearLayout linearLayout_item_kelola_jadwal;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            textJadwal = itemView.findViewById(R.id.text_jadwal);
            textTanggal = itemView.findViewById(R.id.text_tanggal);
            textStatus = itemView.findViewById(R.id.text_status);
            linearLayout_item_kelola_jadwal = itemView.findViewById(R.id.ll_jadwal);
            textOptionsMenu = itemView.findViewById(R.id.text_option_menu);
        }
    }

    AdapterRvKelolaJadwal(Context context, ArrayList<ModelJadwal> dataItem){
        this.context = context;
        this.dataItem = dataItem;
    }

    @NonNull
    @Override
    public AdapterRvKelolaJadwal.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item_jadwal,parent,false);
        return new AdapterRvKelolaJadwal.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        TextView textJadwal = holder.textJadwal;
        TextView textTanggal = holder.textTanggal;
        TextView textStatus = holder.textStatus;

        textJadwal.setText(dataItem.get(position).getJadwal());
        textTanggal.setText(dataItem.get(position).getTanggal());
        textStatus.setText(dataItem.get(position).getStatus());

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
                                Intent intent = new Intent(context, LihatJadwalActivity.class);
                                intent.putExtra("JADWAL", dataItem.get(position).getJadwal());
                                intent.putExtra("TANGGAL", dataItem.get(position).getTanggal());
                                intent.putExtra("STATUS", dataItem.get(position).getStatus());
                                context.startActivity(intent);
                                return true;
                            case R.id.option_edit:
                                Toast.makeText(context, "Edit", Toast.LENGTH_SHORT).show();
                                Intent intent2 = new Intent(context, EditJadwalActivity.class);
                                intent2.putExtra("JADWAL", dataItem.get(position).getJadwal());
                                intent2.putExtra("TANGGAL", dataItem.get(position).getTanggal());
                                intent2.putExtra("STATUS", dataItem.get(position).getStatus());
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

    void setFilter(ArrayList<ModelJadwal> filterModel){
        dataItem = new ArrayList<>();
        dataItem.addAll(filterModel);
        notifyDataSetChanged();
    }
}
