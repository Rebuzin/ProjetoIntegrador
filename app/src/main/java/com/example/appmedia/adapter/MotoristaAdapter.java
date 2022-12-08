package com.example.appmedia.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.appmedia.R;
import com.example.appmedia.model.Motorista;

import java.util.ArrayList;

public class MotoristaAdapter extends BaseAdapter {

    private Context context;
    private ArrayList<Motorista> lista;

    public MotoristaAdapter(Context context, ArrayList<Motorista> lista) {
        this.context = context;
        this.lista = lista;
    }

    @Override//Pega a quantidade de elementos no arraylist
    public int getCount() {
        return lista.size();
    }

    @Override//Retorna o objeto que esta clicando
    public Object getItem(int position) {
        return lista.get(position);
    }

    @Override//Posição que esta clicando
    public long getItemId(int returnPosition) {
        return returnPosition;
    }

    @Override//Vai implementar o layout
    public View getView(int position, View view, ViewGroup viewGroup) {
        if (view == null){
            view = LayoutInflater.from(context).inflate(R.layout.list_item_motorista, viewGroup, false);
        }

        Motorista obj = lista.get(position);
        TextView tx1 = view.findViewById(R.id.tvItemListNome);
        TextView tx2 = view.findViewById(R.id.tvItemListCpf);
        TextView tx3 = view.findViewById(R.id.tvItemListRg);
        TextView tx4 = view.findViewById(R.id.tvItemListLogradouro);


        tx1.setText("Nome: " + obj.getNome());
        tx2.setText("CPF: " + obj.getCpf());
        tx3.setText("RG: " + obj.getRg());
        tx4.setText("Logradouro: " + obj.getLogradouro());

        return view;
    }


}