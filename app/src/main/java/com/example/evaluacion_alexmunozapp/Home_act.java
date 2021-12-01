package com.example.evaluacion_alexmunozapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.MediaController;
import android.widget.Toast;
import android.widget.VideoView;

import Objetos.Productos;

public class Home_act extends AppCompatActivity {

    private Productos pr = new Productos(); //la instancia del obj productos
    private VideoView video;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        video = findViewById(R.id.vw);

        String ruta = "android.resource://" + getPackageName() + "/" + R.raw.video;
        Uri uri = Uri.parse(ruta); //parseo la ruta

        video.setVideoURI(uri);// le paso la ruta al videoview

        //controles para el video

        MediaController media = new MediaController(this);
        video.setMediaController(media);

        video.start(); //iniciamos video


    }
     public void Productos(View View)
     {
         //preparar los extras
         Intent i = new Intent(this, productos_act.class);
         Bundle bun = new Bundle();//necesario para enviar arreglos
         bun.putStringArray("productos", pr.getProductos());//envio el bundle a traves del intent
         i.putExtras(bun);

         startActivity(i);

     }

    public void Info(View view)
    {
        Intent i = new Intent(this, Info_Act.class);
        startActivity(i);
    }

}