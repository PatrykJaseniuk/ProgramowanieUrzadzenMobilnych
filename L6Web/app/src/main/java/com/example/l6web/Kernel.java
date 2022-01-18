package com.example.l6web;

public class Kernel {

    public static String getPogodaDlaMiasta(String nazwaMiasta) {

        String json = OpenWeatherMap.getJsonDlaMiasta(nazwaMiasta);
        String opisPogodyDlaMiasta = JsonExtracter.extractopisPogody(json);
        return opisPogodyDlaMiasta;
    }
}
