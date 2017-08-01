package com.example.crianbra.proyecto_moviles;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.widget.Button;

public class CursosActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener , PerfilFragment.OnFragmentInteractionListener,
        MicursosFragment.OnFragmentInteractionListener{

    String tag = "Lifecycle";

    Activity activity = null;
    Boolean activitySeleccionado = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cursos);
        
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);


        final Button buttonMatematica = (Button) findViewById(R.id.btn_curso_matematicas);
        buttonMatematica.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d (tag,"Si llamo a la funcion");
                Intent intent05 = new Intent(CursosActivity.this, MatematicaActivity.class);
                startActivity(intent05);
            }
        });

        final Button buttonFisica = (Button) findViewById(R.id.btn_curso_fisica);
        buttonFisica.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d (tag,"Si llamo a la funcion");
                Intent intent06 = new Intent(CursosActivity.this, FisicaActivity.class);
                startActivity(intent06);
            }
        });

        final Button buttonAlgebra = (Button) findViewById(R.id.btn_curso_algebra);
        buttonAlgebra.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d (tag,"Si llamo a la funcion");
                Intent intent07 = new Intent(CursosActivity.this, AlgebraActivity.class);
                startActivity(intent07);
            }
        });

        final Button buttonEstadistica= (Button) findViewById(R.id.btn_curso_estadistica);
        buttonEstadistica.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d (tag,"Si llamo a la funcion");
                Intent intent08 = new Intent(CursosActivity.this, EstadisticaActivity.class);
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


    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        Fragment fragment = null;
        Boolean fragmentoSeleccionado = false;


        if (id == R.id.nav_camera) {
            fragment = new PerfilFragment();
            fragmentoSeleccionado = true;

        } else if (id == R.id.nav_gallery) {
            fragment = new MicursosFragment();
            fragmentoSeleccionado = true;

        } else if (id == R.id.nav_send) {

            Intent intent010 = new Intent(Intent.ACTION_MAIN);
            intent010.addCategory(Intent.CATEGORY_HOME);
            intent010.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            startActivity(intent010);
            //finish();
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
}
