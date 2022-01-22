package SerwerPodchody.Kernel;


import java.util.LinkedList;
import java.util.List;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author jasyn
 */
public class Punkt
{
   public String wskazowkaLokalizacji="";
   public Float wspolrzedneSzerokosc=(float)0;
   public Float wspolrzedneDlugosc=(float)0;
   public String pytanie="";
   public List<String> opcjeOdpowiedzi=new LinkedList<String>();
   public int prawidlowaOdpowiedz=-1;    
}
