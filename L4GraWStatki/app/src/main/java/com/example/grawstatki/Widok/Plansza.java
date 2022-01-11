package com.example.grawstatki.Widok;

import android.content.Context;
import android.util.AttributeSet;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.example.grawstatki.GameKernel.GameCore;

import java.util.LinkedList;
import java.util.List;
import java.util.function.BiFunction;

public class Plansza extends LinearLayout {
    public Plansza(Context context, AttributeSet attrs) {
        super(context, attrs);
        setOrientation(VERTICAL);
        this.context = context;
        rysujPlanszeIPowiazPrzyciski();
//        odswierz();
    }


    //    public PlanszaWidok(PlacingShipsActivity activity) {
//        this.activity = activity;
//    }
    public BiFunction<Integer, Integer, Object> onButtonClick = (x, y) -> { return null; };
    public BiFunction<Integer,Integer,Integer> dataSource = (x, y)->{return null;};
//    public Gracz graczDoWyswietlania;

    public void odswierz() {
//        if(graczDoWyswietlania)
        for (PoleWidok poleWidok : listaPolWidokow) {
            poleWidok.odswierzWidok(dataSource);
        }
//        onClick.apply(null);
    }

    private List<PoleWidok> listaPolWidokow = new LinkedList<>();
    private Context context;

    private void rysujPlanszeIPowiazPrzyciski() {
//        LinearLayout plansza = (LinearLayout) findViewById(R.id.linearLayoutSetingsShips);
        for (int i = 0; i < GameCore.aktualnyGracz.plansza.height; i++) {
            LinearLayout wiersz = generujWiersz(i);
            this.addView(wiersz);
        }
    }

    private LinearLayout generujWiersz(int nrWiersza) {
        LinearLayout wiersz = new LinearLayout(context);
        wiersz.setLayoutParams(new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT, 1));

        for (int i = 0; i < GameCore.aktualnyGracz.plansza.width; i++) {
            PoleWidok pole = new PoleWidok(context, i, nrWiersza);
            pole.onButtonClick = (x, y) -> {
                onButtonClick.apply(x, y);
                odswierz();
                return null;
            };

            pole.setLayoutParams(new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT, 1));

            listaPolWidokow.add(pole);
            wiersz.addView(pole);
        }
        return wiersz;
    }
}
