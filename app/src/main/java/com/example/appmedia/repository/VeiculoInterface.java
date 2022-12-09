package com.example.appmedia.repository;

import android.content.Context;

import com.example.appmedia.model.Info;
import com.example.appmedia.model.Veiculo;
import com.example.appmedia.model.Viagem;
import com.example.appmedia.util.InfoResponse;

public interface VeiculoInterface {
    void salvar(Context c, Veiculo dados, InfoResponse<Info> response);
    void listar(Context c, InfoResponse<Info> response);
    void excluirTodosV(Context c, InfoResponse<Info> response);

}
