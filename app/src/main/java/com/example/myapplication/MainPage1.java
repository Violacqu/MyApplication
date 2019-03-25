package com.example.myapplication;

import android.app.Activity;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Spinner;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.ArrayList;
import android.widget.ArrayAdapter;
import android.widget.AdapterView;
import android.view.WindowManager;
import org.litepal.LitePal;
import java.util.List;

public class MainPage1 extends Activity {

    private List<MySql> mySqlList = new ArrayList<>();
    private RecyclerView recyclerView;
    private LinearLayoutManager layoutManager = new LinearLayoutManager(this);
    private float income_total=0;
    private float outcome_total=0;
    private TextView textView_outcome_total;
    private TextView textView_income_total;





    private static final String[] monthList = { "Jan.", "Feb.", "Mar.", "Apr.", "May.", "Jun.", "Jul.", "Aug.", "Sep.", "Oct.", "Nov.", "Dec." };
    private Spinner month_spinner;
    private ArrayAdapter<String> month_adapter;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.monthacc);
        recyclerView=findViewById(R.id.recyclerView);

        textView_income_total=findViewById(R.id.textViewtotal);

        textView_outcome_total=findViewById(R.id.textViewexpensetotal);

        initSpinner();

    }

    @Override
    public void onWindowFocusChanged(boolean hasFocus) {
        super.onWindowFocusChanged(hasFocus);
        refreshTask task=new refreshTask();
        task.execute();
    }

    class refreshTask extends AsyncTask<Void,Void,Void> {
        @Override
        protected void onPreExecute() {
            // progressDialog.show();
            outcome_total = 0;
            income_total = 0;
            mySqlList.clear();
        }

        @Override
        protected Void doInBackground(Void... voids) {
            mySqlList = LitePal.findAll(MySql.class);
            for (MySql mySql:mySqlList){
                if (mySql.getPriceType()==1){
                    outcome_total = outcome_total + Float.parseFloat(mySql.getPrice());
                }
                else{
                    income_total = income_total + Float.parseFloat(mySql.getPrice());
                }
            }
            return null;
        }

        @Override
        protected void onPostExecute(Void aVoid) {

            recyclerView.setLayoutManager(layoutManager);
            MyListAdapter adapter = new MyListAdapter(MainPage1.this,mySqlList);
            recyclerView.setAdapter(adapter);
            textView_income_total.setText(String.valueOf(income_total));
            textView_outcome_total.setText(String.valueOf(outcome_total));
        }
    }


        public void showaddpage1(View view){
        Intent intent = new Intent();
        intent.setClass(MainPage1.this,AddPage1.class);
        startActivity(intent);
        MainPage1.this.finish();
    }

    public void showchart(View view){
        Intent intent = new Intent();
        intent.setClass(MainPage1.this,MainChart.class);
        startActivity(intent);
        MainPage1.this.finish();
    }
    public void showuser(View view){
        Intent intent = new Intent();
        intent.setClass(MainPage1.this,MainUser.class);
        startActivity(intent);
        MainPage1.this.finish();
    }
    public void showaccount(View view){
        Intent intent = new Intent();
        intent.setClass(MainPage1.this,MainPage1.class);
        startActivity(intent);
        MainPage1.this.finish();
    }


    private void initSpinner(){
        month_spinner = (Spinner) findViewById(R.id.spinner3);
        //将可选内容与ArrayAdapter连接起来
        month_adapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_spinner_item, monthList);
        //设置下拉列表的风格
        month_adapter
                .setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        //将adapter添加到spinner中
        month_spinner.setAdapter(month_adapter);
        //添加事件Spinner事件监听
        month_spinner
                .setOnItemSelectedListener(new month_spinnerSelectedListener());
        //设置默认值
        //month_spinner.setSelection(pubFun.getTime("M"), true);
        month_spinner.setSelection(2);
        month_spinner.setVisibility(View.VISIBLE);
    }

    /**
     * 选择 月份 事件 监听器
     */
    class month_spinnerSelectedListener implements AdapterView.OnItemSelectedListener {
        public void onItemSelected(AdapterView<?> arg0, View arg1, int arg2,
                                   long arg3) {
            int pos = month_spinner.getSelectedItemPosition();
        }
        public void onNothingSelected(AdapterView<?> arg0) {
        }
    }


}
