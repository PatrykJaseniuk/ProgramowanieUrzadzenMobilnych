package com.example.l5kantor.BazaDanych;


import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.Index;
import androidx.room.PrimaryKey;

import com.example.l5kantor.Kernel;
import com.example.l5kantor.Repozitory;

@Entity(indices = {@Index(value = {"nazwa_waluty"},unique = true)})
public class Waluta {

    @PrimaryKey(autoGenerate = true)
    public int wId;

    @ColumnInfo(name = "nazwa_waluty")
    public String nazwaWaluty;

    @ColumnInfo(name = "cena")
    public float cena;

    public Waluta()
    {}


    public Waluta(String nazwaWalut, float cena)
    {
        this.nazwaWaluty = nazwaWalut;
        this.cena = cena;
    }

    @Override
   public String toString()
    {
        return (nazwaWaluty+" kupno:"+ (cena*(1- Kernel.getProwizja())) + "\nsprzedarz: " + cena * (1/(1-Kernel.getProwizja())));
    }
}
