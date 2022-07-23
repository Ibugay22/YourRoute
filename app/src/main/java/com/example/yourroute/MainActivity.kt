package com.example.yourroute

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.yourroute.databinding.ActivityMainBinding
import com.yandex.mapkit.Animation
import com.yandex.mapkit.MapKitFactory
import com.yandex.mapkit.geometry.Point
import com.yandex.mapkit.map.CameraPosition

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        initMap()
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setContentView(R.layout.activity_main)

        binding.mapView.map.move(
            CameraPosition(Point(55.751574, 37.573856), 11.0f, 0.0f, 0.0f),
        Animation(Animation.Type.SMOOTH,0f),null)
    }

    private fun initMap(){
        MapKitFactory.setApiKey("27af7f0a-ad24-45f3-88c1-eecf2ff910ce")
        MapKitFactory.initialize(this)
    }

    override fun onStart() {
        binding.mapView.onStart()
        MapKitFactory.getInstance().onStart()
        super.onStart()
    }

    override fun onStop() {
        binding.mapView.onStop()
        MapKitFactory.getInstance().onStop()
        super.onStop()
    }
}