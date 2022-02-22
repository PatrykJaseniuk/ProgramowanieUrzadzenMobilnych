/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package SerwerPodchody.Kernel;

import SerwerPodchody.Kernel.Kernel;
import SerwerPodchody.Kernel.Punkt;
import SerwerPodchody.ObslugaGracz.Api;
import java.util.Iterator;
import java.util.Timer;
import javax.servlet.http.HttpServletRequest;

/**
 *
 * @author jasyn
 */
public class Gracz
{
    private Czasomierz czasomierz = new Czasomierz();
    public boolean czyZwyciestwo = false;   
    Iterator<Punkt> iteratorListaPunktow;
    public Punkt aktywnyPunkt;
    
    Gracz()
    {        
      iteratorListaPunktow = Kernel.listaPunktow.iterator();
      if(iteratorListaPunktow.hasNext())
      {
          aktywnyPunkt = iteratorListaPunktow.next();
      }
    }   
    
    public void getOdpowiedz(HttpServletRequest request, Api api)
    {             
        float szerokosc = api.getSzerokosc(request);
        float dlugosc = api.getDlugosc(request);
        int nrOdpowiedzi = api.getNrOdpowiedzi(request);
        float odlegloscOdPunktuDocelowego = getOdleglosc(szerokosc,dlugosc,aktywnyPunkt.wspolrzedneSzerokosc,aktywnyPunkt.wspolrzedneDlugosc);
        
        if(aktywnyPunkt ==null)
        {
//            return naglowekGraNieGotowa;
            api.GraNieGotowa();
        }  
        else if(czyZwyciestwo)
        {
            api.zwyciestwo();
        }
        else if(odlegloscOdPunktuDocelowego<Kernel.maksymalnaOdleglosc)
        {
            if(czyOdpowiedzNaPytanie(nrOdpowiedzi))
            {
                OdpowiedzCzyPrawidlowaOdpowiedz(nrOdpowiedzi,api);
            }
            else
            {
               api.Pytanie(aktywnyPunkt.pytanie,aktywnyPunkt.opcjeOdpowiedzi);
            }
        }
        else
        {
            api.wskazowkaLokacji(aktywnyPunkt.wskazowkaLokalizacji);
        }
    }

    private float getOdleglosc(float szerokosc, float dlugosc, float szerokosc2, float dlugosc2)
    {
        float dx = szerokosc-szerokosc2;
        float dy = dlugosc-dlugosc2;
        return Math.abs(dx*dx+dy*dy);
    }

    private boolean czyOdpowiedzNaPytanie(int nrOdpowiedzi)
    {
        if(nrOdpowiedzi>=0&&nrOdpowiedzi<aktywnyPunkt.opcjeOdpowiedzi.size())
        {
            return true;
        }
        else
        {
            return false;
        }            
    }

    private void OdpowiedzCzyPrawidlowaOdpowiedz(int nrOdpowiedzi, Api api)
    {
        int pozostalyCzasOczekiwania = czasomierz.getPozostalyCzasOczekiwania();
        if(pozostalyCzasOczekiwania>0)
        {
//            return naglowekRezultatOdpowiedzi +"\n"+ pozostalyCzasOczekiwania;
            api.pozostalyCzasOczekiwania(pozostalyCzasOczekiwania);
        }
        else if(nrOdpowiedzi == aktywnyPunkt.prawidlowaOdpowiedz)
       {
           if(iteratorListaPunktow.hasNext())
           {
               aktywnyPunkt = iteratorListaPunktow.next();
//               return naglowekRezultatOdpowiedzi+"\n"+"true";
               api.rezultatOdpowiedzi(true,0);
           }
           else
           {
               api.zwyciestwo();
               czyZwyciestwo = true;
//               return naglowekZwyciestwo;
           }          
       }
       else
       {
           czasomierz.czakaj(5);
           api.rezultatOdpowiedzi(false,5);
//       return naglowekRezultatOdpowiedzi+"\n"+"false";       
       }
    }

//    private void generowaniePytania()
//    {
////                      String odpowiedz =naglowekPytanie+"\n"+aktywnyPunkt.pytanie;
////                for(String opcjaOdpowiedzi:aktywnyPunkt.opcjeOdpowiedzi)
////                {
////                    odpowiedz+="\n"+opcjaOdpowiedzi;
////                }
////                return odpowiedz;
//                
//    }
//
//    private String generowanieWskazowkiLokalizacji()
//    {
//        String odpowiedz =naglowekWskazowkaLokalizacji+"\n";
//        odpowiedz+=aktywnyPunkt.wskazowkaLokalizacji;
//        return odpowiedz;
//        
//    }    

//    void getOdpowiedz(int szerokosc, int dlugosc, int nrOdpowiedzi, api api)
//    {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
//    }
}
