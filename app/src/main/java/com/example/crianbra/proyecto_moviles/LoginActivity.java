package com.example.crianbra.proyecto_moviles;

import android.content.Intent;
import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

public class LoginActivity extends AppCompatActivity {

    String tag = "Lifecycle";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        String carpetaFuente = "fonts/galette-med.otf";

        final TextView txt_user = (TextView)findViewById(R.id.text_user);
        Typeface fuenteLogin = Typeface.createFromAsset(getAssets(), carpetaFuente);
        txt_user.setTypeface(fuenteLogin);

        final TextView txt_pass = (TextView)findViewById(R.id.txt_pass);
        txt_pass.setTypeface(fuenteLogin);


        final Button buttonLogin = (Button) findViewById(R.id.btn_ingreso);
        buttonLogin.setTypeface(fuenteLogin);
        buttonLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String nombre = txt_user.getText().toString();
                String contraseña = txt_pass.getText().toString();

                if(validarString(nombre) && validarString(contraseña)){

                }else {
                    Toast.makeText(getApplicationContext(),"Datos Incorrectos", Toast.LENGTH_SHORT).show();
                }

                Log.d (tag,"Si llamo a la funcion");
                Intent intent03 = new Intent(LoginActivity.this, CursosActivity.class);
                startActivity(intent03);
            }
        });


    }


    //<editor-fold desc="Menu">
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        return super.onOptionsItemSelected(item);
    }
    //</editor-fold>


    Boolean validarString(String texto){
        return texto!=null && texto.trim().length()>0;
    }

}
