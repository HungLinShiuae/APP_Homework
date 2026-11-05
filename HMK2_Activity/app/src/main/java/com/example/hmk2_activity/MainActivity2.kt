package com.example.hmk2_activity

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.RadioGroup
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity2 : AppCompatActivity() {
    private lateinit var et_beverage: EditText
    private lateinit var rg_sugar: RadioGroup
    private lateinit var rg_ice: RadioGroup
    private lateinit var bt_send: Button
    private var sugar="無糖"
    private var ice="去冰"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main2)
        et_beverage = findViewById(R.id.et_beverage)
        rg_sugar = findViewById(R.id.rg_sugar)
        rg_ice = findViewById(R.id.rg_ice)
        bt_send = findViewById(R.id.bt_send)

        rg_sugar.setOnCheckedChangeListener { radioGroup, i ->
            if (i == R.id.sugar_no) {
                sugar = "無糖"
            } else if (i == R.id.sugar_little) {
                sugar = "微糖"
            } else if (i == R.id.sugar_half) {
                sugar = "半糖"
            } else if (i == R.id.sugar_full) {
                sugar = "全糖"
            }
        }
        rg_ice.setOnCheckedChangeListener { radioGroup, i ->
            if (i == R.id.ice_no) {
                ice = "去冰"
            } else if (i == R.id.ice_little) {
                ice = "微冰"
            } else if (i == R.id.ice_half) {
                ice = "少冰"
            } else if (i == R.id.ice_full) {
                ice = "正常冰"
            }
        }
        bt_send.setOnClickListener {
            val beverage = et_beverage.text.toString()
            val i = Intent()
            val b = Bundle()
            b.putString("beverage", beverage)
            b.putString("sugar", sugar)
            b.putString("ice", ice)
            i.putExtras(b)
            setResult(RESULT_OK, i)
            finish()
        }
    }
}