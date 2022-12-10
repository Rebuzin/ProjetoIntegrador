package com.example.appmedia;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.appmedia.adapter.MotoristaAdapter;
import com.example.appmedia.funcoesvalidacao.FuncoesPadrao;
import com.example.appmedia.model.Info;
import com.example.appmedia.model.Motorista;
import com.example.appmedia.model.Viagem;
import com.example.appmedia.repository.MotoristaInterface;
import com.example.appmedia.repository.MotoristaRepositorioOrmLite;

import java.util.ArrayList;

public class CadMotorista extends AppCompatActivity {

    private ListView listView;
    private ArrayList<Motorista> listaMotorista;
    private EditText edNome;
    private EditText edLogradouro;
    private EditText edRG;
//    private com.santalu.maskara.widget.MaskEditText edCPF;
    private EditText edCPF;
    //    private TextView media;
    private Motorista objSelecionado;

    private static final MotoristaInterface repositorio = new MotoristaRepositorioOrmLite();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.cad_motorista);

        listView = findViewById(R.id.lvMotorista);
        edNome = findViewById(R.id.edNome);
        edLogradouro = findViewById(R.id.edLogradouro);
        edRG = findViewById(R.id.edRG);
        edCPF = findViewById(R.id.edCPF);
        listaMotorista = new ArrayList<>();
        atualizaLista();

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                objSelecionado = (Motorista) adapterView.getAdapter().getItem(position);
            }
        });
    }

    public void adicionarMotorista(View view) {

        Motorista motorista = new Motorista();
        motorista.setNome(edNome.getText().toString());
        motorista.setLogradouro(edLogradouro.getText().toString());
        motorista.setRg(edRG.getText().toString());
        motorista.setCpf(edCPF.getText().toString());

        if (validaDados(motorista)) {


                //Salvando no sqlite
                repositorio.salvar(this, motorista, info3 -> {

                    if (Info.TIPO_MSG_SUCCESS.equals(info3.getTipo())) {
                        //TODO - TRATAR RETORNO DE SUCESSO DE SALVAR
                        System.out.println("Salvou!");

                        listaMotorista.add(motorista);
                        atualizaLista();

                        edNome.setText("");
                        edLogradouro.setText("");
                        edRG.setText("");
                        edCPF.setText("");
                    }
                });



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

//        if (FuncoesPadrao.validaCPF(edCpf.getUnMasked()) == false) {
//            edCpf.setError("CPF INVÁLIDO");
//            return;
//        }

        return true;

    }

    private void atualizaLista(){

        //buscando lista do sqlite
        repositorio.listar(this, info3 -> {

            if (Info.TIPO_MSG_SUCCESS.equals(info3.getTipo())) {

                listaMotorista = (ArrayList<Motorista>)info3.getObjeto();
                MotoristaAdapter adapter = new MotoristaAdapter(this, listaMotorista);
                listView.setAdapter(adapter);

            }
        });

    }

    public void irParaTransferencia(View view) {
        Intent intent2 = new Intent(getApplicationContext(), Transferencia.class);
        startActivity(intent2);
    }

}
