package com.example.tutorials

import android.Manifest
import android.content.pm.PackageManager
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityCompat
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.activity_main)

    btnRequestPermissions.setOnClickListener {
      requestPermissions()
    }
  }

  private fun hasWriteExternalStoragePermission() = ActivityCompat.checkSelfPermission(
    this,
    Manifest.permission.WRITE_EXTERNAL_STORAGE
  ) == PackageManager.PERMISSION_GRANTED

  private fun hasLocationForegroundPermission() = ActivityCompat.checkSelfPermission(
    this,
    Manifest.permission.ACCESS_COARSE_LOCATION
  ) == PackageManager.PERMISSION_GRANTED

  private fun hasLocationBackgroundPermission() = ActivityCompat.checkSelfPermission(
    this,
    Manifest.permission.ACCESS_BACKGROUND_LOCATION
  ) == PackageManager.PERMISSION_GRANTED

  private fun requestPermissions() {
    var permissionsToRequest = mutableListOf<String>()
    if(!hasWriteExternalStoragePermission()) {
      permissionsToRequest.add(Manifest.permission.WRITE_EXTERNAL_STORAGE)
    }

    if(!hasLocationForegroundPermission()) {
      permissionsToRequest.add(Manifest.permission.ACCESS_COARSE_LOCATION)
    }

    if(!hasLocationBackgroundPermission()) {
      permissionsToRequest.add(Manifest.permission.ACCESS_BACKGROUND_LOCATION)
    }

    if(permissionsToRequest.isNotEmpty()) {
      ActivityCompat.requestPermissions(this, permissionsToRequest.toTypedArray(), 0)
    }
  }

  override fun onRequestPermissionsResult(
    requestCode: Int,
    permissions: Array<out String>,
    grantResults: IntArray
  ) {
    super.onRequestPermissionsResult(requestCode, permissions, grantResults)
    if(requestCode == 0 && grantResults.isNotEmpty()) {
      for(i in grantResults.indices) {
        if(grantResults[i] == PackageManager.PERMISSION_GRANTED) {
          Log.d("PermissionRequest", "${permissions[i]} granted.")
        }
      }
    }
  }
}