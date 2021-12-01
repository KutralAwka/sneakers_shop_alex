package com.example.evaluacion_alexmunozapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.RatingBar;
import android.widget.Spinner;
import android.widget.TextView;

import Objetos.Productos;

public class productos_act extends AppCompatActivity {

    private Spinner productos;
    private TextView result;
    private RatingBar calificar;
    private Productos pr = new Productos(); //Instancia del obj Productos

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_productos);

        productos = findViewById(R.id.spnProductos);
        result = findViewById(R.id.result);
        calificar = findViewById(R.id.rt);

        //recibe los extras
        Bundle bun = getIntent().getExtras();// recibo el intent con los valores del bundle.
        String[] listado = bun.getStringArray("productos"); //recobp el listado

        ArrayAdapter adaptProductos = new ArrayAdapter(this, android.R.layout.simple_list_item_1, listado);
        productos.setAdapter(adaptProductos);
    }

    //metodo para calcular insumos
    public void Calcular(View view)
    {

        String opcion = productos.getSelectedItem().toString(); // obtengo la seleccion en una variable
        int resultado = 0;

        for(int i = 0; i < opcion.length(); i++)
        {
            if(opcion.equals(pr.getProductos()[i]))//pregunto por la seleccion de spineers
            {
               //resultado = pr.getPrecios()[i]; //Obtengo precios
                resultado = pr.anadirAdicional(pr.getPrecios()[i], 350); //obtengo regla del adicional
                calificar.setRating(i+1); //pinto las estrellas.
                break;
            }
        }

        result.setText("La Opción es: " + opcion + "\nSu precio es: " + resultado);
    }
}