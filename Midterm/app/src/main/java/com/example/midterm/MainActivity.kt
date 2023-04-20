package com.example.midterm

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.PersistableBundle
import android.view.Menu
import android.view.MenuItem
import com.example.midterm.databinding.ActivityCalcBinding
import com.example.midterm.databinding.ActivityImgBinding
import com.example.midterm.databinding.ActivityMainBinding
import com.example.midterm.databinding.ActivityUserBinding

var str1 = "컴퓨터공학부 소프트웨어전공"
var str2 = "2021158016"
var str3 = "신예진"

class MainActivity : AppCompatActivity(){
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        title = "중간고사"
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu1,menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when(item.itemId){
            R.id.itCal -> {
                intent = Intent(this, CalcActivity::class.java)
                    startActivity(intent)
            }
            R.id.itUser -> {
                intent = Intent(this, UserActivity::class.java)
                startActivityForResult(intent,0)
            }
            R.id.itImg -> {
                intent = Intent(this,ImgActivity::class.java)
                startActivityForResult(intent,0)
            }
        }
        return super.onOptionsItemSelected(item)
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        val binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.tv.text = "학과:"+ str1 + "\n" + "학번:" + str2+ "\n" + "이름:" + str3
        if(resultCode == RESULT_OK){
            when(data!!.getIntExtra("pic", -1)){
                0 -> {
                    binding.iv.setImageResource(R.drawable.cat)
                }
                1 -> {
                    binding.iv.setImageResource(R.drawable.dog)
                }
                2 -> {
                    binding.iv.setImageResource(R.drawable.rabbit)
                }
            }
            if(data!!.getBooleanExtra("isRot", false)){
                binding.iv.rotation = 90f

            } else{
                binding.iv.rotation = 0f
            }
        }
    }

}