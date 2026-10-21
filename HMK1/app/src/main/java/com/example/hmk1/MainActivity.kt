package com.example.hmk1

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.RadioButton
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        val texttitle=findViewById<TextView>(R.id.texttitle)
        val texttips=findViewById<TextView>(R.id.texttips)
        val textinput=findViewById<TextView>(R.id.textinput)
        val editname = findViewById<EditText>(R.id.editname)
        val textgo=findViewById<TextView>(R.id.textgo)
        val textname = findViewById<TextView>(R.id.textname)
        val textyougo = findViewById<TextView>(R.id.textyougo)
        val textwinner = findViewById<TextView>(R.id.textwinner)
        val textcptgo = findViewById<TextView>(R.id.textcptgo)
        val radioscissor = findViewById<RadioButton>(R.id.radioscissor)
        val radiostone = findViewById<RadioButton>(R.id.radiostone)
        val radiopaper = findViewById<RadioButton>(R.id.radiopaper)
        val buttongo = findViewById<Button>(R.id.buttongo)

        buttongo.setOnClickListener {
            if(editname.text.isEmpty()){
                textinput.text="請確實輸入名字:"
                textname.text="您的名字:"
                textyougo.text="您出的拳:"
                textwinner.text="贏家:"
                textcptgo.text="電腦出拳:"
                buttongo.text="輸入名字"
                return@setOnClickListener
            }
            else{
                textinput.text="本名稱可以使用:"
                val playername=editname.text.toString()
                textname.text="您的名字:\n"+playername
                when{
                    radioscissor.isChecked->textyougo.text="您出的拳:\n剪刀"
                    radiostone.isChecked->textyougo.text="您出的拳:\n石頭"
                    radiopaper.isChecked->textyougo.text="您出的拳:\n布"
                }
                val cptrandom=(0..2).random()
                when (cptrandom){
                    0->textcptgo.text="電腦出拳:\n剪刀"
                    1->textcptgo.text="電腦出拳:\n石頭"
                    2->textcptgo.text="電腦出拳:\n布"
                }
                if((radioscissor.isChecked && cptrandom==2)||
                    (radiostone.isChecked && cptrandom==0)||
                    (radiopaper.isChecked && cptrandom==1))
                {
                    textwinner.text="贏家:\n"+playername
                    buttongo.text="恭喜，繼續?"
                }

                else if((radioscissor.isChecked && cptrandom==1)||
                    (radiostone.isChecked && cptrandom==2)||
                    (radiopaper.isChecked && cptrandom==0))
                {
                    textwinner.text="贏家:\n電腦"
                    buttongo.text="可惜，要拚?"
                }

                else
                {
                    textwinner.text="贏家:\n平手"
                    buttongo.text="平手，再來!"
                }
            }
        }
    }
}