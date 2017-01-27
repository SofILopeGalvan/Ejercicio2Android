package com.example.sofilop.ejecrcio2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class SobrePeso extends AppCompatActivity {
    TextView resp;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sobre_peso);



        Persona pe=new Persona();
        resp=(TextView)findViewById(R.id.txtResultado);
        resp.setText("Lo siento mucho puro es estado indica que tiene sobre peso \n "+" \n Name  "+getIntent().getStringExtra("nombre")+" \n peso  "+getIntent().getStringExtra("peso")+
                " \n Estatura  "+getIntent().getStringExtra("estarura")+"\n  RECOMENDACION : \n" +" ►Elige alimentos con poca grasa \n"+
                " ► Reduce en consumo de azúcar y alimentos y bebidas azucaradas. \n"+
                "► Disminuye el consumo de carnes rojas y sustitúyalo por pescados.\n" +
                "► Consume verduras y hortalizas en abundancia.\n" +
                "► Recuerda tomar 3 o 4 piezas de fruta al día.\n" +
                "►  Bebe abundante agua. Al menos 1 litro y medio al día.");


    }
}
