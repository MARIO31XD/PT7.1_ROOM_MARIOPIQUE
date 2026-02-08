package com.example.pt71_room_mariopique.db;


import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.ForeignKey;


@Entity(tableName = "tasca_tag",
        primaryKeys = {"tascaId", "tagId"},
        foreignKeys = {
                @ForeignKey(
                        entity = Tag.class,
                        parentColumns = "id",
                        childColumns = "tagId",
                        onDelete = ForeignKey.CASCADE
                ),
                @ForeignKey(
                        entity = Tasca.class,
                        parentColumns = "id",
                        childColumns = "tascaId",
                        onDelete = ForeignKey.CASCADE
                )
        })

public class TascaTag {

    @ColumnInfo(name = "tagId")
    private int tagId;
    @ColumnInfo(name = "tascaId")
    private int tascaId;

    public TascaTag(int tagId, int tascaId) {
         this.tagId = tagId;
         this.tascaId = tascaId;
    }

    public int getTagId() { return tagId; }
    public void setTagId(int tagId) { this.tagId = tagId; }

    public int getTascaId() { return tascaId; }
    public void setTascaId(int tascaId) { this.tascaId = tascaId; }

}
