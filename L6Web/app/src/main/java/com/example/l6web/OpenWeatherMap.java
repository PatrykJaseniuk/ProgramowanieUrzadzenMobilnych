package com.example.l6web;

import android.util.Log;

import java.io.BufferedReader;
import java.io.Console;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class OpenWeatherMap {


    public static String getJsonDlaMiasta(String nazwaMiasta) {

        int kodOdpowiedzi=0;
        String json=null;
        try
        {
            URL url=getUrl(nazwaMiasta);
            HttpURLConnection polaczenie = (HttpURLConnection) url.openConnection();
            polaczenie.connect();
            kodOdpowiedzi = polaczenie.getResponseCode();
            json = odczytajOdpowiedzPolaczenia(polaczenie);
        }
        catch(Exception e)
        {
            Log.d("WEB","Blad Poloczenia\nkod odpowiedzi: "+kodOdpowiedzi);
        }
        return json;
    }

    private static String odczytajOdpowiedzPolaczenia(HttpURLConnection polaczenie) throws IOException {
        InputStreamReader czytnikStrumieniaWejsciowego= new InputStreamReader(polaczenie.getInputStream());
        BufferedReader obslugaBufora = new BufferedReader(czytnikStrumieniaWejsciowego);
        String wiersz="";
        String json="";
        while ((wiersz = obslugaBufora.readLine())!=null)
        {
            json+=wiersz;
        }
        obslugaBufora.close();
        return json;
    }

    private static URL  getUrl(String nazwaMiasta) throws MalformedURLException {
        URL url = new URL(adres +""+nazwaMiasta+"&appid="+apiKey);
        return url;
    }
    private static final String adres ="https://api.openweathermap.org/data/2.5/weather?units=metric&lang=pl&q=";
    private static final String apiKey = "4acb94f726a6db9004d60f636758b2bf";
}
