package it.itsar.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

public class Maps extends AppCompatActivity implements OnMapReadyCallback {

    private GoogleMap mMap;
    ImageView p1,p2,p3,p4,p5;
    Button btn_back;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);

        //Istanbul
        p1 = findViewById(R.id.p1);
        p1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                LatLng milan = new LatLng(41.00527, 28.97696);
                mMap.addMarker(new MarkerOptions()
                        .position(milan)
                        .title("Istanbul"));
                mMap.moveCamera(CameraUpdateFactory.newLatLng(milan));

                mMap.moveCamera(CameraUpdateFactory.zoomTo(12));

            }
        });


        //Paris
        p2 = findViewById(R.id.p2);
        p2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                LatLng milan = new LatLng(48.856614, 2.352222);
                mMap.addMarker(new MarkerOptions()
                        .position(milan)
                        .title("Paris"));
                mMap.moveCamera(CameraUpdateFactory.newLatLng(milan));

                mMap.moveCamera(CameraUpdateFactory.zoomTo(12));

            }
        });

        //Santa Monica
        p3 = findViewById(R.id.p3);
        p3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                LatLng milan = new LatLng(34.009242, -118.497604);
                mMap.addMarker(new MarkerOptions()
                        .position(milan)
                        .title("Santa Monica"));
                mMap.moveCamera(CameraUpdateFactory.newLatLng(milan));

                mMap.moveCamera(CameraUpdateFactory.zoomTo(12));

            }
        });

        //Tokyo
        p4 = findViewById(R.id.p4);
        p4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                LatLng milan = new LatLng(35.685, 139.751389);
                mMap.addMarker(new MarkerOptions()
                        .position(milan)
                        .title("Tokyo"));
                mMap.moveCamera(CameraUpdateFactory.newLatLng(milan));

                mMap.moveCamera(CameraUpdateFactory.zoomTo(12));

            }
        });

        //Amsterdam
        p5 = findViewById(R.id.p5);
        p5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                LatLng milan = new LatLng(52.370216, 4.895168);
                mMap.addMarker(new MarkerOptions()
                        .position(milan)
                        .title("Amsterdam"));
                mMap.moveCamera(CameraUpdateFactory.newLatLng(milan));

                mMap.moveCamera(CameraUpdateFactory.zoomTo(12));

            }
        });

        btn_back = findViewById(R.id.btn_back);
        btn_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), Home.class);
                startActivity(intent);
            }
        });
    }


    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;

        LatLng milan = new LatLng(45.4149275, 9.2645213);
        mMap.addMarker(new MarkerOptions()
                .position(milan)
                .title("Milan"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(milan));
    }

}
