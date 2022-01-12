package com.example.grawstatki.GameKernel;

import android.graphics.Color;

import java.io.Serializable;
import java.util.function.BiFunction;

public class Gracz implements Serializable
{
    Gracz()
    {
        id=liczbaGraczy;
        liczbaGraczy++;
    }

   public Plansza plansza = new Plansza();
    public int id;
private static int liczbaGraczy=0;

    public void setShip(int x, int y)
    {
       ustawianieStatku.ustaw( x,y);
    }

    public int getPozostalailoscModulowStatkow() {
        return ustawianieStatku.modulyStatkuDoRozlokowania;
    }

    public boolean ostrzal(int x, int y) {
        plansza.setCzyOstrzal(true,x,y);
        if(plansza.getCzyStatek(x,y))
        {
//            plansza.setColor(Color.RED,x,y);
            modulyStatkuNieZniszczone--;
            return true;
        }
        else
        {
//            plansza.setColor(Color.YELLOW,x,y);
            return false;
        }
    }

    public boolean czyPrzegral() {
        if(modulyStatkuNieZniszczone<=0)
        {
            return true;
        }
        else
        {
            return false;
        }
    }


    public class UstawianieStatku implements Serializable {

        public int getColorProxy(int x, int y, BiFunction<Integer,Integer,Integer> getColor)
        {
            if(x==xPoczatkowe && y==yPoczatkowe)
            {
                return Color.CYAN;
            }
            else
            {
                return getColor.apply(x,y);
            }
        }

        public  void ustaw(int x, int y)
        {
            if(stan == Stan.poczatek)
            {
                xPoczatkowe = x;
                yPoczatkowe = y;
//                plansza.setColor(Color.YELLOW, x, y);
                stan = Stan.koniec;
            }
            else
            {
                if(sprawdzCzyZaznaczeniaSaWLini(xPoczatkowe,yPoczatkowe,x,y))
                {
                    int dlugoscStatku = sprobujNarysowacStatekNaPlanszy(xPoczatkowe,yPoczatkowe,x,y,plansza,modulyStatkuDoRozlokowania);
                    if(dlugoscStatku>0)
                    {
                        modulyStatkuDoRozlokowania-=dlugoscStatku;
                        stan = Stan.poczatek;
                        xPoczatkowe = -1;
                        yPoczatkowe= -1;
                      return;
                    }
                }//                plansza.setColor(Color.BLUE,xPoczatkowe,yPoczatkowe);
                stan = Stan.poczatek;
            }
//            plansza.setColor(Color.YELLOW , x,y);
        }

         private int sprobujNarysowacStatekNaPlanszy(int xPoczatkowe, int yPoczatkowe, int xKoncowe, int yKoncowe, Plansza plansza, int modulyStatkuDoRozlokowania) {
            int dlugoscX = Math.abs(xKoncowe-xPoczatkowe );
            int dlugoscY = Math.abs(yKoncowe-yPoczatkowe);

            if(dlugoscX<=modulyStatkuDoRozlokowania && dlugoscY<=modulyStatkuDoRozlokowania)
            {
                int krokX = uzyskajKierunekPrzesuwania(xKoncowe,xPoczatkowe);
                int krokY = uzyskajKierunekPrzesuwania(yKoncowe,yPoczatkowe);
                int xAktualne = xPoczatkowe;
                int yAktualne = yPoczatkowe;
                while (xAktualne!= xKoncowe)
                {
//                    plansza.setColor(Color.GREEN,xAktualne,yAktualne);
                    plansza.setCzyStatek(true,xAktualne,yAktualne);
                    xAktualne += krokX;
                }
                while (yAktualne != yKoncowe)
                {
                    plansza.setCzyStatek(true,xAktualne,yAktualne);
                    yAktualne+=krokY;
                }

//                plansza.setColor(Color.GREEN, xKoncowe, yKoncowe );

                return dlugoscX+dlugoscY;
            }
            return 0;
         }

        private int uzyskajKierunekPrzesuwania(int xPoczatkowe, int xKoncowe) {
            int przesuniecie = xPoczatkowe - xKoncowe;
            if(przesuniecie>0)
            {
                return 1;
            }
            else if(przesuniecie<0)
            {
                return -1;
            }
            else
            {
                return 0;
            }
        }

        private boolean sprawdzCzyZaznaczeniaSaWLini(int xPoczatkowe, int yPoczatkowe, int x, int y) {

            if(xPoczatkowe == x || yPoczatkowe == y)
            {
                return true;
            }
            else
            {
                return false;
            }
        }


         private int xPoczatkowe=-1,yPoczatkowe=-1;
                 public int modulyStatkuDoRozlokowania=10;

        private  Stan stan = Stan.poczatek;

    }
    enum Stan {
    poczatek,
    koniec;
}

public UstawianieStatku ustawianieStatku = new UstawianieStatku();
    public int modulyStatkuNieZniszczone = ustawianieStatku.modulyStatkuDoRozlokowania;
}
