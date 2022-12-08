package com.example.appmedia;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.appmedia.adapter.VeiculoAdapter;
import com.example.appmedia.model.Info;
import com.example.appmedia.model.Motorista;
import com.example.appmedia.model.Veiculo;
import com.example.appmedia.repository.VeiculoInterface;
import com.example.appmedia.repository.VeiculoRepositorioOrmLite;

import java.util.ArrayList;

public class CadVeiculo extends AppCompatActivity {

    private ListView listView;
    private ArrayList<Veiculo> listaVeiculo;
    private EditText edPlaca;
    private EditText edRenavam;
    private EditText edEixos;
    private EditText edModelo;

    private Veiculo objSelecionado;

    private static final VeiculoInterface repositorio = new VeiculoRepositorioOrmLite();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.cad_veiculo);

        listView = findViewById(R.id.lvVeiculo);
        edPlaca = findViewById(R.id.edPlaca);
        edRenavam = findViewById(R.id.edRenavam);
        edEixos = findViewById(R.id.edEixos);
        edModelo = findViewById(R.id.edModelo);
        listaVeiculo = new ArrayList<>();

        atualizaLista();

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                objSelecionado = (Veiculo) adapterView.getAdapter().getItem(position);
            }
        });
    }

    public void adicionarVeiculo(View view){

        Veiculo veiculo = new Veiculo();
        veiculo.setPlaca(edPlaca.getText().toString());
        veiculo.setRenavam(edRenavam.getText().toString());
        veiculo.setEixos(edEixos.getText().toString());
        veiculo.setModelo(edModelo.getText().toString());

        if(validaDados(veiculo)){

            //Salvando no sqlite
            repositorio.salvar(this, veiculo, info3 -> {

                if (Info.TIPO_MSG_SUCCESS.equals(info3.getTipo())) {
                    //TODO - TRATAR RETORNO DE SUCESSO DE SALVAR
                    System.out.println("Salvou!");

                    listaVeiculo.add(veiculo);
                    atualizaLista();

                    edPlaca.setText("");
                    edRenavam.setText("");
                    edEixos.setText("");
                    edModelo.setText("");
                }
            });



        } else {
            Toast.makeText(this, "Preencha os campos obrigatórios!", Toast.LENGTH_LONG).show();
        }

    }

    public boolean validaDados(Veiculo veiculo) {

        if (veiculo.getPlaca() == null || veiculo.getPlaca().equals("")) {
            edPlaca.setError("Informe a Placa");
            edPlaca.requestFocus();
            return false;
        }

        if (veiculo.getRenavam() == null || veiculo.getRenavam().equals("")) {
            edRenavam.setError("Informe o RENAVAM");
            edRenavam.requestFocus();
            return false;
        }

        if (veiculo.getEixos() == null || veiculo.getEixos().equals("")) {
            edEixos.setError("Informe a quantidade de Eixos");
            edEixos.requestFocus();
            return false;
        }

        if (veiculo.getModelo() == null || veiculo.getModelo().equals("")) {
            edModelo.setError("Informe o Modelo");
            edModelo.requestFocus();
            return false;
        }

        return true;

    }

    private void atualizaLista(){

        //buscando lista do sqlite
        repositorio.listar(this, info3 -> {

            if (Info.TIPO_MSG_SUCCESS.equals(info3.getTipo())) {

                listaVeiculo = (ArrayList<Veiculo>)info3.getObjeto();
                VeiculoAdapter adapter = new VeiculoAdapter(this, listaVeiculo);
                listView.setAdapter(adapter);

            }
        });

    }

    public void irParaTransferencia(View view){
        Intent intent1 = new Intent(getApplicationContext(), Transferencia.class);
        startActivity(intent1);
    }
}
