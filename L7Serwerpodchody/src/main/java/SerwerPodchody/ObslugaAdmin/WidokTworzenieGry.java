package SerwerPodchody.ObslugaAdmin;


import SerwerPodchody.Kernel.Punkt;
import Widok.Element;
import Widok.Form;
import Widok.Header;
import Widok.Input;
import Widok.Link;
import Widok.View;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.function.BiConsumer;
import javax.servlet.http.HttpServletRequest;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author jasyn
 */
public class WidokTworzenieGry extends View
{        
   public  Input inputIloscGraczy;
    public Link linkDodajPytanie;
    private Element pojemnikNaWidokPunkt;
    
    public WidokTworzenieGry()
    {
        add(new Header("Tworzenie Gry"));
       
        
        Form formularz = new Form("Admin", "get");
        add(formularz);
        
        inputIloscGraczy = new Input("Podaj ilosc graczy", "number");
        formularz.add(inputIloscGraczy);
        
        pojemnikNaWidokPunkt = new Element();
        formularz.add(pojemnikNaWidokPunkt);
//        for(WidokPunkt widokPunkt: listaWidokowPunkt)
//        {
//            add(widokPunkt);
//        } 

            linkDodajPytanie = new Link("Dodaj Pytanie","Admin");
            add(linkDodajPytanie);
    }

    public void addWidokPunkt(WidokPunkt widokPunkt)
    {
        ustawWlasciweIndeksy(pojemnikNaWidokPunkt.elementy);
        pojemnikNaWidokPunkt.add(widokPunkt);
    }

    private void ustawWlasciweIndeksy(List<Element> listaWidokPunkt)
    {
        for(int i=0; i<listaWidokPunkt.size();i++)
        {
            ((WidokPunkt)listaWidokPunkt.get(i)).setIndex(i);
        }
    }

    void edycjaFormularza(HttpServletRequest request)
    {
         if(linkDodajPytanie.isClicked(request))
        {
            addWidokPunkt(new WidokPunkt());
            ustawWlasciweIndeksy(pojemnikNaWidokPunkt.elementy);
        } 
         usunWidokPunkt(request);       
    }

    private void usunWidokPunkt(HttpServletRequest request)
    {
        
        for(int i=0; i<pojemnikNaWidokPunkt.elementy.size();i++)
        {
            WidokPunkt widokPunkt = ((WidokPunkt)pojemnikNaWidokPunkt.elementy.get(i));
            if(widokPunkt.linkUsun.isClicked(request))
            {
                pojemnikNaWidokPunkt.elementy.remove(i);
                ustawWlasciweIndeksy(pojemnikNaWidokPunkt.elementy);
                return;
            }
        }
    }

    List<Punkt> getPunkty(HttpServletRequest request)
    {
        List<Punkt> listaPunktow = new LinkedList<Punkt>();
       for(Element wp:pojemnikNaWidokPunkt.elementy)
       {
           listaPunktow.add(((WidokPunkt)wp).getPunkt(request));
       }
       return listaPunktow;
    }

    int getliczbaGraczy(HttpServletRequest request)
    {
        int iloscGraczy = 0;
        try
        {
           iloscGraczy= Integer.valueOf(inputIloscGraczy.getText(request));
        }
        catch(Exception e)
        {
            
        }         
       return iloscGraczy;
    }
}
