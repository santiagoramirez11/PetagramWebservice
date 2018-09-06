package com.coursera.santiago.petagram.fragment;

import com.coursera.santiago.petagram.adapter.MascotaAdaptador;
import com.coursera.santiago.petagram.pojo.Mascota;

import java.util.ArrayList;

public interface IRecyclerViewFragmentView {

    public void generarLinearLayoutVertical();
    public MascotaAdaptador crearAdaptador(ArrayList<Mascota> mascotas);
    public void inicializarAdaptador(MascotaAdaptador adaptador);

    public void generarGridLayout();
    public void cargarOtroCampos(ArrayList<Mascota> mascotas);
}
