package com.coursera.santiago.petagram;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;

import com.coursera.santiago.petagram.adapter.MascotaAdaptador;
import com.coursera.santiago.petagram.db.ConstructorMascotas;
import com.coursera.santiago.petagram.fragment.IRecyclerViewFragmentView;
import com.coursera.santiago.petagram.pojo.ListadoMascotas;
import com.coursera.santiago.petagram.pojo.Mascota;
import com.coursera.santiago.petagram.presentador.IRecyclerViewFragmentPresenter;
import com.coursera.santiago.petagram.presentador.RecyclerViewFragmentPresenter;

import java.util.ArrayList;

public class MascotasFavoritas extends AppCompatActivity implements IRecyclerViewFragmentView{

    RecyclerView rvMascostasFavoritas;
    ArrayList<Mascota> alMascotasFavoritas = new ArrayList<Mascota>();
    View v;
    private IRecyclerViewFragmentPresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mascotas_favoritas);

        Toolbar miActionBar = findViewById(R.id.miActionBar);
        miActionBar.findViewById(R.id.ibFavoritos).setVisibility(View.INVISIBLE);
        setSupportActionBar(miActionBar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        presenter = new RecyclerViewFragmentPresenter(this, getApplicationContext());

        rvMascostasFavoritas = findViewById(R.id.rvMascotasFavoritas);


    }



    @Override
    public void generarLinearLayoutVertical() {

    }

    @Override
    public MascotaAdaptador crearAdaptador(ArrayList<Mascota> mascotas) {
        alMascotasFavoritas = ListadoMascotas.getListadoOrdenadoPorLike(mascotas);
        return new MascotaAdaptador(alMascotasFavoritas);
    }

    @Override
    public void inicializarAdaptador(MascotaAdaptador adaptador) {
        rvMascostasFavoritas.setAdapter(adaptador);
    }

    @Override
    public void generarGridLayout() {
        GridLayoutManager gridLayoutManager = new GridLayoutManager(getApplicationContext(), 2);
        rvMascostasFavoritas.setLayoutManager(gridLayoutManager);
    }

    @Override
    public void cargarOtroCampos(ArrayList<Mascota> mascotas) {

    }
}
