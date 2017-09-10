package app.proyecto.crianbra.proyecto_moviles;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Typeface;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.crianbra.proyecto_moviles.R;
import com.facebook.appevents.AppEventsLogger;
import com.facebook.login.LoginManager;
import com.squareup.picasso.Picasso;

import org.json.JSONObject;

public class CursosActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener ,
        MicursosFragment.OnFragmentInteractionListener, MiPerfilFragment.OnFragmentInteractionListener{

    NavigationView navigation_view;
    String jsondata;
    int LOGED=0;


    String tag = "Lifecycle";

    JSONObject response, profile_pic_data, profile_pic_url;
    ///// response: objeto JSON  contine toda la informacion basica del usuaria.
    //// profile_pic_data: Objeto JSON que contendra toda la informacion relevante a la foto del usuario, url dimensiones
    //// profile_pic_url: Objeto JSON que contendra la url del usuario extraida de profile_pic_data

    TextView user_name, user_email;
    //user_email: Variable para asignar el correo de que se obtiene  del Objeto JSON
    //user_name : Variable para asignar el nombre del usuario que se obtiene del Objeto JSON

    ImageView user_picture ,user_picture_perfil ;
    ///user_picture: variable en donde se mostrara la foto del usuario

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cursos);

        String carpetaFuente = "fonts/galette-med.otf";
        Typeface fuenteCursos = Typeface.createFromAsset(getAssets(), carpetaFuente);

        Intent intent = getIntent();//obtine el intent que viene desde la clase MainActivity
        LOGED = intent.getIntExtra("loged",LOGED);

        if(LOGED == 1){
            jsondata = intent.getStringExtra("jsondata");//// en caso de q recein se inicio sesion
            SavePerfil(jsondata);//llama a metodo donde se guarda en preferencias la informacion del usuario
        }else {///En caso de que ya haya iniciado session en otra ocacion y solo este abriendo la app
            jsondata= LoadPerfil(); ///Metodo que carga la información  del usuario desde preferencias
        }

        setNavigationHeader();
        setUserProfile(jsondata);//// se envia el Json para cargar la foto, nombre , id y correo


        
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        //NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigation_view.setNavigationItemSelectedListener(this);


        final Button buttonMatematica = (Button) findViewById(R.id.btn_curso_matematicas);
        buttonMatematica.setTypeface(fuenteCursos);
        buttonMatematica.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d (tag,"Si llamo a la funcion");
                Intent intent05 = new Intent(CursosActivity.this, MatematicaActivity.class);
                startActivity(intent05);
            }
        });

        final Button buttonCelc = (Button) findViewById(R.id.btn_celc);
        buttonCelc.setTypeface(fuenteCursos);
        buttonCelc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d (tag,"Si llamo a la funcion");
                Intent intent06 = new Intent(CursosActivity.this, CelcActivity.class);
                startActivity(intent06);
            }
        });

        final Button buttonAsiri = (Button) findViewById(R.id.btn_asiri);
        buttonAsiri.setTypeface(fuenteCursos);
        buttonAsiri.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d (tag,"Si llamo a la funcion");
                Intent intent07 = new Intent(CursosActivity.this, AsiriActivity.class);
                startActivity(intent07);
            }
        });

        final Button buttonIcpol= (Button) findViewById(R.id.btn_icpol);
        buttonIcpol.setTypeface(fuenteCursos);
        buttonIcpol.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d (tag,"Si llamo a la funcion");
                Intent intent08 = new Intent(CursosActivity.this, IcpolActivity.class);
                startActivity(intent08);
            }
        });
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }


    public void setNavigationHeader(){

        navigation_view = (NavigationView) findViewById(R.id.nav_view);

        View header = LayoutInflater.from(this).inflate(R.layout.nav_header_cursos, null);
        navigation_view.addHeaderView(header);

        user_name = (TextView) header.findViewById(R.id.username);
        user_picture = (ImageView) header.findViewById(R.id.profile_pic);
        user_email = (TextView) header.findViewById(R.id.email);


    }

    /*public  void  setUserProfile_perfil (String jsondata){

        try {
            response = new JSONObject(jsondata);

            profile_pic_data = new JSONObject(response.get("picture").toString());
            profile_pic_url = new JSONObject(profile_pic_data.getString("data"));


            Picasso.with(this).load(profile_pic_url.getString("url"))
                    .into(user_picture_perfil);
        } catch (Exception e){
            e.printStackTrace();
        }
    }*/


  /*
       Obtener la informacion de perfild e usuario
para la cabecera del menu

     */


    public  void  setUserProfile(String jsondata){

        try {
            response = new JSONObject(jsondata);

            user_email.setText(response.get("email").toString());
            user_name.setText(response.get("name").toString());

            profile_pic_data = new JSONObject(response.get("picture").toString());
            profile_pic_url = new JSONObject(profile_pic_data.getString("data"));

            Picasso.with(this).load(profile_pic_url.getString("url"))
                    .into(user_picture);


        } catch (Exception e){
            e.printStackTrace();
        }
    }


    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        Fragment fragment = null;
        Boolean fragmentoSeleccionado = false;

        /*String carpetaFuente = "fonts/galette-med.otf";
        Typeface fuenteCursos1 = Typeface.createFromAsset(getAssets(), carpetaFuente);
        NavigationMenuItemView perfil = (NavigationMenuItemView) findViewById(R.id.nav_camera);
        perfil.setTypeface(fuenteCursos1);*/

        if (id == R.id.nav_camera) {

            fragment = new MiPerfilFragment();
            fragmentoSeleccionado = true;
            //setTitle("Mi Perfil");

        } else if (id == R.id.nav_gallery) {
            Intent i = new Intent(CursosActivity.this, CursosActivity.class);
            startActivity(i);
            //setTitle("Mis Cursos");

        } else if (id == R.id.nav_send) {

            logout();
        }

        if (fragmentoSeleccionado){
            getSupportFragmentManager().beginTransaction().replace(R.id.Contenedor, fragment).addToBackStack("xxx").commit();

            item.setChecked(true);
            getSupportActionBar().setTitle(item.getTitle());


        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    @Override
    public void onFragmentInteraction(Uri uri) {

    }


    @Override
    protected void onResume() {
        super.onResume();
        // Logs 'install' and 'app activate' App Events.
        AppEventsLogger.activateApp(this);
    }

    @Override
    protected void onPause() {
        super.onPause();

        // Logs 'app deactivate' App Event.
        AppEventsLogger.deactivateApp(this);
    }

    public void logout() {
        LoginManager.getInstance().logOut();
        SavePerfil("");
        goLoginScreen();
    }
    /// regresar a la pantalla de inicio de sesion
    private void goLoginScreen() {
        Intent intent = new Intent(this, MainActivity.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(intent);
    }

    /** Guarda la informacion del perfil*/
    public  void SavePerfil(String data){

        SharedPreferences Preferens = getSharedPreferences("Load_Profile", Context.MODE_PRIVATE);
        SharedPreferences.Editor  editor = Preferens.edit();
        editor.putString("JSON",data);
        editor.commit();
        Log.d("JSON","Guardo ");

    }

    public String LoadPerfil(){

        SharedPreferences Preferens = getSharedPreferences("Load_Profile", Context.MODE_PRIVATE);
        //  IsLoged= Preferens.getBoolean("IsLog",false);
        String data =Preferens.getString("JSON","");
        // Log.d("JSON",""+IsLoged);
        Log.d("JSON",""+data);
        return  data;

    }
}
