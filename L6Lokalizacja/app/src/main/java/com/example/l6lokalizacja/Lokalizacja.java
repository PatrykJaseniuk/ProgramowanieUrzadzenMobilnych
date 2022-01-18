package com.example.l6lokalizacja;

import android.Manifest;
import android.content.Context;
import android.content.pm.PackageManager;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.os.Looper;

import androidx.annotation.NonNull;
import androidx.core.app.ActivityCompat;

import com.example.l6lokalizacja.DataBase.Wspolrzedne;

public class Lokalizacja {
    public static Wspolrzedne getWspolrzedne() {
        return wspolrzedne;
    }


    public static void inicjalizuj(Context context) {
//        Looper.prepare();//wymagane do korzystania z z lokalizacji nie dziala
        if (ActivityCompat.checkSelfPermission(context, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(context, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            // TODO: Consider calling
            //    ActivityCompat#requestPermissions
            // here to request the missing permissions, and then overriding
            //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
            //                                          int[] grantResults)
            // to handle the case where the user grants the permission. See the documentation
            // for ActivityCompat#requestPermissions for more details.
            return;
        }
        nasluchiwaczZmianLokacji = new LocationListener() {
            @Override
            public void onLocationChanged(@NonNull Location location) {
                wspolrzedne.x = (float) location.getLongitude();
                wspolrzedne.y = (float) location.getLatitude();
                if(callbackOnLocationChange!=null)
                {
                    callbackOnLocationChange.run(wspolrzedne);
                }
            }
            //te metody musza byc nadpisane inaczej wyrzuca wyjatek
            @Override
            public void onProviderEnabled(@NonNull String provider) {

            }

            @Override
            public void onProviderDisabled(@NonNull String provider) {

            }

            @Override
            public void onStatusChanged(String provider, int status, Bundle extras) {

            }
        };
        locationMenager = (LocationManager) context.getSystemService(Context.LOCATION_SERVICE);

        locationMenager.requestLocationUpdates(LocationManager.GPS_PROVIDER, LOCATION_REFRESH_TIME,
                LOCATION_REFRESH_DISTANCE, nasluchiwaczZmianLokacji);

    }


    private static LocationListener nasluchiwaczZmianLokacji;
    private static LocationManager locationMenager;
    private static Wspolrzedne wspolrzedne = new Wspolrzedne(0, 0);
    private static Funkcja callbackOnLocationChange;
    static final int LOCATION_REFRESH_TIME = 0; // 5 seconds to update
    static final int LOCATION_REFRESH_DISTANCE = 0; // 1 meters to update


    public static void onLocationChange(Funkcja funkcja) {
        callbackOnLocationChange = funkcja;
    }
}
