package com.example.l8grapodchody;

import android.Manifest;
import android.content.Context;
import android.content.pm.PackageManager;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.core.app.ActivityCompat;

public class Lokalizacja {
    public Wspolrzedne getAktualneWsporzedne() {
        return wspolrzedne;
    }
    public Lokalizacja(Context context) {
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
                wspolrzedne.dlugosc =  location.getLongitude();
                wspolrzedne.szerokosc =  location.getLatitude();
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
    Wspolrzedne wspolrzedne = new Wspolrzedne();
    private  LocationListener nasluchiwaczZmianLokacji;
    private  LocationManager locationMenager;
    final int LOCATION_REFRESH_TIME = 0; // 5 seconds to update
    final int LOCATION_REFRESH_DISTANCE = 0; // 1 meters to update
}
