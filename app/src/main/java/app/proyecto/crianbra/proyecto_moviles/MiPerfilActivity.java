package app.proyecto.crianbra.proyecto_moviles;

import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Typeface;
import android.net.Uri;
import android.provider.MediaStore;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.crianbra.proyecto_moviles.R;

public class MiPerfilActivity extends AppCompatActivity {

    private String APP_DIRECTORY = "myPictureApp/";
    private String MEDIA_DIRECTORY = APP_DIRECTORY + "media";
    private String TEMPORAL_PICTURE_NAME = "temporal.jpg";

    private final int PHOTO_CODE = 100;
    private final int SELECT_PICTURE = 200;

    private ImageView image;
    String tag = "Lifecycle";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mi_perfil);

        String carpetaFuente = "fonts/galette-med.otf";
        Typeface fuentePerfil = Typeface.createFromAsset(getAssets(), carpetaFuente);

        TextView nombre_perfil = (TextView) findViewById(R.id.txt_nombre_perfil);
        TextView colegio_perfil = (TextView) findViewById(R.id.txt_colegio_perfil);
        TextView ciudad_perfil = (TextView) findViewById(R.id.txt_dire_perfil);
        TextView mail_perfil = (TextView) findViewById(R.id.txt_mail_perfil);
        TextView contrasenia_perfil = (TextView) findViewById(R.id.txt_contraseña_perfil);
        TextView contrasenia_conf_perfil = (TextView) findViewById(R.id.txt_conf_contrasenia_perfil);
        Button btn_guardar = (Button)findViewById(R.id.btn_guardar);
        Button btn_cancelar = (Button)findViewById(R.id.btn_cancelar);

        nombre_perfil.setTypeface(fuentePerfil);
        colegio_perfil.setTypeface(fuentePerfil);
        ciudad_perfil.setTypeface(fuentePerfil);
        mail_perfil.setTypeface(fuentePerfil);
        contrasenia_perfil.setTypeface(fuentePerfil);
        contrasenia_conf_perfil.setTypeface(fuentePerfil);
        btn_guardar.setTypeface(fuentePerfil);
        btn_cancelar.setTypeface(fuentePerfil);


        final Button buttonGuardar = (Button) findViewById(R.id.btn_guardar);
        buttonGuardar.setTypeface(fuentePerfil);
        buttonGuardar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d (tag,"Si llamo a la funcion");
                Toast.makeText(getApplicationContext(), "Se Guardo correctamente", Toast.LENGTH_SHORT).show();
                Intent intent05 = new Intent(MiPerfilActivity.this, CursosActivity.class);
                startActivity(intent05);
            }
        });

        final Button buttonCancelar = (Button) findViewById(R.id.btn_cancelar);
        buttonCancelar.setTypeface(fuentePerfil);
        buttonCancelar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d (tag,"Si llamo a la funcion");
                Toast.makeText(getApplicationContext(), "Se Cancelo correctamente", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(MiPerfilActivity.this, CursosActivity.class);
                startActivity(intent);
            }
        });
    }


}
