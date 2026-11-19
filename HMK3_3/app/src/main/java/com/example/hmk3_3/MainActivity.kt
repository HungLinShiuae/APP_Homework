package com.example.hmk3_3
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.os.Message
import android.widget.Button
import android.widget.SeekBar
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
class MainActivity : AppCompatActivity() {
    private var PR = 0
    private var PT = 0
    private lateinit var bt_start: Button
    private lateinit var sb_rabbit: SeekBar
    private lateinit var sb_turtle: SeekBar

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        bt_start = findViewById(R.id.bt_start)
        sb_rabbit = findViewById(R.id.sb_rabbit)
        sb_turtle = findViewById(R.id.sb_turtle)
        bt_start.setOnClickListener {
            bt_start.isEnabled = false
            PR = 0
            PT = 0
            sb_rabbit.progress = 0
            sb_turtle.progress = 0
            run_Rabbit()
            run_Turtle()
        }
    }
    private fun run_Rabbit() {
        lifecycleScope.launch(Dispatchers.Default) {
            //背景執行同協序，方便計算
            val sleepProbability = arrayOf(true, true, false)
            //if True...then sleep
            while (PR < 100 && PT < 100) {
                delay(100);
                if(sleepProbability.random())delay(300)
                PR += 3
                withContext(Dispatchers.Main){
                    //切換至主畫面執行，可以控制seekbar移動
                    sb_rabbit.progress=PR
                    if (PR >= 100 && PT < 100) {
                        showToast("兔子勝利")
                        bt_start.isEnabled = true
                    }
                }
            }
        }
    }
    private fun run_Turtle() {
        lifecycleScope.launch(Dispatchers.Default) {
            //背景執行同協序，方便計算
            while (PR < 100 && PT < 100) {
                delay(100);
                PT += 1
                withContext(Dispatchers.Main){
                    //切換至主畫面執行，可以方便控制主畫面的物件更新
                    sb_turtle.progress=PT
                    //連結當前PT的數值給SeekBar做調整
                    if (PT >= 100 && PR < 100) {
                        showToast("烏龜勝利")
                        bt_start.isEnabled = true
                    }
                }
            }
        }
    }
    private fun showToast(msg: String) =
        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show()
}