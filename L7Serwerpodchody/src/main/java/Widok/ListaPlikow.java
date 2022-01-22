/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Widok;

import java.io.File;
import java.util.List;
import java.util.Set;
import javax.servlet.http.HttpServletRequest;

/**
 *
 * @author jasyn
 */
public class ListaPlikow extends Element
{
    private File[] listaPlikow;
    private final String nazwaParametru= "plikdoPobrania";
    
    @Override
    public String getHtml()
    {
        String html ="";
        
        for (File file : listaPlikow)
        {
            html+= "<br><a href=\"?"+nazwaParametru+"="+file.getName()+"\">"+file.getName()+"</a><br>";
        }
        
        return html;
    }    

    public String getAdresPliku(HttpServletRequest request)
    {
        String nazwaPliku = request.getParameter(nazwaParametru);
        if(nazwaPliku!=null)
        {
            for (File file : listaPlikow)
            {
                if(file.getName() == null ? nazwaPliku == null : file.getName().equals(nazwaPliku))
                {
                    return file.getAbsolutePath();
                }
            }
        }
        return null;
     }

    public void indeksowanieFolderu(String lokoalizacjaFolderowZPlikami)
    {
        File file = new File(lokoalizacjaFolderowZPlikami+"\\Folder1");
        listaPlikow = file.listFiles();
    }

//    private void indeksuj(File file)
//    {
//        File[] tablicaPlikow = file.
//      }
    
    
}
