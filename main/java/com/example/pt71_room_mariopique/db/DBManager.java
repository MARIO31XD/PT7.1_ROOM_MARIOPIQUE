package com.example.pt71_room_mariopique.db;


import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;


@Database(entities = {   // tenemos dos entidades que son las dos clases
        Tag.class,
        Tasca.class,
        TascaTag.class
}, version = 1)


public abstract class DBManager extends RoomDatabase {

    private static DBManager INSTANCE;
    public abstract TagDAO tagDAO();
    public abstract TascaDAO tascaDAO();
    public abstract TascaTagDAO tascaTagDao();


    public static DBManager getDbInstance(Context context)  {
        if (INSTANCE == null) {
            INSTANCE = Room.databaseBuilder(
                    context.getApplicationContext(),
                    DBManager.class,
                    "app_database"
            ).build();
        }
        return INSTANCE;

    }

    public TascaTagDAO tascaTagDAO() {
        return null;
    }


}

