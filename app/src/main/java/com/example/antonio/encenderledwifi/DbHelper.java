package com.example.antonio.encenderledwifi;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import com.j256.ormlite.android.apptools.OrmLiteSqliteOpenHelper;
import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.support.ConnectionSource;
import com.j256.ormlite.table.TableUtils;

import java.sql.SQLException;

/**
 * Created by Antonio on 14/04/2015.
 */
public class DbHelper extends OrmLiteSqliteOpenHelper {

    private static final String DATABASE_NAME = "ormlite.sqlite";
    private static final int DATABASE_VERSION = 1;

    //Creamos el Dao para poder realizar operaciones con la base de datos
    private Dao<Usuario, Integer> usuarioDao;

    //Constructor de la clase
    public DbHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    //Crear tablas
    @Override
    public void onCreate(SQLiteDatabase db, ConnectionSource source) {
        try {
            TableUtils.createTable(source, Usuario.class);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    //Actualiza base de datos
    @Override
    public void onUpgrade(SQLiteDatabase db, ConnectionSource source, int i, int i1) {
        onCreate(db, source);
    }

    //Recuperamos el Dao, si no esta inicializado lo inicializamos
    public Dao<Usuario, Integer> getUsuarioDao() throws SQLException {
        if(usuarioDao == null){
            usuarioDao = getDao(Usuario.class);
        }
        return usuarioDao;
    }

    //Libera recursos
    @Override
    public void close() {
        super.close();
        usuarioDao = null;
    }
}
