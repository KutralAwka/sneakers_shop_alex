package com.example.evaluacion_alexmunozapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;

public class Info_Act extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info);
    }

    // intents implicitos
    public void Marcar(View View)
    {
        Intent i = new Intent(Intent.ACTION_DIAL); // accion para marcado telefonico
        i.setData(Uri.parse("tel:"+"947301254")); // numero al marcar
        startActivity(i);
    }

    public void Maps(View View)
    {
        Intent i = new Intent(this, MapsActivity.class);
        startActivity(i);
    }
}