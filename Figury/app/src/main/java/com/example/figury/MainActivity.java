package com.example.figury;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.Switch;




public class MainActivity extends AppCompatActivity {

static public boolean czyTrybNauka;
static public FiguraNazwa figuraNazwa;
private Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//        ConstraintLayout cl = findViewById(R.id.borysek);
//
//        cl.addView(new Button(this));
        dodajActionListinera();
    }

    private void dodajActionListinera() {
        Switch toggle = (Switch) findViewById(R.id.switch1);
        toggle.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    // The toggle is enabled
                    czyTrybNauka=true;
                } else {
                    // The toggle is disabled
                    czyTrybNauka = false;
                }
            }
        });
    }

    public void onClickProstokat(View element)
    {
        figuraNazwa = FiguraNazwa.prostokat;
        startActivity(new Intent(this, AktywnoscZFigura.class));
    }
    public void onClickKwadrat(View element)
    {
        figuraNazwa = FiguraNazwa.kwadrat;
        startActivity(new Intent(this, AktywnoscZFigura.class));
    }

    public void onClickTrojkatProstokatny(View element)
    {
        figuraNazwa = FiguraNazwa.trojkatProstokatny;
        startActivity(new Intent(this, AktywnoscZFigura.class));
    }
    public void onClickTrojkatRownoboczny(View element)
    {
        figuraNazwa = FiguraNazwa.trojkatRownoboczny;
        startActivity(new Intent(this, AktywnoscZFigura.class));
    }
    public void onClickKolo(View element)
    {
        figuraNazwa = FiguraNazwa.kolo;
        startActivity(new Intent(this, AktywnoscZFigura.class));
    }
    public void onClickRownoleglobok(View element)
    {
        figuraNazwa = FiguraNazwa.rownoleglobok;
        startActivity(new Intent(this, AktywnoscZFigura.class));
    }
    public void onClickTrapez(View element)
    {
        figuraNazwa = FiguraNazwa.trapez;
        startActivity(new Intent(this, AktywnoscZFigura.class));
    }
}