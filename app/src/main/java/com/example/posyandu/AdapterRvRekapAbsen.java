package com.example.posyandu;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class AdapterRvRekapAbsen extends RecyclerView.Adapter<AdapterRvRekapAbsen.ViewHolder> {
    private ArrayList<ModelRekapAbsen> dataItem;
    private Context context;

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView textTanggal;
        TextView textStatus;
        TextView textJadwal;
        LinearLayout linearLayout_item_rekap_absen;


        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            textJadwal = itemView.findViewById(R.id.text_jadwal);
            textTanggal = itemView.findViewById(R.id.text_tanggal);
            textStatus = itemView.findViewById(R.id.text_status);
            linearLayout_item_rekap_absen = itemView.findViewById(R.id.ll_rekap_absen);
        }
    }

    AdapterRvRekapAbsen(Context context,ArrayList<ModelRekapAbsen> dataItem){
        this.context = context;
        this.dataItem = dataItem;
    }

    @NonNull
    @Override
    public AdapterRvRekapAbsen.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item_rekap_absen,parent,false);
        return new AdapterRvRekapAbsen.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        TextView textJadwal = holder.textJadwal;
        TextView textTanggal = holder.textTanggal;
        TextView textStatus = holder.textStatus;

        textJadwal.setText(dataItem.get(position).getJadwal());
        textTanggal.setText(dataItem.get(position).getTanggal());
        textStatus.setText(dataItem.get(position).getStatus());
    }

    @Override
    public int getItemCount() {
        return dataItem.size();
    }

}
