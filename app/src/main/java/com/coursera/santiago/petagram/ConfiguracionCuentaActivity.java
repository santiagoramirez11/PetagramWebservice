package com.coursera.santiago.petagram;

import android.support.design.widget.TextInputEditText;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;

import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.MimeMessage;

public class ConfiguracionCuentaActivity extends AppCompatActivity {

    TextInputEditText tietUsuario;
    TextInputEditText tietCorreo;
    TextInputEditText tietMensaje;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_configuracion_cuenta);

        Toolbar miActionBar = findViewById(R.id.miActionBar);
        miActionBar.findViewById(R.id.ibFavoritos).setVisibility(View.INVISIBLE);
        setSupportActionBar(miActionBar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        tietUsuario = findViewById(R.id.tietUsuario);

    }

    public void guardarCuenta(View v){
        ConfiguracionCuentaActivity.this.finish();
    }
}
