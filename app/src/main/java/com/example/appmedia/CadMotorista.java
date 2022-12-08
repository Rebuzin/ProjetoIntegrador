package com.example.appmedia;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.appmedia.model.Motorista;
import com.example.appmedia.model.Viagem;

import java.util.ArrayList;

public class CadMotorista extends AppCompatActivity {

    private ListView lvMotorista;
    private ArrayList<Motorista> listaMotorista;
    private EditText edNome;
    private EditText edLogradouro;
    private EditText edRG;
    private EditText edCPF;
//    private TextView media;
    private Motorista motoristaSelecionado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.cad_motorista);

        lvMotorista = findViewById(R.id.lvMotorista);
        edNome = findViewById(R.id.edNome);
        edLogradouro = findViewById(R.id.edLogradouro);
        edRG = findViewById(R.id.edRG);
        edCPF = findViewById(R.id.edCPF);
        listaMotorista = new ArrayList<>();
    }

    public void adicionarMotorista(View view){

        Motorista motorista = new Motorista();
        motorista.setNome(edNome.getText().toString());
        motorista.setLogradouro(edLogradouro.getText().toString());
        motorista.setRg(edRG.getText().toString());
        motorista.setCpf(edCPF.getText().toString());

        if(validaDados(motorista)){
            listaMotorista.add(motorista);

            edNome.setText("");
            edLogradouro.setText("");
            edRG.setText("");
            edCPF.setText("");

        } else {
        Toast.makeText(this, "Preencha os campos obrigatórios!", Toast.LENGTH_LONG).show();
    }

    }

    public boolean validaDados(Motorista motorista) {

        if (motorista.getNome() == null || motorista.getNome().equals("")) {
            edNome.setError("Informe o Nome");
            edNome.requestFocus();
            return false;
        }

        if (motorista.getLogradouro() == null || motorista.getLogradouro().equals("")) {
            edLogradouro.setError("Informe o Logradouro");
            edLogradouro.requestFocus();
            return false;
        }

        if (motorista.getRg() == null || motorista.getRg().equals("")) {
            edRG.setError("Informe o RG");
            edRG.requestFocus();
            return false;
        }

        if (motorista.getCpf() == null || motorista.getCpf().equals("")) {
            edCPF.setError("Informe o CPF");
            edCPF.requestFocus();
            return false;
        }

        return true;

    }

    public void irParaTransferencia(View view){
        Intent intent2 = new Intent(getApplicationContext(), Transferencia.class);
        startActivity(intent2);
    }

}
