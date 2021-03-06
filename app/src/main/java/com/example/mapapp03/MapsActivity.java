package com.example.mapapp03;

import android.graphics.Color;
import android.support.v4.app.FragmentActivity;
import android.os.Bundle;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.CircleOptions;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.maps.model.PolygonOptions;
import com.google.android.gms.maps.model.PolylineOptions;

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

//        // 線を描く
//        PolylineOptions line = new PolylineOptions();
//        line.add(tokyo);
//        line.add(seattle);
//        // 色、太さ、測地線
//        line.color(Color.RED);
//        line.width(30);
//        line.geodesic(true);
//        mMap.addPolyline(line);

//        // 3地点を結ぶ半透明の三角形を描く(ポリゴン(多角形))
//        PolygonOptions triangle = new PolygonOptions();
//        triangle.add(tokyo);
//        triangle.add(seattle);
//        triangle.add(sydney);
//        triangle.strokeColor(Color.GREEN);
//        triangle.fillColor(Color.argb(64, 255, 0, 0));
//        mMap.addPolygon(triangle);

        // 3地点を中心とする半透明の円を描く(3つの円が重なるように大きさを調整)
        CircleOptions circleTokyo = new CircleOptions();
        circleTokyo.center(tokyo);
        circleTokyo.radius(5000000);
        mMap.addCircle(circleTokyo);
    }
}
