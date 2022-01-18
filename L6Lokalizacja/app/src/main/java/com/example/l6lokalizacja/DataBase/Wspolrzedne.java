package com.example.l6lokalizacja.DataBase;

public class Wspolrzedne {

    public float x;
    public float y;

    public Wspolrzedne(float x, float y) {
        this.x = x;
        this.y = y;
    }

    public float odleglosc(Wspolrzedne wspolrzedne) {
        float dx = x - wspolrzedne.x;
        float dy = y - wspolrzedne.y;
        return (float) Math.sqrt(dx * dx + dy * dy);
    }

    @Override
    public String toString() {
        return "  dlugosc :" + x +
                "  szerokosc :" + y;
    }
}
