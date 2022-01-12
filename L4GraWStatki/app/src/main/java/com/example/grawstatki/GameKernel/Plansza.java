package com.example.grawstatki.GameKernel;

import android.graphics.Color;

import java.io.Serializable;

public class Plansza implements Serializable {
    public final int height = 10;
    public final int width = 10;
    private Pole plansza[][] = new Pole[width][height];

    Plansza() {
        for (int y = 0; y < height; y++) {
            for (int x = 0; x < width; x++) {
                plansza[x][y] = new Pole();
            }
        }
    }


    public int getKolorPola(int x, int y) {
        return plansza[x][y].color;
    }

    public void setColor(int color, int x, int y) {
        plansza[x][y].color = color;
    }

    public void setCzyStatek(boolean czyStatek,int x,int y)
    {
        plansza[x][y].czyStatek = czyStatek;
    }

    public int getPoleDlaAktualnegoGracza(int x, int y) {
        Pole aktualnePole = plansza[x][y];
        if (aktualnePole.czyStatek) {
            if (aktualnePole.czyTrafiony) {
               return Color.RED;
            }
            else
            {
                return Color.GREEN;
            }
        }
        else if(aktualnePole.czyTrafiony)
        {
            return Color.YELLOW;
        }
        else{
            return Color.BLUE;
        }
    }

    public int getPolePrzeciwnika(int x, int y)
    {
        Pole aktualnePole = plansza[x][y];
        if(aktualnePole.czyTrafiony)
        {
            if(aktualnePole.czyStatek)
            {
                return Color.RED;
            }
            else
            {
                return Color.YELLOW;
            }
        }
        else
        {
            return Color.BLUE;
        }
    }

    public void setCzyOstrzal(boolean b, int x, int y) {
        plansza[x][y].czyTrafiony=b;
    }

    public boolean getCzyStatek(int x, int y) {
        return plansza[x][y].czyStatek;
    }


    class Pole implements Serializable {
        int color = Color.BLUE;
        boolean czyStatek=false;
        boolean czyTrafiony=false;
    }

}
