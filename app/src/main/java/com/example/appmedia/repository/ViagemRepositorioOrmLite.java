package com.example.appmedia.repository;

import android.content.Context;

import com.example.appmedia.mapper.ViagemMapperOrmLite;
import com.example.appmedia.model.Info;
import com.example.appmedia.model.Viagem;
import com.example.appmedia.ormlite.ViagemOrmLite;
import com.example.appmedia.util.DatabaseHelper;
import com.example.appmedia.util.InfoResponse;
import com.example.appmedia.util.LogApp;
import com.j256.ormlite.android.apptools.OpenHelperManager;
import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.support.DatabaseConnection;

import org.mapstruct.factory.Mappers;

import java.util.List;

public class ViagemRepositorioOrmLite implements ViagemInterface {
    private static final LogApp<ViagemRepositorioOrmLite> logger = LogApp.getLogger(ViagemRepositorioOrmLite.class);

    @Override
    public void salvar(Context c, Viagem dados, InfoResponse<Info> response) {
        try {
            DatabaseHelper databaseHelper = OpenHelperManager.getHelper(c, DatabaseHelper.class);

            Dao<ViagemOrmLite, Integer> dao = databaseHelper.getViagemOrmLiteDao();

            DatabaseConnection db = dao.startThreadConnection();

            try {
                ViagemMapperOrmLite mapper = Mappers.getMapper(ViagemMapperOrmLite.class);

                // Inicio a transação
                // Removo o autocommit
                dao.setAutoCommit(db, false);

                ViagemOrmLite embOrmLite = mapper.voToOrm(dados);
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

            Dao<ViagemOrmLite, Integer> dao = databaseHelper.getViagemOrmLiteDao();

            List<ViagemOrmLite> lista = dao.queryForAll();

            ViagemMapperOrmLite instance = Mappers.getMapper(ViagemMapperOrmLite.class);
            List<Viagem> listaModel = instance.listOrmToListVo(lista);

            response.processFinish(Info.getSuccess(listaModel));
        } catch (Exception e) {
            logger.e(e);
            response.processFinish(Info.getError(e.getMessage(), c));
        }

    }



    @Override
    public void excluirTodos(Context c, InfoResponse<Info> response) {
        try {
            DatabaseHelper databaseHelper = OpenHelperManager.getHelper(c, DatabaseHelper.class);

            Dao<ViagemOrmLite, Integer> dao = databaseHelper.getViagemOrmLiteDao();

            DatabaseConnection db = dao.startThreadConnection();
            dao.setAutoCommit(db, false);

            List<ViagemOrmLite> lista = dao.queryForAll();

            for(ViagemOrmLite omrLite : lista){
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
