package com.example.myapplication;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import org.litepal.LitePal;

import java.text.SimpleDateFormat;
import java.util.Date;

public class AddPage1 extends Activity implements View.OnClickListener{

    private MySql myAccount=new MySql(); //用来添加用的
    SimpleDateFormat format=new SimpleDateFormat("YYYY-MM-dd HH:mm:ss");


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.addaccount);
        LitePal.getDatabase();

    }



    public void showaddpage1(View view){
        Intent intent = new Intent();
        intent.setClass(AddPage1.this,AddPage1.class);
        startActivity(intent);
        AddPage1.this.finish();
    }

    public void showaddpage2(View view){
        Intent intent = new Intent();
        intent.setClass(AddPage1.this,AddPage2.class);
        startActivity(intent);
        AddPage1.this.finish();
    }
    public void showchart(View view){
        Intent intent = new Intent();
        intent.setClass(AddPage1.this,MainChart.class);
        startActivity(intent);
        AddPage1.this.finish();
    }
    public void showuser(View view){
        Intent intent = new Intent();
        intent.setClass(AddPage1.this,MainUser.class);
        startActivity(intent);
        AddPage1.this.finish();
    }
    public void showaccount(View view){
        Intent intent = new Intent();
        intent.setClass(AddPage1.this,MainPage1.class);
        startActivity(intent);
        AddPage1.this.finish();
    }


    @Override
    public void onClick(View v) {
        ImageView inputType = findViewById(R.id.img_icon1);


        switch (v.getId()){
            case R.id.canyin:
                myAccount.setType("food");
                myAccount.setPriceType(0);
                inputType.setImageResource(R.drawable.canyin);
                break;
            case R.id.fushi:
                myAccount.setType("clothing");
                myAccount.setPriceType(0);
                inputType.setImageResource(R.drawable.fushi);
                break;
            case R.id.gouwu:
                myAccount.setType("shopping");
                myAccount.setPriceType(0);
                inputType.setImageResource(R.drawable.gouwu);
                break;
            case R.id.chongwu:
                myAccount.setType("pets");
                myAccount.setPriceType(0);
                inputType.setImageResource(R.drawable.chongwu);
                break;
            case R.id.riyong:
                myAccount.setType("commodity");
                myAccount.setPriceType(0);
                inputType.setImageResource(R.drawable.riyongcopy);
                break;
            case R.id.jiaotong:
                myAccount.setType("transport");
                myAccount.setPriceType(0);
                inputType.setImageResource(R.drawable.jiaotong);
                break;
            case R.id.lvxing:
                myAccount.setType("traveling");
                myAccount.setPriceType(0);
                inputType.setImageResource(R.drawable.lvhang);
                break;
            case R.id.yiliao:
                myAccount.setType("medical");
                myAccount.setPriceType(0);
                inputType.setImageResource(R.drawable.yiliao);
                break;
            case R.id.xuexi:
                myAccount.setType("study");
                myAccount.setPriceType(0);
                inputType.setImageResource(R.drawable.xuexi);
                break;
            case R.id.yule:
                myAccount.setType("entertainment");
                myAccount.setPriceType(0);
                inputType.setImageResource(R.drawable.yule);
                break;
            case R.id.zhufang:
                myAccount.setType("housing");
                myAccount.setPriceType(0);
                inputType.setImageResource(R.drawable.zhufang);
                break;
            case R.id.qita:
                myAccount.setType("others");
                myAccount.setPriceType(0);
                inputType.setImageResource(R.drawable.qita);
                break;

        }


    }




    public void setimg(View v){
        final EditText inputPrice = findViewById(R.id.edit_addaccount);
        //inputPrice.setText(myAccount.getType());
        myAccount.setTime(format.format(new Date()));
        myAccount.setPrice(inputPrice.getText().toString());
        myAccount.save();
        Toast.makeText(AddPage1.this, "Price "+inputPrice.getText().toString()+" has been recorded!", Toast.LENGTH_SHORT).show();
        inputPrice.setText("");
    }
}
