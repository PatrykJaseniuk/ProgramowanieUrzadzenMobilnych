package com.example.l5kantor;

import android.content.Context;
import android.content.Intent;

import androidx.lifecycle.MutableLiveData;

import com.example.l5kantor.Activities.LogowanieActivity;
import com.example.l5kantor.Activities.WprowadzanieWalutyActivity;
import com.example.l5kantor.Activities.WybierzWaluteActivity;
import com.example.l5kantor.BazaDanych.Waluta;

import java.util.List;

public class Kernel {

    public static Waluta walutaDoWymiany= new Waluta(), walutaDoOtrzymania = new Waluta(), aktywanaWaluta;

    private static MutableLiveData<Float> liveDataIloscPieniedzy1, iloscPIeniedzy2;




    public static void inicjalizujBazeDanych(Context context) {
        new InicjalizujBazeDanych(context).start();
    }


    public static float getIloscPieniedzyDoOtrzymania(float iloscPieniedzyDoWymiany) {
        if (walutaDoWymiany != null && walutaDoOtrzymania != null) {
            float cenaWalutaDoWymiany = walutaDoWymiany.cena;
            float cenaWalutaDoOtrzymania = walutaDoOtrzymania.cena;
            float prowizja = repozitory.getProwizja();
            float zlotowki = iloscPieniedzyDoWymiany * cenaWalutaDoWymiany;
            float iloscPieniedzyDoOtzrymania = zlotowki / cenaWalutaDoOtrzymania;
            float iloscPieniedzyPoOdliczeniuProwizji = iloscPieniedzyDoOtzrymania * (1 - prowizja);
            return iloscPieniedzyPoOdliczeniuProwizji;
        } else return 0;
    }

    public static void wybierzWaluteDoKupna(Context context) {
        aktywanaWaluta = walutaDoOtrzymania;
        context.startActivity(new Intent(context, WybierzWaluteActivity.class));
    }

    public static void wybierzWaluteDoSprzedania(Context context) {
        aktywanaWaluta = walutaDoWymiany;
        context.startActivity(new Intent(context, WybierzWaluteActivity.class));
    }

    public static void wyswietlTabeleKursow(Context context) {
    }

    public static void wyswietlAdmin(Context context) {
        context.startActivity(new Intent(context,LogowanieActivity.class));
    }


    public static Repozitory repozitory;

    public static List<Waluta> getWszystkieWaluty() {
        return repozitory.getAll();
    }

    public static void setWaluta(Waluta wybranaWaluta) {
        aktywanaWaluta.nazwaWaluty = wybranaWaluta.nazwaWaluty;
        aktywanaWaluta.cena = wybranaWaluta.cena;
    }

    public static float getProwizja() {
        return repozitory.getProwizja();
    }

    public static void zaloguj(Context context, String podaneHaslo) {
        if(haslo.equals(podaneHaslo))
        {
            context.startActivity(new Intent(context, WprowadzanieWalutyActivity.class));
        }
    }

    static private String haslo = "admin";

    public static void dodajWalute(String nazwa, float cena) {
        Thread t = new Thread(){
            @Override
            public void run() {
                repozitory.putWaluta(nazwa,cena);
            }
        };
        t.start();
    }
}
