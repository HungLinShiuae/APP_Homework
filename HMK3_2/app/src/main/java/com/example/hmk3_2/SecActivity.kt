package com.example.hmk3_2

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class SecActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_sec)
        val edName = findViewById<EditText>(R.id.edName)
        val edPhone = findViewById<EditText>(R.id.edPhone)
        val btnSend = findViewById<Button>(R.id.btnSend)
        // 設定按鈕監聽器，取得輸入的姓名與電話
        btnSend.setOnClickListener {
            //判斷是否輸入資料
            when {//資料不可為空
                edName.text.isEmpty() -> Toast.makeText(this,"請輸入姓名"
                    , Toast.LENGTH_SHORT).show()
                edPhone.text.isEmpty() -> Toast.makeText(this,"請輸入電話"
                , Toast.LENGTH_SHORT).show()
                else -> {
                    val b = Bundle()//建立打包物件丟回去給MainActivity
                    b.putString("name", edName.text.toString())
                    b.putString("phone", edPhone.text.toString())
                    //使用setResult()回傳聯絡人資料
                    setResult(Activity.RESULT_OK, Intent().putExtras(b))
                    finish()
                }
            }
        }
    }
}