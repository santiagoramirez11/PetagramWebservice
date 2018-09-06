package com.coursera.santiago.petagram.db;

public final class ConstantesBaseDatos {

    public static final String DATABASE_NAME ="mascotas";
    public static final int DATABASE_VERSION = 1;

    public static final String TABLA_MASCOTA = "mascota";
    public static final String TABLA_MASCOTA_CAMPO_ID = "id";
    public static final String TABLA_MASCOTA_CAMPO_NOMBRE = "nombre";
    public static final String TABLA_MASCOTA_CAMPO_FOTO = "foto";

    public static final String TABLE_LIKES_MASCOTA = "mascota_likes";
    public static final String TABLE_LIKES_MASCOTA_CAMPO_ID = "id";
    public static final String TABLE_LIKES_MASCOTA_CAMPO_NUMERO_LIKES = "numero_like";
    public static final String TABLE_LIKES_MASCOTA_CAMPO_ID_MASCOTA = "id_mascota";
}
