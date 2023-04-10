package com.example.thirdweek

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

fun main(){
    println(hofFun({a,b->a>b},10,20)())
    println(hofFun({a,b->a>b},20,10)())
    println(hofFun({a,b->a>b},20,20)())
}

fun hofFun(function: (Int, Int) -> Boolean, arg1:Int, arg2:Int) : () -> String {
    val result = if (function(arg1, arg2)) arg1 else arg2
    return {"Result: $result"}
}