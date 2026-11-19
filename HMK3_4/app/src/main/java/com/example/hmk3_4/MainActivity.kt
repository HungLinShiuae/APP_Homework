package com.example.hmk3_4

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.LinearLayout
import android.widget.ProgressBar
import android.widget.RadioButton
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.lifecycle.lifecycleScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import kotlin.math.pow

class MainActivity : AppCompatActivity() {
    private lateinit var bt_start: Button
    private lateinit var et_height: EditText
    private lateinit var et_weight: EditText
    private lateinit var et_age: EditText
    private lateinit var tv_weightresult: TextView
    private lateinit var tv_fatresult: TextView
    private lateinit var tv_bmi: TextView
    private lateinit var tv_loading: TextView
    private lateinit var pb_loading: ProgressBar
    private lateinit var ll_loading: LinearLayout
    private lateinit var rb_male: RadioButton
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        bt_start = findViewById(R.id.bt_start)
        et_height = findViewById(R.id.et_height)
        et_weight = findViewById(R.id.et_weight)
        et_age = findViewById(R.id.et_age)
        tv_weightresult = findViewById(R.id.tv_weightresult)
        tv_fatresult = findViewById(R.id.tv_fatresult)
        tv_bmi = findViewById(R.id.tv_bmi)
        tv_loading = findViewById(R.id.tv_loading)
        pb_loading = findViewById(R.id.pb_loading)
        ll_loading = findViewById(R.id.ll_loading)
        rb_male = findViewById(R.id.rb_male)
        bt_start.setOnClickListener {
            when {
                et_height.text.isEmpty() -> showToast("請輸入身高")
                et_weight.text.isEmpty() -> showToast("請輸入體重")
                et_age.text.isEmpty() -> showToast("請輸入年齡")
                else -> Calculate()
            }
        }
    }
    private fun Calculate() {
        tv_weightresult.text = "標準體重\n無"
        tv_fatresult.text = "體脂肪\n無"
        tv_bmi.text = "BMI\n無"
        // 初始化進度條
        pb_loading.progress = 0
        tv_loading.text = "0%"
        // 顯示進度條
        ll_loading.visibility = View.VISIBLE
        lifecycleScope.launch(Dispatchers.Default){
            var count=0
            while(count<100){
                delay(10)
                count++
                withContext(Dispatchers.Main){
                    pb_loading.progress=count
                    tv_loading.text="$count%"
                }
            }
            val h=et_height.text.toString().toDouble()
            val w=et_weight.text.toString().toDouble()
            val a=et_age.text.toString().toDouble()
            val b=w/((h/100).pow(2))
            val (standWeight, bodyFat) = if (rb_male.isChecked)Pair((h - 80) * 0.7, 1.39 * b + 0.16 * a - 19.34)
                else Pair((h - 70) * 0.6, 1.39 * b + 0.16 * a - 9)
            withContext(Dispatchers.Main){
                ll_loading.visibility = View.GONE
                tv_weightresult.text = "標準體重 \n${String.format("%.2f", standWeight)}"
                tv_fatresult.text = "體脂肪 \n${String.format("%.2f", bodyFat)}"
                tv_bmi.text = "BMI \n${String.format("%.2f", b)}"
            }
        }
    }
    private fun showToast(msg: String) =
        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show()
}