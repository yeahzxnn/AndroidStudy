package com.example.midterm

import android.app.Activity
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.example.midterm.databinding.ActivityImgBinding

class ImgActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityImgBinding.inflate(layoutInflater)
        setContentView(binding.root)
        title = "이미지 선택"

        var pic = -1
        var isRot = false

        binding.rad.setOnCheckedChangeListener { rad, i ->
            binding.rotCheck.visibility = View.VISIBLE
            when (i) {
                R.id.radCat -> {
                    binding.userIv.setImageResource(R.drawable.cat)
                    pic = 0
                }
                R.id.radDog -> {
                    binding.userIv.setImageResource(R.drawable.dog)
                    pic = 1
                }
                R.id.radRab -> {
                    binding.userIv.setImageResource(R.drawable.rabbit)
                    pic = 2
                }
            }
        }
        binding.rotCheck.setOnCheckedChangeListener { ch, i ->
            if (i) {
                isRot = true
                binding.userIv.rotation = 90f
            } else {
                isRot = false
                binding.userIv.rotation = 0f
            }
        }


        binding.btnBack.setOnClickListener {
            intent.putExtra("pic", pic)
            intent.putExtra("isRot", isRot)
            setResult(Activity.RESULT_OK, intent)
            finish()
        }


    }
}