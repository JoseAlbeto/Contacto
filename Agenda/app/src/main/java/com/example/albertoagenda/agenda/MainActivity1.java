package com.example.albertoagenda.agenda;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import java.io.Serializable;
import java.util.ArrayList;

public class MainActivity1 extends AppCompatActivity implements Serializable{

    Button botonA;
    ListView listaCon;
    ArrayList <String> arr;
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main1);
        botonA =(Button)findViewById(R.id.btnAgregarCon);

        arr= new ArrayList<>();
        listaCon = (ListView)findViewById(R.id.lvListaCon);

        botonA.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplication(), MainActivity2.class);

                startActivityForResult(i,1000);
            }
        });


    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(resultCode==RESULT_OK){
            Contacto con = (Contacto)data.getSerializableExtra("contac");
            arr.add(con.getUsuario()+"\n"+con.getEmail());
            ArrayAdapter adaptador = new ArrayAdapter(this,android.R.layout.simple_expandable_list_item_1,arr);
            listaCon.setAdapter(adaptador);

        }
    }
}
