package com.example.quizeco;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;

public class Inquietudes extends AppCompatActivity {

    private Button Continuar3;
    private RadioButton teoria, ejercicios, enunciado;
    int puntos=0;
    private boolean Valor;
    private boolean continuar1;
    private String nombre, id;

    SharedPreferences prefs;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inquietudes);

        Continuar3= findViewById(R.id.Continuar3);
        teoria = findViewById(R.id.teoria);
        ejercicios = findViewById(R.id.ejercicios);
        enunciado = findViewById(R.id.enunciado);
        continuar1=false;
        prefs  = getSharedPreferences("datos", MODE_PRIVATE);



        Continuar3.setOnClickListener(
                (v) -> {

                    if (continuar1==true){
                        puntos += prefs.getInt("puntos",0);


                        prefs.edit().putString("usuario",prefs.getString("usuario","") + " :" + puntos +"\n").apply();


                        Intent i = new Intent(this,MainActivity.class);
                        startActivity(i);
                        finish();

                    }} );

    }


    public void Teoria (View view)
    {
        if (teoria.isChecked()==true)
            Continuar3.setBackgroundResource(R.drawable.boton);
            puntos += 2;
        continuar1=true;

    }

    public void Ejercicios (View view)
    {
        if (ejercicios.isChecked()==true)
            Continuar3.setBackgroundResource(R.drawable.boton);
            puntos += 3;
        continuar1=true;

    }

    public void Enunciado (View view)
    {
        if (enunciado.isChecked()==true)
            Continuar3.setBackgroundResource(R.drawable.boton);
        puntos+=1;
        continuar1=true;

    }
}