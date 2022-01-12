package com.example.grawstatki.GameKernel;

import com.example.grawstatki.GameKernel.Stany.Stan;

import java.io.Serializable;

class Zapis implements Serializable {
    public Gracz gracz1;
    public Gracz gracz2;
    public Gracz aktualnyGracz;
    public Gracz nieaktywnyGracz;
    public Stan stan;

    Zapis(Gracz gracz1, Gracz gracz2, Gracz aktualnyGracz, Gracz nieaktywnyGracz, Stan stan)
    {
        this.gracz1 = gracz1;
        this.gracz2 = gracz2;
        this.aktualnyGracz = aktualnyGracz;
        this.nieaktywnyGracz = nieaktywnyGracz;
        this.stan = stan;
    }
}
