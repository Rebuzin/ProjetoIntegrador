package com.example.appmedia.repository;

import android.content.Context;

import com.example.appmedia.mapper.VeiculoMapperOrmLite;
import com.example.appmedia.model.Info;
import com.example.appmedia.model.Veiculo;
import com.example.appmedia.ormlite.VeiculoOrmLite;
import com.example.appmedia.ormlite.ViagemOrmLite;
import com.example.appmedia.util.DatabaseHelper;
import com.example.appmedia.util.InfoResponse;
import com.example.appmedia.util.LogApp;
import com.j256.ormlite.android.apptools.OpenHelperManager;
import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.support.DatabaseConnection;

import org.mapstruct.factory.Mappers;

import java.util.List;

public class VeiculoRepositorioOrmLite implements VeiculoInterface {
    private static final LogApp<VeiculoRepositorioOrmLite> logger = LogApp.getLogger(VeiculoRepositorioOrmLite.class);

    @Override
    public void salvar(Context c, Veiculo dados, InfoResponse<Info> response) {
        try {
            DatabaseHelper databaseHelper = OpenHelperManager.getHelper(c, DatabaseHelper.class);

            Dao<VeiculoOrmLite, Integer> dao = databaseHelper.getVeiculoOrmLiteDao();

            DatabaseConnection db = dao.startThreadConnection();

            try {
                VeiculoMapperOrmLite mapper = Mappers.getMapper(VeiculoMapperOrmLite.class);

                // Inicio a transação
                // Removo o autocommit
                dao.setAutoCommit(db, false);

                VeiculoOrmLite embOrmLite = mapper.voToOrm(dados);
                dao.createOrUpdate(embOrmLite);

                dao.commit(db);

            } catch (Exception e) {
                logger.e(e);
                if (db != null) {
                    dao.rollBack(db);
                }
                response.processFinish(Info.getError(e.getMessage(), c));
            } finally {
                // Habilito novamente o autocommit
                dao.setAutoCommit(db, false);

                response.processFinish(Info.getSuccess());
            }
        } catch (Exception e) {
            logger.e(e);
            response.processFinish(Info.getError(e.getMessage(), c));
        }
    }

    @Override
    public void listar(Context c, InfoResponse<Info> response) {
        try {
            DatabaseHelper databaseHelper = OpenHelperManager.getHelper(c, DatabaseHelper.class);

            Dao<VeiculoOrmLite, Integer> dao = databaseHelper.getVeiculoOrmLiteDao();

            List<VeiculoOrmLite> lista = dao.queryForAll();

            VeiculoMapperOrmLite instance = Mappers.getMapper(VeiculoMapperOrmLite.class);
            List<Veiculo> listaModel = instance.listOrmToListVo(lista);

            response.processFinish(Info.getSuccess(listaModel));
        } catch (Exception e) {
            logger.e(e);
            response.processFinish(Info.getError(e.getMessage(), c));
        }

    }

    @Override
    public void excluirTodosV(Context c, InfoResponse<Info> response) {
        try {
            DatabaseHelper databaseHelper = OpenHelperManager.getHelper(c, DatabaseHelper.class);

            Dao<VeiculoOrmLite, Integer> dao = databaseHelper.getVeiculoOrmLiteDao();

            DatabaseConnection db = dao.startThreadConnection();
            dao.setAutoCommit(db, false);

            List<VeiculoOrmLite> lista = dao.queryForAll();

            for(VeiculoOrmLite omrLite : lista){
                dao.delete(omrLite);
            }

            dao.commit(db);

            response.processFinish(Info.getSuccess());
        } catch (Exception e) {
            logger.e(e);
            response.processFinish(Info.getError(e.getMessage(), c));
        }

    }
}
