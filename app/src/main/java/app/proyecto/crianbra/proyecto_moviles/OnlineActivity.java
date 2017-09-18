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
        Typeface fuenteCursos = Typeface.createFromAsset(getAssets(), carpetaFuente);

        final Button buttonMatematica = (Button) findViewById(R.id.btn_matematicas);
        buttonMatematica.setTypeface(fuenteCursos);
        buttonMatematica.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent05 = new Intent(OnlineActivity.this, MatematicaActivity.class);
                startActivity(intent05);
            }
        });
    }
}
