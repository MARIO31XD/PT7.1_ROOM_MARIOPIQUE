package com.example.pt71_room_mariopique.db;


import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.Transaction;
import java.util.List;

@Dao
public interface TascaTagDAO {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    void insert(TascaTag tascaTag);


    @Delete
    void delete(TascaTag tascaTag);
}
