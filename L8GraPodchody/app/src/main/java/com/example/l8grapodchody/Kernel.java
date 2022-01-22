package com.example.l8grapodchody;

import android.content.Context;
import android.content.Intent;

import com.example.l8grapodchody.StanyActivity.Pytanie.PytanieActivity;
import com.example.l8grapodchody.StanyActivity.RezultatOdpowiedziActivity;
import com.example.l8grapodchody.StanyActivity.WskazowkaActivity;
import com.example.l8grapodchody.StanyActivity.ZwyciestwoActiviyt;

public class Kernel {

    private static int idGracza;
    private static Server server;
    private static Lokalizacja lokalizacja;
    public static String wskazowka;
    public static Pytanie pytanie;
    public static Odpowiedz rezultatOdpowiedz;
    static Wspolrzedne aktualneWspolrzedne;

    public static void inicjalizjuLokalizacje(Context context)
    {
        if(lokalizacja ==null)
        {
            lokalizacja = new Lokalizacja(context);
        }
    }


    public static boolean logowanieDoGry(Context context,int idGracza) {
        if(server ==null)
        {
            server = new Server();
        }
        boolean czyOK= server.sprawdzId(idGracza);
        if(czyOK)
        {
            Kernel.idGracza = idGracza;
            rozpocznijWzkazowkaLubPytanie(context);
            return true;
        }
        else
        {
            return false;
        }
    }

    public static void rozpocznijWzkazowkaLubPytanie(Context context) {
       aktualneWspolrzedne = lokalizacja.getAktualneWsporzedne();

        Object wskazowkaLubPytanie = server.getWskazowkaLubPytanie(idGracza,aktualneWspolrzedne);
        if(wskazowkaLubPytanie.getClass() == Pytanie.class)
        {
            pytanie = (Pytanie)wskazowkaLubPytanie;
            context.startActivity(new Intent(context, PytanieActivity.class));
        }
        else
        {
            wskazowka = (String)wskazowkaLubPytanie;
            context.startActivity(new Intent(context, WskazowkaActivity.class));
        }
    }

    public static void odpowiedz(Context context,int nrOpcjiOdpowiedzi) {

        rezultatOdpowiedz = server.odpowiedz(idGracza, aktualneWspolrzedne, nrOpcjiOdpowiedzi);

        if(rezultatOdpowiedz.czyZwyciestwoGry)
        {
            context.startActivity(new Intent(context, ZwyciestwoActiviyt.class));
        }
        else
        {
            context.startActivity(new Intent(context, RezultatOdpowiedziActivity.class));
        }
    }
}
