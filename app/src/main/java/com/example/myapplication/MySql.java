package com.example.myapplication;

import org.litepal.LitePal;
import org.litepal.crud.LitePalSupport;

public class MySql extends LitePalSupport {
    private int flag; //flag,1 = expense，0 = income
    private String price;
    private String type; //the type of expense, e.g food,fruits,
    private String time;

    public int getPriceType() {
        return flag;
    }

    public void setPriceType(int flag) {
        this.flag= flag;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }
}
