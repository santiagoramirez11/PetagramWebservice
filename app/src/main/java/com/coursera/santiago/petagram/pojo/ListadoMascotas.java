package com.coursera.santiago.petagram.pojo;

import java.util.ArrayList;
import java.util.Collections;

public class ListadoMascotas {
    private static ArrayList<Mascota> mascotas = new ArrayList<Mascota>();

    public static ArrayList<Mascota> getMascotas() {
        return mascotas;
    }

    public static void setMascotas(ArrayList<Mascota> mascotas) {
        ListadoMascotas.mascotas = mascotas;
    }

    public static ArrayList<Mascota> getListadoOrdenadoPorLike(){
        ArrayList<Mascota> mascotasFavoritas = new ArrayList<Mascota>();
        mascotasFavoritas.addAll(getMascotas());
        Collections.sort(mascotasFavoritas);
        int size = mascotasFavoritas.size();
        while (size > 5){
            mascotasFavoritas.remove(mascotasFavoritas.size()-1);
            size--;
        }
        return mascotasFavoritas;
    }

    public static ArrayList<Mascota> getListadoOrdenadoPorLike(ArrayList<Mascota> mascotas){
        ArrayList<Mascota> mascotasFavoritas = new ArrayList<Mascota>();
        mascotasFavoritas.addAll(mascotas);
        Collections.sort(mascotasFavoritas);
        int size = mascotasFavoritas.size();
        while (size > 5){
            mascotasFavoritas.remove(mascotasFavoritas.size()-1);
            size--;
        }
        return mascotasFavoritas;
    }
}
