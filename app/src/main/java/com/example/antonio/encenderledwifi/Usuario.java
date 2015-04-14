package com.example.antonio.encenderledwifi;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

/**
 * Created by Antonio on 14/04/2015.
 * Base de datos SQLite para el control del acceso de la aplicacion usando el motor OrmLite
 */
@DatabaseTable
public class Usuario {

    public static final String ID = "_id";
    public static final String NOMBRE = "nombre";
    public static final String EMAIL = "email";
    public static final String CONTRASENA = "contrasena";

    //<editor-fold desc="ATRIBUTOS DE LA CLASE">
    @DatabaseField(generatedId = true, columnName = ID)
    private int id;
    @DatabaseField(columnName = EMAIL)
    private String email;
    @DatabaseField(columnName = NOMBRE)
    private String nombre;
    @DatabaseField(columnName = CONTRASENA)
    private String contrasena;
    //</editor-fold>

    //<editor-fold desc="GETTER">
    public String getEmail() {
        return email;
    }

    public String getNombre() {
        return nombre;
    }

    public String getContrasena() {
        return contrasena;
    }
    //</editor-fold>

    //<editor-fold desc="SETTER">
    public void setEmail(String email) {
        this.email = email;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }
    //</editor-fold>
}
