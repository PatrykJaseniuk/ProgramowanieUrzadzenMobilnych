package com.example.l8grapodchody;

import java.util.List;

public class Pytanie {
    public List<String> listaOpcjiOdpowiedzi;
    public String trescPytania;

    public Pytanie(String trescPytanie, List<String> opcjeOdpowiedzi) {
    this.listaOpcjiOdpowiedzi = opcjeOdpowiedzi;
    this.trescPytania = trescPytanie;
    }
}
