package com.example.android.navigation;

import android.app.Activity;
import android.content.Context;
import android.location.Location;
import android.location.LocationManager;
import android.os.Bundle;
import android.util.Log;

import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

public class MapActivity extends Activity {
    private GoogleMap gMap;


    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_map);

        gMap= ((MapFragment)getFragmentManager().findFragmentById(R.id.map)).getMap();

        final String editFrom = getIntent().getStringExtra("FROM");
        final String editTo = getIntent().getStringExtra("TO");

        gMap.setMyLocationEnabled(true);
            LocationManager lm = (LocationManager) getSystemService(Context.LOCATION_SERVICE);
            Location location = lm.getLastKnownLocation(LocationManager.GPS_PROVIDER);
            double longitude = location.getLongitude();
            double latitude = location.getLatitude();
        Double f = longitude;
            Double t = latitude;
//            Log.d("VVVV",f.toString());
//            Log.d("VVVV",t.toString());
//
//            Log.d("VVVV", f.toString());
//            Log.d("VVVV", t.toString());


            String from = t.toString()+","+f.toString();
        Log.d("mmmmm",t.toString()+","+f.toString());                            //t.toString()+","+f.toString();
            String to = "Orissa";
            Log.d("mmmmm",from.toString());
        gMap.

            new RotaTask(this, gMap, from, to).execute();


    }

}



