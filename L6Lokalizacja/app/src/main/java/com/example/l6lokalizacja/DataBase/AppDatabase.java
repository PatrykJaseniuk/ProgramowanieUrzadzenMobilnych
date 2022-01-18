package com.example.l6lokalizacja.DataBase;

import androidx.room.Database;
import androidx.room.RoomDatabase;
import androidx.room.TypeConverters;

@Database(entities = {Punkt.class}, version =1)
@TypeConverters({WspolrzedneConverter.class})
public abstract class AppDatabase extends RoomDatabase {
    public abstract PunktDAO punktDao();
}