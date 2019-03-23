package com.example.myapplication;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class MyListAdapter extends RecyclerView.Adapter<MyListAdapter.ViewHolder> {

    static List<MySql> mMysqlList;
    private Context mContext;
    static class ViewHolder extends RecyclerView.ViewHolder {
        ImageView typeimg;
        TextView time;
        TextView price;
        TextView type;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            typeimg = (ImageView) itemView.findViewById(R.id.imageView_item_image);
            time = (TextView) itemView.findViewById(R.id.textView_item_date);
            price = (TextView) itemView.findViewById(R.id.textView_item_money);
            type = (TextView) itemView.findViewById(R.id.textView_item_type);
        }
    }

    public MyListAdapter(Context context,List<MySql> accountList){
        mContext = context;
        mMysqlList = accountList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.list_item, viewGroup, false);
        ViewHolder holder = new ViewHolder( view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {
        MySql mySql = mMysqlList.get(i);
        switch (mySql.getType()){
            case "pets":
                viewHolder.typeimg.setImageResource(R.drawable.chongwu);
                break;
            case "food":
                viewHolder.typeimg.setImageResource(R.drawable.canyin);
                break;
            case "clothing":
                viewHolder.typeimg.setImageResource(R.drawable.fushi);
                break;
            case "salary":
                viewHolder.typeimg.setImageResource(R.drawable.gongzi);
                break;
            case "shopping":
                viewHolder.typeimg.setImageResource(R.drawable.gouwu);
                break;
            case "part-time job":
                viewHolder.typeimg.setImageResource(R.drawable.jianzhi);
                break;
            case "transport":
                viewHolder.typeimg.setImageResource(R.drawable.jiaotong);
                break;
            case "traveling":
                viewHolder.typeimg.setImageResource(R.drawable.lvhang);
                break;
            case "others":
                viewHolder.typeimg.setImageResource(R.drawable.qita);
                break;
            case "commodity":
                viewHolder.typeimg.setImageResource(R.drawable.riyongcopy);
                break;
            case "study":
                viewHolder.typeimg.setImageResource(R.drawable.xuexi);
                break;
            case "medical":
                viewHolder.typeimg.setImageResource(R.drawable.yiliao);
                break;
            case "entertainment":
                viewHolder.typeimg.setImageResource(R.drawable.yule);
                break;
            case "housing":
                viewHolder.typeimg.setImageResource(R.drawable.zhufang);
                break;
            case "other incomes":
                viewHolder.typeimg.setImageResource(R.drawable.qita);
                break;
        }

        if (mySql.getPrice().equals("")){
            mySql.setPrice("0");
        }


     //   viewHolder.price.setText(mySql.getType());
        if (mySql.getPriceType()==1){
            viewHolder.price.setText("+"+String.valueOf(mySql.getPrice()));
        }else {
            viewHolder.price.setText("-"+String.valueOf(mySql.getPrice()));
        }
        viewHolder.time.setText(mySql.getTime());
        viewHolder.type.setText(mySql.getType());

    }

    @Override
    public int getItemCount() {
        return mMysqlList.size();
    }
}
