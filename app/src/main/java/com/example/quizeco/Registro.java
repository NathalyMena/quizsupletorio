package com.example.quizeco;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Registro extends AppCompatActivity {

    private EditText Nombre, ID;
    private Button Continuar1;
    private String nombre, id;
    private boolean numero;
    boolean existe=false;


    SharedPreferences sharedPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro);

        Nombre = findViewById(R.id.Nombre);
        ID = findViewById(R.id.ID);
        Continuar1 = findViewById(R.id.Continuar1);
        sharedPreferences = getSharedPreferences("datos",MODE_PRIVATE);

        Continuar1.setOnClickListener(

                (v) -> {
                    String registrosAnteriores = sharedPreferences.getString("codigo", "");

                    String nombre = Nombre.getText().toString();
                    String codigo = ID.getText().toString();

                    if(nombre.isEmpty()||codigo.isEmpty()){

                        Toast.makeText(this, "Por favor complete todos los campos", Toast.LENGTH_SHORT).show();
                        return;
                    }


                    if (registrosAnteriores != null) {

                        String[] registros;
                        registros = registrosAnteriores.split(",");


                        for (int i = 0; i < registros.length; i++) {

                            if (registros[i].contentEquals(codigo)) {

                                existe = true;
                                Toast.makeText(this, "ya existe un usario con este codigo", Toast.LENGTH_SHORT).show();
                                return;
                            }
                            else{


                                existe=false;
                            }

                        }
                    }
                    if(!existe){

                        sharedPreferences.edit().putString("usuario", sharedPreferences.getString("usuario", "") + nombre).apply();
                        sharedPreferences.edit().putString("codigo", sharedPreferences.getString("codigo", "") + codigo + ",").apply();

                        Intent intent = new Intent(this, Asistencia.class);
                        startActivity(intent);
                        finish();

                    }

                });

                }


    protected void validacion() {
        numero = true;
        if (nombre == null || nombre.isEmpty() || id == null || id.isEmpty()) {
            Toast.makeText(this, "Hay campos vacíos", Toast.LENGTH_LONG).show();
            numero = false;
        } else {
            for (int i = 0; i < nombre.length(); i++) {
                if (Character.isDigit(nombre.charAt(i))) {
                    Toast.makeText(this, "Tienes números en el nombre. Revíselo.", Toast.LENGTH_LONG).show();
                    nombre = "";
                    numero = false;
                } else {
                    numero = true;
                }
            }
        }
        String usuarios = getSharedPreferences("encuesta", MODE_PRIVATE).getString("encuestados", "");
        if (usuarios.contains(id)) {
            Toast.makeText(this, "Esta persona ya fue registrada", Toast.LENGTH_LONG).show();
            numero = false;
        }
    }
}


