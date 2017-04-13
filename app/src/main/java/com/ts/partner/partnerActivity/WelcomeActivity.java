package com.ts.partner.partnerActivity;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.view.Window;
import android.view.WindowManager;
import com.ts.partner.R;
import com.ts.partner.partnerBase.BaseActivity;
import com.ts.partner.partnerUtils.SystemUtil;
import org.xutils.common.Callback;

/**
 * 登录欢迎界面 有接口之后判断版本做自动更新处理
 */
public class WelcomeActivity extends BaseActivity {
//    SystemUtil su = new SystemUtil(this);
    Intent intent;
//    int isFresh=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setStates();
        setContentView(R.layout.activity_welcome);
//        fresh();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {

//                autoLogin();
                Intent intent=new Intent(WelcomeActivity.this,LoginActivity.class);
                startActivity(intent);
                WelcomeActivity.this.finish();
            }
        }, 2000);
    }

    Handler handler = new Handler();

    //自动登录
//    private void autoLogin() {
//        if ("".equals(su.showPhone()) || su.showPhone() == null || "".equals(su.showPwd()) || su.showPwd() == null) {
//            intent = new Intent(this, LoginActivity.class);
//            startActivity(intent);
//        } else {
//            intent = new Intent(this, TabHomeActivity.class);
//            intent.putExtra("isfresh",isFresh);
//            startActivity(intent);
//        }
//    }
    //设置全屏展示
      private void setStates(){
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            Window window = getWindow();
            // Translucent status bar
//            window.setFlags(
//                    WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS,
//                    WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
//            // Translucent navigation bar
//            window.setFlags(
//                    WindowManager.LayoutParams.FLAG_TRANSLUCENT_NAVIGATION,
//                    WindowManager.LayoutParams.FLAG_TRANSLUCENT_NAVIGATION);
            window.setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                    WindowManager.LayoutParams.FLAG_FULLSCREEN);
        }
    }
    Callback.Cancelable cancelable;
//    private void fresh() {
//
//       cancelable= NetUtils.Get(BaseData.GETVERSION, null, new Callback.CommonCallback<String>() {
//            @Override
//            public void onSuccess(String result) {
//                GetversionBean bean=new Gson().fromJson(result,GetversionBean.class);
//                if(bean.getData().get(0).getNumber()>SystemUtil.getVersionCode()){
//                    //显示是否更新的对话框
//                    isFresh=1;
//                }else {
//                    isFresh=0;
//
//                }
//            }
//
//            @Override
//            public void onError(Throwable ex, boolean isOnCallback) {
//                toast(getString(R.string.net_error));
//            }
//
//            @Override
//            public void onCancelled(CancelledException cex) {
//
//            }
//
//            @Override
//            public void onFinished() {
//            }
//        })    ;
//
//    }
}
