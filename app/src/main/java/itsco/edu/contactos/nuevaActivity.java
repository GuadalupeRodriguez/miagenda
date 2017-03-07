package itsco.edu.contactos;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class nuevaActivity extends AppCompatActivity implements View.OnClickListener{
    private Button btnGuardar;
    private Button btnCancelar;

    private EditText txtNom;
    private EditText txtNum;
    private EditText txtEmail;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nueva);

        btnCancelar=(Button)findViewById(R.id.btn_cancelar);
        btnGuardar=(Button) findViewById(R.id.btn_guardar);
        btnCancelar.setOnClickListener(this);
        btnGuardar.setOnClickListener(this);
        txtNom=(EditText)findViewById(R.id.txt_nom);
        txtNum=(EditText)findViewById(R.id.txt_num);
        txtEmail=(EditText)findViewById(R.id.txt_email);
    }

    @Override
    public void onClick(View view) {
        if (view.getId()==btnGuardar.getId()){
            Intent data=getIntent();
            agrega a=new agrega();

            a.setNombre(txtNom.getText().toString());
            a.setNumero(txtNum.getText().toString());
            a.setEmail(txtEmail.getText().toString());

            data.putExtra("AGREGA",a);
            setResult(RESULT_OK,data);
        }
        if (view.getId()==btnCancelar.getId()){
            setResult(RESULT_CANCELED);
        }
        finish();

    }
}
