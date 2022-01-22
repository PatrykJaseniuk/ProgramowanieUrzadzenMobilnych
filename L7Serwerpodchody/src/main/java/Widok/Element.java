package Widok;


import java.util.LinkedList;
import java.util.List;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */

/**
 *
 * @author jasyn
 */
public  class Element {
    
  public  List<Element> elementy= new LinkedList<Element>();
            
    public void add(Element element)
    {
        elementy.add(element);
    }
    
     public String getHtml()
     {
         String html="";
         for(Element element: elementy)
         {
             html+=element.getHtml();
         }
         return html;
     }
}
