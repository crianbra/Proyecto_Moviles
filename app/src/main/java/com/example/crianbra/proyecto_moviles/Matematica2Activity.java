package com.example.crianbra.proyecto_moviles;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class Matematica2Activity extends AppCompatActivity {

    String tag = "Lifecycle";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_matematica2);

        final Button buttonMatematica2 = (Button) findViewById(R.id.btn_felicidades_matematicas);
        buttonMatematica2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d (tag,"Si llamo a la funcion");
                Intent intent05 = new Intent(Matematica2Activity.this, CursosActivity.class);
                startActivity(intent05);
                Toast.makeText(getApplicationContext(),"Has aprobado con éxito el curso.",Toast.LENGTH_SHORT).show();
            }
        });
    }
}
