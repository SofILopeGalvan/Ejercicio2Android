package com.example.sofilop.ejecrcio2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Button;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity {
    EditText txtNombre, txtPeso, txtEstatura;
    CheckBox chEjercicio;
    RadioButton rdHombre, rdMujer;
    TextView txtResul;
    Button btnCalcular;
    Button btnBorrar;
    String status;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txtNombre=(EditText)findViewById(R.id.txtNombre);
        txtPeso=(EditText)findViewById(R.id.txtpeso);
        txtEstatura=(EditText)findViewById(R.id.txtEstatura);
        chEjercicio=(CheckBox) findViewById(R.id.chEjercicio);
        rdHombre=(RadioButton)findViewById(R.id.rdNombre);
        rdMujer=(RadioButton)findViewById(R.id.rdMujer);
        txtResul=(TextView)findViewById(R.id.txtResultado);
        btnCalcular=(Button)findViewById(R.id.btnCalcular);
        btnBorrar=(Button)findViewById(R.id.btnBorrar);
String nom;
btnCalcular.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
        Persona p = new Persona();

        Intent siguiente=new Intent().setClass(MainActivity.this,Respuesta.class);

        siguiente.putExtra("nombre", txtNombre.getText().toString());
        siguiente.putExtra("peso", txtPeso.getText().toString());
        siguiente.putExtra("estatura", txtEstatura.getText().toString());



        Intent sobrePeso=new Intent().setClass(MainActivity.this,SobrePeso.class);

        sobrePeso.putExtra("nombre", txtNombre.getText().toString());
        sobrePeso.putExtra("peso", txtPeso.getText().toString());
        sobrePeso.putExtra("estatura", txtEstatura.getText().toString());


        Intent bajoPeso=new Intent().setClass(MainActivity.this,BajoPeso.class);

        bajoPeso.putExtra("nombre", txtNombre.getText().toString());
        bajoPeso.putExtra("peso", txtPeso.getText().toString());
        bajoPeso.putExtra("estatura", txtEstatura.getText().toString());

        p.setNombre(txtNombre.getText().toString());
        p.setPeso(Double.parseDouble(txtPeso.getText().toString()));
        p.setEstatura(Double.parseDouble(txtEstatura.getText().toString()));
p.calcularImc();





        if (txtNombre.equals("")||txtPeso.equals("")|| txtEstatura.equals(""))
            Toast.makeText(getApplicationContext(),"No lleno los campos requeridos ",Toast.LENGTH_SHORT).show();
        else
        try {
            if(chEjercicio.isChecked()){
                p.setEjercicio((byte)1);
            }else{
                p.setEjercicio((byte)0);
            }
            if (rdHombre.isChecked()){
                p.setSexo('H');
                p.calcularImc();
                if (p.getImc()<20){
                    status="Falta de peso";
                    startActivity(bajoPeso);
                }
                if (p.getImc()>=20 && p.getImc()<=25){
                    status="Peso normal";
                    startActivity(siguiente);
                }
                if (p.getImc()>=26 && p.getImc()<=30){
                    status="Sobre peso";
                    startActivity(sobrePeso);
                }
                if (p.getImc()>=31 && p.getImc()<=40){
                    status="Obesidad";
                    startActivity(sobrePeso);
                }
                if (p.getImc()>40){
                    status="Fuerte obesidad";
                    startActivity(sobrePeso);
                }
            }else if (rdMujer.isChecked()){
                p.setSexo('M');
                p.calcularImc();
                if (p.getImc()<19){
                    status="Falta de peso";
                    startActivity(bajoPeso);
                }
                if (p.getImc()>=19 && p.getImc()<=24){
                    status="Peso normal";
                    startActivity(siguiente);
                }
                if (p.getImc()>=25 && p.getImc()<=30){
                    status="Sobre peso";
                    startActivity(sobrePeso);
                }
                if (p.getImc()>=31 && p.getImc()<=40){
                    status="Obesidad";
                    startActivity(sobrePeso);
                }
                if (p.getImc()>40){
                    status="Fuerte obesidad";
                    startActivity(sobrePeso);
                }
            }

            txtResul.setText(p.toString()+"\nTu estado de peso es: "+status);



        }catch (Exception e){
            Toast.makeText(getApplicationContext(),"No lleno los campos requeridos ",Toast.LENGTH_SHORT).show();

        }
    }
});
        btnBorrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                txtNombre.setText("");
                txtPeso.setText("");
                txtEstatura.setText("");
                chEjercicio.setChecked(false);
                rdHombre.setChecked(false);
                rdMujer.setChecked(false);
                txtResul.setText("");

            }
        });
    }
}
