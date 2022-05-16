package com.example.android.viewmodel

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.android.viewmodel.Model.viewModelLiveData

class MainActivity : AppCompatActivity() {
    lateinit var  viewModel: viewModelLiveData
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        viewModel = ViewModelProvider(this).get(viewModelLiveData::class.java)

        viewModel.currentNumber.observe(this, Observer {
            val tv_textView = findViewById<TextView>(R.id.tv_textView)
            tv_textView.text = it.toString()
        })

        viewModel.currentboolean.observe(this, Observer {
            val tv_textView = findViewById<TextView>(R.id.tv_boolText)
            tv_textView.text = it.toString()
        })

        incrementText()
    }
    private fun incrementText(){
        val btn_button = findViewById<Button>(R.id.btn_button)
        btn_button.setOnClickListener{
            viewModel.currentNumber.value = ++viewModel.number
            viewModel.currentboolean.value = viewModel.number % 2 == 0
        }
    }


}