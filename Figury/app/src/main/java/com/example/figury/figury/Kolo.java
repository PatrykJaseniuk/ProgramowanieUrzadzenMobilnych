package com.example.figury.figury;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.view.ViewGroup;

import java.util.Random;

public class Kolo extends Figura{

    int r;
    public Kolo (Context context) {
        super(context);

        nazwaFigury ="Kolo";
        wzorObwod = "pi * 2 * r ";
        wzorPole = "pi * r * r ";

        Random rand = new Random();
        r= rand.nextInt(100)+50;

        wartosciString = "r = "+r;

        pole= (int)(3.14 * 2 *r);
        obwod = (int)(3.14 * r*r);

//        setLayoutParams(new ViewGroup.LayoutParams(r*2, r*2));
    }

    @Override
    public void onDraw(Canvas canvas)
    {
        super.onDraw(canvas);


        Paint p = new Paint();
        p.setColor(Color.RED);
    canvas.drawCircle(r,r,r,p);

        p.setColor(Color.BLACK);
        p.setTextSize(40);
        canvas.drawText("R",(int)(r/2),r+40,p);

        canvas.drawLine(0,r,r,r,p);

        invalidate();
    }
}
