package com.example.pt71_room_mariopique.db;


import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;

@Entity(tableName = "tag")
public class Tag {
    @PrimaryKey(autoGenerate = true)
    private int id;

    @ColumnInfo(name = "nom")
    private String nom;

    public Tag(int id, String nom) {
        this.id = id;
        this.nom = nom;
    }

    @Ignore
    public Tag(String nom) {
        this.nom = nom;
    }

    // GETTERS & SETTERS
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }
}
