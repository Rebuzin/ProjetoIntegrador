package com.example.appmedia.repository;

import android.content.Context;

import com.example.appmedia.ormlite.ViagemOrmLite;
import com.example.appmedia.util.DatabaseHelper;
import com.example.appmedia.util.LogApp;
import com.j256.ormlite.android.apptools.OpenHelperManager;
import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.stmt.PreparedQuery;
import com.j256.ormlite.stmt.QueryBuilder;
import com.j256.ormlite.support.DatabaseConnection;

public class ViagemRepositorioOrmLite  {
    private static final LogApp<ViagemRepositorioOrmLite> logger = LogApp.getLogger(ViagemRepositorioOrmLite.class);

//    @Override
//    public void salvarConfCarga(Context c, ConfCargaFromServerVo dados, InfoResponse<Info> response) {
//        try {
//            DatabaseHelper databaseHelper = OpenHelperManager.getHelper(c, DatabaseHelper.class);
//
//            Dao<ViagemOrmLite, Integer> dao = databaseHelper.getViagemOrmLiteDao();
//
//            DatabaseConnection db = dao.startThreadConnection();
//
//            try {
////                ConfCargaMapperOrmLite mapper = Mappers.getMapper(ConfCargaMapperOrmLite.class);
////                ConfCargaItemMapperOrmLite mapperConfCargaItem = Mappers.getMapper(ConfCargaItemMapperOrmLite.class);
////                ConfCargaEmbMapperOrmLite mapperConfCargaEmb = Mappers.getMapper(ConfCargaEmbMapperOrmLite.class);
//
//                // Inicio a transação
//                // Removo o autocommit
//                dao.setAutoCommit(db, false);
//
//
////                    ViagemOrmLite embOrmLite = mapperConfCargaEmb.voToOrm(confCargaEmbVo);
////                    dao.createOrUpdate(embOrmLite);
//
//
//                dao.commit(db);
//
////                getConfCarga(c, dados.getEstab(), response);
//            } catch (Exception e) {
//                logger.e(e);
//                if (db != null) {
//                    dao.rollBack(db);
//                }
////                response.processFinish(Info.getError(e, c));
//            } finally {
//                // Habilito novamente o autocommit
//                dao.setAutoCommit(db, false);
//            }
//        } catch (Exception e) {
//            logger.e(e);
////            response.processFinish(Info.getError(e, c));
//        }
//    }
}
