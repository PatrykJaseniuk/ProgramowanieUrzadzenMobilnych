package com.example.l5kantor;

import android.content.Context;

import androidx.room.Room;

import com.example.l5kantor.BazaDanych.AppDatabase;
import com.example.l5kantor.BazaDanych.Waluta;
import com.example.l5kantor.BazaDanych.WalutaDAO;

import java.util.List;

public class Repozitory {

    public Repozitory(Context context)
    {
        AppDatabase appDataBase = Room.databaseBuilder(context.getApplicationContext(),AppDatabase.class, "kantor").build();
        walutaDAO =appDataBase.walutaDao();
    }

    private WalutaDAO walutaDAO;

    public float getCena(String waluta) {
        return walutaDAO.getCenaWaluty(waluta);
    }

    public float getProwizja() {
        return (float)0.05;
    }

    public void putWaluta(String nazwa, float cena)
    {
        Waluta nowaWaluta = new Waluta(nazwa, cena);
        try
        {walutaDAO.insert(nowaWaluta);

        }catch(Exception e )
        {
        }

    }

    public List<Waluta> getAll()
    {
        return walutaDAO.getAll();
    }




}
