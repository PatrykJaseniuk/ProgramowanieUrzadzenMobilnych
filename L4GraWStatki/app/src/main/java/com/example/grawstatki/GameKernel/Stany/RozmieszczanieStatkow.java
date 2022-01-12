package com.example.grawstatki.GameKernel.Stany;

import android.content.Context;
import android.content.Intent;

import com.example.grawstatki.GameKernel.GameCore;
import com.example.grawstatki.Activitis.PlacingShipsActivity;
import com.example.grawstatki.Activitis.ZaslonaActivity;

public class RozmieszczanieStatkow implements Stan
{
boolean czyWyswietlonoZaslone = false;
    @Override
    public void nextPlayer(Context context) {
        if(czyWyswietlonoZaslone)
        {
            if(GameCore.aktualnyGracz.getPozostalailoscModulowStatkow()<=0)
            {
                if(GameCore.aktualnyGracz==GameCore.gracz1)
                {
//                    context.startActivity(new Intent(context, ZaslonaActivity.class));
//                stan = c ->{nextPlayer(c); return null;};
                }
                else if(GameCore.aktualnyGracz==GameCore.gracz2)
                {
//                    GameCore.zmianaGracza();
                    GameCore.stan = new Bitwa();

                }
                GameCore.zmianaGracza();
//                GameCore.stan = new Bitwa();
                czyWyswietlonoZaslone =false;
                context.startActivity(new Intent(context, ZaslonaActivity.class));
            }
        }
        else
        {
            czyWyswietlonoZaslone = true;
            context.startActivity(new Intent(context, PlacingShipsActivity.class));
        }

    }

    @Override
    public void fieldClicked(int x, int y) {
        GameCore.aktualnyGracz.setShip(x,y);
    }

    @Override
    public void reset() {
        czyWyswietlonoZaslone = false;
    }
}
