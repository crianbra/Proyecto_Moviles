package app.proyecto.crianbra.proyecto_moviles;

import android.content.Intent;
import android.graphics.Typeface;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.crianbra.proyecto_moviles.R;

public class EntidadesActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_entidades);

        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);

        String carpetaFuente = "fonts/galette-med.otf";
        Typeface fuenteCursos = Typeface.createFromAsset(getAssets(), carpetaFuente);

        final Button buttonCelc = (Button) findViewById(R.id.btn_celc);
        buttonCelc.setTypeface(fuenteCursos);
        buttonCelc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent05 = new Intent(EntidadesActivity.this, CelcActivity.class);
                startActivity(intent05);
            }
        });

        final Button buttonAsiri= (Button) findViewById(R.id.btn_asiri);
        buttonAsiri.setTypeface(fuenteCursos);
        buttonAsiri.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent05 = new Intent(EntidadesActivity.this, AsiriActivity.class);
                startActivity(intent05);
            }
        });

        final Button buttonICPOL = (Button) findViewById(R.id.btn_icpol);
        buttonICPOL.setTypeface(fuenteCursos);
        buttonICPOL.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent05 = new Intent(EntidadesActivity.this, IcpolActivity.class);
                startActivity(intent05);
            }
        });


    }
}
