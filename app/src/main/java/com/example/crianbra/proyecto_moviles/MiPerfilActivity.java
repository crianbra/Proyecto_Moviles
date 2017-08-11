package com.example.crianbra.proyecto_moviles;

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


        image = (ImageView)findViewById(R.id.imagePerfil);
        Button boton = (Button)findViewById(R.id.btn_foto);
        boton.setTypeface(fuentePerfil);

        boton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final CharSequence[] options = {"Elegir de Galeria", "Cancelar"};
                final AlertDialog.Builder builder = new AlertDialog.Builder(MiPerfilActivity.this);
                builder.setTitle("Elige una opcion");
                builder.setItems(options, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int seleccion) {
                        if (options[seleccion] == "Elegir de Galeria"){
                            Intent intent = new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
                            intent.setType("image/*");
                            startActivityForResult(intent.createChooser(intent, "Selecciona app de imagen"), SELECT_PICTURE);
                        }else if (options[seleccion] == "Cancelar"){
                            dialog.dismiss();
                        }
                    }
                });
                builder.show();

            }
        });

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

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data){
        super.onActivityResult(requestCode, resultCode, data);

        switch (requestCode){

            case SELECT_PICTURE:
                if(resultCode == RESULT_OK){
                    Uri path = data.getData();
                    image.setImageURI(path);
                }
                break;
        }
    }

    private void decodeBitmap(String dir) {
        Bitmap bitmap;
        bitmap = BitmapFactory.decodeFile(dir);

        image.setImageBitmap(bitmap);

    }
}
