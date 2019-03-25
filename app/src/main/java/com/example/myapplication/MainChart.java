package com.example.myapplication;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.achartengine.ChartFactory;
import org.achartengine.GraphicalView;
import org.achartengine.model.CategorySeries;
import org.achartengine.model.SeriesSelection;
import org.achartengine.renderer.DefaultRenderer;
import org.achartengine.renderer.SimpleSeriesRenderer;
import org.litepal.LitePal;

import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;
import android.os.AsyncTask;

public class MainChart extends Activity {



    private List<MySql> mySqlList = new ArrayList<>();
    private static float food;
    private static float shopping;
    private static float pets;
    private static float commodity;
    private static float traveling;
    private static float medical;
    private static float study;
    private static float entertainment;
    private static float housing;
    private static float transport;
    private static float others;
    private static float clothing;

    private static int[] COLORS = new int[] { Color.rgb(241,204,184), Color.rgb(60,179,113),
            Color.rgb(197,240,236), Color.rgb(160,95,113), Color.rgb(211,187,238), Color.rgb(240,157,129), Color.rgb(251,229,102) ,Color.rgb(214,129,98),Color.rgb(196,239,207),Color.rgb(207,106,63),Color.rgb(173,183,211),Color.rgb(189,210,151)};

    private CategorySeries mSeries = new CategorySeries("");// PieChart的DataSet
    // 其实就是一些键值对，跟Map使用方法差不多

    private DefaultRenderer mRenderer = new DefaultRenderer();// PieChart的主要描绘器

    private GraphicalView mChartView;// 用来显示PieChart 需要在配置文件Manifest中添加
    // <activity android:name="org.achartengine.GraphicalActivity"/>

    private LinearLayout mLinear;

    private static float VALUE = 0;// 总数

    @Override
    protected void onCreate(Bundle savedInstanceState) {


        super.onCreate(savedInstanceState);
        setContentView(R.layout.chart);


        mLinear = (LinearLayout) findViewById(R.id.chart);
        mLinear.setBackgroundColor(Color.rgb(250,236,243));
//        mLinear.setBackgroundColor(Color.rgb(0,0,0));
        mRenderer.setZoomButtonsVisible(true);// 显示放大缩小功能按钮
        mRenderer.setStartAngle(180);// 设置为水平开始
        mRenderer.setDisplayValues(true);// 显示数据
        mRenderer.setFitLegend(true);// 设置是否显示图例
        mRenderer.setLegendTextSize(40);// 设置图例字体大小
        mRenderer.setLegendHeight(10);// 设置图例高度
        mRenderer.setLabelsColor(Color.rgb(0,0,0));
//
//       VALUE = food + shopping + pets + commodity +traveling +medical+ study  +entertainment+ housing+
//        transport + others + clothing;


//        if(food!=0.0){
//            mSeries.add("food",food/VALUE);
//            SimpleSeriesRenderer renderer = new SimpleSeriesRenderer();
//            renderer.setColor(COLORS[0]);// 设置描绘器的颜色
//            renderer.setChartValuesFormat(NumberFormat.getPercentInstance());// 设置百分比
//            mRenderer.setChartTitleTextSize(44);// 设置饼图标题大小
//            mRenderer.addSeriesRenderer(renderer);// 将最新的描绘器添加到DefaultRenderer中
//
//        }else if(shopping!= 0.0){
//            mSeries.add("shopping",shopping/VALUE);
//            SimpleSeriesRenderer renderer = new SimpleSeriesRenderer();
//            renderer.setColor(COLORS[1]);// 设置描绘器的颜色
//            renderer.setChartValuesFormat(NumberFormat.getPercentInstance());// 设置百分比
//            mRenderer.setChartTitleTextSize(44);// 设置饼图标题大小
//            mRenderer.addSeriesRenderer(renderer);// 将最新的描绘器添加到DefaultRenderer中
//        }else if(pets!= 0.0){
//            mSeries.add("pets",pets/VALUE);
//            SimpleSeriesRenderer renderer = new SimpleSeriesRenderer();
//            renderer.setColor(COLORS[2]);// 设置描绘器的颜色
//            renderer.setChartValuesFormat(NumberFormat.getPercentInstance());// 设置百分比
//            mRenderer.setChartTitleTextSize(44);// 设置饼图标题大小
//            mRenderer.addSeriesRenderer(renderer);// 将最新的描绘器添加到DefaultRenderer中
//        }else if(commodity!= 0.0){
//            mSeries.add("commodity",commodity/VALUE);
//            SimpleSeriesRenderer renderer = new SimpleSeriesRenderer();
//            renderer.setColor(COLORS[3]);// 设置描绘器的颜色
//            renderer.setChartValuesFormat(NumberFormat.getPercentInstance());// 设置百分比
//            mRenderer.setChartTitleTextSize(44);// 设置饼图标题大小
//            mRenderer.addSeriesRenderer(renderer);// 将最新的描绘器添加到DefaultRenderer中
//        }else if(traveling!= 0.0){
//
//            mSeries.add("traveling",traveling/VALUE);
//            SimpleSeriesRenderer renderer = new SimpleSeriesRenderer();
//            renderer.setColor(COLORS[4]);// 设置描绘器的颜色
//            renderer.setChartValuesFormat(NumberFormat.getPercentInstance());// 设置百分比
//            mRenderer.setChartTitleTextSize(44);// 设置饼图标题大小
//            mRenderer.addSeriesRenderer(renderer);// 将最新的描绘器添加到DefaultRenderer中
//
//        }else if(medical!= 0.0){
//            mSeries.add("medical",medical/VALUE);
//            SimpleSeriesRenderer renderer = new SimpleSeriesRenderer();
//            renderer.setColor(COLORS[5]);// 设置描绘器的颜色
//            renderer.setChartValuesFormat(NumberFormat.getPercentInstance());// 设置百分比
//            mRenderer.setChartTitleTextSize(44);// 设置饼图标题大小
//            mRenderer.addSeriesRenderer(renderer);// 将最新的描绘器添加到DefaultRenderer中
//        }else if(study!= 0.0){
//
//            mSeries.add("study",study/VALUE);
//            SimpleSeriesRenderer renderer = new SimpleSeriesRenderer();
//            renderer.setColor(COLORS[6]);// 设置描绘器的颜色
//            renderer.setChartValuesFormat(NumberFormat.getPercentInstance());// 设置百分比
//            mRenderer.setChartTitleTextSize(44);// 设置饼图标题大小
//            mRenderer.addSeriesRenderer(renderer);// 将最新的描绘器添加到DefaultRenderer中
//        }if(housing!= 0.0){
//
//            mSeries.add("housing",housing/VALUE);
//            SimpleSeriesRenderer renderer = new SimpleSeriesRenderer();
//            renderer.setColor(COLORS[7]);// 设置描绘器的颜色
//            renderer.setChartValuesFormat(NumberFormat.getPercentInstance());// 设置百分比
//            mRenderer.setChartTitleTextSize(44);// 设置饼图标题大小
//            mRenderer.addSeriesRenderer(renderer);// 将最新的描绘器添加到DefaultRenderer中
//        }if(transport!= 0.0){
//
//            mSeries.add("transport",transport/VALUE);
//            SimpleSeriesRenderer renderer = new SimpleSeriesRenderer();
//            renderer.setColor(COLORS[8]);// 设置描绘器的颜色
//            renderer.setChartValuesFormat(NumberFormat.getPercentInstance());// 设置百分比
//            mRenderer.setChartTitleTextSize(44);// 设置饼图标题大小
//            mRenderer.addSeriesRenderer(renderer);// 将最新的描绘器添加到DefaultRenderer中
//        }if(entertainment!= 0.0){
//
//            mSeries.add("entertainment",entertainment/VALUE);
//            SimpleSeriesRenderer renderer = new SimpleSeriesRenderer();
//            renderer.setColor(COLORS[9]);// 设置描绘器的颜色
//            renderer.setChartValuesFormat(NumberFormat.getPercentInstance());// 设置百分比
//            mRenderer.setChartTitleTextSize(44);// 设置饼图标题大小
//            mRenderer.addSeriesRenderer(renderer);// 将最新的描绘器添加到DefaultRenderer中
//        }if(others!= 0.0){
//
//            mSeries.add("others",others/VALUE);
//            SimpleSeriesRenderer renderer = new SimpleSeriesRenderer();
//            renderer.setColor(COLORS[10]);// 设置描绘器的颜色
//            renderer.setChartValuesFormat(NumberFormat.getPercentInstance());// 设置百分比
//            mRenderer.setChartTitleTextSize(44);// 设置饼图标题大小
//            mRenderer.addSeriesRenderer(renderer);// 将最新的描绘器添加到DefaultRenderer中
//        }if(clothing!= 0.0){
//            mSeries.add("clothing",clothing/VALUE);
//            SimpleSeriesRenderer renderer = new SimpleSeriesRenderer();
//            renderer.setColor(COLORS[11]);// 设置描绘器的颜色
//            renderer.setChartValuesFormat(NumberFormat.getPercentInstance());// 设置百分比
//            mRenderer.setChartTitleTextSize(44);// 设置饼图标题大小
//            mRenderer.addSeriesRenderer(renderer);// 将最新的描绘器添加到DefaultRenderer中
//        }
      // double data[] = new double[] { 403, 219, 121, 1200, 220, 110, 33,2000,28,200,1203 };
//       data[0] = food;
//       data[1] = shopping;
//       data[2] = pets;
//       data[3] = commodity;
//       data[4] = traveling;
//       data[5] = medical;
//       data[6] = study;
//       data[7] = entertainment;
//       data[8] = housing;
//       data[9] = transport;
//       data[10] = others;
//       data[11] = clothing;
//        double data[] = new double[] { food, shopping ,pets ,commodity ,traveling ,medical ,study , entertainment, housing,
//                transport ,others ,clothing};
//
//        for (int i = 0; i < data.length; i++)
//            VALUE += data[i];
//        for (int i = 0; i < data.length; i++) {
//            mSeries.add("示例 " + (i + 1), data[i] / VALUE);// 设置种类名称和对应的数值，前面是（key,value）键值对
//
//            SimpleSeriesRenderer renderer = new SimpleSeriesRenderer();
//            if (i < COLORS.length) {
//                renderer.setColor(COLORS[i]);// 设置描绘器的颜色
//            } else {
//                renderer.setColor(getRandomColor());// 设置描绘器的颜色
//            }
//            renderer.setChartValuesFormat(NumberFormat.getPercentInstance());// 设置百分比
//            mRenderer.setChartTitleTextSize(46);// 设置饼图标题大小
//            mRenderer.addSeriesRenderer(renderer);// 将最新的描绘器添加到DefaultRenderer中
//        }
//
//        if (mChartView == null) {// 为空需要从ChartFactory获取PieChartView
//            mChartView = ChartFactory.getPieChartView(getApplicationContext(),
//                    mSeries, mRenderer);// 构建mChartView
//            mRenderer.setClickEnabled(true);// 允许点击事件
//            mChartView.setOnClickListener(new View.OnClickListener() {// 具体内容
//                @Override
//                public void onClick(View v) {
//                    SeriesSelection seriesSelection = mChartView
//                            .getCurrentSeriesAndPoint();// 获取当前的类别和指针
//                    if (seriesSelection == null) {
//                        Toast.makeText(getApplicationContext(),
//                                "您未选择数据", Toast.LENGTH_SHORT).show();
//                    } else {
//
//
//                        for (int i = 0; i < mSeries.getItemCount(); i++) {
//                            mRenderer.getSeriesRendererAt(i).setHighlighted(i == seriesSelection.getPointIndex());
//                        }
//                        mChartView.repaint();
//                       // Toast.makeText(getApplicationContext(), "Your chosen is" + (seriesSelection.getPointIndex() + 1) + " 项 \n" + NumberFormat.getPercentInstance().format(seriesSelection.getValue()), Toast.LENGTH_SHORT).show();
//                    }
//                }
//            });
//            mLinear.addView(mChartView, new LayoutParams(LayoutParams.FILL_PARENT, LayoutParams.FILL_PARENT));
//        } else {
//            mChartView.repaint();
//        }
    }

    private int getRandomColor() {// 分别产生RBG数值
        Random random = new Random();
        int R = random.nextInt(255);
        int G = random.nextInt(255);
        int B = random.nextInt(255);
        return Color.rgb(R, G, B);
    }



    public void showaddpage1(View view){
        Intent intent = new Intent();
        intent.setClass(MainChart.this,AddPage1.class);
        startActivity(intent);
        MainChart.this.finish();
    }

    public void showchart(View view){
        Intent intent = new Intent();
        intent.setClass(MainChart.this,MainChart.class);
        startActivity(intent);
        MainChart.this.finish();
    }
    public void showuser(View view){
        Intent intent = new Intent();
        intent.setClass(MainChart.this,MainUser.class);
        startActivity(intent);
        MainChart.this.finish();
    }
    public void showaccount(View view){
        Intent intent = new Intent();
        intent.setClass(MainChart.this,MainPage1.class);
        startActivity(intent);
        MainChart.this.finish();
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
            food = 0;
            pets = 0;
            commodity = 0;
            transport = 0;
            traveling = 0;
            medical = 0;
            study = 0 ;
            entertainment = 0;
            clothing = 0;
            shopping = 0;
            transport = 0;
            housing = 0;
            others = 0;
            mySqlList.clear();
        }

        @Override
        protected Void doInBackground(Void... voids) {
            mySqlList = LitePal.findAll(MySql.class);
            for (MySql mySql:mySqlList) { //计算每个类别的总数
                if (mySql.getType().equals("food")){
                    food = food +Float.parseFloat(mySql.getPrice());
                }if (mySql.getType().equals("clothing")){
                    clothing = clothing +Float.parseFloat(mySql.getPrice());
                }if (mySql.getType().equals("pets")){
                    pets = pets +Float.parseFloat(mySql.getPrice());
                }if (mySql.getType().equals("shopping")){
                    shopping = shopping +Float.parseFloat(mySql.getPrice());
                }if (mySql.getType().equals("medical")){
                    medical = medical +Float.parseFloat(mySql.getPrice());
                }if (mySql.getType().equals("commodity")){
                    commodity = commodity +Float.parseFloat(mySql.getPrice());
                }if (mySql.getType().equals("transport")){
                    transport = transport +Float.parseFloat(mySql.getPrice());
                }if (mySql.getType().equals("traveling")){
                    traveling = traveling +Float.parseFloat(mySql.getPrice());
                }if (mySql.getType().equals("study")){
                    study = study +Float.parseFloat(mySql.getPrice());
                }if (mySql.getType().equals("housing")){
                    housing = housing +Float.parseFloat(mySql.getPrice());
                }if (mySql.getType().equals("entertainment")){
                    entertainment = entertainment +Float.parseFloat(mySql.getPrice());
                }if(mySql.getType().equals("others")){
                    others = others+Float.parseFloat(mySql.getPrice());
                }
            }
            return null;
        }

        @Override
        protected void onPostExecute(Void aVoid) {


            double data[] = new double[] { food, shopping ,pets ,commodity ,traveling ,medical ,study , entertainment, housing,
                    transport ,others ,clothing};

            for (int i = 0; i < data.length; i++)
                VALUE += data[i];
            for (int i = 0; i < data.length; i++){
                switch (i){
                    case 0:
                        mSeries.add("food",food/VALUE);
                        break;
                    case 1:
                        mSeries.add("shopping",shopping/VALUE);
                        break;
                    case 2:
                        mSeries.add("pets",pets/VALUE);
                        break;
                    case 3:
                        mSeries.add("commodity",commodity/VALUE);
                        break;
                    case 4:
                        mSeries.add("traveling",traveling/VALUE);
                        break;
                    case 5:
                        mSeries.add("medical",medical/VALUE);
                        break;
                    case 6:
                        mSeries.add("study",study/VALUE);
                        break;
                    case 7:
                        mSeries.add("entertainment",entertainment/VALUE);
                        break;
                    case 8:
                        mSeries.add("housing",housing/VALUE);
                        break;
                    case 9:
                        mSeries.add("transport",transport/VALUE);
                        break;
                    case 10:
                        mSeries.add("others",others/VALUE);
                        break;
                    case 11:
                        mSeries.add("clothing",clothing/VALUE);
                        break;
                }
                SimpleSeriesRenderer renderer = new SimpleSeriesRenderer();
                if (i < COLORS.length) {
                    renderer.setColor(COLORS[i]);// 设置描绘器的颜色
                } else {
                    renderer.setColor(getRandomColor());// 设置描绘器的颜色
                }
                renderer.setChartValuesFormat(NumberFormat.getPercentInstance());// 设置百分比
                mRenderer.setChartTitleTextSize(44);// 设置饼图标题大小
                mRenderer.addSeriesRenderer(renderer);// 将最新的描绘器添加到DefaultRenderer中
            }
            if (mChartView == null) {// 为空需要从ChartFactory获取PieChartView
                mChartView = ChartFactory.getPieChartView(getApplicationContext(),
                        mSeries, mRenderer);// 构建mChartView
                mRenderer.setClickEnabled(true);// 允许点击事件
                mChartView.setOnClickListener(new View.OnClickListener() {// 具体内容
                    @Override
                    public void onClick(View v) {
                        SeriesSelection seriesSelection = mChartView
                                .getCurrentSeriesAndPoint();// 获取当前的类别和指针
                        if (seriesSelection == null) {
                            Toast.makeText(getApplicationContext(),
                                    "您未选择数据", Toast.LENGTH_SHORT).show();
                        } else {


                            for (int i = 0; i < mSeries.getItemCount(); i++) {
                                mRenderer.getSeriesRendererAt(i).setHighlighted(i == seriesSelection.getPointIndex());
                            }
                            mChartView.repaint();

                            switch (seriesSelection.getPointIndex()){
                                case 0:
                                    Toast.makeText(getApplicationContext(), "Your chosen is food \n" + NumberFormat.getPercentInstance().format(seriesSelection.getValue()), Toast.LENGTH_SHORT).show();
                                    break;
                                case 1:
                                    Toast.makeText(getApplicationContext(), "Your chosen is shopping \n" + NumberFormat.getPercentInstance().format(seriesSelection.getValue()), Toast.LENGTH_SHORT).show();
                                    break;
                                case 2:
                                    Toast.makeText(getApplicationContext(), "Your chosen is pets \n" + NumberFormat.getPercentInstance().format(seriesSelection.getValue()), Toast.LENGTH_SHORT).show();
                                    break;
                                case 3:
                                    Toast.makeText(getApplicationContext(), "Your chosen is commodity \n" + NumberFormat.getPercentInstance().format(seriesSelection.getValue()), Toast.LENGTH_SHORT).show();
                                    break;
                                case 4:
                                    Toast.makeText(getApplicationContext(), "Your chosen is traveling \n" + NumberFormat.getPercentInstance().format(seriesSelection.getValue()), Toast.LENGTH_SHORT).show();
                                    break;
                                case 5:
                                    Toast.makeText(getApplicationContext(), "Your chosen is medical \n" + NumberFormat.getPercentInstance().format(seriesSelection.getValue()), Toast.LENGTH_SHORT).show();
                                    break;
                                case 6:
                                    Toast.makeText(getApplicationContext(), "Your chosen is study \n" + NumberFormat.getPercentInstance().format(seriesSelection.getValue()), Toast.LENGTH_SHORT).show();
                                    break;
                                case 7:
                                    Toast.makeText(getApplicationContext(), "Your chosen is entertainment \n" + NumberFormat.getPercentInstance().format(seriesSelection.getValue()), Toast.LENGTH_SHORT).show();
                                    break;
                                case 8:
                                    Toast.makeText(getApplicationContext(), "Your chosen is housing \n" + NumberFormat.getPercentInstance().format(seriesSelection.getValue()), Toast.LENGTH_SHORT).show();
                                    break;
                                case 9:
                                    Toast.makeText(getApplicationContext(), "Your chosen is transport \n" + NumberFormat.getPercentInstance().format(seriesSelection.getValue()), Toast.LENGTH_SHORT).show();
                                    break;
                                case 10:
                                    Toast.makeText(getApplicationContext(), "Your chosen is others \n" + NumberFormat.getPercentInstance().format(seriesSelection.getValue()), Toast.LENGTH_SHORT).show();
                                    break;
                                case 11:
                                    Toast.makeText(getApplicationContext(), "Your chosen is clothing \n" + NumberFormat.getPercentInstance().format(seriesSelection.getValue()), Toast.LENGTH_SHORT).show();
                                    break;

                            }
                            //Toast.makeText(getApplicationContext(), "Your chosen is" + (seriesSelection.getPointIndex() + 1) + " 项 \n" + NumberFormat.getPercentInstance().format(seriesSelection.getValue()), Toast.LENGTH_SHORT).show();
                        }
                    }
                });
                mLinear.addView(mChartView, new LayoutParams(LayoutParams.FILL_PARENT, LayoutParams.FILL_PARENT));
            } else {
                mChartView.repaint();
            }
//
        }

    }

}
