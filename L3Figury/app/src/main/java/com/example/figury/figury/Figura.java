package com.example.figury.figury;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;

import androidx.constraintlayout.widget.ConstraintLayout;

public class Figura extends View
{

    public Figura(Context context) {
        super(context);
    }

//    @Override
//    public void setLayoutParams(ViewGroup.LayoutParams params) {
//        super.setLayoutParams(params);
//    }


    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);

        setMeasuredDimension(height, width);
    }

    public int pole, obwod;
    public String wzorPole, wzorObwod, nazwaFigury, wartosciString ;
    protected final int height = 300, width = 300;
}
