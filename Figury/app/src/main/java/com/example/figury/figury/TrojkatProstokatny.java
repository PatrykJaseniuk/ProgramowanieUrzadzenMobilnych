package com.example.figury.figury;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Rect;
import android.view.ViewGroup;

import java.util.Random;

public class TrojkatProstokatny extends Figura{

    int a,b,c;
    public TrojkatProstokatny(Context context) {
        super(context);

        nazwaFigury ="Trojkat Prostokatny";
        wzorObwod = "a + b + c ";
        wzorPole = "(a * b) / 2";

        Random r = new Random();
        a= r.nextInt(210)+50;
        b= r.nextInt(210)+50;
        c= (int)java.lang.Math.sqrt(a*a + b*b);

        wartosciString = "a = "+a+"\nb = "+b + "\nc = "+c;

        pole= (a*b)/2;
        obwod = a*2 + b*2;

        setLayoutParams(new ViewGroup.LayoutParams(a+40, b+40));
    }

    @Override
    public void onDraw(Canvas canvas)
    {
        super.onDraw(canvas);


        Paint p = new Paint();
        p.setColor(Color.RED);
        Rect r = new Rect(0,0,a,b);
//        canvas.drawRect(r,p);
    Path sciezka = new Path();
    sciezka.lineTo(0,0);
        sciezka.lineTo(0,b);
        sciezka.lineTo(a,b);
        sciezka.lineTo(0,0);
        canvas.drawPath(sciezka, p );


        p.setColor(Color.BLACK);
        p.setTextSize(40);
        canvas.drawText("A",(int)(a/2),b+40,p);

//                p.setColor(Color.BLACK);
//                p.setTextSize(30);
        canvas.drawText("B",0,(int)(b/2),p);

        canvas.drawText("c",(int)(a/2),(int)(b/2),p);

        invalidate();
    }
}
