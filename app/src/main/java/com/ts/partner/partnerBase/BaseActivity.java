package com.ts.partner.partnerBase;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.Toast;

/**
 * Created by Administrator on 2016/12/28.
 * activity基类
 */

public abstract class BaseActivity extends AppCompatActivity {


    @Override
    protected void onResume() {
        super.onResume();

    }

    @Override
    protected void onPause() {
        super.onPause();
    }

    @Override
    protected void onRestart() {
        super.onRestart();
    }

    @Override
    protected void onStart() {
        super.onStart();
    }

    @Override
    protected void onStop() {
        super.onStop();

    }

      public void loge(String logMsg){
          Log.e("log",logMsg);

    }
    public void loge(String key,String logMsg){
        Log.e(key,logMsg);
    }

    public void toast(String msg){
        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show();
    }
    public void longToast(String msg){
        Toast.makeText(this, msg, Toast.LENGTH_LONG).show();
    }


    //判断是否能够连接到网络
    public boolean isConnect() {
        ConnectivityManager connectivity = (ConnectivityManager) this
                .getSystemService(Context.CONNECTIVITY_SERVICE);
        if (connectivity != null) {
            NetworkInfo info = connectivity.getActiveNetworkInfo();
            if (info != null && info.isConnected()) {
                if (info.getState() == NetworkInfo.State.CONNECTED) {
                    return true;
                }
            }
        }
        Toast.makeText(this, "请检查你的网络", Toast.LENGTH_SHORT).show();
        return false;
    }
}
