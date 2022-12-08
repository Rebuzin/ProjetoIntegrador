package com.example.appmedia.repository;

import android.content.Context;

import com.example.appmedia.model.Info;
import com.example.appmedia.model.Motorista;
import com.example.appmedia.model.Viagem;
import com.example.appmedia.util.InfoResponse;

public interface MotoristaInterface {
    void salvar(Context c, Motorista dados, InfoResponse<Info> response);
    void listar(Context c, InfoResponse<Info> response);

}
