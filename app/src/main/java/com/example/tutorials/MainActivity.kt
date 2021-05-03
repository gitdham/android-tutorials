package com.example.tutorials

import android.content.Context
import android.os.Bundle
import android.view.WindowManager
import android.view.inputmethod.InputMethodManager
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.activity_main)

    var todoList = mutableListOf(
      Todo("Feed my cat", false),
      Todo("Take a shower", true),
    )

    val adapter = TodoAdapter(todoList)
    rvTotos.adapter = adapter
    rvTotos.layoutManager = LinearLayoutManager(this)

    btnAddTodo.setOnClickListener {
      val title = etTodo.text.toString()
      val todo = Todo(title, false)
      todoList.add(todo)
      adapter.notifyItemInserted(todoList.size - 1)
      hideKeyboard()
      etTodo.text.clear()
      Toast.makeText(this, "Added new todo", Toast.LENGTH_SHORT).show()
    }
  }

  private fun hideKeyboard(){
    val view = this.currentFocus
    if(view != null){
      val hideMe = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
      hideMe.hideSoftInputFromWindow(view.windowToken,0)
    }
    window.setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_HIDDEN)
  }
}