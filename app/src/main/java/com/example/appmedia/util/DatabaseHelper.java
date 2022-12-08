package com.example.appmedia.util;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import com.example.appmedia.R;
import com.example.appmedia.ormlite.MotoristaOrmLite;
import com.example.appmedia.ormlite.VeiculoOrmLite;
import com.example.appmedia.ormlite.ViagemOrmLite;
import com.j256.ormlite.android.apptools.OpenHelperManager;
import com.j256.ormlite.android.apptools.OrmLiteSqliteOpenHelper;
import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.support.ConnectionSource;
import com.j256.ormlite.table.TableUtils;

import java.sql.SQLException;


public class DatabaseHelper extends OrmLiteSqliteOpenHelper {
    private static final LogApp<DatabaseHelper> logger = LogApp.getLogger(DatabaseHelper.class);
    private static final String DATABASE_NAME = "appmedia2.db";
    private static final int DATABASE_VERSION = 1;
    private Dao<ViagemOrmLite, Integer> viagemOrmLiteDao;
    private Dao<MotoristaOrmLite, Integer> motoristaOrmLiteDao;
    private Dao<VeiculoOrmLite, Integer> veiculoOrmLiteDao;


    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION, R.raw.ormlite_config);

    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase, ConnectionSource connectionSource) {
        try {

            TableUtils.createTable(connectionSource, ViagemOrmLite.class);
            TableUtils.createTable(connectionSource, MotoristaOrmLite.class);
            TableUtils.createTable(connectionSource, VeiculoOrmLite.class);


        } catch (SQLException ex) {
            logger.e("Unable to create tables", ex);

        }
    }

    public void dropAndCreateTables(Context c) {
        DatabaseHelper helper = OpenHelperManager.getHelper(c, DatabaseHelper.class);
        SQLiteDatabase database = helper.getWritableDatabase();
        this.dropAndCreateTables(database, getConnectionSource());
    }

    public void dropAndCreateTables(SQLiteDatabase sqLiteDatabase, ConnectionSource connectionSource) {
        try {
            TableUtils.dropTable(connectionSource, ViagemOrmLite.class, true);
            TableUtils.dropTable(connectionSource, MotoristaOrmLite.class, true);
            TableUtils.dropTable(connectionSource, VeiculoOrmLite.class, true);


            onCreate(sqLiteDatabase, connectionSource);
        } catch (SQLException ex) {
            logger.e("Unable to create tables", ex);
        }
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, ConnectionSource connectionSource, int oldVer, int newVer) {
        this.dropAndCreateTables(sqLiteDatabase, connectionSource);
    }

    public <T> Dao<T, Integer> getObjectDao(Class<T> classe) throws SQLException {
        return getDao(classe);
    }

    public Dao<ViagemOrmLite, Integer> getViagemOrmLiteDao() throws SQLException {
        if (viagemOrmLiteDao == null) {
            viagemOrmLiteDao = getObjectDao(ViagemOrmLite.class);
        }
        return viagemOrmLiteDao;
    }

    public Dao<MotoristaOrmLite, Integer> getMotoristaOrmLiteDao() throws SQLException {
        if (motoristaOrmLiteDao == null) {
            motoristaOrmLiteDao = getObjectDao(MotoristaOrmLite.class);
        }
        return motoristaOrmLiteDao;
    }

    public Dao<VeiculoOrmLite, Integer> getVeiculoOrmLiteDao() throws SQLException {
        if (veiculoOrmLiteDao == null) {
            veiculoOrmLiteDao = getObjectDao(VeiculoOrmLite.class);
        }
        return veiculoOrmLiteDao;
    }

}