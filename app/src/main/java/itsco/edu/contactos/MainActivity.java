package itsco.edu.contactos;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity
        implements View.OnClickListener, AdapterView.OnItemClickListener{


    public static final int NUEVA_TAREA=10;

    private Button btnNuevo;
    private ListView lista;

    private ArrayList<agrega> data;
    private ArrayAdapter<agrega> adapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnNuevo=(Button)findViewById(R.id.btn_nuevo);
        btnNuevo.setOnClickListener(this);

        lista=(ListView)findViewById(R.id.lista_contacto);
        data = new ArrayList<>();
        adapter = new ArrayAdapter<>(this,
                android.R.layout.simple_list_item_1,
                android.R.id.text1, data );
        lista.setAdapter(adapter);
        lista.setOnItemClickListener(this);
    }

    @Override
    public void onClick(View view) {
        Intent i=new Intent(this,nuevaActivity.class);
        startActivityForResult(i,NUEVA_TAREA);

    }

    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

        agrega a= data.get(i);
                Intent intent=new Intent(this,
                        DetalleActivity.class);
        intent.putExtra("NOMBRE",a.getNombre());
        intent.putExtra("NUMERO",a.getNumero());
        intent.putExtra("EMAIL",a.getEmail());

        startActivity(intent);

        Intent intent1 = new Intent(this,DialerActivity.class);
        intent1.putExtra("NOMBRE",a.getNombre());
        intent1.putExtra("NUMERO",a.getNumero());
        startActivity(intent1);


    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode==RESULT_OK){
            if (requestCode==NUEVA_TAREA){

                agrega a = data.getParcelableExtra("AGREGA");
                this.data.add(a);

                adapter.notifyDataSetChanged();
            }
        }
    }
}
