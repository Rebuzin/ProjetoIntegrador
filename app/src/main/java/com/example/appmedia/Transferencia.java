package com.example.appmedia;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

public class Transferencia extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.transferencia);
    }

    public void irParaTelaCadMotorista(View view){
        Intent intent2 = new Intent(getApplicationContext(), CadMotorista.class);
        startActivity(intent2);
    }

    public void irParaTelaCadVeiculo(View view){
        Intent intent3 = new Intent(getApplicationContext(), CadVeiculo.class);
        startActivity(intent3);
    }

    public void irParaTelaMain(View view){
        Intent intent4 = new Intent(getApplicationContext(), MainActivity.class);
        startActivity(intent4);
    }


}
