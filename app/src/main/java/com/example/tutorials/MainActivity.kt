package com.example.tutorials

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.activity_main)


    btnAdd.setOnClickListener {
      val firstNum = etFirstNum.text.toString().toInt()
      val secondNum = etSecondNum.text.toString().toInt()
      val result = firstNum + secondNum
      tvResult.text = result.toString()
    }

    btnSubtract.setOnClickListener {
      val firstNum = etFirstNum.text.toString().toInt()
      val secondNum = etSecondNum.text.toString().toInt()
      val result = firstNum - secondNum
      tvResult.text = result.toString()
    }

    btnMultiply.setOnClickListener {
      val firstNum = etFirstNum.text.toString().toInt()
      val secondNum = etSecondNum.text.toString().toInt()
      val result = firstNum * secondNum
      tvResult.text = result.toString()
    }

    btnDiv.setOnClickListener {
      val firstNum = etFirstNum.text.toString().toFloat()
      val secondNum = etSecondNum.text.toString().toFloat()
      val result = firstNum / secondNum
      tvResult.text = result.toString()
    }
  }
}