package com.coursera.santiago.petagram.adapter;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;

import com.coursera.santiago.petagram.R;
import com.coursera.santiago.petagram.pojo.Mascota;

import java.util.ArrayList;

public class MascotaGridAdaptador extends RecyclerView.Adapter<MascotaGridAdaptador.MascotaViewHolder>{

    ArrayList<Mascota> alMascotas;

    public MascotaGridAdaptador(ArrayList<Mascota> alMascotas){
        this.alMascotas = alMascotas;
    }
    @NonNull
    @Override
    public MascotaViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.card_view_gid_mascota, parent, false);
        return new MascotaViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull final MascotaViewHolder mascotaViewHolder, int position) {
        final Mascota mascota = alMascotas.get(position);
        mascotaViewHolder.ibFoto.setImageResource(mascota.getFoto());
        mascotaViewHolder.tvCantidadLike.setText(""+mascota.getCantidadLike());

    }

    @Override
    public int getItemCount() {
        return alMascotas.size();
    }

    public static class MascotaViewHolder extends RecyclerView.ViewHolder {

        private ImageButton ibFoto;
        private TextView tvCantidadLike;

        public MascotaViewHolder(View itemView) {
            super(itemView);
            ibFoto = itemView.findViewById(R.id.ibFoto);
            tvCantidadLike = itemView.findViewById(R.id.tvCantidadLike);


        }
    }
}
