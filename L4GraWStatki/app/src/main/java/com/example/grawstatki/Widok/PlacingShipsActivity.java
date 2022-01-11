package com.example.grawstatki.Widok;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.example.grawstatki.GameKernel.GameCore;
import com.example.grawstatki.R;

import java.util.function.Function;

public class PlacingShipsActivity extends AppCompatActivity {
//    @RequiresApi(api = Build.VERSION_CODES.N)
//    class Funkcja implements Function
//    {
//        PlacingShipsActivity placingShipsActivity;
//        Funkcja(PlacingShipsActivity placingShipsActivity)
//        {
//            this.placingShipsActivity = placingShipsActivity;
//        }
//
//        @Override
//        public Object apply(Object o) {
//            placingShipsActivity.odswierz();
//            return null;
//        }
//    }

    public Plansza plansza;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.placing_ship_activity);
        Plansza plansza = findViewById(R.id.plansza);
        plansza.onButtonClick = (x, y) -> {
            GameCore.buttonClicked(x, y);
            odswierz();
            return null;
        };
//        planszaWidok.rysujPlanszeIPowiazPrzyciski();
        //Co to za cudo
        plansza.dataSource = (x, y) -> {
            return GameCore.aktualnyGracz.ustawianieStatku.getColorProxy(x, y,
                    ((xGlowne, yGlowne) -> {
                        return GameCore.aktualnyGracz.plansza.getPoleDlaAktualnegoGracza(xGlowne, yGlowne);
                    }));
        };
        plansza.odswierz();
        odswierz();
    }

    public void odswierz() {
//        planszaWidok.odswierzPlansze();
        odswierzIloscPozostalychModulow();
    }

    public void onClickOk(View view) {
        GameCore.nextPlayer(this);
    }

    private void odswierzIloscPozostalychModulow() {
        TextView textViewIloscPozostalychModulow = findViewById(R.id.textViewPozostalaIloscStatkow);
        textViewIloscPozostalychModulow.setText((Integer.toString(GameCore.aktualnyGracz.getPozostalailoscModulowStatkow())));
    }


//    class PlanszaWidok
//        {
//            private List<PoleWidok> listaPolWidokow = new LinkedList<>();
//            private PlacingShipsActivity activity;
//
//            public PlanszaWidok(PlacingShipsActivity activity) {
//                this.activity = activity;
//            }
//
//            public void odswierzPlansze() {
//                for (PoleWidok poleWidok: listaPolWidokow)
//                {
//                    poleWidok.odswierzWidok();
//                }
//            }
//
//            private void rysujPlanszeIPowiazPrzyciski() {
//                LinearLayout plansza = (LinearLayout) findViewById(R.id.linearLayoutSetingsShips);
//                for(int i = 0; i< GameCore.aktualnyGracz.plansza.height; i++)
//                {
//                    LinearLayout wiersz = generujWiersz(i);
//                    plansza.addView(wiersz);
//                }
//            }
//
//            private LinearLayout generujWiersz(int nrWiersza) {
//                LinearLayout wiersz = new LinearLayout(activity);
//                wiersz.setLayoutParams(new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT,1));
//
//                for( int i=0; i<GameCore.aktualnyGracz.plansza.width;i++)
//                {
////                    PoleWidok pole = new PoleWidok(activity,i,nrWiersza);
////
////                    pole.setLayoutParams(new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT,1));
////
////                    listaPolWidokow.add(pole);
////                    wiersz.addView(pole);
//                }
//                return wiersz;
//            }
//        }
}