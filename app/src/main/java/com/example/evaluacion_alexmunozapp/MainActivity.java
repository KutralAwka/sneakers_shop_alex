package com.example.evaluacion_alexmunozapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;

import Objetos.Administrador;
import Objetos.Productos;

public class MainActivity extends AppCompatActivity {

    private EditText user, pass;
    private TextView msj;
    private Administrador adm = new Administrador();
    private Productos pr = new Productos();
    private Button btn;
    private ProgressBar barra;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        user = findViewById(R.id.etuser);
        pass = findViewById(R.id.etpass);
        msj = findViewById(R.id.msj);
        msj.setVisibility(View.INVISIBLE);
        barra.setVisibility(View.INVISIBLE);
        btn = findViewById(R.id.btn);
        barra = findViewById(R.id.pb);


        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                //aqui corre la tarea asincrona

                new Task().execute();
            }
        });
    }

    //tarea asincrona.

    class Task extends AsyncTask<String, Void, String>
    {
        //es donde se puede dar la conf inicial a mi tarea
        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            barra.setVisibility(View.VISIBLE); //hago visible mi barra.
        }

        //es el encargado de procesar en segundo plano nuestra tarea pesada.
        @Override
        protected String doInBackground(String... strings) {

            try {
                for (int i = 0; 1 <= 10; i++)
                {
                    Thread.sleep(500); //duerme un proceso por 500milis.
                }
            }
            catch (InterruptedException e)
            {
                e.printStackTrace();
            }
            return null;
        }

        //es donde finaliza mi tarea asincrona
        @Override
        protected void onPostExecute(String s) {
            super.onPostExecute(s);

            barra.setVisibility(View.INVISIBLE);

             //validacion de la sesion
            String usuario = user.getText().toString().trim();
            String contraseña = pass.getText().toString().trim();

            String userObj = adm.getUser().trim();
            String passObj = adm.getPass().trim();

            switch (usuario)
            {
                case "Alex":
                    if(usuario.equals(userObj) && contraseña.equals(passObj))
                    {
                        //inciio de sesion
                        msj.setVisibility(View.INVISIBLE);
                        Intent i = new Intent(getBaseContext(), Home_act.class);
                        startActivity(i);
                    }
                    break;
                case "":
                    if(usuario.equals("")&& contraseña.equals(""))
                    {
                        msj.setVisibility(View.INVISIBLE);
                        msj.setText("Campos vacíos favor intente nuevamente");

                    }
                    break;
                default:
                    if(!usuario.equals(userObj) && !contraseña.equals(passObj))
                    {
                        msj.setVisibility(View.INVISIBLE);
                        msj.setText("Campos incorrectos favor intente nuevamente");

                    }
                    break;


            }
        }
    }


    public void Facebook(View View)
    {
        Intent i = new Intent(Intent.ACTION_VIEW); //ABRE UN SITIO WEB
        i.setData(Uri.parse("https://www.facebook.com/"));
        startActivity(i);
    }
    public void Youtube(View View)
    {
        Intent i = new Intent(Intent.ACTION_VIEW); //ABRE UN SITIO WEB
        i.setData(Uri.parse("https://www.youtube.com/"));
        startActivity(i);
    }
    public void Twitter(View View)
    {
        Intent i = new Intent(Intent.ACTION_VIEW); //ABRE UN SITIO WEB
        i.setData(Uri.parse("https://www.twitter.com/"));
        startActivity(i);
    }

}