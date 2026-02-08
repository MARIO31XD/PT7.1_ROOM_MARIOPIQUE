package com.example.pt71_room_mariopique.db;


import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.Transaction;
import androidx.room.Update;

import java.util.List;

@Dao
public interface TascaDAO {

    @Insert
    long insertTasca(Tasca tasca);

    @Insert
    void insertTag(Tag tag);


    @Transaction
    @Query("SELECT * FROM tasca")
    List<TascaAmbTags> getTasquesAmbTags();


    @Transaction
    @Query("SELECT * FROM tasca INNER JOIN tasca_tag ON tasca.id = tasca_tag.tascaId INNER JOIN tag ON tag.id = tasca_tag.tagId WHERE tag.nom = :nomTag")
    List<TascaAmbTags> getTasquesPerNomDeTag(String nomTag);

    @Transaction
    @Query("SELECT * FROM tasca")
    List<TascaAmbTags> getTotesLesTasques();

    @Transaction
    @Query("SELECT * FROM tasca INNER JOIN tasca_tag ON tasca.id = tasca_tag.tascaId " +
            "INNER JOIN tag ON tag.id = tasca_tag.tagId WHERE tag.nom = :nomTag")
    List<TascaAmbTags> getTasquesFiltradesPerTag(String nomTag);


}


