package com.example.appmedia.repository;

import android.content.Context;

import com.example.appmedia.mapper.MotoristaMapperOrmLite;
import com.example.appmedia.model.Info;
import com.example.appmedia.model.Motorista;
import com.example.appmedia.ormlite.MotoristaOrmLite;
import com.example.appmedia.util.DatabaseHelper;
import com.example.appmedia.util.InfoResponse;
import com.example.appmedia.util.LogApp;
import com.j256.ormlite.android.apptools.OpenHelperManager;
import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.support.DatabaseConnection;

import org.mapstruct.factory.Mappers;

import java.util.List;

public class MotoristaRepositorioOrmLite implements MotoristaInterface {
    private static final LogApp<MotoristaRepositorioOrmLite> logger = LogApp.getLogger(MotoristaRepositorioOrmLite.class);

    @Override
    public void salvar(Context c, Motorista dados, InfoResponse<Info> response) {
        try {
            DatabaseHelper databaseHelper = OpenHelperManager.getHelper(c, DatabaseHelper.class);

            Dao<MotoristaOrmLite, Integer> dao = databaseHelper.getMotoristaOrmLiteDao();

            DatabaseConnection db = dao.startThreadConnection();

            try {
                MotoristaMapperOrmLite mapper = Mappers.getMapper(MotoristaMapperOrmLite.class);

                // Inicio a transação
                // Removo o autocommit
                dao.setAutoCommit(db, false);

                MotoristaOrmLite embOrmLite = mapper.voToOrm(dados);
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

            Dao<MotoristaOrmLite, Integer> dao = databaseHelper.getMotoristaOrmLiteDao();

            List<MotoristaOrmLite> lista = dao.queryForAll();

            MotoristaMapperOrmLite instance = Mappers.getMapper(MotoristaMapperOrmLite.class);
            List<Motorista> listaModel = instance.listOrmToListVo(lista);

            response.processFinish(Info.getSuccess(listaModel));
        } catch (Exception e) {
            logger.e(e);
            response.processFinish(Info.getError(e.getMessage(), c));
        }

    }
}
