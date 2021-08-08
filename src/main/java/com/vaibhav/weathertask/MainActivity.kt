package com.vaibhav.weathertask

import android.Manifest
import android.content.Context
import android.content.Intent
import android.content.pm.PackageManager
import android.location.Location
import android.location.LocationManager
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Looper
import android.provider.Settings
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.core.app.ActivityCompat
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.google.android.gms.location.*
import com.vaibhav.weathertask.AppConstants.LOCATION_REQUEST_CODE
import java.time.LocalTime
import java.util.*

class MainActivity : AppCompatActivity() {

    private lateinit var fusedLocationClient: FusedLocationProviderClient
    lateinit var viewModel: MainViewModel
    var weatherData = arrayListOf<WeatherModel>()
    var adapter = WeatherAdapter(weatherData)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        viewModel = ViewModelProvider(this).get(MainViewModel::class.java)
        fusedLocationClient = LocationServices.getFusedLocationProviderClient(this)
        registerObserver()
        if (isGpsEnabled())
            getCurrentLocation()
        else
            showGpsDialog(this)

    }

    private fun registerObserver() {
        viewModel.weatherObserver.observe(this, Observer {
            toast(it.message)
            weatherData.clear()
            weatherData.addAll(it)
            adapter.notifyDataSetChanged()
        })
        viewModel.errorObserver.observe(this, Observer {
            toast(it)

        })
    }


    fun isGpsEnabled(): Boolean {
        val locationManager = getSystemService(Context.LOCATION_SERVICE) as LocationManager
        return locationManager.isProviderEnabled(LocationManager.GPS_PROVIDER)
    }

    var locationCallback: LocationCallback = object : LocationCallback() {
        override fun onLocationResult(locationResult: LocationResult?) {
            locationResult ?: return
            hitWeatherAPI(locationResult.lastLocation)
        }
    }

    override fun onResume() {
        super.onResume()
        if (weatherData.isEmpty()) {
            if (isGpsEnabled())
                getCurrentLocation()
            else
                showGpsDialog(this)
        }
    }

    fun getCurrentLocation() {
        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {

            ActivityCompat.requestPermissions(
                    this, arrayOf(
                    Manifest.permission.ACCESS_COARSE_LOCATION,
                    Manifest.permission.ACCESS_FINE_LOCATION
            ), LOCATION_REQUEST_CODE
            )
        }
        fusedLocationClient.requestLocationUpdates(LocationRequest.create()
                .setPriority(LocationRequest.PRIORITY_HIGH_ACCURACY).setInterval(1000), locationCallback, Looper.getMainLooper())
    }



    fun hitWeatherAPI(location: Location) {
        if(isNetworkAvailable())
        viewModel.fetchData(location)
    }

    fun showGpsDialog(context: Context) {
        val builder = AlertDialog.Builder(context)
        builder.setTitle("Location Request")
        builder.setMessage("Kindly enable GPS to get weather info of your location")
                .setCancelable(true)
                .setPositiveButton("Enable") { dialog, which ->
                    dialog.dismiss()
                    val intent = Intent()
                    intent.action = Settings.ACTION_LOCATION_SOURCE_SETTINGS
                    context.startActivity(intent)
                }
        val dialog = builder.create()
        dialog.show()
    }

    override fun onRequestPermissionsResult(requestCode: Int, permissions: Array<out String>, grantResults: IntArray) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        if (requestCode == LOCATION_REQUEST_CODE && permissions.size > 0) {
            for (i in grantResults) {
                if (i != PackageManager.PERMISSION_GRANTED) {
                    Toast.makeText(this, "Location Permissions Required to fetch location, Kindly enable permissions", Toast.LENGTH_LONG).show()
                    return
                }
            }
            Toast.makeText(this, "Location Permissions acquired", Toast.LENGTH_LONG).show()
            if (isGpsEnabled())
                getCurrentLocation()
            else
                showGpsDialog(this)
        }
        else
            Toast.makeText(this, "Location Permissions Required to fetch location, Kindly enable permissions", Toast.LENGTH_LONG).show()

    }
}
