package com.example.l6lokalizacja.DataBase;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import java.util.List;

@Dao
public interface PunktDAO {

    @Query("SELECT pId, nazwa_punktu, wspolrzedne_punktu FROM Punkt ")
    List<Punkt> getAll();

    @Query("SELECT opis_punktu FROM Punkt WHERE pId LIKE :id")
    String getOpis(int id);

    @Insert(onConflict = OnConflictStrategy.ABORT )
    void insert(Punkt punkt);
}
