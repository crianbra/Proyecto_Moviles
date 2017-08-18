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
import android.widget.Toast;

import com.example.crianbra.proyecto_moviles.R;
import com.facebook.CallbackManager;
import com.facebook.FacebookCallback;
import com.facebook.FacebookException;
import com.facebook.login.LoginResult;
import com.facebook.login.widget.LoginButton;


public class MainActivity extends AppCompatActivity
implements NavigationView.OnNavigationItemSelectedListener{

    String tag = "Lifecycle";

    private LoginButton loginButton;
    private CallbackManager callbackManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d("mensaje", "creando");
        setContentView(R.layout.activity_main);

        String carpetaFuente = "fonts/galette-med.otf";
        Typeface fuente = Typeface.createFromAsset(getAssets(), carpetaFuente);

        final Button buttonLogin = (Button) findViewById(R.id.btn_inicio);
        buttonLogin.setTypeface(fuente);
        buttonLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d (tag,"Si llamo a la funcion");
                Intent intent01 = new Intent(MainActivity.this, LoginActivity.class);
                startActivity(intent01);
            }
        });

        final Button buttonRegistro = (Button) findViewById(R.id.btn_registro);
        buttonRegistro.setTypeface(fuente);
        buttonRegistro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d (tag,"Si llamo a la funcion");
                Intent intent02 = new Intent(MainActivity.this, RegistroActivity.class);
                startActivity(intent02);
            }
        });


        callbackManager = CallbackManager.Factory.create();

        loginButton = (LoginButton)findViewById(R.id.loginButton);
        loginButton.registerCallback(callbackManager, new FacebookCallback<LoginResult>() {
            @Override
            public void onSuccess(LoginResult loginResult) {
                // Toast.makeText(getApplicationContext(), "Exito", Toast.LENGTH_SHORT).show();
                // System.out.print("INicio con exito");

                goMainScreen();
            }

            @Override
            public void onCancel() {
                Toast.makeText(getApplicationContext(), R.string.cancel_login, Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onError(FacebookException error) {
                Toast.makeText(getApplicationContext(), R.string.error_login, Toast.LENGTH_SHORT).show();
            }
        });

    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        return false;
    }


    private void goMainScreen() {
        Intent intent = new Intent(this, CursosActivity.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(intent);

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        callbackManager.onActivityResult(requestCode, resultCode, data);
    }

}
