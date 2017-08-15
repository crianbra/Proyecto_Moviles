package app.proyecto.crianbra.proyecto_moviles;

import android.content.Intent;
import android.graphics.Typeface;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;


public class MainActivity extends AppCompatActivity
implements NavigationView.OnNavigationItemSelectedListener{

    String tag = "Lifecycle";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d("mensaje", "creando");
        setContentView(app.example.crianbra.proyecto_moviles.R.layout.activity_main);

        String carpetaFuente = "fonts/galette-med.otf";
        Typeface fuente = Typeface.createFromAsset(getAssets(), carpetaFuente);

        final Button buttonLogin = (Button) findViewById(app.example.crianbra.proyecto_moviles.R.id.btn_inicio);
        buttonLogin.setTypeface(fuente);
        buttonLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d (tag,"Si llamo a la funcion");
                Intent intent01 = new Intent(MainActivity.this, LoginActivity.class);
                startActivity(intent01);
            }
        });

        final Button buttonRegistro = (Button) findViewById(app.example.crianbra.proyecto_moviles.R.id.btn_registro);
        buttonRegistro.setTypeface(fuente);
        buttonRegistro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d (tag,"Si llamo a la funcion");
                Intent intent02 = new Intent(MainActivity.this, RegistroActivity.class);
                startActivity(intent02);
            }
        });

    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        return false;
    }



}
