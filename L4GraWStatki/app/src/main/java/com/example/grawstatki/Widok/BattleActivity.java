package com.example.grawstatki.Widok;

import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;

import com.example.grawstatki.GameKernel.GameCore;
import com.example.grawstatki.R;

public class BattleActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(com.example.grawstatki.R.layout.activity_my_ships);

        plansza = findViewById(R.id.planszaBattle);
//        plansza.graczDoWyswietlania = GameCore.aktualnyGracz;
        plansza.dataSource = (x,y)->{return GameCore.aktualnyGracz.plansza.getPoleDlaAktualnegoGracza(x,y);};
        plansza.odswierz();

        inicjalizowanieMediaPlayerow();
    }

    private void inicjalizowanieMediaPlayerow() {
        mpStrzalWStatek = MediaPlayer.create(this,R.raw.strzal_w_statek);
        mpStrzalWWode = MediaPlayer.create(this, R.raw.strzal_w_wode);
    }

    public void onClickMojeStatki(View view) {
//        plansza.graczDoWyswietlania = GameCore.aktualnyGracz;
        plansza.dataSource = (x,y)->{return GameCore.aktualnyGracz.plansza.getPoleDlaAktualnegoGracza(x,y);};
        plansza.onButtonClick = (x, y) -> {return null;};
        plansza.odswierz();
    }

    public void onClickStatkiWroga(View view) {
//        plansza.graczDoWyswietlania = GameCore.nieaktywnyGracz;
        plansza.dataSource = (x,y)->{return GameCore.nieaktywnyGracz.plansza.getPolePrzeciwnika(x,y);};
        plansza.odswierz();
        plansza.onButtonClick = (x, y) -> {GameCore.buttonClicked(x, y);return null;};
    }

    public void OnClickNastepnyGracz(View view)
    {
        GameCore.nextPlayer(this);
    }

    public static MediaPlayer mpStrzalWWode;
    public static MediaPlayer mpStrzalWStatek;

    private Plansza plansza;
}