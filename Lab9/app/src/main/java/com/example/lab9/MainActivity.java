package com.example.lab9;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.Locale;

public class MainActivity extends AppCompatActivity {
    private TextView tv_clock;
    private Button bt_start;
    private Boolean flag=false;
    private BroadcastReceiver receiver=new BroadcastReceiver() {
        @Override
        public void onReceive(Context context, Intent intent) {
            Bundle b = intent.getExtras();
            tv_clock.setText(String.format(Locale.getDefault(),"%02d:%02d:%02d"
            ,b.getInt("H"),b.getInt("M"),b.getInt("S")));
        }
    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        tv_clock=findViewById(R.id.tv_clock);
        bt_start=findViewById(R.id.bt_start);
        ContextCompat.registerReceiver(this,receiver,new IntentFilter("com.example.lab9.MyMessage"),Context.RECEIVER_EXPORTED);
        Log.d("LAB9","Receiver Registered");
        flag=MyService.flag;
        if(flag){
            bt_start.setText("Stop");
        }
        else{
            bt_start.setText("Start");
        }
        bt_start.setOnClickListener(v -> {
            flag=!flag;
            if(flag){
                bt_start.setText("Stop");
                Toast.makeText(this,"計時開始",Toast.LENGTH_SHORT).show();
            }
            else {
                bt_start.setText("Start");
                Toast.makeText(this,"計時暫停",Toast.LENGTH_SHORT).show();
            }
            startService(new Intent(this, MyService.class).putExtra("flag",flag));
        });
    }
    @Override
    protected void onDestroy(){
        super.onDestroy();
        unregisterReceiver(receiver);
    }
}