package com.example.posyandu;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class AdapterRvRekapAbsenPeserta extends RecyclerView.Adapter<AdapterRvRekapAbsenPeserta.ViewHolder> {
    private ArrayList<ModelRekapAbsenPeserta> dataItem;
    private Context context;

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView textTanggal;
        TextView textJadwal;
        LinearLayout linearLayout_item_rekap_absen_peserta;


        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            textJadwal = itemView.findViewById(R.id.text_jadwal);
            textTanggal = itemView.findViewById(R.id.text_tanggal);
            linearLayout_item_rekap_absen_peserta = itemView.findViewById(R.id.ll_rekap_absen_peserta);
        }
    }

    AdapterRvRekapAbsenPeserta(Context context, ArrayList<ModelRekapAbsenPeserta> dataItem){
        this.context = context;
        this.dataItem = dataItem;
    }

    @NonNull
    @Override
    public AdapterRvRekapAbsenPeserta.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item_rekap_absen_peserta,parent,false);
        return new AdapterRvRekapAbsenPeserta.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        TextView textJadwal = holder.textJadwal;
        TextView textTanggal = holder.textTanggal;

        textJadwal.setText(dataItem.get(position).getJadwal());
        textTanggal.setText(dataItem.get(position).getTanggal());

        holder.linearLayout_item_rekap_absen_peserta.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context, RekapAbsenPesertaDetailActivity.class);
                intent.putExtra("JADWAL", dataItem.get(position).getJadwal());
                context.startActivity(intent);
                Toast.makeText(context, dataItem.get(position).getJadwal(), Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public int getItemCount() {
        return dataItem.size();
    }

    void setFilter(ArrayList<ModelRekapAbsenPeserta> filterModel){
        dataItem = new ArrayList<>();
        dataItem.addAll(filterModel);
        notifyDataSetChanged();
    }
}
