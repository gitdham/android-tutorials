package com.example.tutorials

import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.activity_main)
  }

  override fun onCreateOptionsMenu(menu: Menu?): Boolean {
    menuInflater.inflate(R.menu.app_bar_menu, menu)
    return true
  }

  override fun onOptionsItemSelected(item: MenuItem): Boolean {
    when(item.itemId) {
      R.id.miAddContact -> Toast.makeText(
        this,
        "You clicked on add contact",
        Toast.LENGTH_SHORT
      ).show()

      R.id.miFavorites  -> Toast.makeText(
        this,
        "You clicked on favorites",
        Toast.LENGTH_SHORT
      ).show()

      R.id.miSettings   -> Toast.makeText(
        this,
        "You clicked on settings",
        Toast.LENGTH_SHORT
      ).show()

      R.id.miFeedback   -> Toast.makeText(
        this,
        "You clicked on feedback",
        Toast.LENGTH_SHORT
      ).show()

      R.id.miClose      -> finish()
    }
    return true
  }
}