package com.ts.partner.partnerActivity;

import android.app.Activity;
import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;

import com.google.gson.Gson;
import com.ts.partner.R;
import com.ts.partner.databinding.PhoneTestBinding;
import com.ts.partner.partnerBase.BaseActivity;
import com.ts.partner.partnerBase.BaseData;
import com.ts.partner.partnerBean.netBean.Regist_phoneback;
import com.ts.partner.partnerUtils.NetUtils;

import org.xutils.common.Callback;

import java.util.HashMap;
import java.util.Map;

/*
短信验证的activity
 */
public class PhoneTestActivity extends BaseActivity implements View.OnClickListener {
    PhoneTestBinding binding;
    String cardnum = "";
    String cardcity = "";
    String phone = "";
    String yanzhen="";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_phone_test);
        init();
    }



    private void init() {
        binding.phoneback.setOnClickListener(this);
        binding.phonetextNextstep.setOnClickListener(this);
        cardnum = getIntent().getStringExtra("cardnum");
        cardcity = getIntent().getStringExtra("cardcity");
        phone = getIntent().getStringExtra("phone");
        loge(phone);
        binding.phonetextText.setText(phone + "返回的验证码");
        binding.phonetestObtainmsg.setOnClickListener(this);
        binding.phonetestYanzhengma.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                String text = binding.phonetestYanzhengma.getText().toString();
                if (null == text || "".equals(text)) {
                    binding.phonetextNextstep.setEnabled(false);
                    binding.phonetextNextstep.setBackgroundResource(R.mipmap.addcard_next_moren);
                } else {
                    binding.phonetextNextstep.setEnabled(true);
                    binding.phonetextNextstep.setBackgroundResource(R.drawable.selector_addcard_nextstep);
                }

            }
        });
    }


    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.phoneback:
                onBackPressed();
                break;
            case R.id.phonetext_nextstep:
                jump();
                break;
            case R.id.phonetest_obtainmsg:
                getWordFromNet();
                break;
        }
    }

    private void jump() {
        String textYanz=binding.phonetestYanzhengma.getText().toString();
        if(yanzhen.equals(textYanz)){
            Intent intent = new Intent(this, AddCardInputPassWorldActivity.class);
            intent.putExtra("cardnum",cardnum);
            intent.putExtra("cardcity",cardcity);
            startActivity(intent);
        }else {
            toast("验证码错误，请重新输入");
        }


    }

    private int beginTime = 30;
    Handler handler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            switch (msg.what) {
                case 1:
                    binding.phonetestObtainmsg.setText("请等待" + "(" + beginTime + ")");
                    break;
                case 2:
                    beginTime=30;
                    binding.phonetestObtainmsg.setEnabled(true);
                    binding.phonetestObtainmsg.setText(null);
                    binding.phonetestObtainmsg.setBackgroundResource(R.mipmap.yanzhengma);
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

    private void getWordFromNet() {

        binding.phonetestObtainmsg.setBackground(null);
        handler.post(runnable);
        binding.phonetestObtainmsg.setEnabled(false);
        Map<String, String> apends = new HashMap<>();
        apends.put("agent_tel", phone);
        NetUtils.Get(BaseData.DUANXINYANZHENG, apends, new Callback.CommonCallback<String>() {
            @Override
            public void onSuccess(String result) {
                Gson gson = new Gson();
                Regist_phoneback phoneMsg = gson.fromJson(result, Regist_phoneback.class);
                yanzhen=phoneMsg.getMsg();
                loge("yanzheng",yanzhen);

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
    @Override
    protected void onDestroy() {
        super.onDestroy();
        binding=null;
        handler.removeCallbacks(runnable);
    }

}
