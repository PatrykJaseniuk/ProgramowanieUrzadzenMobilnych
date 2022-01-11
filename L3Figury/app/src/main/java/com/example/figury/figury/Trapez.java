package com.example.figury.figury;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.view.ViewGroup;

import java.util.Random;

public class Trapez extends Figura{
    int a, b, c, d ,h, odsuniecieGory = 20;
    public Trapez(Context context) {
        super(context);

        nazwaFigury ="Trapez";
        wzorObwod = "a + b + c + d ";
        wzorPole = "(a + b) * h / 2";

        Random r = new Random();
        h= r.nextInt(210)+50;
        a= r.nextInt(210)+50;
        b= r.nextInt(120)+50;
        c= (int)java.lang.Math.sqrt(h*h +odsuniecieGory * odsuniecieGory);
        int podstawa = odsuniecieGory + b - a;
        d = (int) java.lang.Math.sqrt(podstawa * podstawa + h *h );



        wartosciString = "a = "+a+"\nb = "+b+"\nc = "+c+"\nd = "+d+"\nh = "+h;

        pole= (int) (a+b)*h/2;
        obwod = a+b+c+d;

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
        sciezka.lineTo(b+odsuniecieGory,0);
        sciezka.lineTo(odsuniecieGory,0);
        sciezka.lineTo(0,h);
        canvas.drawPath(sciezka, p );


        p.setColor(Color.BLACK);
        p.setTextSize(40);
        canvas.drawText("A",(int)(a/2),h+40,p);
        canvas.drawText("B",odsuniecieGory+30,40,p);
        canvas.drawText("C",0,h/2,p);
        canvas.drawText("D",a,h/2,p);
        canvas.drawText("H",a/2,h/2,p);

        canvas.drawLine(a/2,0,a/2,h,p);


        invalidate();
    }
}
