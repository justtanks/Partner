package com.ts.partner.partnerBean.BendingBean;

import android.util.Log;

import com.ts.partner.partnerBean.netBean.LoginDataBean;

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

    String allMoney;
    String todayTime;
    String yestodaytime;
    String beforyedaytime;
    int allorders;

    public int getAllorders() {
        return allorders;
    }

    public void setAllorders(int allorders) {
        this.allorders = allorders;
    }

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

    public DatasInMain(LoginDataBean.DataBean bean) {

        for(LoginDataBean.DataBean.MoneyBean mon:bean.getToday_money()){
                this.todayMoney+=mon.getMoney();
        }
        for(LoginDataBean.DataBean.MoneyBean mon:bean.getYesterday_money()){
            this.yesdayMoney+=mon.getMoney();
        }
        this.allorders=bean.getAll_order().size();
        this.todayOrderCount = bean.getToday_order().size()+"";
        this.yesdayOrderCount = bean.getYesterday_order().size()+"";
        this.allMoney = bean.getPartner_infos().get(0).getPartner_income()+"";
        this.ketixian=bean.getPartner_infos().get(0).getPartner_balance();
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
    public String getAllMoney() {
        return allMoney;
    }

    public void setAllMoney(String allMoney) {
        this.allMoney = allMoney;
    }
}
