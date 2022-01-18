package com.example.l6lokalizacja.DataBase;



import android.icu.text.MessagePattern;

import androidx.room.TypeConverter;




import java.lang.reflect.Type;
import java.util.LinkedList;
import java.util.List;

public class WspolrzedneConverter {

    @TypeConverter
    public static String formWspolrzedneToFloat(Wspolrzedne wspolrzedne)
    {
        String kod="";
        if(wspolrzedne!=null)
        {
            kod = Float.toString(wspolrzedne.x)+" "+Float.toString(wspolrzedne.y);
        }
        return kod;
    }

    @TypeConverter
    public static Wspolrzedne foromJsonToWspolrzedne(String json)
    {
     String x="",y="";

     int i=0;
     while (i<json.length())
     {
         char c=json.charAt(i);
         if(c==' ')
         {
             break;
         }
         x+=c;
         i++;
     }
     i++;
        while (i<json.length())
        {
            char c=json.charAt(i);
            if(c==' ')
            {
                break;
            }
            y+=c;
            i++;
        }
        float xf=0;
        float yf=0;

        try{
            xf=Float.valueOf(x);
            yf=Float.valueOf(y);
        }catch(Exception e)
        {

        }
        return new Wspolrzedne(xf,yf);
    }
}
