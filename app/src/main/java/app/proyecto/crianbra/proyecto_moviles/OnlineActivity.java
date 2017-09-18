package app.proyecto.crianbra.proyecto_moviles;

import android.content.Intent;
import android.graphics.Typeface;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.example.crianbra.proyecto_moviles.R;

public class OnlineActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_online);

        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);

        String carpetaFuente = "fonts/galette-med.otf";
        Typeface fuente = Typeface.createFromAsset(getAssets(), carpetaFuente);

        final Button buttonMatematica = (Button) findViewById(R.id.btn_matematicas);
        buttonMatematica.setTypeface(fuente);
        buttonMatematica.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent05 = new Intent(OnlineActivity.this, MatematicaActivity.class);
                startActivity(intent05);
            }
        });

        final Button btnAlgebra = (Button) findViewById(R.id.btn_algebra);
        btnAlgebra.setTypeface(fuente);
        btnAlgebra.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent05 = new Intent(OnlineActivity.this, AsiriInfoActivity.class);
                startActivity(intent05);
            }
        });

        final Button btnEstadistica = (Button) findViewById(R.id.btn_estadistica);
        btnEstadistica.setTypeface(fuente);
        btnEstadistica.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent05 = new Intent(OnlineActivity.this, AsiriInfoActivity.class);
                startActivity(intent05);
            }
        });

        final Button btnCalculo = (Button) findViewById(R.id.btn_calculo);
        btnCalculo.setTypeface(fuente);
        btnCalculo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent05 = new Intent(OnlineActivity.this, AsiriInfoActivity.class);
                startActivity(intent05);
            }
        });

    }
}
