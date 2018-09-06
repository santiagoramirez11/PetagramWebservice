package com.coursera.santiago.petagram.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.coursera.santiago.petagram.R;
import com.coursera.santiago.petagram.adapter.MascotaAdaptador;
import com.coursera.santiago.petagram.pojo.ListadoMascotas;
import com.coursera.santiago.petagram.pojo.Mascota;
import com.coursera.santiago.petagram.presentador.IRecyclerViewFragmentPresenter;
import com.coursera.santiago.petagram.presentador.RecyclerViewFragmentPresenter;

import java.util.ArrayList;


public class ListadoMascotaFragment extends Fragment implements IRecyclerViewFragmentView{

    RecyclerView rvMascostas;
    private IRecyclerViewFragmentPresenter presenter;
    public ListadoMascotaFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_listado_mascota, container, false);

        rvMascostas = v.findViewById(R.id.rvMascostas);

        presenter = new RecyclerViewFragmentPresenter(this, getContext());
//        crearListadoMascota();
//        inicializarAdaptador();
        return v;
    }

    public void inicializarAdaptador(){

    }


    public void crearListadoMascota(){
        if(ListadoMascotas.getMascotas().isEmpty()){
            ArrayList<Mascota> alMascotas = new ArrayList<Mascota>();
            alMascotas.add(new Mascota("Bobby",R.drawable.cachorro1,0));
            alMascotas.add(new Mascota("Catty",R.drawable.cachorro2,0));
            alMascotas.add(new Mascota("Tommy",R.drawable.cachorro3,0));
            alMascotas.add(new Mascota("Tom",R.drawable.cachorro4,0));
            alMascotas.add(new Mascota("Lazy",R.drawable.cachorro5,0));
            alMascotas.add(new Mascota("Doki",R.drawable.cachorro6,0));
            alMascotas.add(new Mascota("Samy",R.drawable.cachorro7,0));
            ListadoMascotas.setMascotas(alMascotas);
        }
    }

    @Override
    public void generarLinearLayoutVertical() {
        LinearLayoutManager llmMascota = new LinearLayoutManager(getActivity());
        llmMascota.setOrientation(LinearLayoutManager.VERTICAL);

        rvMascostas.setLayoutManager(llmMascota);
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

    }
}
