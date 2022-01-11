package com.example.grawstatki.GameKernel;

import android.content.Context;

import com.example.grawstatki.GameKernel.Stany.RozmieszczanieStatkow;
import com.example.grawstatki.GameKernel.Stany.Stan;

public class GameCore {


//    public static Plansza planszaGracza1 = new Plansza();

    public  static Gracz gracz1 = new Gracz();
    public static Gracz gracz2  = new Gracz();
    public static Gracz aktualnyGracz= gracz1;
    public static Gracz nieaktywnyGracz = gracz2;
    public static Stan stan = new RozmieszczanieStatkow();

//    static Function<Context,Object> stan = context->{placingShipsStartActivity(context); return null;};
////    public static void nextPlayerMove(NextPlayer nextPlayer) {
//
//    }




    public static void nextPlayer(Context context)
    {
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
        stan.fieldClicked(x,y);
    }

    public static int getColorOfField(int x, int y)
    {
         return aktualnyGracz.plansza.getKolorPola(x,y);
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

    public static void zmianaGracza()
    {
        Gracz pomocniczyZapis = aktualnyGracz;
        aktualnyGracz=nieaktywnyGracz;
        nieaktywnyGracz = pomocniczyZapis;
    }

}
