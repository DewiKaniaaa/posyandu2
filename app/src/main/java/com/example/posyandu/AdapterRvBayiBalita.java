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

public class AdapterRvBayiBalita extends RecyclerView.Adapter<AdapterRvBayiBalita.ViewHolder> {
    private ArrayList<ModelBayiBalita> dataItem;
    private Context context;

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView textNama;
        TextView textJenisKelamin;
        TextView textTanggalLahir;
        TextView textAnakKe;
        TextView textNamaIbu;
        TextView textNamaAyah;
        TextView textStatus;
        TextView textOptionsMenu;
        LinearLayout linearLayout_bayi_balita;


        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            textNama = itemView.findViewById(R.id.text_nama_bayi);
            textJenisKelamin = itemView.findViewById(R.id.text_jenis_kelamin);
            linearLayout_bayi_balita = itemView.findViewById(R.id.ll_bayi_balita);
            textOptionsMenu = itemView.findViewById(R.id.text_option_menu);
        }
    }

    public AdapterRvBayiBalita(Context context, ArrayList<ModelBayiBalita> dataItem){
        this.context = context;
        this.dataItem = dataItem;
    }

    @NonNull
    @Override
    public AdapterRvBayiBalita.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item_bayi_balita,parent,false);
        return new AdapterRvBayiBalita.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        TextView textNama = holder.textNama;
        TextView textJenisKelamin = holder.textJenisKelamin;
//        TextView textTanggal = holder.textTanggal;
//        TextView textStatus = holder.textStatus;

        textNama.setText(dataItem.get(position).getNama());
        textJenisKelamin.setText(dataItem.get(position).getJenis_kelamin());
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
                                Intent intent = new Intent(context, LihatBayiBalitaActivity.class);
//                                intent.putExtra("JADWAL", dataItem.get(position).getJadwal());
//                                intent.putExtra("TANGGAL", dataItem.get(position).getTanggal());
//                                intent.putExtra("STATUS", dataItem.get(position).getStatus());
                                context.startActivity(intent);
                                return true;
                            case R.id.option_edit:
                                Toast.makeText(context, "Edit", Toast.LENGTH_SHORT).show();
                                Intent intent2 = new Intent(context, EditBayiBalitaActivity.class);
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

    void setFilter(ArrayList<ModelBayiBalita> filterModel){
        dataItem = new ArrayList<>();
        dataItem.addAll(filterModel);
        notifyDataSetChanged();
    }
}
