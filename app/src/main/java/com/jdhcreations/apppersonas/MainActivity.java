package com.jdhcreations.apppersonas;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    //Metodo Boton formulario
    public void FormularioPersonas(View view){
        Intent FormularioEmpleado = new Intent(this, FormularioPersonas.class);
        startActivity(FormularioEmpleado);
    }

}