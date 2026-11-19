package com.example.hmk3_2

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.activity.result.ActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    private lateinit var adp:RowAdapter
    private val contacts=ArrayList<MainActivity.Contact>()
    private val startForResult = registerForActivityResult(
        ActivityResultContracts.StartActivityForResult()
    ) { result: ActivityResult ->
        if (result.resultCode == Activity.RESULT_OK) {
            // 取得回傳的 Intent，並從 Intent 中取得聯絡人資訊
            val intent = result.data
            val name = intent?.getStringExtra("name") ?: ""
            val phone = intent?.getStringExtra("phone") ?: ""
            // 新增聯絡人資料
            contacts.add(MainActivity.Contact(name, phone))
            // 更新列表
            adp.notifyDataSetChanged()
        }
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        // 宣告元件變數並使用 findViewByID 方法取得元件
        val recyclerView = findViewById<RecyclerView>(R.id.recyclerView)//清單
        val btnAdd = findViewById<Button>(R.id.btnAdd)//按鈕
        // 創建 LinearLayoutManager 物件，設定垂直排列
        val linearLayoutManager = LinearLayoutManager(this)//垂直排列設定管理
        linearLayoutManager.orientation = LinearLayoutManager.VERTICAL//排列為垂直
        recyclerView.layoutManager = linearLayoutManager//整套丟給清單去設定
        // 創建 MyAdapter 並連結 recyclerView
        adp = RowAdapter(contacts)//容器變數
        recyclerView.adapter = adp//丟給清單去設定
        // 設定按鈕監聽器，使用 startForResult 前往 SecActivity
        btnAdd.setOnClickListener {//按按鈕，跳去設定新的聯絡人
            val i = Intent(this, SecActivity::class.java)
            startForResult.launch(i)
        }
    }
    data class Contact(val name: String, val phone: String)
}