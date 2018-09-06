package com.coursera.santiago.petagram.pojo;

import android.support.annotation.NonNull;

public class Mascota implements Comparable<Mascota>{
    private int id;
    private String nombre;
    private int foto;
    private int cantidadLike;

    private String otroId;
    private String urlFoto;
    private String urlFotoPerfil;
    public Mascota(){

    }

    public Mascota(String nombre, int foto, int cantidadLike) {
        this.nombre = nombre;
        this.foto = foto;
        this.cantidadLike = cantidadLike;
    }

    public Mascota(String nombre, String urlFoto, int cantidadLike) {
        this.nombre = nombre;
        this.urlFoto = urlFoto;
        this.cantidadLike = cantidadLike;
    }

    public String getOtroId() {
        return otroId;
    }

    public void setOtroId(String otroId) {
        this.otroId = otroId;
    }

    public String getUrlFoto() {
        return urlFoto;
    }

    public void setUrlFoto(String urlFoto) {
        this.urlFoto = urlFoto;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getFoto() {
        return foto;
    }

    public void setFoto(int foto) {
        this.foto = foto;
    }

    public int getCantidadLike() {
        return cantidadLike;
    }

    public void setCantidadLike(int cantidadLike) {
        this.cantidadLike = cantidadLike;
    }

    @Override
    public int compareTo(@NonNull Mascota comparado) {

        return comparado.getCantidadLike()-this.getCantidadLike();
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId(){
        return id;
    }

    public void setUrlFotoPerfil(String urlFotoPerfil) {
        this.urlFotoPerfil = urlFotoPerfil;
    }

    public String getUrlFotoPerfil(){
        return urlFotoPerfil;
    }
}
