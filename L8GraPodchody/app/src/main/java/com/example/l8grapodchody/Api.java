package com.example.l8grapodchody;

import java.io.BufferedReader;
import java.util.LinkedList;
import java.util.List;

public class Api {

    private final String adresUrl = "http://172.30.253.148:8080/L7Serwerpodchody/ObslugaGracza";
    private final String nazwaParametruIdGracza = "idGracza";
    private final String nazwaParametruSzerokosc = "szerokosc";
    private final String nazwaParametruDlugosc = "dlugosc";
    private final String nazwaParametruNrOdpowiedzi = "nrOdpowiedzi";

    private final String naglowekPytanie = "pytanie";
    private final String naglowekRezultatOdpowiedzi = "rezultatOdpowiedzi";
    private final String naglowekWskazowkaLokalizacji = "wskazowkaLokalizacji";
    private final String naglowekGraNieGotowa = "graNieGotowa";
    private final String naglowekZwyciestwo = "zwyciestwo";
    private final String naglowekNieprawidloweId = "nieprawidloweId";
    private final String prawidlowaOdpowiedz = "true";
    private final String niePrawidlowaOdpowiedz = "false";


    public String rzadanieCzywlasciweId(int idGracza) {
        String rzadanie = adresUrl +"?"+nazwaParametruIdGracza+"="+idGracza;
        return rzadanie;
    }

    public boolean odczytCzywlasciweId(BufferedReader odpowiedz) {
        String naglowek="";
        try
        {
            naglowek = odpowiedz.readLine();
            odpowiedz.close();
        }catch(Exception e)
        {}

       if(naglowekPytanie.equals(naglowek) || naglowekWskazowkaLokalizacji.equals(naglowek))
       {
           return true;
       }
        else
       {
           return false;
       }
    }

    public String rzadanieUzyskajPytanieLubWskazowke(int idGracza, Wspolrzedne aktualneWspolrzedne) {
        String rzadanie = adresUrl +"?"+nazwaParametruIdGracza+"="+idGracza+
                "&"+nazwaParametruDlugosc+"="+aktualneWspolrzedne.dlugosc+
                "&"+nazwaParametruSzerokosc+"="+aktualneWspolrzedne.szerokosc;
        return rzadanie;
    }

    public Object odczytWskazowkaLubPytanie(BufferedReader odpowiedz) {
        Object pytanieLubWskazowka=null;
        try
        {
            String naglowek = odpowiedz.readLine();
            if(naglowekPytanie.equals(naglowek))
            {
                String trescPytanie = odpowiedz.readLine();
                List<String> opcjeOdpowiedzi = new LinkedList<>();
                String opcja="";
                while((opcja = odpowiedz.readLine())!=null)
                {
                    opcjeOdpowiedzi.add(opcja);
                }
               pytanieLubWskazowka = new Pytanie(trescPytanie,opcjeOdpowiedzi);

            }else if(naglowekWskazowkaLokalizacji.equals(naglowek))
            {
                pytanieLubWskazowka = odpowiedz.readLine();
            }
            odpowiedz.close();
        }catch(Exception e)
        {}
        return pytanieLubWskazowka;
    }

    public String rzadanieWynikOdpowiedzi(int idGracza, Wspolrzedne aktualneWspolrzedne, int nrOpcjiOdpowiedzi) {
        String rzadanie = adresUrl +
                "?"+nazwaParametruIdGracza+"="+idGracza+
                "&"+nazwaParametruDlugosc+"="+aktualneWspolrzedne.dlugosc+
                "&"+nazwaParametruSzerokosc+"="+aktualneWspolrzedne.szerokosc+
                "&"+nazwaParametruNrOdpowiedzi+"="+nrOpcjiOdpowiedzi;
        return rzadanie;
    }

    public Odpowiedz odczytWynikuOdpowiedzi(BufferedReader odpowiedz) {
        Odpowiedz wynikOdpowiedzi =new Odpowiedz();
        try
        {
            String naglowek = odpowiedz.readLine();
            if(naglowekRezultatOdpowiedzi.equals(naglowek))
            {
                String rezultatOdpowiedzi = odpowiedz.readLine();
                if(prawidlowaOdpowiedz.equals(rezultatOdpowiedzi))
                {
                    wynikOdpowiedzi.czyPrawidlowaOdpowiedz=true;
                }else if (niePrawidlowaOdpowiedz.equals(rezultatOdpowiedzi))
                {
                    wynikOdpowiedzi.czyPrawidlowaOdpowiedz = false;
                    String czasOczekiwania = odpowiedz.readLine();
                    wynikOdpowiedzi.czasOczekiwania =Integer.valueOf(czasOczekiwania);
                }
            }
            else if(naglowekZwyciestwo.equals(naglowek))
            {
                wynikOdpowiedzi.czyZwyciestwoGry= true;
            }

            odpowiedz.close();
        }catch(Exception e)
        {
            return null;
        }
        return wynikOdpowiedzi;
    }
}
