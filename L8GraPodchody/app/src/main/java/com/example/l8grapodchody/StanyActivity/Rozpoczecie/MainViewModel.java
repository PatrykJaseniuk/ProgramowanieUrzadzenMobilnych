package com.example.l8grapodchody.StanyActivity.Rozpoczecie;

import android.content.Context;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.example.l8grapodchody.Kernel;

public class MainViewModel {

    private static MutableLiveData<String> liveDataOdpowiedzZwrotna;
    public static void podajIdGracza(Context context, int idGracza) {
        Kernel.inicjalizjuLokalizacje(context);
        new Thread(){
            @Override
            public void run() {
                if(!Kernel.logowanieDoGry(context ,idGracza))
                {
                    liveDataOdpowiedzZwrotna.postValue("nieprawidlowe id");
                }
            }
        }.start();

    }


    public static LiveData<String> getLiveDataInformacjaZwrotna() {
        if(liveDataOdpowiedzZwrotna ==null)
        {
            liveDataOdpowiedzZwrotna = new MutableLiveData<String>();
        }
        return liveDataOdpowiedzZwrotna;
    }
}
