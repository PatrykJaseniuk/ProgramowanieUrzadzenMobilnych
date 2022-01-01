package com.example.figury.Activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.Switch;

import com.example.figury.FiguraNazwa;
import com.example.figury.R;
import com.example.figury.StanyGraczy;
import com.example.figury.figury.Kolo;
import com.example.figury.figury.Kwadrat;
import com.example.figury.figury.Prostokat;
import com.example.figury.figury.Rownoleglobok;
import com.example.figury.figury.Trapez;
import com.example.figury.figury.TrojkatProstokatny;
import com.example.figury.figury.TrojkatRownoboczny;


public class MainActivity extends AppCompatActivity {

static public boolean czyTrybNauka;
static public FiguraNazwa figuraNazwa;
static private  Switch toggle;
private Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//        dodajActionListinerazDoPrzelacznika();
        toggle = (Switch) findViewById(R.id.switch1);
//        toggle.setChecked(true);
    }

//    @Override
//    protected void onResume() {
//        super.onResume();
//        toggle.setChecked(true);
//    }

    private void ustawPrzelacznik() {
        Switch toggle = (Switch) findViewById(R.id.switch1);
        toggle.setChecked(czyTrybNauka);
        toggle.isChecked();
    }

    @Override
    protected void onStart() {
        super.onStart();
        ustawStanGry();
    }

    @Override
    public void onBackPressed() {
//        super.onBackPressed();
        startActivity(new Intent(this,WyborGracza.class));
    }

    private void ustawStanGry() {
        Button przycisk = findViewById(R.id.buttonProstokat);
        if(StanyGraczy.czyFiguraDostepna(Prostokat.class))
        {
            przycisk.setClickable(true);
            przycisk.setBackgroundColor(Color.GREEN);
        }
        else
        {
            przycisk.setClickable(false);
            przycisk.setBackgroundColor(Color.RED);
        }
        przycisk = findViewById(R.id.buttonKwadrat);
        if(StanyGraczy.czyFiguraDostepna(Kwadrat.class))
        {
            przycisk.setClickable(true);
            przycisk.setBackgroundColor(Color.GREEN);
        }
        else
        {
            przycisk.setClickable(false);
            przycisk.setBackgroundColor(Color.RED);
        }
        przycisk = findViewById(R.id.buttonTrojkatProstokatny);
        if(StanyGraczy.czyFiguraDostepna(TrojkatProstokatny.class))
        {
            przycisk.setClickable(true);
            przycisk.setBackgroundColor(Color.GREEN);
        }
        else
        {
            przycisk.setClickable(false);
            przycisk.setBackgroundColor(Color.RED);
        }
        przycisk = findViewById(R.id.buttonTrojkatRownoboczny);
        if(StanyGraczy.czyFiguraDostepna(TrojkatRownoboczny.class))
        {
            przycisk.setClickable(true);
            przycisk.setBackgroundColor(Color.GREEN);
        }
        else
        {
            przycisk.setClickable(false);
            przycisk.setBackgroundColor(Color.RED);
        }
        przycisk = findViewById(R.id.buttonKolo);
        if(StanyGraczy.czyFiguraDostepna(Kolo.class))
        {
            przycisk.setClickable(true);
            przycisk.setBackgroundColor(Color.GREEN);
        }
        else
        {
            przycisk.setClickable(false);
            przycisk.setBackgroundColor(Color.RED);
        }
        przycisk = findViewById(R.id.buttonTrapez);
        if(StanyGraczy.czyFiguraDostepna(Trapez.class))
        {
            przycisk.setClickable(true);
            przycisk.setBackgroundColor(Color.GREEN);
        }
        else
        {
            przycisk.setClickable(false);
            przycisk.setBackgroundColor(Color.RED);
        }
        przycisk = findViewById(R.id.buttonRownoleglobok);
        if(StanyGraczy.czyFiguraDostepna(Rownoleglobok.class))
        {
            przycisk.setClickable(true);
            przycisk.setBackgroundColor(Color.GREEN);
        }
        else
        {
            przycisk.setClickable(false);
            przycisk.setBackgroundColor(Color.RED);
        }
    }

//    private void dodajActionListinerazDoPrzelacznika() {
//        Switch toggle = (Switch) findViewById(R.id.switch1);
//        toggle.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
//            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
//                if (isChecked) {
//                    // The toggle is enabled
//                    czyTrybNauka=true;
//                } else {
//                    // The toggle is disabled
//                    czyTrybNauka = false;
//                }
//            }
//        });
//    }

    public void onClickProstokat(View element)
    {

        czyTrybNauka = toggle.isChecked();
        figuraNazwa = FiguraNazwa.prostokat;
        startActivity(new Intent(this, AktywnoscZFigura.class));
    }
    public void onClickKwadrat(View element)
    {
        czyTrybNauka = toggle.isChecked();
        figuraNazwa = FiguraNazwa.kwadrat;
        startActivity(new Intent(this, AktywnoscZFigura.class));
    }

    public void onClickTrojkatProstokatny(View element)
    {
        czyTrybNauka = toggle.isChecked();
        figuraNazwa = FiguraNazwa.trojkatProstokatny;
        startActivity(new Intent(this, AktywnoscZFigura.class));
    }
    public void onClickTrojkatRownoboczny(View element)
    {
        czyTrybNauka = toggle.isChecked();
        figuraNazwa = FiguraNazwa.trojkatRownoboczny;
        startActivity(new Intent(this, AktywnoscZFigura.class));
    }
    public void onClickKolo(View element)
    {
        czyTrybNauka = toggle.isChecked();
        figuraNazwa = FiguraNazwa.kolo;
        startActivity(new Intent(this, AktywnoscZFigura.class));
    }
    public void onClickRownoleglobok(View element)
    {
        czyTrybNauka = toggle.isChecked();
        figuraNazwa = FiguraNazwa.rownoleglobok;
        startActivity(new Intent(this, AktywnoscZFigura.class));
    }
    public void onClickTrapez(View element)
    {
        czyTrybNauka = toggle.isChecked();
        figuraNazwa = FiguraNazwa.trapez;
        startActivity(new Intent(this, AktywnoscZFigura.class));
    }
}