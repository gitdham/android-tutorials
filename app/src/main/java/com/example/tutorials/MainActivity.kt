package com.example.tutorials

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.activity_main)

    btnOpenActivity.setOnClickListener {
      Intent(this, SecondActivity::class.java).also {
        startActivity(it)
      }
    }
  }
}