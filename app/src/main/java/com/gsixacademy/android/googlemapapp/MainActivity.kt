package com.gsixacademy.android.googlemapapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.LatLngBounds
import com.google.android.gms.maps.model.MarkerOptions

class MainActivity : AppCompatActivity(), OnMapReadyCallback {

    private lateinit var map : GoogleMap

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val mapFragment = supportFragmentManager.findFragmentById(R.id.fragment_map) as SupportMapFragment
        mapFragment.getMapAsync(this)
    }


    override fun onMapReady(googleMap: GoogleMap) {
        map = googleMap

        map.setOnMapLoadedCallback {
            val gsixLocation = LatLng(42.011986, 21.372345)
            val gtcLocation = LatLng(41.995422, 21.434676)
            val dolnoSonje = LatLng(41.940128, 21.378703)
            val builder = LatLngBounds.Builder()
            builder.include(gsixLocation)
            builder.include(gtcLocation)
            builder.include(dolnoSonje)
            val bounds = builder.build()
            map.addMarker(MarkerOptions().position(gsixLocation).title("GSIX "))
            // map.animateCamera(CameraUpdateFactory.newLatLngZoom(gsixLocation, 15f))
            map.addMarker(MarkerOptions().position(gtcLocation).title("GTC"))
            map.addMarker(MarkerOptions().position(dolnoSonje).title("Dolno Sonje"))
            map.moveCamera(CameraUpdateFactory.newLatLngBounds(bounds, 90))

        }




    }
}
