package com.example.sofilop.ejecrcio2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class Respuesta extends AppCompatActivity {

    TextView resp;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_respuesta);



Persona pe=new Persona();
resp=(TextView)findViewById(R.id.txtResultado);
        resp.setText("Estatus: NORMAL "+"Name  "+getIntent().getStringExtra("nombre")+" \n peso  "+getIntent().getStringExtra("peso")+" \n Estatura  "+getIntent().getStringExtra("estarura")+
                "");



    }
}
