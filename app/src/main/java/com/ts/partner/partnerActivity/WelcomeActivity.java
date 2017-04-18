package com.ts.partner.partnerActivity;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.view.Window;
import android.view.WindowManager;

import com.google.gson.Gson;
import com.ts.partner.R;
import com.ts.partner.partnerBase.BaseActivity;
import com.ts.partner.partnerBase.BaseData;
import com.ts.partner.partnerBean.netBean.GetversionBean;
import com.ts.partner.partnerUtils.NetUtils;
import com.ts.partner.partnerUtils.SystemUtil;
import org.xutils.common.Callback;

/**
 * 登录欢迎界面 有接口之后判断版本做自动更新处理
 */
public class WelcomeActivity extends BaseActivity {
    Intent intent;
    int isFresh=0; //是否进行更新的标识 1，更新  0 不更新
    SystemUtil su=new SystemUtil(this);
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setStates();
        setContentView(R.layout.activity_welcome);
        fresh();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent=new Intent(WelcomeActivity.this,LoginActivity.class);
                intent.putExtra("isfresh",isFresh);
                loge("isfresh",isFresh+"");
                startActivity(intent);
                WelcomeActivity.this.finish();
                if(cancelable!=null){
                    cancelable.cancel();
                }
            }
        }, 2000);
    }

    Handler handler = new Handler();

    //设置全屏展示
      private void setStates(){
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            Window window = getWindow();
            window.setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                    WindowManager.LayoutParams.FLAG_FULLSCREEN);
        }
    }
    Callback.Cancelable cancelable;
    private void fresh() {

       cancelable= NetUtils.Post(BaseData.VERSIONCODE, null, new Callback.CommonCallback<String>() {
            @Override
            public void onSuccess(String result) {
                GetversionBean bean=new Gson().fromJson(result,GetversionBean.class);
                if(bean.getData().get(0).getNumber()>SystemUtil.getVersionCode()){
                    //显示是否更新的对话框
                    isFresh=1;
                }else {
                    isFresh=0;
                }
            }

            @Override
            public void onError(Throwable ex, boolean isOnCallback) {

            }

            @Override
            public void onCancelled(CancelledException cex) {

            }

            @Override
            public void onFinished() {
            }
        })    ;

    }
}
