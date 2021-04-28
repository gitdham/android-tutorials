package com.example.tutorials

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.activity_main)

    btnApply.setOnClickListener {
      val name = etName.text.toString()
      val age = etAge.text.toString().toInt()
      val country = etCountry.text.toString()
      val person = Person(name, age, country)

      Intent(this, SecondActivity::class.java).also {
        it.putExtra("EXTRA_PERSON", person)
        startActivity(it)
      }
    }
  }
}