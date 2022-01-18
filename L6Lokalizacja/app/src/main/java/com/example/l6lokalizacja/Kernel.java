package com.example.l6lokalizacja;

import android.content.Context;

import com.example.l6lokalizacja.DataBase.Punkt;
import com.example.l6lokalizacja.DataBase.Wspolrzedne;

import java.util.LinkedList;
import java.util.List;

public class Kernel {
    public static List<Punkt> getListaPunktow(float odleglosc) {
        List<Punkt> wszystkiePunkty = Repozytorium.getWszystkiePunkty();
        List<Punkt> punktyWOdpowiedniejOdleglosci = getPunktuWOdleglosci(odleglosc, wszystkiePunkty);
        return punktyWOdpowiedniejOdleglosci;
    }

    public static String getOpisPunktu(Punkt punkt) {
        return Repozytorium.getOpisPunktu(punkt);
    }

    public static void inicjalizuj(Context context) {
//        Lokalizacja.inicjalizuj(context);
        Repozytorium.inicjalizuj(context);
        Repozytorium.insert(new Punkt("Nysa", new Wspolrzedne(11, 9), "Moje Miasto"));
        Repozytorium.insert(new Punkt("Wroclaw", new Wspolrzedne(20, 20), "Duze Miasto"));
        Repozytorium.insert(new Punkt("Opolw", new Wspolrzedne(15, 12), "Srednie miasto"));
        Repozytorium.insert(new Punkt("Grodkow", new Wspolrzedne(8, 8), "Male miasto"));

    }

    private static List<Punkt> getPunktuWOdleglosci(float zadanaOdleglosc, List<Punkt> wszystkiePunkty) {
        List<Punkt> punktyWOdpowiedniejOdleglosci = new LinkedList<Punkt>();
        Wspolrzedne mojeWspolrzedne = Lokalizacja.getWspolrzedne();
        for (Punkt punkt : wszystkiePunkty) {
            float odleglosc = mojeWspolrzedne.odleglosc(punkt.wspolrzedne);
            if (odleglosc < zadanaOdleglosc) {
                punktyWOdpowiedniejOdleglosci.add(punkt);
            }
        }
        return punktyWOdpowiedniejOdleglosci;
    }
}


