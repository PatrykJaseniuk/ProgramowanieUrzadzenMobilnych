package com.example.figury.figury;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.view.ViewGroup;

import java.util.Random;

public class Prostokat extends Figura{

    int a, b;
    public Prostokat(Context context) {
        super(context);

        nazwaFigury ="Prostokat";
        wzorObwod = "a*2 + b*2 ";
        wzorPole = "a*b";

        Random r = new Random();
        a= r.nextInt(210)+50;
        b= r.nextInt(210)+50;

        pole= a*b;
        obwod = a*2 + b*2;
        wartosciString ="a = "+a+"\nb = "+b;

        setLayoutParams(new ViewGroup.LayoutParams(a+40, b+40));
    }

    @Override
    public void onDraw(Canvas canvas)
    {
        super.onDraw(canvas);


        Paint p = new Paint();
        p.setColor(Color.RED);
        Rect r = new Rect(0,0,a,b);
        canvas.drawRect(r,p);

        p.setColor(Color.BLACK);
        p.setTextSize(40);
        canvas.drawText("A",(int)(a/2),b+40,p);

//                p.setColor(Color.BLACK);
//                p.setTextSize(30);
        canvas.drawText("B",a,(int)(b/2),p);

        invalidate();
    }
}
