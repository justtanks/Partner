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
    int todayMoney;
    int todayOrderCount;
    int yesdayMoney;
    int yesdayOrderCount;

    int allMoney;
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
        if (bean != null) {


            if (bean != null && bean.getToday_money() != null) {
                for (LoginDataBean.DataBean.MoneyBean mon : bean.getToday_money()) {
                    this.todayMoney += mon.getMoney();
                }
            }
            if (bean != null && bean.getYesterday_money() != null) {
                for (LoginDataBean.DataBean.MoneyBean mon : bean.getYesterday_money()) {
                    this.yesdayMoney += mon.getMoney();
                }
            }
            if (bean.getAll_order() != null) {
                this.allorders = bean.getAll_order().size();
            }
            if (bean.getToday_order() != null) {
                this.todayOrderCount = bean.getToday_order().size();
            }
            if (bean.getYesterday_order() != null) {
                this.yesdayOrderCount = bean.getYesterday_order().size();
            }
            if (bean.getPartner_infos() != null) {

                if (bean.getPartner_infos().get(0) != null) {
                    String income=bean.getPartner_infos().get(0).getPartner_income();
                    if(null!=income&&!"".equals(income)){
                        int incom=Integer.parseInt(income);
                        this.allMoney = incom;
                    }else {
                        this.allMoney=0;
                    }
                    String banlance=bean.getPartner_infos().get(0).getPartner_balance();
                    if(null!=banlance&&!"".equals(banlance)){
                        this.ketixian =Integer.parseInt(banlance) ;
                    }else{
                        this.ketixian=0;
                    }
                } else {
                    this.allMoney = 0;
                    this.ketixian = 0;

                }
            }
        }
        getdayTime();

    }

    //    private String getTodaytime(){
//        SimpleDateFormat formatter = new SimpleDateFormat("yyyy年MM月dd日:");
//        Date curDate = new Date(System.currentTimeMillis());//获取当前时间
//       return formatter.format(curDate);
//    }
    private void getdayTime() {
        Date today = new Date();
        this.todayTime = new SimpleDateFormat("yyyy年MM月dd日:").format(today);
        Date yesterday = new Date(today.getTime() - 86400000L);
        this.yestodaytime = new SimpleDateFormat("yyyy年MM月dd日:").format(yesterday);
        Date beforeyestoday = new Date(yesterday.getTime() - 86400000L);
        this.beforyedaytime = new SimpleDateFormat("yyyy年MM月dd日:").format(beforeyestoday);
    }


    public DatasInMain() {

    }

    public int getTodayMoney() {
        return todayMoney;
    }

    public void setTodayMoney(int todayMoney) {
        this.todayMoney = todayMoney;
    }

    public int getTodayOrderCount() {
        return todayOrderCount;
    }

    public void setTodayOrderCount(int todayOrderCount) {
        this.todayOrderCount = todayOrderCount;
    }

    public int getYesdayMoney() {
        return yesdayMoney;
    }

    public void setYesdayMoney(int yesdayMoney) {
        this.yesdayMoney = yesdayMoney;
    }

    public int getYesdayOrderCount() {
        return yesdayOrderCount;
    }

    public void setYesdayOrderCount(int yesdayOrderCount) {
        this.yesdayOrderCount = yesdayOrderCount;
    }

    public int getAllMoney() {
        return allMoney;
    }

    public void setAllMoney(int allMoney) {
        this.allMoney = allMoney;
    }
}
