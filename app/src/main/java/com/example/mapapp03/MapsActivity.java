package com.example.mapapp03;

import android.support.v4.app.FragmentActivity;
import android.os.Bundle;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

public class MapsActivity extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
    }


    /**
     * Manipulates the map once available.
     * This callback is triggered when the map is ready to be used.
     * This is where we can add markers or lines, add listeners or move the camera. In this case,
     * we just add a marker near Sydney, Australia.
     * If Google Play services is not installed on the device, the user will be prompted to install
     * it inside the SupportMapFragment. This method will only be triggered once the user has
     * installed Google Play services and returned to the app.
     */
    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;

        // シドニーの緯度経度を設定して、そこにマーカーを設置
        LatLng sydney = new LatLng(-34, 151);
        mMap.addMarker(new MarkerOptions().position(sydney).title("Marker in Sydney"));
        // 日本のどこかの緯度経度を設定して、そこにマーカーを設置
        LatLng tokyo = new LatLng(35.680926, 139.765295);
        mMap.addMarker(new MarkerOptions().position(tokyo).title("東京の丸の内"));
        // 北米のどこかの緯度経度を設定して、そこにマーカーを設置
        LatLng seattle = new LatLng(47.590777, -122.332976);
        mMap.addMarker(new MarkerOptions().position(seattle).title("マリナーズ球場"));

        // カメラの位置とズームを設定
        LatLng center = new LatLng(10.582792, -172.405480);
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(center, 2));
    }
}
