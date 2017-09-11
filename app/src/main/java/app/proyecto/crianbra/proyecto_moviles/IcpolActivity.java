package app.proyecto.crianbra.proyecto_moviles;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import com.example.crianbra.proyecto_moviles.R;


public class IcpolActivity extends Activity {

    private String cursosCelc[]=new String[]{"Cálculo de una Variable","Cálculo de Varias Variables","Física 1",
            "Física 2","Estadística", "Ecuaciones Diferenciales", "Analisis Numerico"};

    private String descripcion[]=new String[]{"Sábado 9 y Domingo 10 de 8:00am a 13:00pm","Sábado 9 y Domingo 10 de 14:00pm a 19:00pm",
            "Sábado 9 y Domingo 10 de 14:00pm a 19:00pm","Sábado 9 y Domingo 10 de 13:00pm a 18:00pm",
            "Sábado 9 y Domingo 10 de 8:00am a 13:00pm", "Sábado 9 y Domingo 10 de 13:00pm a 18:00pm", "Sábado 9 y Domingo 10 de 8:00am a 13:00pm"};

    private Integer[] imgid={

            R.drawable.calculo,
            R.drawable.calculo,
            R.drawable.fisica,
            R.drawable.fisica,
            R.drawable.estadistica,
            R.drawable.analisis,
            R.drawable.ecuaciones
    };

    private ListView lista;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_icpol);

        LenguajeListAdapter adapter=new LenguajeListAdapter(this,cursosCelc,descripcion,imgid);
        lista=(ListView)findViewById(R.id.mi_lista_icpol);
        lista.setAdapter(adapter);
        lista.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String Slecteditem= cursosCelc[+position];
                Toast.makeText(getApplicationContext(), Slecteditem, Toast.LENGTH_SHORT).show();
            }
        });
    }
}