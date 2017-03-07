package itsco.edu.contactos;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class DialerActivity extends AppCompatActivity implements View.OnClickListener {

    private TextView txtNom;
    private  TextView txtNum;

    private Button btnFin;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dialer);
        btnFin=(Button)findViewById(R.id.btn_fin);
        btnFin.setOnClickListener(this);

        txtNom=(TextView)findViewById(R.id.txt_nombre);
        txtNum=(TextView)findViewById(R.id.txt_numero);

        Intent data=getIntent();
        txtNom.setText(data.getStringExtra("NOMBRE"));
        txtNum.setText(data.getStringExtra("NUMERO"));


    }

    @Override
    public void onClick(View view) {
        Intent fin = new Intent(this,MainActivity.class);
        startActivity(fin);

        Toast.makeText(this,
                "Finalizando",
                Toast.LENGTH_SHORT).show();

    }
}
