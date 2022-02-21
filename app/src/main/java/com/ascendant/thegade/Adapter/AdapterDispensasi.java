package com.ascendant.thegade.Adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.ascendant.thegade.Method.Ascendant;
import com.ascendant.thegade.Model.DataModel;
import com.ascendant.thegade.R;
import com.bumptech.glide.Glide;

import java.util.List;

public class AdapterDispensasi extends RecyclerView.Adapter<AdapterDispensasi.HolderData>{
    private List<DataModel> mList;
    private Context ctx;
    Ascendant AscNet;
    public AdapterDispensasi (Context ctx, List<DataModel> mList){
        this.ctx = ctx;
        this.mList = mList;
    }

    @NonNull
    @Override
    public HolderData onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View layout = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.list_dispensasi,viewGroup,false);
        HolderData holder = new HolderData(layout);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull final HolderData holderData, int posistion) {
        final DataModel dm = mList.get(posistion);
        AscNet = new Ascendant();
        holderData.TglPengajuan.setText(dm.getTgl_pengajuan());
        holderData.JenisDispensasi.setText(dm.getJenis_dispensasi());
        holderData.Mulai.setText(dm.getTgl_mulai());
        holderData.Selesai.setText(dm.getTgl_selesai());
        holderData.Keterangan.setText(dm.getKeterangan_dispensasi());
    }

    @Override
    public int getItemCount() {
        return mList.size();
    }

    class HolderData extends RecyclerView.ViewHolder{
        TextView TglPengajuan,JenisDispensasi,Mulai,Selesai,Keterangan;
        public HolderData(View v) {
            super(v);
            TglPengajuan = v.findViewById(R.id.tvTanggalPengajuan);
            JenisDispensasi = v.findViewById(R.id.tvJenisDispensasi);
            Mulai = v.findViewById(R.id.tvTglMulai);
            Selesai = v.findViewById(R.id.tvTglSelesai);
            Keterangan = v.findViewById(R.id.tvKeterangan);
        }
    }
}
