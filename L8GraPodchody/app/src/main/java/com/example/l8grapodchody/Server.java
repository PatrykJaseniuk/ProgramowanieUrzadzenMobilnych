package com.example.l8grapodchody;

import android.util.Log;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class Server {

    Api api = new Api();

    public boolean sprawdzId(int idGracza) {

        String rzadanie = api.rzadanieCzywlasciweId(idGracza);
        BufferedReader odpowiedz = uzyskajOdpowiecZSerwera(rzadanie);
        boolean czyWlasciweId = api.odczytCzywlasciweId(odpowiedz);
        return czyWlasciweId;
    }

    public Object getWskazowkaLubPytanie(int idGracza, Wspolrzedne aktualneWspolrzedne) {

        String rzadanie= api.rzadanieUzyskajPytanieLubWskazowke(idGracza,aktualneWspolrzedne);
        BufferedReader odpowiedz = uzyskajOdpowiecZSerwera(rzadanie);
        Object wskazowkaLubPytanie = api.odczytWskazowkaLubPytanie(odpowiedz);

//        Pytanie pytanie =new Pytanie();
//        pytanie.trescPytania="Witam panstwa";
//        pytanie.listaOpcjiOdpowiedzi = new ArrayList<>();
//        pytanie.listaOpcjiOdpowiedzi.add("opcaj 1");
//        pytanie.listaOpcjiOdpowiedzi.add("opcaj 2");
//        pytanie.listaOpcjiOdpowiedzi.add("opcaj 3");
        return wskazowkaLubPytanie;
    }

    public Odpowiedz odpowiedz(int idGracza, Wspolrzedne aktualneWspolrzedne,int nrOpcjiOdpowiedzi) {
        String rzadanie= api.rzadanieWynikOdpowiedzi(idGracza,aktualneWspolrzedne,nrOpcjiOdpowiedzi);
        BufferedReader odpowiedz = uzyskajOdpowiecZSerwera(rzadanie);
        Odpowiedz wynikOdpowiedzi = api.odczytWynikuOdpowiedzi(odpowiedz);
        return wynikOdpowiedzi;
    }

    private BufferedReader uzyskajOdpowiecZSerwera(String rzadanie) {
        int kodOdpowiedzi=0;
        BufferedReader obslugaBufora =null;
        try
        {
            URL url= new URL(rzadanie);
            HttpURLConnection polaczenie = (HttpURLConnection) url.openConnection();
            polaczenie.connect();
            kodOdpowiedzi = polaczenie.getResponseCode();
            InputStreamReader czytnikStrumieniaWejsciowego= new InputStreamReader(polaczenie.getInputStream());
            obslugaBufora = new BufferedReader(czytnikStrumieniaWejsciowego);
        }
        catch(Exception e)
        {
            Log.d("WEB","Blad Poloczenia\nkod odpowiedzi: "+e.getMessage());
        }
        return obslugaBufora;
    }
}
