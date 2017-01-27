package com.example.sofilop.ejecrcio2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class BajoPeso extends AppCompatActivity {
    TextView resp;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bajo_peso);


        Persona pe=new Persona();
        resp=(TextView)findViewById(R.id.txtResultado);
        resp.setText("Estatus : Lo siento pero usted esta por de bajo de su peso normal \n "+
        "Name : "+getIntent().getStringExtra("nombre")+"\n Peso : "+getIntent().getStringExtra("peso")+"\n Estatura: "+getIntent().getStringExtra("estatura")+
        "\n*** RECOMENDACIONES*** \n"+
        "¶ Procura comer suficiente. Para ganar medio kg de masa muscular efectivamente cada semana se necesita aumentar la ingesta de alimentos diariamente. \n"+
        "\n ¶ Mejora la distribución de las proteínas. Incluir siempre algo de proteínas en cada comida"+
                "\n ¶ Conviene que las grasas sean de buena calidad para que la dieta sea lo más saludable posible: aceite de oliva, aceitunas, frutos secos, aguacate, pescado azul, etc.");
    }
}
