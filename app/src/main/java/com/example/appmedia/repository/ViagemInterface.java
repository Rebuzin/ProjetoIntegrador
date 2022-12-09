package com.example.appmedia.repository;

import android.content.Context;

import com.example.appmedia.model.Info;
import com.example.appmedia.model.Viagem;
import com.example.appmedia.util.InfoResponse;

public interface ViagemInterface {
    void salvar(Context c, Viagem dados, InfoResponse<Info> response);

    void listar(Context c, InfoResponse<Info> response);

//    void excluirTodos(Context c, InfoResponse<Info> response);
}
