package app.proyecto.crianbra.proyecto_moviles;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import com.example.crianbra.proyecto_moviles.R;


public class CelcActivity extends Activity {

    private String cursosCelc[]=new String[]{"Curso de Computación","Curso de Asistente Contable","Curso de Electricidad Básica",
            "Curso de SENESCYT-INEVAL","Curso de Diseño Gráfico Básico", "Curso de Reparación de Celulares", "Curso de Emfermería",
            "Curso Avanzado de Excel", "Curso de Programación"};

    private String descripcion[]=new String[]{"Horario Lunes-Miercoles-Viernes de 8:00am a 10:00am","Horario Lunes-Miercoles-Viernes de 10:00am a 12:00pm",
            "Horario Lunes-Miercoles-Viernes de 14:00pm a 16:00am","Horario Martes y Jueves de 8:00am a 10:00am",
            "Horario Martes y Jueves de 10:00am a 12:00am", "Horario Martes y Jueves de 14:00pm a 16:00am", "Sabados y Domingos de 8:00am a 11:00pm",
            "Sabados y Domingos de 11:00am a 14:00pm", "Sabados y Domingos de 14:00pm a 17:00pm"};

    private Integer[] imgid={

            R.drawable.computacion,
            R.drawable.contable,
            R.drawable.electricidad,
            R.drawable.senescyt,
            R.drawable.diseno,
            R.drawable.celulares,
            R.drawable.enfermeria,
            R.drawable.excel,
            R.drawable.programacion
    };

    private ListView lista;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_celc);

        LenguajeListAdapter adapter=new LenguajeListAdapter(this,cursosCelc,descripcion,imgid);
        lista=(ListView)findViewById(R.id.mi_lista);
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
