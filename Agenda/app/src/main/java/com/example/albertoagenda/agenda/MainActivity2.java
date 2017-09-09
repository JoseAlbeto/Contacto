package com.example.albertoagenda.agenda;


import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.io.Serializable;
import java.util.ArrayList;

public class MainActivity2 extends AppCompatActivity implements Serializable{
    ArrayList <String> con2;
    Button bontonAgr;
    EditText usuario;
    EditText email;
    EditText twiter;
    EditText telefono;
    EditText fechNac;
    Contacto contac2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        Intent i = getIntent();
        bontonAgr = (Button)findViewById(R.id.btnGuardar);
        usuario = (EditText) findViewById(R.id.txtUsuario);
        email = (EditText) findViewById(R.id.txtEmail);
        twiter = (EditText) findViewById(R.id.txtTwiter);
        telefono = (EditText) findViewById(R.id.txtTelefono);
        fechNac = (EditText) findViewById(R.id.txtFecha);


        bontonAgr.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                contac2 = new Contacto();

                contac2.setUsuario(usuario.getText().toString());
                contac2.setEmail(email.getText().toString());
                contac2.setTwiter(twiter.getText().toString());
                contac2.setTelefono(telefono.getText().toString());
                contac2.setFechaNacimiento(fechNac.getText().toString());

                Intent i = new Intent();
                i.putExtra("contac",contac2);
                setResult(RESULT_OK,i);

                Toast.makeText(getApplication(),"Se hizo clic al botón", Toast.LENGTH_LONG).show();
                finish();
            }
        });




    }
}