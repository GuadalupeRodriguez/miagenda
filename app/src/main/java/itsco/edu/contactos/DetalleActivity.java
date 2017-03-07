package itsco.edu.contactos;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;

public class DetalleActivity extends AppCompatActivity implements View.OnClickListener{

    private TextView txtNom;
    private  TextView txtNum;
    private TextView txtEmail;

    private Button btnLlama;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalle);

        txtNom=(TextView)findViewById(R.id.txt_nom);
        txtNum=(TextView)findViewById(R.id.txt_num);
        txtEmail=(TextView)findViewById(R.id.txt_email);

        btnLlama=(Button)findViewById(R.id.btn_llama);
        btnLlama.setOnClickListener(this);



        Intent data=getIntent();
        txtNom.setText(data.getStringExtra("NOMBRE"));
        txtNum.setText(data.getStringExtra("NUMERO"));
        txtEmail.setText(data.getStringExtra("EMAIL"));
    }

    @Override
    public void onClick(View view) {
        Intent llama = new Intent(DetalleActivity.this, DialerActivity.class);
        startActivity(llama);

    }

}
