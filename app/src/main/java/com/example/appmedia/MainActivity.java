package com.example.appmedia;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import com.example.appmedia.adapter.ViagemAdapter;
import com.example.appmedia.model.Viagem;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private ListView lvViagem;
    private ArrayList<Viagem> listaViagem;
    private EditText edData;
    private EditText edKmInicial;
    private EditText edKmFinal;
    private EditText edLitros;
    private TextView media;
    private Viagem viagemSelecionada;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edData = findViewById(R.id.edData);
        edKmInicial = findViewById(R.id.edKmInicial);
        edKmFinal = findViewById(R.id.edKmFinal);
        edLitros = findViewById(R.id.edLitros);

        lvViagem = findViewById(R.id.lvViagem);
        listaViagem = new ArrayList<>();
        atualizaLista();

        lvViagem.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                viagemSelecionada = (Viagem) adapterView.getAdapter().getItem(position);
            }
        });
    }

    private void atualizaLista(){
        ViagemAdapter  adapter = new ViagemAdapter(this, listaViagem);
        lvViagem.setAdapter(adapter);
    }

    public void adicionarViagem(View view) {
        Viagem viagem = new Viagem();
        viagem.setData(edData.getText().toString());
        viagem.setKmInicial(edKmInicial.getText().toString());
        viagem.setKmFinal(edKmFinal.getText().toString());
        viagem.setLitros(edLitros.getText().toString());

        listaViagem.add(viagem);
        atualizaLista();

        edData.setText("");
        edKmInicial.setText("");
        edKmFinal.setText("");
        edLitros.setText("");

    }
}