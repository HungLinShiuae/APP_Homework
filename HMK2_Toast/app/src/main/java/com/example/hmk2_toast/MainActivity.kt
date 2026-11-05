package com.example.hmk2_toast

import android.app.AlertDialog
import android.os.Bundle
import android.view.Gravity
import android.view.ViewGroup
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import android.widget.Button
import android.widget.Toast
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val bt_dialog=findViewById<Button>(R.id.bt_dialog)

        bt_dialog.setOnClickListener {
            val dialog= AlertDialog.Builder(this)
            dialog.setTitle("Choose Option")
            dialog.setMessage("請根據下方按鈕選擇顯示")
            dialog.setNegativeButton("取消")
            {dialog,i->
                Toast.makeText(this,"Dialog關閉",Toast.LENGTH_SHORT).show()
            }
            dialog.setNeutralButton("顯示Toast")
            {dialog,i->
                showToast()
            }
            dialog.setPositiveButton("顯示Dialog")
            {dialog,i->
                showListDialog()
            }
            dialog.show()
        }

    }
    private fun showToast(){
        val toast= Toast(this)
        toast.setGravity(Gravity.TOP,0,50)
        toast.duration= Toast.LENGTH_SHORT
        val inflater=layoutInflater
        val layout=inflater.inflate(R.layout.custom_toast,findViewById<ViewGroup>(R.id.custom_toast_root))
        toast.view=layout
        toast.show()
    }
    private fun showListDialog(){
        val list = arrayOf("message1","message2","message3","message4","message5")
        val dialog_list= AlertDialog.Builder(this)
        dialog_list.setTitle("List Show")
        dialog_list.setItems(list)
        {dialogInterface,i->
            Toast.makeText(this,"你選擇:${list[i]}",Toast.LENGTH_SHORT).show()
        }
        dialog_list.show()
    }
}