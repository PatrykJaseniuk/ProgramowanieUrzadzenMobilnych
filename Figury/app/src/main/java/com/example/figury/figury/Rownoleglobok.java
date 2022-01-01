package com.example.figury.figury;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.view.ViewGroup;

import java.util.Random;

public class Rownoleglobok extends Figura {
    int a, b, h,przesuniecieGory = 20;
    public Rownoleglobok(Context context) {
        super(context);

        nazwaFigury ="Rownoleglobok";
        wzorObwod = "a * 2 + b * 2  ";
        wzorPole = "a * h";

        Random r = new Random();
        a= r.nextInt(190)+50;
        h= r.nextInt(190)+50;
        b = (int)java.lang.Math.sqrt(przesuniecieGory*przesuniecieGory + h*h);

        wartosciString = "a = "+a+"\nb = "+b+"\nh = "+h;

        pole= a*h;
        obwod = a*2 + b*2;

//        setLayoutParams(new ViewGroup.LayoutParams(a+40, h+40));
    }

    @Override
    public void onDraw(Canvas canvas)
    {
        super.onDraw(canvas);

//        float h = (float)(a*java.lang.Math.sqrt(3)/2);
        Paint p = new Paint();
        p.setColor(Color.RED);
//        Rect r = new Rect(0,0,a,b);
//        canvas.drawRect(r,p);
        Path sciezka = new Path();
        sciezka.lineTo(0,h);
        sciezka.lineTo(a,h);
        sciezka.lineTo(przesuniecieGory+a,0);
        sciezka.lineTo(przesuniecieGory,0);
        sciezka.lineTo(0,h);
        canvas.drawPath(sciezka, p );


        p.setColor(Color.BLACK);
        p.setTextSize(40);
        canvas.drawText("A",(int)(a/2),h+40,p);
        canvas.drawText("B",(int)(a+przesuniecieGory),h/2,p);
        canvas.drawText("H",(int)(przesuniecieGory),h/2,p);

        canvas.drawLine(przesuniecieGory,0,przesuniecieGory,h,p);

        invalidate();
    }
}
