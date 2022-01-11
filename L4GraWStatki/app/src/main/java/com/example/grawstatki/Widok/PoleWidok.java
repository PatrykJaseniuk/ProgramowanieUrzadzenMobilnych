package com.example.grawstatki.Widok;

import android.content.Context;

import com.example.grawstatki.GameKernel.GameCore;
import com.example.grawstatki.GameKernel.Gracz;

import java.util.function.BiFunction;

public class PoleWidok extends androidx.appcompat.widget.AppCompatButton {

    public PoleWidok(Context context, int x, int y) {
        super(context);

        this.x=x;
        this.y=y;
//        this.planszaWidok= planszaWidok;
//        this.plansza = plansza;

        setOnClickListener(v -> onButtonClick.apply(x,y));
    }

//    void przycisniecieguzika()
//    {
////        GameCore.buttonClicked(x,y);
//        onButtonClick.apply(x,y);
////        plansza.odswierz();
//    }

    void odswierzWidok(BiFunction<Integer,Integer,Integer> dataSource)
    {
        setBackgroundColor(dataSource.apply(x,y));
    }

    private int x,y;
    public BiFunction<Integer,Integer,Object> onButtonClick;
//    private PlacingShips.PlanszaWidok planszaWidok;
//    private Plansza plansza;
}
