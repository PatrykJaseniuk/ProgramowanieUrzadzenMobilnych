package com.example.l5kantor.BazaDanych;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import java.util.List;

@Dao
public interface WalutaDAO {

    @Insert(onConflict = OnConflictStrategy.ABORT )
    void insert(Waluta waluta) throws Exception;

    @Delete
    void delet(Waluta waluta);

    @Query("SELECT * FROM Waluta ")
    List<Waluta> getAll();

    @Query("SELECT cena FROM Waluta WHERE nazwa_waluty LIKE :nazwaWaluty")
    float getCenaWaluty(String nazwaWaluty);

}
