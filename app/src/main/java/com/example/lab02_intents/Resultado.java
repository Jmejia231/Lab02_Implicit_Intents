package com.example.lab02_intents;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.ImageView;

public class Resultado extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resultado);

        EditText et_Nombre = (EditText) findViewById(R.id.txt_NombreRes);
        String Nombre = getIntent().getStringExtra("Nombre");
        et_Nombre.setText(Nombre);

        EditText et_Posicion = (EditText) findViewById(R.id.txt_PosicionRes);
        String Posicion = getIntent().getStringExtra("Posicion");
        et_Posicion.setText(Posicion);

        EditText et_Altura = (EditText) findViewById(R.id.txt_AlturaRes);
        String Altura = getIntent().getStringExtra("Nombre");
        et_Altura.setText(Altura);

        EditText et_Peso = (EditText) findViewById(R.id.txt_PesoRes);
        String Peso = getIntent().getStringExtra("Peso");
        et_Peso.setText(Peso);

        EditText et_Equipo = (EditText) findViewById(R.id.txt_EquipoRes);
        String Equipo = getIntent().getStringExtra("Equipo");
        et_Equipo.setText(Equipo);

        EditText et_Fecha = (EditText) findViewById(R.id.txt_FechaRes);
        String Fecha = getIntent().getStringExtra("Fecha");
        et_Fecha.setText(Fecha);

        EditText et_Edad = (EditText) findViewById(R.id.txt_EdadRes);
        String Edad = getIntent().getStringExtra("Edad");
        et_Edad.setText(Edad);

        ImageView iv_foto = (ImageView)findViewById(R.id.iv_PictureRes);
        Bitmap imagen2 = (Bitmap)getIntent().getParcelableExtra("Imagen");
        iv_foto.setImageBitmap(imagen2);
    }
}