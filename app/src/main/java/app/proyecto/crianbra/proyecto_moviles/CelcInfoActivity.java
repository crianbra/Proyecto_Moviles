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
import android.widget.TextView;
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

public class CelcInfoActivity extends AppCompatActivity {

    EditText nombre, correo, asunto, mensaje;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_celc_info);

        String carpetaFuente = "fonts/galette-med.otf";
        Typeface fuente = Typeface.createFromAsset(getAssets(), carpetaFuente);

        TextView celc = (TextView)findViewById(R.id.celc);
        TextView texto_celc = (TextView)findViewById(R.id.texto_cel);
        TextView texto_info = (TextView)findViewById(R.id.texto_info);
        nombre = (EditText) findViewById(R.id.txt_nombre);
        correo = (EditText) findViewById(R.id.txt_correo);
        asunto = (EditText) findViewById(R.id.txt_curso);
        mensaje = (EditText) findViewById(R.id.mensaje);

        celc.setTypeface(fuente);
        texto_celc.setTypeface(fuente);
        texto_info.setTypeface(fuente);
        nombre.setTypeface(fuente);
        correo.setTypeface(fuente);
        asunto.setTypeface(fuente);
        mensaje.setTypeface(fuente);

        nombre.setText((String)getIntent().getExtras().get("name"));
        correo.setText((String)getIntent().getExtras().get("email"));
        asunto.setText((String)getIntent().getExtras().get("curso"));

        final Button enviar = (Button) findViewById(R.id.btn_enviar);
        enviar.setTypeface(fuente);
        enviar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new CargarDatos1().execute("https://educaapp.000webhostapp.com/sw/info.php?nombre="+nombre.getText().toString()+"&correo="+correo.getText().toString()+"&asunto="+asunto.getText().toString()+"&mensaje="+mensaje.getText().toString());

            }
        });




    }

    private class CargarDatos1 extends AsyncTask<String, Void, String> {

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

            Toast.makeText(getApplicationContext(), "Se envio su mensaje correctamente", Toast.LENGTH_SHORT).show();
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
