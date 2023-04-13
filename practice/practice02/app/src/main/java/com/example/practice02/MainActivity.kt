package com.example.practice02

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.practice02.databinding.ActivityMainBinding
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    lateinit var edit1: EditText
    lateinit var edit2: EditText
    lateinit var btnAdd: Button
    lateinit var btnSub: Button
    lateinit var btnMul: Button
    lateinit var btnDiv: Button
    lateinit var btn1: Button
    lateinit var textResult: TextView
    lateinit var num1: String
    lateinit var num2: String
    var result: Double? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        edit1 = findViewById<EditText>(R.id.Edit1)
        edit2 = findViewById<EditText>(R.id.Edit2)
        btnAdd = findViewById(R.id.BtnAdd)
        btnSub = findViewById(R.id.BtnSub)
        btnMul = findViewById(R.id.BtnMul)
        btnDiv = findViewById(R.id.BtuDiv)
        btn1 = findViewById(R.id.Btn1)
        textResult = findViewById(R.id.TextResult)

        btnAdd.setOnClickListener {
            num1 = edit1.text.toString()
            num2 = edit2.text.toString()
            if (num1.trim().equals("") || num2.trim().equals("")){
                Toast.makeText(this, "숫자입력 하세요", Toast.LENGTH_SHORT).show()
            }else {
                result = num1.toDouble() + num2.toDouble()
                textResult.text = "계산 결과 : " + result

            }
        }
        btnSub.setOnClickListener {
            num1 = edit1.text.toString()
            num2 = edit2.text.toString()
            if  (num1.trim().equals("") || num2.trim().equals("")){
                Toast.makeText(applicationContext, "숫자입력 하세요", Toast.LENGTH_SHORT).show()
            }else {
                result = num1.toDouble() - num2.toDouble()
                textResult.text = "계산 결과 : " + result.toString()
            }
        }

        btnMul.setOnClickListener {
            num1 = edit1.text.toString()
            num2 = edit2.text.toString()
            if (num1.trim().equals("") || num2.trim().equals("")){
                Toast.makeText(applicationContext, "숫자입력 하세요", Toast.LENGTH_SHORT).show()
            }
            else {
                result = num1.toDouble() * num2.toDouble()
                textResult.text = "계산 결과 : " + result.toString()
            }
            false
        }

        btnDiv.setOnClickListener {
            num1 = edit1.text.toString()
            num2 = edit2.text.toString()
            if(num1.trim().equals("") || num2.trim().equals("")){
                Toast.makeText(applicationContext, "숫자입력 하세요", Toast.LENGTH_SHORT).show()
            }
            else {
                //num값은 String 인데 계속 Int 0 이랑 비교해서 안된거였음
                if (num2=="0") {
                    Toast.makeText(applicationContext, "0입력", Toast.LENGTH_SHORT).show()
                }
                else {
                    result = num1.toDouble() / num2.toDouble()
                    //나누기 할때 소수점 두번째자리 까지만 표시
                    //ex) 123.45687913...일때 (123.456789..*100) 하면 12345.6132456..
                    //(12345.6132456..).toInt()하면 소수점 없이 12345 만 출력됨
                    //(12345)/100.0해주면 123.45
                    //멤버변수에 result null 을 넣어서 !!를 사용하여 null이아닐때 사용하겠다고 해야함
                    result =(result!! *100).toInt()/100.0
                    textResult.text = "계산 결과 : " + result.toString()
                }
            }
        }

        btn1.setOnClickListener {
            num1 = edit1.text.toString()
            num2 = edit2.text.toString()
            if (num1.trim().equals("") || num2.trim().equals("")){
                Toast.makeText(applicationContext, "숫자입력 하세요", Toast.LENGTH_SHORT).show()
            }else {
                result = num1.toDouble() % num2.toDouble()
                textResult.text = "계산 결과 : " + result.toString()
            }
            false
        }
    }
}