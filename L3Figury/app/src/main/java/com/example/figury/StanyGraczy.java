package com.example.figury;

import android.content.SharedPreferences;

import com.example.figury.Activities.WyborGracza;
import com.example.figury.figury.Figura;
import com.example.figury.figury.Kolo;
import com.example.figury.figury.Kwadrat;
import com.example.figury.figury.Prostokat;
import com.example.figury.figury.Rownoleglobok;
import com.example.figury.figury.Trapez;
import com.example.figury.figury.TrojkatProstokatny;
import com.example.figury.figury.TrojkatRownoboczny;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class StanyGraczy {
    public static void odgadnietoFigure(Class<? extends Figura> aClass) {
        listaGraczy.get(aktualnyGracz).dodajZaliczonaFigure(aClass);
    }

    public static String[] getListaGraczy() {
        String listaImionGraczy[] = new String[listaGraczy.size()];
        for (int i = 0; i < listaGraczy.size(); i++) {
            listaImionGraczy[i] = listaGraczy.get(i).imie;
        }
        return listaImionGraczy;
    }

    public static void aktywujGracza(int idGracza) {
        if (idGracza >= 0 && idGracza < listaGraczy.size()) {
            aktualnyGracz = idGracza;
        }
    }

    public static void dodajGracza(String nazwaGracza) {
        if (!czyGraczOtakiejNazwieJuzIstnieje(nazwaGracza)) {
            listaGraczy.add(new Gracz(nazwaGracza));
        }
    }

    static private List<Gracz> listaGraczy = new LinkedList<Gracz>();
    static private int aktualnyGracz;

    private static boolean czyGraczOtakiejNazwieJuzIstnieje(String nazwaGracza) {
        boolean czyIstniejeTakaNazwa = false;
        for (Gracz gracz : listaGraczy) {
            if (gracz.imie.equals(nazwaGracza))
            {
                return true;
            }
        }
        return false;
    }

    public static boolean czyFiguraDostepna(Class<? extends Figura> aClass) {
        return listaGraczy.get(aktualnyGracz).listaFigurDostepnychDoZaliczenia.contains(aClass);
    }

    public static void wczytajZPreferencji(WyborGracza wyborGracza) {
        SharedPreferences stanyGraczy = wyborGracza.getSharedPreferences("StanyGraczy",0);
        Map<String,?> mapaStanow = stanyGraczy.getAll();
        for (Map.Entry<String, ?> entry : mapaStanow.entrySet()) {

            Class<?extends Figura> ostatniaDostepnaFigura = uzyskajKlase(entry.getValue());
//            dodajGracza();
            if(!czyGraczOtakiejNazwieJuzIstnieje(entry.getKey()))
            {
                Gracz nowyGracz = new Gracz(entry.getKey(),ostatniaDostepnaFigura);
                listaGraczy.add(nowyGracz);
            }
        }
    }

    public static void zapiszDoPreferencji(WyborGracza wyborGracza) {
        SharedPreferences stanyGraczy = wyborGracza.getSharedPreferences("StanyGraczy",0);
        SharedPreferences.Editor editor = stanyGraczy.edit();
        for (Gracz gracz: listaGraczy  ) {
            editor.putString(gracz.imie, gracz.ostatniaDostepnaFigura.toString());
        }
        editor.commit();
    }

    private static Class<? extends Figura> uzyskajKlase(Object value) {
        String nazwa = (String)value;
        if(nazwa.equals(Prostokat.class.toString()))
        {
            return Prostokat.class;
        }
        else if(nazwa.equals(Kolo.class.toString()))
        {
            return Kolo.class;
        }
        else if(nazwa.equals(Kwadrat.class.toString()))
        {
            return Kwadrat.class;
        }
        else if(nazwa.equals(Rownoleglobok.class.toString()))
        {
            return Rownoleglobok.class;
        }
        else if(nazwa.equals(Trapez.class.toString()))
        {
            return Trapez.class;
        }
        else if(nazwa.equals(TrojkatProstokatny.class.toString()))
        {
            return TrojkatProstokatny.class;
        }
        else if(nazwa.equals(TrojkatRownoboczny.class.toString()))
        {
            return TrojkatRownoboczny.class;
        }
        return null;
    }



//    public static void wczytajZPreferencji()
//    {
//        SharedPreferences ustawienia = this.getSharedPreferences("",0);
//        String NazwaOstatniejZaliczonejFigury =
//    }


    static public class Gracz {


        Gracz(String imie) {
            this.imie = imie;
            id = liczbaGraczy++;
            ustawianieKolejnosci(mapaKolejnychFigurDoZaliczenia);
            listaFigurDostepnychDoZaliczenia.add(Prostokat.class);

        }
        Gracz(String imie, Class<? extends Figura> OstatniaZaliczonaFigura)
        {
            this.imie = imie;
            id = liczbaGraczy++;
            ustawianieKolejnosci(mapaKolejnychFigurDoZaliczenia);
            listaFigurDostepnychDoZaliczenia.add(Prostokat.class);

            ustawZaliczoneFigury(OstatniaZaliczonaFigura);

        }

        private void ustawZaliczoneFigury(Class<? extends Figura> ostatniaDostepnaFigura) {
            this.ostatniaDostepnaFigura = ostatniaDostepnaFigura;
            Class<? extends Figura> figuraDoDodania =ostatniaDostepnaFigura;
            if(!Prostokat.class.toString().equals(figuraDoDodania.toString()))
            {
                do {
                    listaFigurDostepnychDoZaliczenia.add(figuraDoDodania);
                    figuraDoDodania = getKey(mapaKolejnychFigurDoZaliczenia,figuraDoDodania);
                }while(!Prostokat.class.toString().equals(figuraDoDodania.toString()));
            }
        }

        public <K, V> K getKey(Map<K, V> map, V value) {
            for (Map.Entry<K, V> entry : map.entrySet()) {
                if (entry.getValue().equals(value)) {
                    return entry.getKey();
                }
            }
            return null;
        }

        private void ustawianieKolejnosci(Map<Class<? extends Figura>, Class<? extends Figura>> mapaKolejnychFigurDoZaliczenia) {
            mapaKolejnychFigurDoZaliczenia.put(Prostokat.class, Kwadrat.class);
            mapaKolejnychFigurDoZaliczenia.put(Kwadrat.class, TrojkatProstokatny.class);
            mapaKolejnychFigurDoZaliczenia.put(TrojkatProstokatny.class, TrojkatRownoboczny.class);
            mapaKolejnychFigurDoZaliczenia.put(TrojkatRownoboczny.class, Kolo.class);
            mapaKolejnychFigurDoZaliczenia.put(Kolo.class, Trapez.class);
            mapaKolejnychFigurDoZaliczenia.put(Trapez.class, Rownoleglobok.class);
        }
        Class<? extends Figura> ostatniaDostepnaFigura = Prostokat.class;
        static int liczbaGraczy = 0;
        String imie;
        int id;
        List<Class<? extends Figura>> listaFigurDostepnychDoZaliczenia = new LinkedList<Class<? extends Figura>>();
        Map<Class<? extends Figura>, Class<? extends Figura>> mapaKolejnychFigurDoZaliczenia = new HashMap<Class<? extends Figura>, Class<? extends Figura>>();

        void dodajZaliczonaFigure(Class<? extends Figura> figura) {
            Class<? extends Figura> kolejnaFigura = mapaKolejnychFigurDoZaliczenia.get(figura);
            listaFigurDostepnychDoZaliczenia.add(kolejnaFigura);
            ostatniaDostepnaFigura = kolejnaFigura;
        }
    }
}
