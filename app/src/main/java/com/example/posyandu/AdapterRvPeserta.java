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

public class AdapterRvPeserta extends RecyclerView.Adapter<AdapterRvPeserta.ViewHolder> {
    private ArrayList<ModelPeserta> dataItem;
    private Context context;

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView textTanggalLahir;
        TextView textNama;
        TextView textJenisKelamin;
        LinearLayout linearLayout_item_peserta;


        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            textNama = itemView.findViewById(R.id.text_nama);
            linearLayout_item_peserta = itemView.findViewById(R.id.ll_peserta);
        }
    }

    AdapterRvPeserta(Context context, ArrayList<ModelPeserta> dataItem){
        this.context = context;
        this.dataItem = dataItem;
    }

    @NonNull
    @Override
    public AdapterRvPeserta.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item_peserta,parent,false);
        return new AdapterRvPeserta.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        TextView textNama = holder.textNama;
//        TextView textTanggal = holder.textTanggal;
//        TextView textStatus = holder.textStatus;

        textNama.setText(dataItem.get(position).getNama());
//        textTanggal.setText(dataItem.get(position).getTanggal());
//        textStatus.setText(dataItem.get(position).getStatus());
    }

    @Override
    public int getItemCount() {
        return dataItem.size();
    }

    void setFilter(ArrayList<ModelPeserta> filterModel){
        dataItem = new ArrayList<>();
        dataItem.addAll(filterModel);
        notifyDataSetChanged();
    }
}
