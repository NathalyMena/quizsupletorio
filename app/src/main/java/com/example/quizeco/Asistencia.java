package com.example.quizeco;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;

public class Asistencia extends AppCompatActivity  {

    private Button Continuar2;
    private RadioButton totalidad, parte, no;
    int puntos = 0;
    private boolean continuar;

    SharedPreferences prefs;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_asistencia);

        Continuar2 = findViewById(R.id.Continuar3);
        totalidad = findViewById(R.id.totalidad);
        parte = findViewById(R.id.parte);
        no = findViewById(R.id.no);
        continuar=false;
        prefs  = getSharedPreferences("datos", MODE_PRIVATE);



        Continuar2.setOnClickListener(
                (v) -> {

                    if (continuar==true){

                    Intent i = new Intent(this, Inquietudes.class);
                        prefs.edit().putInt("puntos",puntos).apply();
                        startActivity(i);
                        finish();

                } });

    }


        public void Totalidad (View view)
    {
        if (totalidad.isChecked()==true)
            Continuar2.setBackgroundResource(R.drawable.boton);
        puntos += 3;
        continuar=true;



    }

    public void Parte (View view)
    {
        if (parte.isChecked()==true)
            Continuar2.setBackgroundResource(R.drawable.boton);
        puntos += 1;
        continuar=true;

    }

    public void No (View view)
    {
        if (no.isChecked()==true)
            Continuar2.setBackgroundResource(R.drawable.boton);
        puntos += 0;
        continuar=true;

    }


        }




