package com.example.quizeco;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.RadioButton;
import android.widget.Toast;

public class Asistencia extends AppCompatActivity  {

    private Button Continuar2;
    SharedPreferences prefs;
    private RadioButton totalidad, parte, no;
    int puntos = 0;
    private boolean Valor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_asistencia);

        Continuar2 = findViewById(R.id.Continuar2);
        totalidad = findViewById(R.id.totalidad);
        parte = findViewById(R.id.parte);
        no = findViewById(R.id.no);



    Continuar2.setOnClickListener(
            (v) ->    {

        Intent i = new Intent(this, Inquietudes.class);
        if (Valor) {

            if (totalidad.isChecked()) {

                puntos += 3;
            }

            if (parte.isChecked()) {

                puntos++;
            }

        } else {
            Toast.makeText(this, "Haz al menos una elección", Toast.LENGTH_SHORT).show();
        }


    });

    }
    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
        new Thread(
                () -> {
                    while (true) {
                        try {
                            Thread.sleep(200);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        if (totalidad.isChecked() || parte.isChecked() || no.isChecked() ) {
                            runOnUiThread(
                                    () -> {
                                        Continuar2.setEnabled(true);
                                        Continuar2.setBackgroundResource(R.drawable.boton);
                                    }
                            );
                        } else {
                            runOnUiThread(
                                    () -> {
                                        Continuar2.setEnabled(false);
                                        Continuar2.setBackgroundResource(R.drawable.boton2);
                                    }
                            );
                        }
                    }
                }
        ).start();
    }
}
