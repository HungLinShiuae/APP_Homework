package com.example.hmk3_1

import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.GridView
import android.widget.ListView
import android.widget.Spinner
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        val sp = findViewById<Spinner>(R.id.main_sp)
        val lv = findViewById<ListView>(R.id.main_lv)
        val gv = findViewById<GridView>(R.id.main_gv)
        // 儲存購買數量資訊
        val count = ArrayList<String>()
        // 儲存水果資訊
        val item = ArrayList<Item>()
        // 建立價格範圍
        val priceRange = IntRange(10, 100)
        val imageList = intArrayOf(
            R.drawable.apple,
            R.drawable.avocado,
            R.drawable.banana,
            R.drawable.cherries,
            R.drawable.coconut,
            R.drawable.grapes,
            R.drawable.lemon,
            R.drawable.orange,
            R.drawable.peach,
            R.drawable.pineapple,
            R.drawable.strawberry,
            R.drawable.tomato
        )
        val imageName =arrayOf("蘋果","酪梨","香蕉","櫻桃","椰子","葡萄","檸檬","橘子","桃子","鳳梨","草莓","番茄")
        // 讀取圖檔
        for(i in imageList.indices) {
            // 水果圖片 Id
            val photo = imageList[i]
            // 水果名稱
            val name = imageName[i]
            // 亂數產生價格
            val price = priceRange.random()
            // 新增可購買數量資訊
            count.add("${i+1}個")
            // 新增水果資訊
            item.add(Item(photo, name, price))
        }
        // 釋放圖檔資源
        // 建立 ArrayAdapter 物件，並傳入字串與 simple_list_item_1.xml(這是預設就有的)
        sp.adapter = ArrayAdapter(this,
            android.R.layout.simple_list_item_1, count)
        // 設定橫向顯示列數
        gv.numColumns = 4
        // 建立 MyAdapter 物件，並傳入 adapter_vertical 作為畫面(MyAdapter是自己建立的)
        gv.adapter = MyAdapter(this, item, R.layout.adapter_vertical)
        // 建立 MyAdapter 物件，並傳入 adapter_horizontal 作為畫面
        lv.adapter = MyAdapter(this, item, R.layout.adapter_horizontal)
    }
    data class Item(
        // 圖片
        val photo: Int,
        // 名稱
        val name: String,
        // 價格
        val price: Int
    )

}