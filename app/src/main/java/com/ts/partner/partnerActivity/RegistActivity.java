package com.ts.partner.partnerActivity;

import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.View;

import com.google.gson.Gson;
import com.ts.partner.R;
import com.ts.partner.databinding.ActivityRegistBinding;
import com.ts.partner.partnerBase.BaseActivity;
import com.ts.partner.partnerBase.BaseData;
import com.ts.partner.partnerBean.netBean.NetError;
import com.ts.partner.partnerBean.netBean.Regist_phoneback;
import com.ts.partner.partnerUtils.NetUtils;

import org.xutils.common.Callback;

import java.util.HashMap;
import java.util.Map;

//注册界面
public class RegistActivity extends BaseActivity implements View.OnClickListener {
    ActivityRegistBinding b;
    String yanzheng;//验证码
    Gson gson = new Gson();
    String userphone;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        b = DataBindingUtil.setContentView(this, R.layout.activity_regist);
        init();
    }

    private void init() {
        b.registBack.setOnClickListener(this);
        b.registBt.setOnClickListener(this);
        b.registTextback.setOnClickListener(this);
        b.registXieyi.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.regist_back:
                onBackPressed();
                break;
            case R.id.regist_bt:
                registOnNet();
                break;
            case R.id.regist_textback:
                getPhoneText();
                break;
            case R.id.regist_xieyi:
                toXieyi();
                break;

        }
    }

    //跳转到协议界面
    private void toXieyi() {
        Intent intent = new Intent(this, AgreeMentActivity.class);
        startActivity(intent);
    }

    //访问服务器注册 tel/123/password/123456
    private void registOnNet() {
        String phone = b.registPhone.getText().toString();
        String psw = b.registPass.getText().toString();
        if (phone == null || phone.equals("")) {
            toast("请输入手机号");
            return;
        }
        if (psw == null || psw.equals("")) {
            toast("请输入密码");
            return;
        }
        if (!b.registCheck.isChecked()) {
            toast("请阅读企成成合伙人协议");
            return;
        }
        if (!phone.equals(userphone)) {
            toast("和验证码使用手机不一致");
            return;
        }
        if (!yanzheng.equals(b.registText.getText().toString())) {
            toast("请输入验证码");
            return;
        }
        if (yanzheng != null && b.registText.getText().toString().equals(yanzheng)) {
            b.registText.setText("");
            Map<String, Object> params = new HashMap<>();
            params.put("tel", phone);
            params.put("password", psw);
            NetUtils.Post(BaseData.REGIST, params, new Callback.CommonCallback<String>() {
                @Override
                public void onSuccess(String result) {
                    if (result.substring(0, 18).contains("Error")) {
                        NetError error = gson.fromJson(result, NetError.class);
                        toast(error.getMsg());
                    } else {
                        Regist_phoneback suce = gson.fromJson(result, Regist_phoneback.class);
                        if (suce.getFlag().equalsIgnoreCase("Success")) {
                            onBackPressed();
                            toast("注册成功");
                            finish();
                        }
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
            });
        } else {
            toast("验证码错误，请重新输入");
        }

    }

    //获取验证码人
    public void getPhoneText() {
        final String phone = b.registPhone.getText().toString();
        if (null == phone || "".equals(phone)) {
            toast("请输入手机号");
            return;
        }
        b.registTextback.setVisibility(View.GONE);
        handler.post(runnable);
        Map<String, String> apends = new HashMap<>();
        apends.put("agent_tel", phone);
        NetUtils.Get(BaseData.DUANXINYANZHENG, apends, new Callback.CommonCallback<String>() {
            @Override
            public void onSuccess(String result) {
                Regist_phoneback phoneMsg = gson.fromJson(result, Regist_phoneback.class);
                yanzheng = phoneMsg.getMsg();
                userphone = phone;
            }

            @Override
            public void onError(Throwable ex, boolean isOnCallback) {
                toast(getString(R.string.net_error));

            }

            @Override
            public void onCancelled(CancelledException cex) {

            }

            @Override
            public void onFinished() {

            }
        });

    }

    private int beginTime = 30;
    Handler handler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            switch (msg.what) {
                case 1:
                    b.registBttext.setText("请等待" + "(" + beginTime + ")");
                    break;
                case 2:
                    beginTime = 30;
                    b.registTextback.setVisibility(View.VISIBLE);
                    b.registBttext.setText(R.string.huoquyanzhengma);
                    break;
            }

        }
    };
    Runnable runnable = new Runnable() {
        @Override
        public void run() {
            handler.sendEmptyMessage(1);
            if (beginTime > 0) {
                beginTime--;
                handler.postDelayed(runnable, 1000);
            } else {
                handler.sendEmptyMessage(2);
            }

        }
    };
}
