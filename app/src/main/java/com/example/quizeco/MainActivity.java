package com.example.quizeco;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private Button Registrar;
    private TextView Registro;

    SharedPreferences sharedPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Registrar = findViewById(R.id.Registrar);
        Registro = findViewById(R.id.Registro);
        sharedPreferences = getSharedPreferences("datos",MODE_PRIVATE);


        MostrarRegistros();

        Registrar.setOnClickListener(
                (v)->{
                    Intent i = new Intent(this, Registro.class);
                    startActivity(i);
                }
        );

    }

       public void MostrarRegistros(){

        String registros = sharedPreferences.getString("usuario","");

        Registro.setText(registros);

    }


}