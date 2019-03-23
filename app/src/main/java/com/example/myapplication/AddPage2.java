package com.example.myapplication;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import org.litepal.LitePal;

import java.text.SimpleDateFormat;
import java.util.Date;

public class AddPage2 extends Activity  implements View.OnClickListener{
    private MySql myAccount=new MySql(); //用来添加用的
    SimpleDateFormat format=new SimpleDateFormat("YYYY-MM-dd HH:mm:ss");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.addincome);
        LitePal.getDatabase();

    }

    public void showaddpage1(View view){
        Intent intent = new Intent();
        intent.setClass(AddPage2.this,AddPage1.class);
        startActivity(intent);
    }

    public void showchart(View view){
        Intent intent = new Intent();
        intent.setClass(AddPage2.this,MainChart.class);
        startActivity(intent);
    }
    public void showuser(View view){
        Intent intent = new Intent();
        intent.setClass(AddPage2.this,MainUser.class);
        startActivity(intent);
    }
    public void showaccount(View view){
        Intent intent = new Intent();
        intent.setClass(AddPage2.this,MainPage1.class);
        startActivity(intent);
    }


    @Override
    public void onClick(View v) {
        ImageView inputType = findViewById(R.id.img_icon2);


        switch (v.getId()){
            case R.id.gongzi:
                myAccount.setType("salary");
                myAccount.setPriceType(1);
                inputType.setImageResource(R.drawable.gongzi);
                break;
            case R.id.jianzhi:
                myAccount.setType("part-time job");
                myAccount.setPriceType(1);
                inputType.setImageResource(R.drawable.jianzhi);
                break;
            case R.id.qita2:
                myAccount.setType("other incomes");
                myAccount.setPriceType(1);
                inputType.setImageResource(R.drawable.qita);
                break;

        }

    }

    public void setimg(View v){
        final EditText inputPrice = findViewById(R.id.edit_addaccount2);
        //inputPrice.setText(myAccount.getType());
        myAccount.setTime(format.format(new Date()));
        myAccount.setPrice(inputPrice.getText().toString());
        myAccount.save();
        Toast.makeText(AddPage2.this, "Price "+inputPrice.getText().toString()+" has been recorded!", Toast.LENGTH_SHORT).show();
        inputPrice.setText("");
    }

}
