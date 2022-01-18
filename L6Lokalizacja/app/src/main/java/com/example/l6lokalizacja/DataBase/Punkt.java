package com.example.l6lokalizacja.DataBase;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.Index;
import androidx.room.PrimaryKey;

@Entity(indices = {@Index(value = {"wspolrzedne_punktu"},unique = true)})
public class Punkt {

    @PrimaryKey(autoGenerate = true)
    public int pId;

    @ColumnInfo(name = "nazwa_punktu")
    public String nazwa;

    @ColumnInfo(name = "wspolrzedne_punktu")
    public Wspolrzedne wspolrzedne;

    @ColumnInfo(name = "opis_punktu")
    public String opis;

    @Override
    public String toString() {
        return
                nazwa + '\n' +
                wspolrzedne;
    }

    public Punkt()
    {}

    @Ignore
    public Punkt(String nazwa, Wspolrzedne wspolrzedne, String opis)
    {
        this.nazwa = nazwa;
        this.wspolrzedne = wspolrzedne;
        this.opis =opis;
    }
}
