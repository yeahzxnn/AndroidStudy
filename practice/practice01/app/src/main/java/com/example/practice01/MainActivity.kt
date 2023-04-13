package com.example.practice01

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.practice01.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.myButton.setOnClickListener {
            Toast.makeText(applicationContext, "학과: 컴퓨터공학부(소프트웨어전공)", Toast.LENGTH_SHORT).show()
        }
        binding.myButton1.setOnClickListener {
            Toast.makeText(applicationContext, "이름: 신예진", Toast.LENGTH_SHORT).show()
        }
        binding.myButton2.setOnClickListener {
            Toast.makeText(applicationContext, "학번 : 2021158016", Toast.LENGTH_SHORT).show()
        }
    }
}