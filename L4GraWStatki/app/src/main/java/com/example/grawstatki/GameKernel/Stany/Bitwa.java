package com.example.grawstatki.GameKernel.Stany;

import android.content.Context;
import android.content.Intent;

import com.example.grawstatki.GameKernel.GameCore;
import com.example.grawstatki.Activitis.BattleActivity;
import com.example.grawstatki.Activitis.KoniecActivity;
import com.example.grawstatki.Activitis.ZaslonaActivity;

public class Bitwa implements Stan {
    boolean czyTrafiono = true;
    boolean czyWyswietlonoZaslone = false;
//    boolean czyKoniec = false;
//    Context context;
//    MediaPlayer mp = new MediaPlayer()

    @Override
    public void nextPlayer(Context context) {
        if(GameCore.nieaktywnyGracz.czyPrzegral())
        {
            context.startActivity(new Intent(context, KoniecActivity.class));
        }
        else
        {
            if(czyWyswietlonoZaslone)
            {
                if(!czyTrafiono)
                {
//                    MediaPlayer mp = new MediaPlayer()
                    czyTrafiono=true;
                    GameCore.zmianaGracza();
                    czyWyswietlonoZaslone =false;
                    context.startActivity(new Intent(context, ZaslonaActivity.class));
                }
            }
            else
            {
                czyWyswietlonoZaslone =true;
                context.startActivity(new Intent(context, BattleActivity.class));
            }
        }


    }

    @Override
    public void fieldClicked(int x, int y) {
        if(czyTrafiono) {
            czyTrafiono = GameCore.nieaktywnyGracz.ostrzal( x, y);
            if(czyTrafiono)
            {
                BattleActivity.mpStrzalWStatek.start();
            }
            else
            {
                BattleActivity.mpStrzalWWode.start();
            }
        }
    }

    @Override
    public void reset() {

//         czyTrafiono = true;
         czyWyswietlonoZaslone = false;
    }
}
