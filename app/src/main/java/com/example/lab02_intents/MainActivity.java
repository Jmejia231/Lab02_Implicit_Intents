package com.example.lab02_intents;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    public static int CAMERA_PIC_REQUEST = 1;
    Bitmap bitmap;
    ImageView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final EditText Nombre = (EditText)findViewById(R.id.txt_Nombre);
        final EditText Posicion = (EditText)findViewById(R.id.txt_Posicion);
        final EditText Altura = (EditText)findViewById(R.id.txt_Altura);
        final EditText Peso = (EditText)findViewById(R.id.txt_Peso);
        final EditText Equipo = (EditText)findViewById(R.id.txt_Equipo);
        final EditText Fecha = (EditText)findViewById(R.id.txt_Fecha);
        final EditText Edad = (EditText)findViewById(R.id.txt_Edad);
        imageView = (ImageView)findViewById(R.id.iv_Picture);


        Button btn_Registrar = (Button)findViewById(R.id.btn_Registrar);
        btn_Registrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent resultadoIntent = new Intent(getApplicationContext(),Resultado.class);

                resultadoIntent.putExtra("Nombre",Nombre.getText().toString());
                resultadoIntent.putExtra("Posicion",Posicion.getText().toString());
                resultadoIntent.putExtra("Altura",Altura.getText().toString());
                resultadoIntent.putExtra("Peso",Peso.getText().toString());
                resultadoIntent.putExtra("Equipo",Equipo.getText().toString());
                resultadoIntent.putExtra("Fecha",Fecha.getText().toString());
                resultadoIntent.putExtra("Edad",Edad.getText().toString());
                resultadoIntent.putExtra("Imagen", bitmap);
                startActivity(resultadoIntent);
            }
        });

        Button btn_Foto = (Button)findViewById(R.id.btn_Foto);
        btn_Foto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent cameraIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                startActivityForResult(cameraIntent,CAMERA_PIC_REQUEST);
            }
        });

    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data){
        super.onActivityResult(requestCode,resultCode,data);
        if(requestCode == CAMERA_PIC_REQUEST){
            if(resultCode == RESULT_OK){
                bitmap = (Bitmap)data.getExtras().get("data");
                imageView.setImageBitmap(bitmap);
            }
        }
    }
}