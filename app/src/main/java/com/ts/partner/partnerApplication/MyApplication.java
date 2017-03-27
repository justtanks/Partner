package com.ts.partner.partnerApplication;

import android.app.Application;
import android.content.Context;

import com.ts.partner.partnerUtils.SystemUtil;

import org.xutils.x;


/**
 * Created by Administrator on 2016/12/28.
 */

public class MyApplication extends Application {
    private static Context sContext;
    @Override
    public void onCreate() {
        super.onCreate();
        x.Ext.init(this);
        sContext=getApplicationContext();
//        SystemUtil systemUtil=new SystemUtil(this);

    }
    public static Context getContext(){
        return sContext;
    }


}
