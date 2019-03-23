package com.example.myapplication;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class Setting extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.aboutus);
    }


    public void showuser(View view){
        Intent intent = new Intent();
        intent.setClass(Setting.this,MainUser.class);
        startActivity(intent);
    }


}

