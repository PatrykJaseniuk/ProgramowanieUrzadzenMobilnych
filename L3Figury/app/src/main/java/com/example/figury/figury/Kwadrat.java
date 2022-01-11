package com.example.figury.figury;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.view.ViewGroup;

import java.util.Random;

public class Kwadrat extends Figura {

    int a;
    public Kwadrat (Context context) {
        super(context);

        nazwaFigury ="Kwadrat";
        wzorObwod = "a*4 ";
        wzorPole = "a*a";

        Random r = new Random();
        a= r.nextInt(10)+5;

        wartosciString =" A = "+a;
        pole= a*a;
        obwod = a*4;

//        setLayoutParams(new ViewGroup.LayoutParams(a+40, a+40));
    }

    @Override
    public void onDraw(Canvas canvas)
    {
        super.onDraw(canvas);


        Paint p = new Paint();
        p.setColor(Color.RED);
        Rect r = new Rect(0,0,a,a);
        canvas.drawRect(r,p);

        p.setColor(Color.BLACK);
        p.setTextSize(40);
        canvas.drawText("A",(int)(a/2),a+40,p);

        invalidate();
    }
}
