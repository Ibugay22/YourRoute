package com.example.yourroute

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.yourroute.BuildConfig.MAPS_YANDEX
import com.example.yourroute.databinding.ActivityMainBinding
import com.yandex.mapkit.Animation
import com.yandex.mapkit.MapKitFactory
import com.yandex.mapkit.geometry.Point
import com.yandex.mapkit.map.CameraPosition
//
class MainActivity : AppCompatActivity() {
    private val TARGET_LOCATION: Point =
        Point(59.945933, 30.320045)
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        initMap()
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setContentView(R.layout.activity_main)
        binding.mapView.map.move(
            CameraPosition(TARGET_LOCATION, 14.0f, 0.0f, 0.0f),
            Animation(Animation.Type.SMOOTH, 5f), null)

    }

    private fun initMap() {
        MapKitFactory.setApiKey(MAPS_YANDEX)
        MapKitFactory.initialize(this)
    }
    //

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