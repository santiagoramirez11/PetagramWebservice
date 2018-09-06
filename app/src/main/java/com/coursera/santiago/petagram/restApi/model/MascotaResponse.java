package com.coursera.santiago.petagram.restApi.model;

import com.coursera.santiago.petagram.pojo.Mascota;

import java.util.ArrayList;

public class MascotaResponse {

    ArrayList<Mascota> mMascotas;

    public ArrayList<Mascota> getMascotas() {
        return mMascotas;
    }

    public void setMascotas(ArrayList<Mascota> mascotas) {
        mMascotas = mascotas;
    }
}
