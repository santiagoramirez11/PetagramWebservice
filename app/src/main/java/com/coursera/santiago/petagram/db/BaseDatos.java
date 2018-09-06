package com.coursera.santiago.petagram.db;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.coursera.santiago.petagram.pojo.Mascota;

import java.util.ArrayList;

public class BaseDatos extends SQLiteOpenHelper {
    private Context context;

    public BaseDatos(Context context) {
        super(context, ConstantesBaseDatos.DATABASE_NAME, null, ConstantesBaseDatos.DATABASE_VERSION);
        this.context = context;

    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String queryCrearTablaMascota = "CREATE TABLE " + ConstantesBaseDatos.TABLA_MASCOTA +
                "(" + ConstantesBaseDatos.TABLA_MASCOTA_CAMPO_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                ConstantesBaseDatos.TABLA_MASCOTA_CAMPO_NOMBRE +" TEXT, "+
                ConstantesBaseDatos.TABLA_MASCOTA_CAMPO_FOTO +" INTEGER "+
                ")";

        String queryCrearTablaLikesMascota = "CREATE TABLE " + ConstantesBaseDatos.TABLE_LIKES_MASCOTA +
                "(" + ConstantesBaseDatos.TABLE_LIKES_MASCOTA_CAMPO_ID + " INTEGER PRIMARY KEY AUTOINCREMENT," +
                ConstantesBaseDatos.TABLE_LIKES_MASCOTA_CAMPO_ID_MASCOTA +" INTEGER, " +
                ConstantesBaseDatos.TABLE_LIKES_MASCOTA_CAMPO_NUMERO_LIKES +" INTEGER,"+
                "FOREIGN KEY ("+ ConstantesBaseDatos.TABLE_LIKES_MASCOTA_CAMPO_ID +")"+
                "REFERENCES "+ ConstantesBaseDatos.TABLA_MASCOTA + "("+ConstantesBaseDatos.TABLA_MASCOTA_CAMPO_ID +")"+
                ")";

        db.execSQL(queryCrearTablaMascota);
        db.execSQL(queryCrearTablaLikesMascota);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXIST "+ ConstantesBaseDatos.TABLA_MASCOTA);
        db.execSQL("DROP TABLE IF EXIST "+ ConstantesBaseDatos.TABLE_LIKES_MASCOTA);
        onCreate(db);
    }

    public ArrayList<Mascota> obtenerTodosLasMascotas(){
        ArrayList<Mascota> mascotas = new ArrayList<Mascota>();

        String query = " SELECT * FROM "+ ConstantesBaseDatos.TABLA_MASCOTA;
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor registros = db.rawQuery(query,null);

        while (registros.moveToNext()){
            Mascota mascotaActual = new Mascota();
            mascotaActual.setId(registros.getInt(0));
            mascotaActual.setNombre(registros.getString(1));
            mascotaActual.setFoto(registros.getInt(2));

            String queryLikes = "SELECT COUNT("+ConstantesBaseDatos.TABLE_LIKES_MASCOTA_CAMPO_NUMERO_LIKES +") as likes "+
                    " FROM "+ ConstantesBaseDatos.TABLE_LIKES_MASCOTA +
                    " WHERE " + ConstantesBaseDatos.TABLE_LIKES_MASCOTA_CAMPO_ID_MASCOTA + " = " +mascotaActual.getId();

            Cursor registrosLikes = db.rawQuery(queryLikes, null);
            if(registrosLikes.moveToNext()){
                mascotaActual.setCantidadLike(registrosLikes.getInt(0));
            }else{
                mascotaActual.setCantidadLike(0);
            }
            mascotas.add(mascotaActual);
        }

        db.close();
        return mascotas;
    }

    public void insertarMascota(ContentValues contentValues){
        SQLiteDatabase db = this.getWritableDatabase();
        db.insert(ConstantesBaseDatos.TABLA_MASCOTA, null, contentValues);
        db.close();
    }

    public void insertarLikeMascota(ContentValues contentValues){
        SQLiteDatabase db = this.getWritableDatabase();
        db.insert(ConstantesBaseDatos.TABLE_LIKES_MASCOTA, null, contentValues);
        db.close();
    }

    public int obtenerLikesMascota(Mascota mascota){
        int likes = 0;
        String query = "SELECT COUNT("+ConstantesBaseDatos.TABLE_LIKES_MASCOTA_CAMPO_NUMERO_LIKES +")" +
                " FROM "+ ConstantesBaseDatos.TABLE_LIKES_MASCOTA +
                " WHERE " + ConstantesBaseDatos.TABLE_LIKES_MASCOTA_CAMPO_ID_MASCOTA + " =" +mascota.getId();
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor registros = db.rawQuery(query, null);

        if (registros.moveToNext()){
          likes = registros.getInt(0);
        }
        db.close();
        return likes;
    }
}
