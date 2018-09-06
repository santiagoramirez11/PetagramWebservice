package com.coursera.santiago.petagram;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

public class DetalleContacto extends AppCompatActivity {

    private static final String KEY_EXTRA_URL = "url";
    private static final String KEY_EXTRA_LIKE = "like";
    private TextView tvLikesDetalle;
    private ImageView imgFoto;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalle_contacto);

        Bundle extras = getIntent().getExtras();
        String url = extras.getString(KEY_EXTRA_URL);
        int likes = extras.getInt(KEY_EXTRA_LIKE);

        tvLikesDetalle = findViewById(R.id.tvLikesDetalle);

        tvLikesDetalle.setText(String.valueOf(likes));
        imgFoto = findViewById(R.id.imgFoto);
        Picasso.get()
                .load(url)
                .placeholder(R.drawable.cachorro1)
                .into(imgFoto);


    }
}
