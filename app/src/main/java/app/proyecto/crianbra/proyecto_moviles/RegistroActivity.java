package app.proyecto.crianbra.proyecto_moviles;

import android.content.Intent;
import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.crianbra.proyecto_moviles.R;

public class RegistroActivity extends AppCompatActivity {
    String tag = "Lifecycle";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro);

        Log.d("mensaje", "creando");

        String carpetaFuente = "fonts/galette-med.otf";

        TextView txt_nombre = (TextView)findViewById(R.id.txt_nombre_registro);
        TextView txt_colegio = (TextView)findViewById(R.id.txt_colegio_registro);
        TextView txt_ciudad = (TextView)findViewById(R.id.txt_dire_registro);
        TextView txt_mail = (TextView)findViewById(R.id.txt_mail_registro);
        TextView txt_pass = (TextView)findViewById(R.id.txt_contraseña_registro);
        TextView txt_pass1 = (TextView)findViewById(R.id.txt_conf_contrasenia_registro);

        Typeface fuenteRegistro = Typeface.createFromAsset(getAssets(), carpetaFuente);
        txt_nombre.setTypeface(fuenteRegistro);
        txt_colegio.setTypeface(fuenteRegistro);
        txt_ciudad.setTypeface(fuenteRegistro);
        txt_mail.setTypeface(fuenteRegistro);
        txt_pass.setTypeface(fuenteRegistro);
        txt_pass1.setTypeface(fuenteRegistro);

        final Button buttonLogin = (Button) findViewById(R.id.btn_registar);
        buttonLogin.setTypeface(fuenteRegistro);
        buttonLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d (tag,"Si llamo a la funcion");
                Intent intent04 = new Intent(RegistroActivity.this, CursosActivity.class);
                startActivity(intent04);
            }
        });
    }
}
