package com.example.figury.figury;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Rect;
import android.view.ViewGroup;

import java.util.Random;

public class TrojkatRownoboczny extends Figura{

    int a;
    public TrojkatRownoboczny(Context context) {
        super(context);

        nazwaFigury ="Trojkat Równoboczny";
        wzorObwod = "a * 3  ";
        wzorPole = "(a^2 * 3^(1/2))/4";

        Random r = new Random();
        a= r.nextInt(210)+50;

        wartosciString = "a = "+a;

        pole= (int)(a*a *java.lang.Math.sqrt(3)/4);
        obwod = a*3;

//        setLayoutParams(new ViewGroup.LayoutParams(a+40, a+40));
    }

    @Override
    public void onDraw(Canvas canvas)
    {
        super.onDraw(canvas);

        float h = (float)(a*java.lang.Math.sqrt(3)/2);
        Paint p = new Paint();
        p.setColor(Color.RED);
//        Rect r = new Rect(0,0,a,b);
//        canvas.drawRect(r,p);
        Path sciezka = new Path();
        sciezka.lineTo(0,h);
        sciezka.lineTo(a,h);
        sciezka.lineTo(a/2,0);
        sciezka.lineTo(0,h);
        canvas.drawPath(sciezka, p );


        p.setColor(Color.BLACK);
        p.setTextSize(40);
        canvas.drawText("A",(int)(a/2),h+40,p);

        invalidate();
    }
}
