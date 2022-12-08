package com.example.appmedia;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

public class CadMotorista extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.cad_motorista);
    }

    public void irParaTransferencia(View view){
        Intent intent2 = new Intent(getApplicationContext(), Transferencia.class);
        startActivity(intent2);
    }

}
