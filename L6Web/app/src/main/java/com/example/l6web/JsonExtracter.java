package com.example.l6web;

import org.json.JSONArray;
import org.json.JSONObject;

public class JsonExtracter {
    public static String extractopisPogody(String json) {

        String description="";
        String humidity="";
        String pressure="";
        String temp="";
        String visibility="";
        String speed="";
        try{
            JSONObject root = new JSONObject(json);
            JSONArray weather = root.getJSONArray("weather");
            description = weather.getJSONObject(0).getString("description");
            JSONObject main = root.getJSONObject("main");
            humidity = main.getString("humidity");
            temp = main.getString("temp");
            pressure = main.getString("pressure");
            visibility = root.getString("visibility");
            speed = root.getJSONObject("wind").getString("speed");
        }catch(Exception e)
        {

        }

        String opisPogody = "Pogoda: "+description+
                "\ntemperatura: "+temp+" Cel"+
                "\ncisnienie: "+pressure+" Pasc"+
                "\nwilgotnosc: "+humidity+ " %"+
                "\nwidocznosc: "+visibility+" m"+
                "\nwiatr: "+speed+" m/s";
return opisPogody;
    }
}
