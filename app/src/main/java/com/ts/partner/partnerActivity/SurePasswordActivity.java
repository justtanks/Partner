package com.ts.partner.partnerActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.google.gson.Gson;
import com.ts.partner.R;
import com.ts.partner.partnerBase.BaseActivity;
import com.ts.partner.partnerBase.BaseData;
import com.ts.partner.partnerBean.netBean.SetPasswordBean;
import com.ts.partner.partnerUtils.NetUtils;
import com.ts.partner.partnerUtils.SystemUtil;
import com.ts.partner.partnerViews.PwdEditText;

import org.w3c.dom.Text;
import org.xutils.common.Callback;

import java.util.HashMap;
import java.util.Map;
/*
 添加密码后重新确认密码
 */
public class SurePasswordActivity extends BaseActivity {

    PwdEditText text;
    TextView back;
    SystemUtil su = new SystemUtil(this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sure_password);
        init();
    }

    private void init() {
        text = (PwdEditText) this.findViewById(R.id.surepass_pet_pwd);
        back = (TextView) this.findViewById(R.id.surepass_textback);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });
        text.setOnInputFinishListener(new PwdEditText.OnInputFinishListener() {

            @Override
            public void onInputFinish(String password) {
                String firstpass = getIntent().getStringExtra("firstpass");
                if (password.equals(firstpass)) {
                    //设置密码并跳转到添加银行卡界面
                    setPassWord(password);
                } else {
                    onBackPressed();
                    toast(getString(R.string.mimabuyizhi));
                }

            }
        });
    }
    //访问接口  设置密码

    private void setPassWord(String passWord) {
        Map<String, Object> params = new HashMap<>();
        params.put("partner_id", su.showUid() + "");
        params.put("withdrawals_password", passWord);
        NetUtils.Post(BaseData.SETPASS, params, new Callback.CommonCallback<String>() {
            @Override
            public void onSuccess(String result) {
                Gson gson = new Gson();
                SetPasswordBean bean = gson.fromJson(result, SetPasswordBean.class);
                toast(bean.getMsg());
                if (null != bean && "Success".equals(bean.getFlag())) {
                    Intent intent = new Intent(SurePasswordActivity.this, AddcardStep1Activity.class);
                    startActivity(intent);
                }
            }

            @Override
            public void onError(Throwable ex, boolean isOnCallback) {
                toast(getResources().getString(R.string.net_error));
            }

            @Override
            public void onCancelled(CancelledException cex) {

            }

            @Override
            public void onFinished() {

            }
        });


    }

}
