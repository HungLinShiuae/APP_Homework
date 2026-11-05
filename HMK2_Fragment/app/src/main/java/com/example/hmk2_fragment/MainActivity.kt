package com.example.hmk2_fragment

import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        val bt_start=findViewById<Button>(R.id.bt_start)
        bt_start.setOnClickListener {

            findViewById<View>(R.id.Fg1).visibility = View.VISIBLE

            supportFragmentManager.beginTransaction()
                .replace(R.id.Fg1, Fragment1())
                .commit()

            bt_start.visibility = View.GONE
        }
    }
}