package com.example.myapplication;

import android.app.Activity;
import android.app.AlarmManager;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import org.litepal.LitePal;

public class Logout extends Activity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.setting);

    }
    public void showaddpage1(View view){
        Intent intent = new Intent();
        intent.setClass(Logout.this,AddPage1.class);
        startActivity(intent);
        Logout.this.finish();
    }

    public void showchart(View view){
        Intent intent = new Intent();
        intent.setClass(Logout.this,MainChart.class);
        startActivity(intent);
        Logout.this.finish();
    }
    public void showuser(View view){
        Intent intent = new Intent();
        intent.setClass(Logout.this,MainUser.class);
        startActivity(intent);
        Logout.this.finish();
    }
    public void showaccount(View view){
        Intent intent = new Intent();
        intent.setClass(Logout.this,MainPage1.class);
        startActivity(intent);
        Logout.this.finish();
    }
    public void logout(View view){
        Intent intent = new Intent();
        intent.setClass(Logout.this,MainView.class);
        startActivity(intent);
        Logout.this.finish();
    }

}
