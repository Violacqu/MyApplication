package com.example.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import android.view.Window;
import android.view.WindowManager;

import android.view.animation.AlphaAnimation;
import java.util.Timer;
import java.util.TimerTask;

import android.widget.RelativeLayout;

import android.widget.EditText;


public class MainActivity extends AppCompatActivity {


    //private EditText accountnum;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.addaccount);
        //设置为无标题栏
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        //设置为全屏模式
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);

        setContentView(R.layout.activity_main);

//       // accountnum = findViewById(R.id.edit_addaccount);

        //创建Timer对象
        Timer timer = new Timer();
        //创建TimerTask对象
        TimerTask timerTask = new TimerTask(){
            @Override
            public void run(){
                Intent intent = new Intent(MainActivity.this,MainView.class);
                startActivity(intent);
                finish();
            }
        };
        //使用timer.schedule（）方法调用timerTask，定时3秒后执行run
        timer.schedule(timerTask,3000);
    }






}
