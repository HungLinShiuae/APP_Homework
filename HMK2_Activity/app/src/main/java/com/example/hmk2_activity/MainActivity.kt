package com.example.hmk2_activity

import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import android.widget.Button
import android.widget.TextView
import androidx.activity.result.ActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import kotlinx.serialization.StringFormat

class MainActivity : AppCompatActivity() {
    private lateinit var tv_showmeal: TextView
    private lateinit var bt_start: Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        tv_showmeal=findViewById<TextView>(R.id.tv_showmeal)
        bt_start=findViewById<Button>(R.id.bt_start)
        bt_start.setOnClickListener{
            mStartForResult.launch(
                Intent(this, MainActivity2::class.java)
            )
        }
    }
    private val mStartForResult=registerForActivityResult(ActivityResultContracts.StartActivityForResult()){
        result->
        if(result.resultCode==RESULT_OK){
            val intent=result.data
            if(intent!=null && intent.extras!=null){
                val b=intent.extras
                val beverage=b?.getString("beverage")
                val sugar=b?.getString("sugar")
                val ice=b?.getString("ice")
                tv_showmeal.text= String.format("飲料: %s\n甜度: %s\n冰塊: %s",beverage,sugar,ice)
            }
        }
    }
}