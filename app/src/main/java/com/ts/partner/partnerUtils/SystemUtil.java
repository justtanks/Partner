package com.ts.partner.partnerUtils;


import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;

import com.ts.partner.partnerApplication.MyApplication;

/**
 * 记录用户基本信息
 */

public class SystemUtil {
    private static final String MINE = "partner";
    private Context context;
    private static final String OPENID = "openID";
    private static final String RMEMBER = "remember";
    private static final String UID = "uid";
    private static final String ONLY_ID = "only_id";
    private static final String ZHIFU = "zhifurenmember";
    private static final String NAME = "name";
    private static final String PHONE = "phonenum";
    private static final String PWD = "pass";
    private static final String USER_HEADER = "user_header";


    private static final String MODEL_STATE = "modle_state";
    private static final String IS_SHOW = "is_show";
    private static final String REGESTERSTATE = "regesterstate";


    public SystemUtil(Context context) {
        this.context = context;
    }


    /*
    保存是否注册
     */
    public void saveRegesterState(int state) {
        SharedPreferences preferences = context.getSharedPreferences(MINE,
                Context.MODE_PRIVATE);
        Editor editor = preferences.edit();
        editor.putInt(REGESTERSTATE, state);
        editor.commit();
    }

    public int showRegesterState() {
        SharedPreferences preferences = context.getSharedPreferences(MINE,
                Context.MODE_PRIVATE);
        int state = preferences.getInt(REGESTERSTATE, -1);//默认-1没有注册
        return state;
    }


    public void saveIsShow(int num) {
        SharedPreferences preferences = context.getSharedPreferences(MINE,
                Context.MODE_PRIVATE);
        Editor editor = preferences.edit();
        editor.putInt(IS_SHOW, num);
        editor.commit();
    }

    public int showIsShow() {
        SharedPreferences preferences = context.getSharedPreferences(MINE,
                Context.MODE_PRIVATE);
        int isShow = preferences.getInt(IS_SHOW, 0);
        return isShow;
    }

    //存放添加银行卡流程标识，如果是从提现添加 是1 从银行卡界面添加是2
    public void saveModle1(int num) {
        SharedPreferences preferences = context.getSharedPreferences(MINE,
                Context.MODE_PRIVATE);
        Editor editor = preferences.edit();
        editor.putInt(MODEL_STATE, num);
        editor.commit();
    }

    public int showModle() {
        SharedPreferences preferences = context.getSharedPreferences(MINE,
                Context.MODE_PRIVATE);
        int isTiming = preferences.getInt(MODEL_STATE, 0);
        return isTiming;
    }


/*
  用户头像
 */
    public void saveUserHeader(String url) {
        SharedPreferences preferences = context.getSharedPreferences(MINE,
                Context.MODE_PRIVATE);
        Editor editor = preferences.edit();
        editor.putString(USER_HEADER, url);
        editor.commit();
    }

    public String getUserHeader() {
        SharedPreferences preferences = context.getSharedPreferences(MINE,
                Context.MODE_PRIVATE);
        String url = preferences.getString(USER_HEADER, "");
        return url;

    }

    public String showUserHeader() {
        SharedPreferences preferences = context.getSharedPreferences(MINE,
                Context.MODE_PRIVATE);
        String url = preferences.getString(USER_HEADER, "");
        return url;
    }

    public void saveOnlyID(String onlyID) {
        SharedPreferences preferences = context.getSharedPreferences(MINE,
                Context.MODE_PRIVATE);
        Editor editor = preferences.edit();
        editor.putString(ONLY_ID, onlyID);
        editor.commit();
    }


    public String showOnlyID() {
        SharedPreferences preferences = context.getSharedPreferences(MINE,
                Context.MODE_PRIVATE);
        String onlyid = preferences.getString(ONLY_ID, "");
        return onlyid;
    }

    public void saveUid(int uid) {
        SharedPreferences preferences = context.getSharedPreferences(MINE,
                Context.MODE_PRIVATE);
        Editor editor = preferences.edit();
        editor.putInt(UID, uid);
        editor.commit();
    }


    public int showUid() {
        SharedPreferences preferences = context.getSharedPreferences(MINE,
                Context.MODE_PRIVATE);
        int uid = preferences.getInt(UID, -1);
        return uid;
    }
/*
支付状态
 */
    public void saveZhifuR(int state) {
        SharedPreferences preferences = context.getSharedPreferences(MINE,
                Context.MODE_PRIVATE);
        Editor editor = preferences.edit();
        editor.putInt(ZHIFU, state);
        editor.commit();
    }

    public int showZhifuR() {
        SharedPreferences preferences = context.getSharedPreferences(MINE,
                Context.MODE_PRIVATE);
        int state = preferences.getInt(ZHIFU, -1);
        return state;
    }
/*
记住密码状态
 */
    public void saveRemember(int remember) {
        SharedPreferences preferences = context.getSharedPreferences(MINE,
                Context.MODE_PRIVATE);
        Editor editor = preferences.edit();
        editor.putInt(RMEMBER, remember);
        editor.commit();
    }

    public int showRemember() {
        SharedPreferences preferences = context.getSharedPreferences(MINE,
                Context.MODE_PRIVATE);
        int remember = preferences.getInt(RMEMBER, -1);
        return remember;
    }
/*
保存用户名
 */
    public void saveName(String name) {
        SharedPreferences preferences = context.getSharedPreferences(MINE,
                Context.MODE_PRIVATE);
        Editor editor = preferences.edit();
        editor.putString(NAME, name);
        editor.commit();
    }

    public String showName() {
        SharedPreferences preferences = context.getSharedPreferences(MINE,
                Context.MODE_PRIVATE);
        String Name = preferences.getString(NAME, "");
        return Name;
    }
    /*
    保存用户电话  同时是用户名
     */

    public void savePhone(String num) {
        SharedPreferences preferences = context.getSharedPreferences(MINE,
                Context.MODE_PRIVATE);
        Editor editor = preferences.edit();
        editor.putString(PHONE, num);
        editor.commit();
    }

    public String showPhone() {
        SharedPreferences preferences = context.getSharedPreferences(MINE,
                Context.MODE_PRIVATE);
        String Name = preferences.getString(PHONE, "");
        return Name;
    }
    /*
      密码保存
     */
    public void savePwd(String num) {
        SharedPreferences preferences = context.getSharedPreferences(MINE,
                Context.MODE_PRIVATE);
        Editor editor = preferences.edit();
        editor.putString(PWD, num);
        editor.commit();
    }

    public String showPwd() {
        SharedPreferences preferences = context.getSharedPreferences(MINE,
                Context.MODE_PRIVATE);
        String Name = preferences.getString(PWD, "");
        return Name;
    }

    public static void saveOpenID(String openID) {
        SharedPreferences preferences = MyApplication.getContext().getSharedPreferences(
                MINE, Context.MODE_PRIVATE);
        Editor editor = preferences.edit();
        editor.putString(OPENID, openID);
        editor.commit();
    }

    public static String showOpenID() {
        SharedPreferences preferences = MyApplication.getContext().getSharedPreferences(
                MINE, Context.MODE_PRIVATE);
        String openID = preferences.getString(OPENID, "");
        return openID;
    }

    public static void clear() {
        SharedPreferences preferences = MyApplication.getContext().getSharedPreferences(
                MINE, Context.MODE_PRIVATE);
        Editor editor = preferences.edit();
        editor.clear().commit();
    }

}
