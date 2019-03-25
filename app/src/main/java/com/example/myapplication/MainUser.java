package com.example.myapplication;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class MainUser extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.user);
    }
    public void showaddpage1(View view){
        Intent intent = new Intent();
        intent.setClass(MainUser.this,AddPage1.class);
        startActivity(intent);
        MainUser.this.finish();
    }

    public void showchart(View view){
        Intent intent = new Intent();
        intent.setClass(MainUser.this,MainChart.class);
        startActivity(intent);
        MainUser.this.finish();
    }
    public void showuser(View view){
        Intent intent = new Intent();
        intent.setClass(MainUser.this,MainUser.class);
        startActivity(intent);
        MainUser.this.finish();
    }
    public void showaccount(View view){
        Intent intent = new Intent();
        intent.setClass(MainUser.this,MainPage1.class);
        startActivity(intent);
        MainUser.this.finish();
    }

    public void aboutus(View view){
        Toast.makeText(MainUser.this, "ViVi Account 1.0!" +
                "\n"+"Thanks for using.", Toast.LENGTH_SHORT).show();
    }

    public void help(View view){
        Toast.makeText(MainUser.this,"You can read the readme.md on my github.\n Thank you.",Toast.LENGTH_SHORT).show();


    }
    public void setting(View view){
        Intent intent = new Intent();
        intent.setClass(MainUser.this,Logout.class);
        startActivity(intent);

    }
}
