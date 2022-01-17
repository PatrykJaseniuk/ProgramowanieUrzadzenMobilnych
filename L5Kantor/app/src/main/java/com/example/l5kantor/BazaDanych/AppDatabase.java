package com.example.l5kantor.BazaDanych;

import androidx.room.AutoMigration;
import androidx.room.Database;
import androidx.room.RoomDatabase;

@Database(entities = {Waluta.class}, version =1)

public abstract class AppDatabase extends RoomDatabase {
    public abstract WalutaDAO walutaDao();
}
