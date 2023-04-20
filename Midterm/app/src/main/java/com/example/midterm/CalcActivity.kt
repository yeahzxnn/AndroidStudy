package com.example.midterm

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.midterm.databinding.ActivityCalcBinding

class CalcActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityCalcBinding.inflate(layoutInflater)
        setContentView(binding.root)
        title = "계산기"

        var numb = arrayOf(binding.num0, binding.num1, binding.num2, binding.num3, binding.num4, binding.num5, binding.num6, binding.num7, binding.num8, binding.num9)
        var tmp = ""
        var tmp2 = ""

        for ( i in numb.indices) {
            numb[i].setOnClickListener {
                var tmp = tmp + i.toString()
                binding.t1.setText(binding.t1.text.toString() + i.toString())

            }
        }


        binding.btnVack.setOnClickListener {
            finish()
        }
        binding.btnCln.setOnClickListener {
            binding.t1.setText("")
            tmp = ""
            tmp2 = ""
        }
    }
}