package com.example.figury;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.ConstraintSet;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.figury.figury.Figura;
import com.example.figury.figury.Kolo;
import com.example.figury.figury.Kwadrat;
import com.example.figury.figury.Prostokat;
import com.example.figury.figury.Rownoleglobok;
import com.example.figury.figury.Trapez;
import com.example.figury.figury.TrojkatProstokatny;
import com.example.figury.figury.TrojkatRownoboczny;

public class AktywnoscZFigura extends AppCompatActivity {

    Figura figura;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        generujFigure();
//        generateDimantionsAndCalculate();

        setView();

//        setTextView();
    }

    private void generujFigure() {

        if(MainActivity.figuraNazwa == FiguraNazwa.prostokat)
        {
            figura = new Prostokat(this);
        }
        else if(MainActivity.figuraNazwa == FiguraNazwa.kwadrat)
        {
            figura = new Kwadrat(this);
        }
        else if(MainActivity.figuraNazwa == FiguraNazwa.trojkatProstokatny)
        {
            figura = new TrojkatProstokatny(this);
        }
        else if(MainActivity.figuraNazwa == FiguraNazwa.trojkatRownoboczny)
        {
            figura = new TrojkatRownoboczny(this);
        }
        else if(MainActivity.figuraNazwa == FiguraNazwa.trapez)
        {
            figura = new Trapez(this);
        }
        else if(MainActivity.figuraNazwa == FiguraNazwa.rownoleglobok)
        {
            figura = new Rownoleglobok(this);
        }
        else if(MainActivity.figuraNazwa == FiguraNazwa.kolo)
        {
            figura = new Kolo(this);
        }
    }

//    private void generateDimantionsAndCalculate() {
//        Random r = new Random();
//
//        a= r.nextInt(250)+50;
//        b= r.nextInt(250)+50;
//
//        pole= a*b;
//        obwod = a*2 + b*2;
//    }

    private void setView() {

        ConstraintLayout parentLayout;
        if(MainActivity.czyTrybNauka)
        {
            setContentView(R.layout.tryb_nauki);
            parentLayout = findViewById(R.id.constraintLayoutTrybNauki);
//            cl.addView(figura);



            setTextViewTrybNauka();
        }
        else
        {
            setContentView(R.layout.tryb_odpowiedzi);
           parentLayout =findViewById(R.id.constraintLayoutTrybOdpowiedzi);
//            cl.addView(figura);
            setTextViewTrybOdpowiedz();

            final Button guzik = (Button) findViewById(R.id.buttonOdpowiedz);
            guzik.setOnClickListener(new View.OnClickListener()
            {
                @Override
                public void onClick(View v)
                {
                    sprawdzOdpowiedz();
                }
            });
        }
        ConstraintSet set = new ConstraintSet();
//            View childView = new ImageView(this);
        // set view id, else getId() returns -1
        figura.setId(figura.generateViewId());
//        figura.setBackgroundColor(Color.CYAN);
        parentLayout.addView(figura, 0);

        set.clone(parentLayout);
        // connect start and end point of views, in this case top of child to top of parent.
        set.connect(figura.getId(), ConstraintSet.TOP, parentLayout.getId(), ConstraintSet.TOP, 30);
        // ... similarly add other constraints
        set.connect(figura.getId(), ConstraintSet.START, parentLayout.getId(), ConstraintSet.START,30);
        set.connect(figura.getId(), ConstraintSet.END, parentLayout.getId(), ConstraintSet.END);
//        set.constrainWidth(figura.getId(),ConstraintSet.WRAP_CONTENT);
        set.applyTo(parentLayout);
    }

    private void sprawdzOdpowiedz() {

        int odpowiedzPole=-1;


        int odpowiedzObwod=-1;

        try{
            EditText et = findViewById(R.id.editTextNumberPoleOdpowiedz);
            odpowiedzPole=Integer.parseInt(et.getText().toString());
            et = findViewById(R.id.editTextNumberObwodOdpwiedz);
            odpowiedzObwod=Integer.parseInt(et.getText().toString());
        }catch(Exception e)
        {

        }
        if(odpowiedzObwod==figura.obwod && odpowiedzPole == figura.pole)
        {
            zwyciestwo();
        }
        else
        {
            przegrana();
        }
    }

    private void przegrana() {
        startActivity(new Intent(this,Przegrana.class));
    }

    private void zwyciestwo() {
        startActivity(new Intent(this,Zwyciestwo.class));
    }

    private void setTextViewTrybOdpowiedz() {
        TextView tv = (TextView) findViewById(R.id.textViewWartosci);
        tv.setText(String.valueOf(figura.wartosciString));
//        tv = (TextView)findViewById(R.id.textViewWartoscB);
//        tv.setText(String.valueOf(figura.b));

    }

    private void setTextViewTrybNauka() {
        TextView tv = (TextView)findViewById(R.id.textViewWzorObwod);
        tv.setText(figura.wzorObwod);
        tv = (TextView)findViewById(R.id.textViewWzorPole);
        tv.setText(figura.wzorPole);
        tv = (TextView)findViewById(R.id.textViewNazwaFigury);
        tv.setText(figura.nazwaFigury);
    }

//    private View getFigure()
//    {
//        class ProstokatWidok extends View{
//            ProstokatWidok(Context context)
//            {
//                super(context);
//            }
//            @Override
//            public void onDraw(Canvas canvas)
//            {
//                super.onDraw(canvas);
//
//
//                Paint p = new Paint();
//                p.setColor(Color.RED);
//                Rect r = new Rect(0,0,a,b);
//                canvas.drawRect(r,p);
//
//                p.setColor(Color.BLACK);
//                p.setTextSize(30);
//                canvas.drawText("A",(int)(a/2),b,p);
//
////                p.setColor(Color.BLACK);
////                p.setTextSize(30);
//                canvas.drawText("B",a,(int)(b/2),p);
//
//                invalidate();
//            }
//        }
//    return new ProstokatWidok(this);
//    }




}