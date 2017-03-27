package com.ts.partner.partnerBean.BendingBean;

import android.util.Log;

import com.ts.partner.partnerBean.netBean.LoginBean;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by Administrator on 2017/2/13.
 * 主界面用于展示数据的databinding实用类
 */

public class DatasInMain {
    String todayMoney;
    String todayOrderCount;
    String yesdayMoney;
    String yesdayOrderCount;
    String beyesdayMoney;
    String beyesdayOrderCount;
    String allMoney;
    String todayTime;
    String yestodaytime;
    String beforyedaytime;
    int ketixian;

    public int getKetixian() {
        return ketixian;
    }

    public void setKetixian(int ketixian) {
        this.ketixian = ketixian;
    }

    public String getTodayTime() {
        return todayTime;
    }

    public void setTodayTime(String todayTime) {
        this.todayTime = todayTime;
    }

    public String getYestodaytime() {
        return yestodaytime;
    }

    public void setYestodaytime(String yestodaytime) {
        this.yestodaytime = yestodaytime;
    }

    public String getBeforyedaytime() {
        return beforyedaytime;
    }

    public void setBeforyedaytime(String beforyedaytime) {
        this.beforyedaytime = beforyedaytime;
    }

    public DatasInMain(LoginBean.DataBean bean) {
        this.todayMoney = bean.getPartner_today_order_money();
        this.todayOrderCount = bean.getPartner_today_order_count();
        this.yesdayMoney = bean.getPartner_yesterday_order_money();
        this.yesdayOrderCount = bean.getPartner_yesterday_order_count();
        this.beyesdayMoney = bean.getPartner_before_yesterday_order_money();
        this.beyesdayOrderCount = bean.getPartner_before_yesterday_order_count();
        this.allMoney = bean.getPartner_all_money();
        this.ketixian=bean.getPartner_account_balance();
        Log.e("log",bean.getPartner_account_balance()+"");
        getdayTime();

    }

//    private String getTodaytime(){
//        SimpleDateFormat formatter = new SimpleDateFormat("yyyy年MM月dd日:");
//        Date curDate = new Date(System.currentTimeMillis());//获取当前时间
//       return formatter.format(curDate);
//    }
    private void getdayTime(){
        Date today = new Date();
        this.todayTime=new SimpleDateFormat("yyyy年MM月dd日:").format(today);
        Date yesterday = new Date(today.getTime() - 86400000L);
       this.yestodaytime= new SimpleDateFormat("yyyy年MM月dd日:").format(yesterday);
        Date beforeyestoday=new Date(yesterday.getTime()-86400000L);
        this.beforyedaytime=new SimpleDateFormat("yyyy年MM月dd日:").format(beforeyestoday);
    }



    public DatasInMain() {

    }

    public String getTodayMoney() {
        return todayMoney;
    }

    public void setTodayMoney(String todayMoney) {
        this.todayMoney = todayMoney;
    }

    public String getTodayOrderCount() {
        return todayOrderCount;
    }

    public void setTodayOrderCount(String todayOrderCount) {
        this.todayOrderCount = todayOrderCount;
    }

    public String getYesdayMoney() {
        return yesdayMoney;
    }

    public void setYesdayMoney(String yesdayMoney) {
        this.yesdayMoney = yesdayMoney;
    }

    public String getYesdayOrderCount() {
        return yesdayOrderCount;
    }

    public void setYesdayOrderCount(String yesdayOrderCount) {
        this.yesdayOrderCount = yesdayOrderCount;
    }

    public String getBeyesdayMoney() {
        return beyesdayMoney;
    }

    public void setBeyesdayMoney(String beyesdayMoney) {
        this.beyesdayMoney = beyesdayMoney;
    }

    public String getBeyesdayOrderCount() {
        return beyesdayOrderCount;
    }

    public void setBeyesdayOrderCount(String beyesdayOrderCount) {
        this.beyesdayOrderCount = beyesdayOrderCount;
    }

    public String getAllMoney() {
        return allMoney;
    }

    public void setAllMoney(String allMoney) {
        this.allMoney = allMoney;
    }

    @Override
    public String toString() {
        return "DatasInMain{" +
                "todayMoney='" + todayMoney + '\'' +
                ", todayOrderCount='" + todayOrderCount + '\'' +
                ", yesdayMoney='" + yesdayMoney + '\'' +
                ", yesdayOrderCount='" + yesdayOrderCount + '\'' +
                ", beyesdayMoney='" + beyesdayMoney + '\'' +
                ", beyesdayOrderCount='" + beyesdayOrderCount + '\'' +
                ", allMoney='" + allMoney + '\'' +
                '}';
    }
}
