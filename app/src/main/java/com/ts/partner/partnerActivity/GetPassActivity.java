package com.ts.partner.partnerActivity;

import android.databinding.DataBindingUtil;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.google.gson.Gson;
import com.ts.partner.R;
import com.ts.partner.databinding.ActivityGetPassBinding;
import com.ts.partner.partnerBase.BaseActivity;
import com.ts.partner.partnerBase.BaseData;
import com.ts.partner.partnerBean.netBean.NetError;
import com.ts.partner.partnerBean.netBean.Regist_phoneback;
import com.ts.partner.partnerUtils.NetUtils;

import org.xutils.common.Callback;

import java.util.HashMap;
import java.util.Map;

//找回密码界面
public class GetPassActivity extends BaseActivity implements View.OnClickListener {
    ActivityGetPassBinding b;
    String yanzheng;//验证码
    Gson gson = new Gson();
    String userphone;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        b = DataBindingUtil.setContentView(this, R.layout.activity_get_pass);
        init();
    }

    private void init() {
        b.getpassBack.setOnClickListener(this);
        b.getpassTijiao.setOnClickListener(this);
        b.getpassTextback.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.getpass_back:
                onBackPressed();
                break;
            case R.id.getpass_tijiao:
                changePassOnNet();
                break;
            case R.id.getpass_textback:
                getPhoneText();
                break;
        }
    }

    //tel/18266142739/new_password/123456
    private void changePassOnNet() {
        String phone = b.getpassPhone.getText().toString();
        String psw = b.getpassPass.getText().toString();
        if (phone == null || phone.equals("")) {
            toast("请输入手机号");
            return;
        }
        if (psw == null || psw.equals("")) {
            toast("请输入密码");
            return;
        }
        if (!yanzheng.equals(b.getpassText.getText().toString())) {
            toast("请输入验证码");
            return;
        }
        if (yanzheng != null && b.getpassText.getText().toString().equals(yanzheng)) {
            b.getpassText.setText("");
            Map<String, Object> params = new HashMap<>();
            params.put("tel", phone);
            params.put("new_password", psw);
            NetUtils.Post(BaseData.CHANGEPASS, params, new Callback.CommonCallback<String>() {
                @Override
                public void onSuccess(String result) {
                    if (result.substring(0, 18).contains("Error")) {
                        NetError error = gson.fromJson(result, NetError.class);
                        toast(error.getMsg());
                    } else {
                        toast(getString(R.string.xiugaichenggong));
                        onBackPressed();
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
        final String phone = b.getpassPhone.getText().toString();
        if (null == phone || "".equals(phone)) {
            toast("请输入手机号");
            return;
        }
        b.getpassTextback.setVisibility(View.GONE);
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
                    b.getpassBttext.setText("请等待" + "(" + beginTime + ")");
                    break;
                case 2:
                    beginTime = 30;
                    b.getpassTextback.setVisibility(View.VISIBLE);
                    b.getpassBttext.setText(R.string.huoquyanzhengma);
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
