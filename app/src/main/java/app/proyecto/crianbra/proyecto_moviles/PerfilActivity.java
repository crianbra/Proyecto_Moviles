package app.proyecto.crianbra.proyecto_moviles;

import android.content.Intent;
import android.graphics.Typeface;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.crianbra.proyecto_moviles.R;

import org.json.JSONArray;
import org.json.JSONException;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.io.UnsupportedEncodingException;
import java.net.URL;

import javax.net.ssl.HttpsURLConnection;

public class PerfilActivity extends AppCompatActivity {

    EditText nombre, colegio, ciudad, mail, edad, id;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_perfil);

        String carpetaFuente = "fonts/galette-med.otf";
        Typeface fuente = Typeface.createFromAsset(getAssets(), carpetaFuente);

        nombre = (EditText)findViewById(R.id.nombre);
        colegio = (EditText)findViewById(R.id.colegio);
        ciudad = (EditText)findViewById(R.id.ciudad);
        mail = (EditText)findViewById(R.id.mail);
        edad = (EditText)findViewById(R.id.edad);
        id = (EditText)findViewById(R.id.id);

        nombre.setTypeface(fuente);
        colegio.setTypeface(fuente);
        ciudad.setTypeface(fuente);
        mail.setTypeface(fuente);
        edad.setTypeface(fuente);
        id.setTypeface(fuente);

        nombre.setText((String)getIntent().getExtras().get("name"));
        mail.setText((String)getIntent().getExtras().get("email"));
        id.setText((String)getIntent().getExtras().get("id"));
        //ciudad.setText((String)getIntent().getExtras().get("location"));

        final Button guardar = (Button) findViewById(R.id.btn_guardar);
        guardar.setTypeface(fuente);
        guardar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new CargarDatos().execute("https://educaapp.000webhostapp.com/sw/registro.php?nombre="+nombre.getText().toString()+"&colegio="+colegio.getText().toString()+"&ciudad="+ciudad.getText().toString()+"&mail="+mail.getText().toString()+"&edad="+edad.getText().toString()+"&idfacebook="+id.getText().toString());

            }
        });

        final Button cargar = (Button) findViewById(R.id.btn_cargar);
        cargar.setTypeface(fuente);
        cargar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new ConsultarDatos().execute("https://educaapp.000webhostapp.com/sw/consulta.php?idfacebook="+id.getText().toString());
            }
        });

        final Button salir = (Button) findViewById(R.id.btn_salir);
        salir.setTypeface(fuente);
        salir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(PerfilActivity.this, CursosActivity.class);
                startActivity(intent);
            }
        });

        final Button actualizar = (Button) findViewById(R.id.btn_actualizar);
        actualizar.setTypeface(fuente);
        actualizar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

    }

    private class CargarDatos extends AsyncTask<String, Void, String> {

        @Override
        protected String doInBackground(String... urls) {

            try {
                return downloadUrl(urls[0]);

            }
            catch(IOException e) {
                return "Unable";
            }
        }

        protected void onPostExecute(String result) {

            Toast.makeText(getApplicationContext(), "Se almacenaron los datos correctamente", Toast.LENGTH_SHORT).show();
        }

    }


    private class ConsultarDatos extends AsyncTask<String, Void, String> {

        @Override
        protected String doInBackground(String... urls) {

            try {
                return downloadUrl(urls[0]);

            }
            catch(IOException e) {
                return "Unable";
            }
        }

        protected void onPostExecute(String result) {
            JSONArray ja = null;
            try{
                ja = new JSONArray(result);
                nombre.setText(ja.getString(1));
                colegio.setText(ja.getString(2));
                ciudad.setText(ja.getString(3));
                mail.setText(ja.getString(4));
                edad.setText(ja.getString(5));
                id.setText(ja.getString(6));

            }catch (JSONException e){
                e.printStackTrace();
            }



        }

    }


    private String downloadUrl(String myurl) throws IOException {
        Log.i("URL", ""+myurl);
        myurl = myurl.replace(" ", "%20");
        InputStream stream = null;
        //HttpsURLConnection connection = null;
        //String result = null;

        int len=500;
        try {
            URL url1 = new URL(myurl);
            HttpsURLConnection connection = (HttpsURLConnection) url1.openConnection();
            // Timeout for reading InputStream arbitrarily set to 3000ms.
            connection.setReadTimeout(1000);
            // Timeout for connection.connect() arbitrarily set to 3000ms.
            connection.setConnectTimeout(1000);
            // For this use case, set HTTP method to GET.
            connection.setRequestMethod("GET");
            // Already true by default but setting just in case; needs to be true since this request
            // is carrying an input (response) body.
            connection.setDoInput(true);
            // Open communications link (network traffic occurs here).
            connection.connect();
            //publishProgress(DownloadCallback.Progress.CONNECT_SUCCESS);
            int responseCode = connection.getResponseCode();
            Log.d("respuesta", "The response is : "+responseCode);
            //if (responseCode != HttpsURLConnection.HTTP_OK) {
            //    throw new IOException("HTTP error code: " + responseCode);
            //}
            // Retrieve the response body as an InputStream.
            stream = connection.getInputStream();
            String contentAsString = readStream(stream,len);
            return contentAsString;

        } finally {
            // Close Stream and disconnect HTTPS connection.
            if (stream != null) {
                stream.close();
            }

        }

    }

    public String readStream(InputStream stream, int maxReadSize)
            throws IOException, UnsupportedEncodingException {
        Reader reader = null;
        reader = new InputStreamReader(stream, "UTF-8");
        char[] rawBuffer = new char[maxReadSize];
        int readSize;
        StringBuffer buffer = new StringBuffer();
        while (((readSize = reader.read(rawBuffer)) != -1) && maxReadSize > 0) {
            if (readSize > maxReadSize) {
                readSize = maxReadSize;
            }
            buffer.append(rawBuffer, 0, readSize);
            maxReadSize -= readSize;
        }
        return buffer.toString();
    }



}
