package com.example.grawstatki.GameKernel;

import android.content.Context;
import android.content.Intent;
import android.os.Environment;

import com.example.grawstatki.Activitis.WelcomeScreenActivity;
import com.example.grawstatki.GameKernel.Stany.RozmieszczanieStatkow;
import com.example.grawstatki.GameKernel.Stany.Stan;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.LinkedList;
import java.util.List;

public class GameCore {


//    public static Plansza planszaGracza1 = new Plansza();

    public static Gracz gracz1 = new Gracz();
    public static Gracz gracz2 = new Gracz();
    public static Gracz aktualnyGracz = gracz1;
    public static Gracz nieaktywnyGracz = gracz2;
    public static Stan stan = new RozmieszczanieStatkow();

//    static Function<Context,Object> stan = context->{placingShipsStartActivity(context); return null;};
////    public static void nextPlayerMove(NextPlayer nextPlayer) {
//
//    }


    public static void nextPlayer(Context context) {
        stan.nextPlayer(context);
    }


//    private static void placingShipsStartActivity(Context context) {
//        context.startActivity(new Intent(context, PlacingShipsActivity.class));
//        stan = c->{ placingShips(c); return null;};
//    }

//    private static void placingShips(Context context) {
//
//    }
//
//    private static void bitwa(Context context) {
//
//    }
//
//    private static void koniec(Context context)
//    {
//
//    }


//    private static void nextPlayer(Context context) {
//
//    }


//    private static void move(Context context) {
//        context.startActivity(new Intent(context, BattleActivity.class));
//    }

//    enum StanGry
//    {
//        ustawianieStatkow,
//        rozgrywka,
//        koniec
//    }
//    static private StanGry stanGry = StanGry.ustawianieStatkow;


//    public static void coverBetweenPlacingShip(AppCompatActivity activity) {
//    }
//
//    public static void placingShipsPlayer2(AppCompatActivity activity) {
//    }
//
//    public static void startBattle(AppCompatActivity activity) {
//    }
//
//    public static void player1PrepareForMove(AppCompatActivity activity) {
//    }
//
//    public static void player1Move(AppCompatActivity activity) {
//    }
//
//    public static void player2PrepareForMove(AppCompatActivity activity) {
//    }
//
//    public static void Player2Move(AppCompatActivity activity) {
//    }
//
//    public static void Finish(AppCompatActivity activity) {
//    }

    public static void buttonClicked(int x, int y) {
//        if(stanGry==StanGry.ustawianieStatkow)
//        {
//            aktualnyGracz.setShip(x,y);
//        }
//        else if(stanGry ==StanGry.rozgrywka)
//        {
//
//        }
        stan.fieldClicked(x, y);
    }

    public static int getColorOfField(int x, int y) {
        return aktualnyGracz.plansza.getKolorPola(x, y);
    }

//    public static void endOfMove(Context context) {
//        if(aktualnyGracz.getPozostalailoscModulowStatkow()<=0)
//        {
//            if(aktualnyGracz==gracz1)
//            {
//                zmianaGracza();
//                context.startActivity(new Intent(context, NextPlayer.class));
//            }
//            else if(aktualnyGracz==gracz2)
//            {
//                zmianaGracza();
//                stanGry = StanGry.rozgrywka;
//                context.startActivity(new Intent(context, NextPlayer.class));
//            }
//        }else if(stanGry == StanGry.ustawianieStatkow)
//        {
//            placingShipsStartActivity(context);
//        }
//        else if(stanGry == StanGry.rozgrywka)
//        {
//            move(context);
//        }
//    }

    public static void zmianaGracza() {
        Gracz pomocniczyZapis = aktualnyGracz;
        aktualnyGracz = nieaktywnyGracz;
        nieaktywnyGracz = pomocniczyZapis;
    }

    public static void menuGlowne(Context context) {
        stan.reset();
        context.startActivity(new Intent(context, WelcomeScreenActivity.class));
    }

    public static void zapisz(Context context, String nazwaZapisu) {
        try {
            FileOutputStream fileOut = context.openFileOutput(nazwaZapisu, context.MODE_PRIVATE);
            ObjectOutputStream out = new ObjectOutputStream(fileOut);
            out.writeObject(new Zapis(gracz1, gracz2, aktualnyGracz, nieaktywnyGracz, stan));
            out.close();
            fileOut.close();
        } catch (Exception i) {
            i.printStackTrace();
        }
        context.getDataDir();
    }

    public static String[] getListaZapisow(Context context) {
        List<String> listaZapisow = new LinkedList<>();
        File storageRoot = context.getDataDir();
        File yourDir = new File(storageRoot, "files");
        for (File f : yourDir.listFiles()) {
            if (f.isFile())
                listaZapisow.add(f.getName());
        }
        return  listaZapisow.toArray(new String[0]);
    }

    public static void wczytaj(Context context, String nazwaZapisu) {

        try {
            FileInputStream fileIn = context.openFileInput(nazwaZapisu);
            ObjectInputStream in = new ObjectInputStream(fileIn);
            Zapis zapis = (Zapis) in.readObject();
            in.close();
            fileIn.close();
            gracz1 = zapis.gracz1;
            gracz2 = zapis.gracz2;
            aktualnyGracz= zapis.aktualnyGracz;
            nieaktywnyGracz = zapis.nieaktywnyGracz;
            stan = zapis.stan;
        } catch (Exception i) {
            i.printStackTrace();
            return;
        }
    }


}
