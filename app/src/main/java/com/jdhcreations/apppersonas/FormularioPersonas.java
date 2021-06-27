package com.jdhcreations.apppersonas;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Spinner;
import android.widget.Toast;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class FormularioPersonas extends AppCompatActivity implements View.OnClickListener {

    private EditText txtIdentificationCard;
    private EditText txtName;
    private EditText txtSurname;
    private EditText txtAge;
    private EditText txtCarge;
    private EditText txtEmail;
    private EditText txtSalary;
    private Button btnRegister;
    private ImageButton btnReturn;
    static List<Emple> empleList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_formulario_personas);

        txtIdentificationCard = findViewById(R.id.txtDocumento);
        txtName = findViewById(R.id.txtNombre);
        txtSurname = findViewById(R.id.txtApellido);
        txtAge = findViewById(R.id.txtEdad);
        txtCarge = findViewById(R.id.txtCargo);
        txtEmail = findViewById(R.id.txtCorreo);
        txtSalary = findViewById(R.id.txtSalario);
        btnRegister = findViewById(R.id.btnGuardar);
        btnReturn = findViewById(R.id.ibBack);
        btnRegister.setOnClickListener(this);
        btnReturn.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.btnGuardar){

            if (txtIdentificationCard.getText().toString().isEmpty()  ||  txtName.getText().toString().isEmpty() || txtAge.getText().toString().isEmpty()
                    || txtEmail.getText().toString().isEmpty() || txtSalary.getText().toString().isEmpty()){
                Toast.makeText(this, "Llene todos los campos", Toast.LENGTH_SHORT).show();
            }else {
                addEmple();
                Toast.makeText(this, "Empleado Guardado", Toast.LENGTH_SHORT).show();
            }
        }else if(v.getId()==R.id.ibBack){
            Intent intentList = new Intent(this, MainActivity.class);
            intentList.putExtra("list", (Serializable) empleList);
            startActivity(intentList);

        }
    }

    public void addEmple(){
        Emple newEmp = new Emple(txtIdentificationCard.getText().toString(),txtName.getText().toString(),txtSurname.getText().toString(),
                Integer.parseInt(txtAge.getText().toString()),txtCarge.getText().toString(),txtEmail.getText().toString(),Double.parseDouble(txtSalary.getText().toString()));
        empleList.add(newEmp);
        clearFields();
    }

    public void clearFields(){
        txtIdentificationCard.setText("");
        txtName.setText("");
        txtSurname.setText("");
        txtAge.setText("");
        txtEmail.setText("");
        txtSalary.setText("");
    }
}