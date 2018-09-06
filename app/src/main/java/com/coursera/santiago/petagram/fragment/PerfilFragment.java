package com.coursera.santiago.petagram.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.coursera.santiago.petagram.R;
import com.coursera.santiago.petagram.adapter.MascotaAdaptador;
import com.coursera.santiago.petagram.adapter.MascotaGridAdaptador;
import com.coursera.santiago.petagram.pojo.ListadoMascotas;
import com.coursera.santiago.petagram.pojo.Mascota;
import com.coursera.santiago.petagram.presentador.IRecyclerViewFragmentPresenter;
import com.coursera.santiago.petagram.presentador.RecyclerViewFragmentPresenter;
import com.mikhaellopez.circularimageview.CircularImageView;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

import retrofit2.Retrofit;


public class PerfilFragment extends Fragment implements IRecyclerViewFragmentView{

    RecyclerView rvMascostas;
    View v;
//    ArrayList<Mascota> alMascotas;
    private IRecyclerViewFragmentPresenter presenter;
    private CircularImageView civPerfil;
    private TextView tvNombrePerfil;

    public PerfilFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        v = inflater.inflate(R.layout.fragment_perfil, container, false);

        rvMascostas = v.findViewById(R.id.rvMascostas);
        presenter = new RecyclerViewFragmentPresenter(this, getContext());

        GridLayoutManager gmMascota = new GridLayoutManager(getActivity(), 3);


        rvMascostas.setLayoutManager(gmMascota);
//        crearListadoMascota();
//        inicializarAdaptador();
        return v;
    }

//    public void inicializarAdaptador(){
//        MascotaGridAdaptador adaptador = new MascotaGridAdaptador(alMascotas);
//        rvMascostas.setAdapter(adaptador);
//    }


//    public void crearListadoMascota(){
//        alMascotas = new ArrayList<Mascota>();
//        alMascotas.add(new Mascota("Bobby",R.drawable.cachorro1,3));
//        alMascotas.add(new Mascota("Catty",R.drawable.cachorro2,2));
//        alMascotas.add(new Mascota("Tommy",R.drawable.cachorro3,4));
//        alMascotas.add(new Mascota("Tom",R.drawable.cachorro4,0));
//        alMascotas.add(new Mascota("Lazy",R.drawable.cachorro5,5));
//        alMascotas.add(new Mascota("Doki",R.drawable.cachorro6,1));
//        alMascotas.add(new Mascota("Samy",R.drawable.cachorro7,3));
//    }

    @Override
    public void onResume() {
        super.onResume();
        Log.d("Petagram", "Cambio");
    }

    @Override
    public void generarLinearLayoutVertical() {

    }

    @Override
    public MascotaAdaptador crearAdaptador(ArrayList<Mascota> mascotas) {
        return new MascotaAdaptador(mascotas);
    }

    @Override
    public void inicializarAdaptador(MascotaAdaptador adaptador) {
        rvMascostas.setAdapter(adaptador);
    }

    @Override
    public void generarGridLayout() {
        GridLayoutManager gridLayoutManager = new GridLayoutManager(getContext(), 2);
        rvMascostas.setLayoutManager(gridLayoutManager);
    }

    @Override
    public void cargarOtroCampos(ArrayList<Mascota> mascotas) {
        civPerfil = v.findViewById(R.id.civPerfil);
        tvNombrePerfil = v.findViewById(R.id.tvNombrePerfil);
        if(!mascotas.isEmpty()){
            Picasso.get().load(mascotas.get(0).getUrlFotoPerfil()).into(civPerfil);
            tvNombrePerfil.setText(mascotas.get(0).getNombre());
        }
    }
}
