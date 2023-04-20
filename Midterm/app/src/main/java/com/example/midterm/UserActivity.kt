package com.example.midterm


import android.app.Activity
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.ContextMenu
import android.view.MenuItem
import android.view.View
import androidx.appcompat.app.AlertDialog
import com.example.midterm.databinding.ActivityUserBinding



class UserActivity : AppCompatActivity() {
    var arr = arrayOf("", "", "")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityUserBinding.inflate(layoutInflater)
        setContentView(binding.root)
        title = "개인정보입력"

        binding.tv1.setText(str1)
        binding.tv2.setText(str2)
        binding.tv3.setText(str3)

        arr[0] = str1
        arr[1] = str2
        arr[2] = str3
        var btns = arrayOf(binding.btn1, binding.btn2, binding.btn3)
        var tvs = arrayOf(binding.tv1, binding.tv2, binding.tv3)

//        for (i in btns.indices) {
//            btns[i].setOnClickListener {
//                var dlg = AlertDialog.Builder(this)
//                var dlgView = View.inflate(this, R.layout.dlg1, null)
//                dlgView.dlgTv.text = when (i) {
//                    0 -> "학과:"
//                    1 -> "학번:"
//                    else -> "이름:"
//                }
//                dlgView.dlgEdt.setText(
//                    when (i) {
//                        0 -> str1
//                        1 -> str2
//                        else -> str3
//                    }
//                )
//                dlg.setTitle("개인정보 수정")
//
//                dlg.setPositiveButton("확인") { a, k ->
//                    arr[i] = dlgView.dlgEdt.text.toString()
//                    tvs[i].text = arr[i]
//                }
//                dlg.setView(dlgView)
//                dlg.show()
//            }
//        }


        registerForContextMenu(binding.userBase)

        binding.btnreturn.setOnClickListener {
            str1 = arr[0]
            str2 = arr[1]
            str3 = arr[2]
            setResult(Activity.RESULT_OK, intent)
            finish()
        }
    }

    override fun onCreateContextMenu(

        menu: ContextMenu?,
        v: View?,
        menuInfo: ContextMenu.ContextMenuInfo?
    ) {
        super.onCreateContextMenu(menu, v, menuInfo)
        val binding = ActivityUserBinding.inflate(layoutInflater)
        setContentView(binding.root)
        if (v === binding.userBase) {
            menuInflater.inflate(R.menu.menu2, menu)
        }
    }

    override fun onContextItemSelected(item: MenuItem): Boolean {
        val binding = ActivityUserBinding.inflate(layoutInflater)
        setContentView(binding.root)
        when (item.itemId) {
            R.id.it1 -> {
                binding.tv1.text = str1
                arr[0] = str1
            }
            R.id.it2 -> {
                binding.tv2.text = str2
                arr[1] = str2
            }
            R.id.it3 -> {
                binding.tv3.text = str3
                arr[2] = str3
            }
        }
        return super.onContextItemSelected(item)
    }
}