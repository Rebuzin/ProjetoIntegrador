package com.example.appmedia.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.appmedia.R;
import com.example.appmedia.model.Motorista;
import com.example.appmedia.model.Veiculo;

import java.util.ArrayList;

public class VeiculoAdapter extends BaseAdapter {

    private Context context;
    private ArrayList<Veiculo> lista;

    public VeiculoAdapter(Context context, ArrayList<Veiculo> lista) {
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
            view = LayoutInflater.from(context).inflate(R.layout.list_item_veiculo, viewGroup, false);
        }

        Veiculo obj = lista.get(position);
        TextView tx1 = view.findViewById(R.id.tvItemListPlaca);
        TextView tx2 = view.findViewById(R.id.tvItemListRenavam);
        TextView tx3 = view.findViewById(R.id.tvItemListEixos);
        TextView tx4 = view.findViewById(R.id.tvItemListModelo);


        tx1.setText("Placa: " + obj.getPlaca());
        tx2.setText("Renavam: " + obj.getRenavam());
        tx3.setText("Eixos: " + obj.getEixos());
        tx4.setText("Modelo: " + obj.getModelo());

        return view;
    }


}