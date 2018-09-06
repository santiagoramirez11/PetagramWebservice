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

public class ContactoActivity extends AppCompatActivity {

    TextInputEditText tietNombre;
    TextInputEditText tietCorreo;
    TextInputEditText tietMensaje;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contacto);

        Toolbar miActionBar = findViewById(R.id.miActionBar);
        miActionBar.findViewById(R.id.ibFavoritos).setVisibility(View.INVISIBLE);
        setSupportActionBar(miActionBar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        tietNombre = findViewById(R.id.tietNombre);
        tietCorreo = findViewById(R.id.tietCorreo);
        tietMensaje = findViewById(R.id.tietMensaje);
    }

    public void enviarEmail(View v){
        Thread hiloEnvio = new Thread(){
            public void run(){
                Properties props = new Properties();
                props.setProperty("mail.transport.protocol", "smtp");
                props.setProperty("mail.host", "smtp.gmail.com");
                props.put("mail.smtp.auth", "true");
                props.put("mail.smtp.port", "465");
                props.put("mail.smtp.socketFactory.port", "465");
                props.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
                props.put("mail.smtp.socketFactory.fallback", "false");
                props.setProperty("mail.smtp.quitwait", "false");

                Session session = Session.getInstance(props, null);
                String userName = "";//Colocar email Aquí
                String passWord = "";//Colocar password aquí
                ContactoActivity.this.finish();

                try{
                    MimeMessage msg = new MimeMessage(session);
                    msg.setFrom("");//Colocar email Aquí
                    msg.setRecipients(Message.RecipientType.TO, tietCorreo.getText().toString());
                    msg.setSubject("Petagram - Comentario de "+tietNombre.getText().toString());
                    msg.setText(tietMensaje.getText().toString());
                    Transport.send(msg, userName, passWord);
                }catch (MessagingException ex){
                    Log.d("Petagram", "Fallo el envio de email");
                    ex.printStackTrace();
                }
            }
        };
        hiloEnvio.start();
    }
}