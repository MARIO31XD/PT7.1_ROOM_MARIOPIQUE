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
public interface TagDAO {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    void insertTag(Tag tag);


    @Query("SELECT * FROM tag")
    List<Tag> getAllTags();


    @Query("SELECT * FROM tag WHERE nom = :nom LIMIT 1")
    Tag getTagPerNom(String nom);


    @Delete
    void deleteTag(Tag tag);
}
