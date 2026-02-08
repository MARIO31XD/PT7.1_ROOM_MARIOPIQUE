package com.example.pt71_room_mariopique.db;

import androidx.room.Embedded;
import androidx.room.Junction;
import androidx.room.Query;
import androidx.room.Relation;
import androidx.room.Transaction;

import java.util.List;

public class TascaAmbTags {

    @Embedded
    public Tasca tasca;

    @Relation(
            parentColumn = "id",
            entityColumn = "id",
            associateBy = @Junction(   // junction unión
                    value = TascaTag.class,
                    parentColumn = "tascaId",
                    entityColumn = "tagId"
            )
    )

    public List<Tag> tags;
}
