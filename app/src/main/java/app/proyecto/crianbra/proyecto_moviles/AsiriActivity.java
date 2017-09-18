package app.proyecto.crianbra.proyecto_moviles;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import com.example.crianbra.proyecto_moviles.R;


public class AsiriActivity extends AppCompatActivity {

    private String cursosAsiri[]=new String[]{"Linux con Raspberry Pi","Modelado 3D + Impresora","Diseño de PCB en Eagle y Proteus",
            "MOdelado e Impresión 3D","Mantenimiento y Reparación de Computadoras", "Aplicaciones Electrónicas", "Curso + Impresora 3D"};

    private String descripcion[]=new String[]{"Del 28 al 31 de Agosto","2 y 23 de Septiembre",
            "Del 4 al 7 de Septiembre","Del 11 al 14 de Septiembre","Del 18 al 21 de Septiembre",
            "Sábado 9 y Domingo 10 de 8:00am a 13:00pm","Del 25 al 28 de Septiembre", "Del 26 al 30 de Septiembre"};

    private Integer[] imgid={

            R.drawable.linux,
            R.drawable.corte,
            R.drawable.pcb,
            R.drawable.modelado,
            R.drawable.computadoras,
            R.drawable.electronica,
            R.drawable.curso
    };

    private ListView lista;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_asiri);

        LenguajeListAdapter adapter=new LenguajeListAdapter(this,cursosAsiri,descripcion,imgid);
        lista=(ListView)findViewById(R.id.milista_asiri);
        lista.setAdapter(adapter);
        lista.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                //String Slecteditem= cursosAsiri[+position];
                //Toast.makeText(getApplicationContext(), Slecteditem, Toast.LENGTH_SHORT).show();
                String Slecteditem= (String) parent.getItemAtPosition(position);
                Intent i = new Intent(AsiriActivity.this, AsiriInfoActivity.class);
                String data [] = new String [3];
                i.putExtra("curso", ""+Slecteditem);
                i.putExtra("name", ""+CursosActivity.user_name.getText());
                i.putExtra("email", ""+CursosActivity.user_email.getText());
                startActivity(i);

            }
        });
    }
}
