package com.coursera.santiago.petagram.db;

import android.content.ContentValues;
import android.content.Context;

import com.coursera.santiago.petagram.R;
import com.coursera.santiago.petagram.pojo.Mascota;

import java.util.ArrayList;

public class ConstructorMascotas {

    private static final int LIKE = 1;
    private Context mContext;
    public ConstructorMascotas(Context context){
        this.mContext = context;
    }

    public ArrayList<Mascota> obtenerDatos(){


        BaseDatos db = new BaseDatos(mContext);
        ArrayList<Mascota> datos =db.obtenerTodosLasMascotas();
        if(datos.isEmpty()){
            insertarTodasLasMascotas(db);
            return db.obtenerTodosLasMascotas();
        }
        return datos;
    }

    public void insertarTodasLasMascotas(BaseDatos db){
        ContentValues contentValues  = new ContentValues();
        contentValues.put(ConstantesBaseDatos.TABLA_MASCOTA_CAMPO_NOMBRE,"Bobby");
        contentValues.put(ConstantesBaseDatos.TABLA_MASCOTA_CAMPO_FOTO, R.drawable.cachorro1);
        db.insertarMascota(contentValues);

        contentValues  = new ContentValues();
        contentValues.put(ConstantesBaseDatos.TABLA_MASCOTA_CAMPO_NOMBRE,"Catty");
        contentValues.put(ConstantesBaseDatos.TABLA_MASCOTA_CAMPO_FOTO, R.drawable.cachorro2);
        db.insertarMascota(contentValues);

        contentValues  = new ContentValues();
        contentValues.put(ConstantesBaseDatos.TABLA_MASCOTA_CAMPO_NOMBRE,"Tommy");
        contentValues.put(ConstantesBaseDatos.TABLA_MASCOTA_CAMPO_FOTO, R.drawable.cachorro3);
        db.insertarMascota(contentValues);

        contentValues  = new ContentValues();
        contentValues.put(ConstantesBaseDatos.TABLA_MASCOTA_CAMPO_NOMBRE,"Tom");
        contentValues.put(ConstantesBaseDatos.TABLA_MASCOTA_CAMPO_FOTO, R.drawable.cachorro4);
        db.insertarMascota(contentValues);

        contentValues  = new ContentValues();
        contentValues.put(ConstantesBaseDatos.TABLA_MASCOTA_CAMPO_NOMBRE,"Lazy");
        contentValues.put(ConstantesBaseDatos.TABLA_MASCOTA_CAMPO_FOTO, R.drawable.cachorro5);
        db.insertarMascota(contentValues);

        contentValues  = new ContentValues();
        contentValues.put(ConstantesBaseDatos.TABLA_MASCOTA_CAMPO_NOMBRE,"Doki");
        contentValues.put(ConstantesBaseDatos.TABLA_MASCOTA_CAMPO_FOTO, R.drawable.cachorro6);
        db.insertarMascota(contentValues);

        contentValues  = new ContentValues();
        contentValues.put(ConstantesBaseDatos.TABLA_MASCOTA_CAMPO_NOMBRE,"Samy");
        contentValues.put(ConstantesBaseDatos.TABLA_MASCOTA_CAMPO_FOTO, R.drawable.cachorro7);
        db.insertarMascota(contentValues);
    }

    public void darLikeMascota(Mascota mascota){
        BaseDatos db = new BaseDatos(mContext);
        ContentValues contentValues = new ContentValues();
        contentValues.put(ConstantesBaseDatos.TABLE_LIKES_MASCOTA_CAMPO_ID_MASCOTA, mascota.getId());
        contentValues.put(ConstantesBaseDatos.TABLE_LIKES_MASCOTA_CAMPO_NUMERO_LIKES, LIKE);
        db.insertarLikeMascota(contentValues);
    }

    public int obtenerLikesMascota(Mascota mascota){
        BaseDatos db = new BaseDatos(mContext);
        return db.obtenerLikesMascota(mascota);
    }
}
