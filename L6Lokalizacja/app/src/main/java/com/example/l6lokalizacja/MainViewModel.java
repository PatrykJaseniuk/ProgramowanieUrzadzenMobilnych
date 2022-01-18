package com.example.l6lokalizacja;

import android.content.Context;
import android.os.Build;

import androidx.annotation.RequiresApi;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.example.l6lokalizacja.DataBase.Punkt;
import com.example.l6lokalizacja.DataBase.Wspolrzedne;

import java.util.List;
import java.util.function.Function;

public class MainViewModel {
    private static MutableLiveData<List<Punkt>> liveDataListaPunktow;

    public static LiveData<List<Punkt>> getliveDataListView() {
        if (liveDataListaPunktow == null) {
            liveDataListaPunktow = new MutableLiveData<List<Punkt>>();
        }
        return liveDataListaPunktow;
    }

    public static void requestListaPunktow(float odleglosc) {
        new Thread(){
            @Override
            public void run() {
                List<Punkt> listaPunktow =  Kernel.getListaPunktow(odleglosc);
                liveDataListaPunktow.postValue(listaPunktow);
            }
        }.start();
    }


    private static MutableLiveData<String> liveDataOpis;

    public static LiveData<String> getliveDataOpis() {

        if (liveDataOpis == null) {
            liveDataOpis = new MutableLiveData<String>();
        }
        return liveDataOpis;
    }

    public static void requestSzczegolyPunktu(Punkt punkt) {
        new Thread(){
            @Override
            public void run() {
                String opis =  Kernel.getOpisPunktu(punkt);
                liveDataOpis.postValue(opis);
            }
        }.start();
    }

    public static void inicjalizuj(Context context) {
        Lokalizacja.inicjalizuj(context);
        new Thread()
        {
            @RequiresApi(api = Build.VERSION_CODES.N)
            @Override
            public void run() {
                Kernel.inicjalizuj(context);
                Lokalizacja.onLocationChange(new Funkcja(){
                    @Override
                    public void run(Wspolrzedne w) {
                        liveDataMojeWspolrzedne.postValue(w);
                    }
                });
                odswierzTextViewMojaLokalizacja();
            }
        }.start();


    }

    private static void odswierzTextViewMojaLokalizacja() {
        liveDataMojeWspolrzedne.postValue(Lokalizacja.getWspolrzedne());
    }

    public static MutableLiveData<Wspolrzedne> liveDataMojeWspolrzedne;
    public static LiveData<Wspolrzedne> getliveMojeWspolrzedne() {

        if(liveDataMojeWspolrzedne==null)
        {
            liveDataMojeWspolrzedne = new MutableLiveData<Wspolrzedne>();
        }
        return liveDataMojeWspolrzedne;
    }
}
