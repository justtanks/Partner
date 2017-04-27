package com.ts.partner.partnerActivity;

import android.app.ProgressDialog;
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
import com.ts.partner.partnerBean.netBean.LoginDataBean;
import com.ts.partner.partnerBean.netBean.NetError;
import com.ts.partner.partnerUtils.NetUtils;
import com.ts.partner.partnerUtils.SystemUtil;
import org.xutils.common.Callback;

import java.util.HashMap;
import java.util.Map;

/**
 * 登录欢迎界面 有接口之后判断版本做自动更新处理
 * 添加登录方法 分两种情况进行登录 ，一种是存在账号密码 然后调用登录接口
 * 一种是没有账号密码然后通过跳转到登陆界面进行登录 或者在网络比较差情况之下跳到
 * 登录界面登录
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
                isHaveApass();
            }
        }, 500);
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

    //判断是否有账号密码
    private void isHaveApass(){
        if ("".equals(su.showPhone()) || su.showPhone() == null || "".equals(su.showPwd()) || su.showPwd() == null) {
            loginHavenoPass();
            WelcomeActivity.this.finish();
        } else {
            logWithPass(su.showPhone(),su.showPwd());
        }
        if(cancelable!=null){
            cancelable.cancel();
        }
    }
    //存在账号密码的登录
    private void logWithPass(String phone,String pass){
        Map<String, String> params = new HashMap<>();
        params.put("partner_tel", phone);
        params.put("partner_password", pass);
          NetUtils.Get(BaseData.LOGIN, params, new Callback.CommonCallback<String>() {
            @Override
            public void onSuccess(String result) {
                Gson gson = new Gson();
                String cutResult = result.substring(0, 19);
                if (cutResult.contains("Error")) {
                    NetError error = gson.fromJson(result, NetError.class);
                    toast(error.getMsg());
                    loginHavenoPass();
                    error = null;
                    return;
                } else {
                    LoginDataBean login = gson.fromJson(result, LoginDataBean.class);
                    if ("Success".equals(login.getFlag())) {
                        Intent intent = new Intent(WelcomeActivity.this, HomeActivity.class);
                        intent.putExtra("isfresh", isFresh);
                        intent.putExtra(LoginActivity.DATAS_KEY, login);
                        startActivity(intent);
                        WelcomeActivity.this.finish();
                        login = null;
                    } else {
                        login = null;
                        return;
                    }
                }
            }

            @Override
            public void onError(Throwable ex, boolean isOnCallback) {
                toast("登录错误，请手动登录");
                loginHavenoPass();

            }

            @Override
            public void onCancelled(CancelledException cex) {
            }

            @Override
            public void onFinished() {

            }
        });
    }
    //不存在的登录
    private  void loginHavenoPass(){
        Intent intent=new Intent(WelcomeActivity.this,LoginActivity.class);
        intent.putExtra("isfresh",isFresh);
        startActivity(intent);
    }
}
