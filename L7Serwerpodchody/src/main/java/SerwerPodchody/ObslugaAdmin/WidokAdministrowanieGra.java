/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package SerwerPodchody.ObslugaAdmin;

import SerwerPodchody.Kernel.Gracz;
import SerwerPodchody.Kernel.Kernel;
import SerwerPodchody.Kernel.Punkt;
import Widok.Header;
import Widok.Paragraph;
import Widok.View;
import java.util.function.BiConsumer;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author jasyn
 */
class WidokAdministrowanieGra extends View
{
    public WidokAdministrowanieGra()
    {
        add(new Header("Panel administracyjny"));        
        
         add(new Header("Gracze:"));   
        Kernel.gracze.forEach(new BiConsumer<Integer, Gracz>(){
            @Override
            public void accept(Integer idGracza, Gracz gracz)
            {
                WidokAdministrowanieGra.this.add(new Header("Id Gracza :"+idGracza));
                
                if(gracz.czyZwyciestwo)
                {
                    WidokAdministrowanieGra.this.add(new Paragraph("zwyciestwo"));
                }
                else
                {
                     int nrPunktu =Kernel.listaPunktow.indexOf( gracz.aktywnyPunkt);                        
                WidokAdministrowanieGra.this.add(new Paragraph("aktualny Punkt :"+nrPunktu));
                }               
            }            
        });
        
         add(new Header("Punkty:"));  
         for(Punkt punkt :Kernel.listaPunktow)
         {        
             add(new Header("Punkt nr: "+Kernel.listaPunktow.indexOf(punkt))); 
             add(new Paragraph("Wskazowka lokalizacji: "+punkt.wskazowkaLokalizacji));
             add(new Paragraph("Szerokosc: "+punkt.wspolrzedneSzerokosc));
             add(new Paragraph("Dlugosc: "+punkt.wspolrzedneDlugosc));
             add(new Paragraph("Pytanie: "+punkt.pytanie));
             add(new Paragraph("Opcje odpowiedzi: "));
             for(String opcja : punkt.opcjeOdpowiedzi)
             {           
                  add(new Paragraph("Opcja : "+opcja));
             }
              add(new Paragraph("Prawidlowa odpowiedz: "+ punkt.opcjeOdpowiedzi.get(punkt.prawidlowaOdpowiedz)));             
         }
    }
    
    

//    void response(HttpServletResponse response)
//    {
//        view.response(response);
//    }
    
}
