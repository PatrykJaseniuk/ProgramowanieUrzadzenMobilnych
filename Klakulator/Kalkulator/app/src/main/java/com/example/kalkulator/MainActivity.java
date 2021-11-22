package com.example.kalkulator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private  Kalkulator kalkulator = new Kalkulator();
    private boolean putArg=true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }


    public void add(View view)
    {

        float argument = getArgument();
        kalkulator.putArgument(argument);
        setResault(Float.toString(kalkulator.getResult())+"+");
        kalkulator.putOperator(Kalkulator.Operator.add);
        putArg=false;

    }

    public void substract(View view)
    {float argument = getArgument();
        kalkulator.putArgument(argument);
        setResault(Float.toString(kalkulator.getResult())+"-");
        kalkulator.putOperator(Kalkulator.Operator.substract);
        putArg=false;
    }

    public void multiply(View view)
    {
        float argument = getArgument();
        kalkulator.putArgument(argument);
        setResault(Float.toString(kalkulator.getResult())+"X");
        kalkulator.putOperator(Kalkulator.Operator.multiply);
        putArg=false;
    }

    public void divie(View view)
    {
        float argument = getArgument();
        kalkulator.putArgument(argument);
        setResault(Float.toString(kalkulator.getResult())+"/");
        kalkulator.putOperator(Kalkulator.Operator.divide);
        putArg=false;
    }

    public void power(View view)
    {
        kalkulator.putArgument(getArgument());
        setResault(Float.toString(kalkulator.getResult())+"^");
        kalkulator.putOperator(Kalkulator.Operator.power);
        putArg=false;
    }

    public void strong(View view)
    {
        kalkulator.putArgument(getArgument());
        kalkulator.putOperator(Kalkulator.Operator.strong);
        setResault(Float.toString(kalkulator.getResult()));
        putArg=false;
    }

    public void resolve(View view)
    {
        kalkulator.putArgument(getArgument());
        setResault(Float.toString(kalkulator.getResult()));
        putArg=false;
    }

    public void reset(View view)
    {
        kalkulator.reset();
        setResault(Float.toString(kalkulator.getResult()));
        putArg=false;
    }

    public void select(View view)
    {
        setResault("");
    }

    public void click1(View view)
    {
        putDigit(1);
    }

    public void click2(View view)
    {
        putDigit(2);
    }
    public void click3(View view)
    {
        putDigit(3);
    }
    public void click4(View view)
    {
        putDigit(4);
    } public void click5(View view)
    {
        putDigit(5);
    }
     public void click6(View view)
    {
        putDigit(6);
    } public void click7(View view)
    {
        putDigit(7);
    } public void click8(View view)
    {
        putDigit(8);
    } public void click9(View view)
    {
        putDigit(9);
    }
    public void click0(View view)
    {
        putDigit(0);
    }










    private float getArgument()
    {
        EditText editText = (EditText) findViewById(R.id.editTextNumber);
        String message = editText.getText().toString();
        float argument;
        try {
            argument = Float.parseFloat(message);
        }catch(Exception e)
        {
            argument = 0;
        }

        return argument;
    }

    private void clearScreen()
    {
        EditText editText = (EditText) findViewById(R.id.editTextNumber);
        editText.setText("");
    }

    private void setResault(String resault)
    {
        EditText textView = (EditText) findViewById(R.id.editTextNumber);
        textView.setText(resault);
    }

    private void putDigit(int digit)
    {
        if(!putArg)
        {
            clearScreen();
            putArg=true;
        }
        EditText textView = (EditText) findViewById(R.id.editTextNumber);
        String actual = textView.getText().toString();
        actual+=digit;
        textView.setText(actual);
    }
}