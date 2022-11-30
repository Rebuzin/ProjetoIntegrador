package com.example.appmedia.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.appmedia.R;
import com.example.appmedia.model.Viagem;
import com.example.appmedia.util.Util;

import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.util.ArrayList;

public class ViagemAdapter extends BaseAdapter {

    private Context context;
    private ArrayList<Viagem> listaViagem;

    public ViagemAdapter(Context context, ArrayList<Viagem> listaViagem) {
        this.context = context;
        this.listaViagem = listaViagem;
    }

    @Override//Pega a quantidade de elementos no arraylist
    public int getCount() {
        return listaViagem.size();
    }

    @Override//Retorna o objeto que esta clicando
    public Object getItem(int position) {
        return listaViagem.get(position);
    }

    @Override//Posição que esta clicando
    public long getItemId(int returnPosition) {
        return returnPosition;
    }

    @Override//Vai implementar o layout
    public View getView(int position, View view, ViewGroup viewGroup) {
        if (view == null){
            view = LayoutInflater.from(context).inflate(R.layout.list_item_viagem, viewGroup, false);
        }

        Viagem viagem = listaViagem.get(position);
        TextView tvListData = view.findViewById(R.id.tvItemListData);
        TextView tvListKmInicial = view.findViewById(R.id.tvItemListKmInicial);
        TextView tvListKmFinal = view.findViewById(R.id.tvItemListKmFinal);
        TextView tvListLitros = view.findViewById(R.id.tvItemListLitros);
        TextView tvListMedia = view.findViewById(R.id.tvItemListMedia);


        tvListData.setText("Data: " + viagem.getData());
        tvListKmInicial.setText("Km Inicial: " + viagem.getKmInicial());
        tvListKmFinal.setText("Km Final: " + viagem.getKmFinal());
        tvListLitros.setText("Litros: " + viagem.getLitros());
        tvListMedia.setText("Média: " + Util.formatDecimaltoString(viagem.getMedia()));
        return view;
    }


}