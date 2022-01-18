package com.example.l6lokalizacja;

import android.content.Context;
import android.widget.Toast;

import androidx.room.Room;

import com.example.l6lokalizacja.DataBase.AppDatabase;
import com.example.l6lokalizacja.DataBase.Punkt;
import com.example.l6lokalizacja.DataBase.PunktDAO;

import java.util.List;

public class Repozytorium {
    private static PunktDAO punktDao;

    public static void inicjalizuj(Context context) {
        AppDatabase appDataBase = Room.databaseBuilder(context.getApplicationContext(),AppDatabase.class, "kantor").build();
        punktDao =appDataBase.punktDao();
    }
    public static List<Punkt> getWszystkiePunkty() {
        return punktDao.getAll();
    }

    public static String getOpisPunktu(Punkt punkt)
    {
        return punktDao.getOpis(punkt.pId);
    }

    public static void insert(Punkt nowyPunkt)
    {
        try{
            punktDao.insert(nowyPunkt);
        }catch (Exception e)
        { }
    }
}
