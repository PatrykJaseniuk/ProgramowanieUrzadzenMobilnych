package com.example.l5kantor.Activities;

import androidx.lifecycle.MutableLiveData;

import com.example.l5kantor.BazaDanych.Waluta;
import com.example.l5kantor.Kernel;

import java.util.List;

public class MainViewModel {

    private static MutableLiveData<Float> liveDataIloscPieniedzy;
    private static  MutableLiveData<List<Waluta>> liveDataListaWalut;

    public static MutableLiveData<Float> getLiveDataIloscPieniedzy() {
        if (liveDataIloscPieniedzy == null) {
            liveDataIloscPieniedzy = new MutableLiveData<Float>();
        }
        return liveDataIloscPieniedzy;
    }

    public static MutableLiveData<List<Waluta>> getLiveDataListaWalut()
    {
        if (liveDataListaWalut == null)
        {
            liveDataListaWalut = new MutableLiveData<List<Waluta>>();
        }
        return liveDataListaWalut;
    }

    public static void setIloscPieniedzyDoWymiany(float iloscPieniedzyDoWymiany) {
        if(liveDataIloscPieniedzy!= null)
        {
            Thread t = new Thread() {
                @Override
                public void run() {
                    float iloscPieniedzyDoOtrzymania = Kernel.getIloscPieniedzyDoOtrzymania(iloscPieniedzyDoWymiany);
                    liveDataIloscPieniedzy.postValue(iloscPieniedzyDoOtrzymania);
//                liveDataIloscPieniedzy.postValue(iloscPieniedzyDoWymiany);
                }
            };
            t.start();
        }
    }

    public static void setListaWalut() {
        if(liveDataListaWalut !=null)
        {
            Thread t = new Thread()
            {
                @Override
                public void run()
                {
                    List<Waluta> listaWalut = Kernel.getWszystkieWaluty();
                    liveDataListaWalut.postValue(listaWalut);
                }
            };
            t.start();
        }
    }
}
