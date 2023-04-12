package com.example.fifthweek

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.fifthweek.databinding.KakaotalkBinding

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = KakaotalkBinding.inflate(layoutInflater)
        setContentView(binding.root)

    }
}