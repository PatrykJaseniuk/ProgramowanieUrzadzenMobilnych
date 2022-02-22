 package SerwerPodchody.Kernel;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Random;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author jasyn
 */
public class Kernel
{
    static Random rand = new Random();
    public static List<Punkt> listaPunktow;
    public static float maksymalnaOdleglosc=5;
    public static Map<Integer,Gracz> gracze = new HashMap<>();
    
    public static void StworzGre(List<Punkt> punkty, int liczbaGraczy)
    {
        listaPunktow = punkty;  
//        listaPunktow = new LinkedList<Punkt>();
//        listaPunktow.add(new Punkt());
        
        for(;liczbaGraczy>0;liczbaGraczy--)
        {            
           int noweIdGracza;
            do
            {
                noweIdGracza = rand.nextInt(99); 
            }while(gracze.containsKey(noweIdGracza));
            
            gracze.put(noweIdGracza, new Gracz());
        }
        gracze.put(1,new Gracz());
        gracze.put(2,new Gracz());
    }    
}
