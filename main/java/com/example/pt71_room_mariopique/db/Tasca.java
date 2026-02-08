package com.example.pt71_room_mariopique.db;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "tasca")   // NOM DE LA TAULA
public class Tasca {

    @PrimaryKey(autoGenerate = true)
    private int id;


    @ColumnInfo(name = "titol")
    public String titol;

    @ColumnInfo(name = "descripcio")
    private String descripcio;

    @ColumnInfo(name = "estat")
    private String estat;


    @ColumnInfo(name = "dataCreacio")
    private long dataCreacio;


    @ColumnInfo(name = "dataCanvi")
    private long dataCanvi;


    // GETTERS & SETTERS
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitol() {
        return titol;
    }

    public void setTitol(String titol) {
        this.titol = titol;
    }

    public String getDescripcio() {
        return descripcio;
    }

    public void setDescripcio(String descripcio) {
        this.descripcio = descripcio;
    }

    public String getEstat() {
        return estat;
    }

    public void setEstat(String estat) {
        this.estat = estat;
    }

    public long getDataCreacio() {
        return dataCreacio;
    }

    public void setDataCreacio(int dataCreacio) {
        this.dataCreacio = dataCreacio;
    }

    public long getDataCanvi() {
        return dataCanvi;
    }

    public void setDataCanvi(int dataCanvi) {
        this.dataCanvi = dataCanvi;
    }

    // CONSTRUCTOR AMB ELS PARAMETRES
    public Tasca(String titol, String descripcio, String estat, long dataCreacio, long dataCanvi) {
        this.titol = titol;
        this.descripcio = descripcio;
        this.estat = estat;
        this.dataCreacio = dataCreacio;
        this.dataCanvi = dataCanvi;
    }
}
