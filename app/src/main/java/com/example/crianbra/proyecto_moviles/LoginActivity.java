package com.example.crianbra.proyecto_moviles;

import android.content.Intent;
import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import org.w3c.dom.Text;

public class LoginActivity extends AppCompatActivity {

    String tag = "Lifecycle";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        String carpetaFuente = "fonts/galette-med.otf";

        TextView txt_user = (TextView)findViewById(R.id.text_user);
        Typeface fuenteLogin = Typeface.createFromAsset(getAssets(), carpetaFuente);
        txt_user.setTypeface(fuenteLogin);

        TextView txt_pass = (TextView)findViewById(R.id.txt_pass);
        txt_pass.setTypeface(fuenteLogin);


        final Button buttonLogin = (Button) findViewById(R.id.btn_ingreso);
        buttonLogin.setTypeface(fuenteLogin);
        buttonLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d (tag,"Si llamo a la funcion");
                Intent intent03 = new Intent(LoginActivity.this, CursosActivity.class);
                startActivity(intent03);
            }
        });


    }
}
