/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package SerwerPodchody.ObslugaGracz;

import Widok.Input;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author jasyn
 */
public class Api
{
    private final String nazwaParametruIdGracza = "idGracza";
    private final String nazwaParametruSzerokosc = "szerokosc";
    private final String nazwaParametruDlugosc = "dlugosc";
    private final String nazwaParametruNrOdpowiedzi = "nrOdpowiedzi";

    private final String naglowekPytanie = "pytanie";
    private final String naglowekRezultatOdpowiedzi = "rezultatOdpowiedzi";
    private final String naglowekWskazowkaLokalizacji = "wskazowkaLokalizacji";
    private final String naglowekGraNieGotowa = "graNieGotowa";
    private final String naglowekZwyciestwo = "zwyciestwo";
    private final String naglowekNieprawidloweId = "nieprawidloweId";
    private final String prawidlowaOdpowiedz = "true";
    private final String niePrawidlowaOdpowiedz = "false";
    
    private  String odpowiedz;
    

    public int getIdGracza(HttpServletRequest request)
    {
        int id = -1;
        try
        {
            id = Integer.valueOf(request.getParameter(nazwaParametruIdGracza));
        } catch (Exception e)
        {

        }
        return id;
    }

    public float getSzerokosc(HttpServletRequest request)
    {
        float szerokosc = -1000;
        try
        {
            szerokosc = Float.valueOf(request.getParameter(nazwaParametruSzerokosc));
        } catch (Exception e)
        {
        }
        return szerokosc;
    }

    public float getDlugosc(HttpServletRequest request)
    {
        float dlugosc = -1000;
        try
        {
            dlugosc = Float.valueOf(request.getParameter(nazwaParametruDlugosc));
        } catch (Exception e)
        {
        }
        return dlugosc;
    }

    public int getNrOdpowiedzi(HttpServletRequest request)
    {
        int nrOdpowiedzi = -1000;
        try
        {
            nrOdpowiedzi = Integer.valueOf(request.getParameter(nazwaParametruNrOdpowiedzi));
        } catch (Exception e)
        {
        }
        return nrOdpowiedzi;
    }

    public void GraNieGotowa()
    {
         odpowiedz = naglowekGraNieGotowa;
    }

    public void pozostalyCzasOczekiwania(int pozostalyCzasOczekiwania)
    {
         odpowiedz = naglowekRezultatOdpowiedzi +
                  "\n"+niePrawidlowaOdpowiedz+
                   "\n"+ pozostalyCzasOczekiwania;
    }

    public void rezultatOdpowiedzi(boolean czyPoprawnaOdpowiedz, int pozostalyCzasOczekiwania)
    {
       if(czyPoprawnaOdpowiedz)
       {
           odpowiedz = naglowekRezultatOdpowiedzi+
                   "\n"+prawidlowaOdpowiedz;
       }
       else
       {
           odpowiedz = naglowekRezultatOdpowiedzi+
                   "\n"+niePrawidlowaOdpowiedz+
                   "\n"+ pozostalyCzasOczekiwania;
       }
    }

    public void zwyciestwo()
    {
        odpowiedz = naglowekZwyciestwo;
    }

    public void Pytanie(String pytanie, List<String> opcjeOdpowiedzi)
    {
        odpowiedz =naglowekPytanie+"\n"+pytanie;
                for(String opcjaOdpowiedzi:opcjeOdpowiedzi)
                {
                    odpowiedz+="\n"+opcjaOdpowiedzi;
                }                
    }

    public void wskazowkaLokacji(String wskazowkaLokalizacji)
    {
        odpowiedz =naglowekWskazowkaLokalizacji+"\n";
        odpowiedz+=wskazowkaLokalizacji;
    }

    public void nieprawidloweId()
    {
        odpowiedz = naglowekNieprawidloweId;
    }

    void response(HttpServletResponse response)
    {
         response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.print(odpowiedz);
        } catch (Exception e) {
        }
    }
}
