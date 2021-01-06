package com.example.travelpage;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class user extends AppCompatActivity {
        private MyBroadcastReceiver receiver;
        private TextView tv;
        private ImageView iv;
        SharedPreferences sp;
        SharedPreferences.Editor editor;
        @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user);
            init();
            Intent intent = getIntent();
            String loginname=intent.getStringExtra("loginname");
            TextView tv_user= findViewById(R.id.username);
            tv_user.setText("你好！"+loginname);
    }

    private void init() {
        receiver=  new MyBroadcastReceiver();
                    String action = "Brodcast";
                    IntentFilter intentFilter =  new IntentFilter(action);
                    registerReceiver(receiver,intentFilter);
                    Button btn_help = findViewById(R.id.help);
                    btn_help.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            switch (v.getId()) {
                                case R.id.help:
                                    Intent intent = new Intent();
                                    intent.setAction("Broadcast");
                                    sendBroadcast(intent);
                                    Toast.makeText(user.this,"信号已发出！",Toast.LENGTH_LONG).show();
                                    break;

                }
            }
        });
        Button btn_music = findViewById(R.id.music);
        btn_music.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent music = new Intent(user.this,music.class);
                startActivity(music);

            }
        });
    }




}
