package com.ts.partner.partnerActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Toast;

import com.google.gson.Gson;
import com.ts.partner.R;
import com.ts.partner.databinding.LonginBing;
import com.ts.partner.partnerBase.BaseActivity;
import com.ts.partner.partnerBase.BaseData;
import com.ts.partner.partnerBean.BendingBean.TestEditLoginBean;
import com.ts.partner.partnerBean.netBean.LoginDataBean;
import com.ts.partner.partnerBean.netBean.NetError;
import com.ts.partner.partnerUtils.NetUtils;
import com.ts.partner.partnerUtils.SystemUtil;

import org.xutils.common.Callback;

import java.util.HashMap;
import java.util.Map;

import cn.sharesdk.framework.ShareSDK;

/**
 * Created by Administrator on 2017/2/13.
 * 登录界面
 */

public class LoginActivity extends BaseActivity implements View.OnClickListener, View.OnFocusChangeListener {
    private LonginBing bing;
    private TestEditLoginBean mDataEdit;
    Callback.Cancelable cancel;
    SystemUtil su = new SystemUtil(this);
    public static String DATAS_KEY = "datas";
    ProgressDialog dialog;
    Map<String, Boolean> isEnable = new HashMap<>();
    public static final int HOMEBACKCODE = 1111;
    public static final int SETTINGBACKCODE = 2222;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        bing = DataBindingUtil.setContentView(this, R.layout.activity_login);
//        autoLogin();
        mDataEdit = new TestEditLoginBean();
        bing.setPass(mDataEdit);
        init();
    }

    private void init() {
        bing.loginLoginbutton.setOnClickListener(this);
        bing.loginEditPhone.setOnFocusChangeListener(this);
        bing.loginEditPass.setOnFocusChangeListener(this);
        bing.loginEditPhone.addTextChangedListener(new NameWatcher());
        bing.loginEditPass.addTextChangedListener(new PWatcher());
        bing.loginRegist.setOnClickListener(this);
        ShareSDK.initSDK(this, "1b82993cdeee3");
        isEnable.put("name", false);
        isEnable.put("pass", false);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.login_loginbutton:
                LoginOnNet();
                break;
            case R.id.login_regist:
                toRegist();
                break;
        }
    }

    private void toRegist() {
        Intent intent=new Intent(this,RegistActivity.class);
        startActivity(intent);
    }

    private void LoginOnNet() {

        if (null == mDataEdit.getUserName() || "".equals(mDataEdit.getUserName())) {
            Toast.makeText(this, getResources().getString(R.string.inputyouphonenum), Toast.LENGTH_SHORT).show();
            return;
        }
        if (null == mDataEdit.getUserPassword() || "".equals(mDataEdit.getUserPassword())) {
            toast(getResources().getString(R.string.inputyourpasswiord));
            return;
        }
        dialog = ProgressDialog.show(this, "提示", "正在登陆");
        dialog.show();
        bing.loginLoginbutton.setEnabled(false);
        Map<String, String> params = new HashMap<>();
        params.put("partner_tel", mDataEdit.getUserName());
        params.put("partner_password", mDataEdit.getUserPassword());
        cancel = NetUtils.Get(BaseData.LOGIN, params, new Callback.CommonCallback<String>() {
            @Override
            public void onSuccess(String result) {
                Gson gson = new Gson();
                String cutResult = result.substring(0, 19);
                if (cutResult.contains("Error")) {
                    NetError error = gson.fromJson(result, NetError.class);
                    toast(error.getMsg());
                    error = null;
                    return;
                } else {
                    LoginDataBean login = gson.fromJson(result, LoginDataBean.class);
                    if ("Success".equals(login.getFlag())) {
                        su.saveUid(Integer.parseInt(login.getData().get(0).getPartner_info().get(0).getId()));
                        su.savePhone(login.getData().get(0).getPartner_info().get(0).getPartner_account());
                        su.savePwd(mDataEdit.getUserPassword());
                        Intent intent = new Intent(LoginActivity.this, HomeActivity.class);
                        intent.putExtra("isfresh", getIntent().getIntExtra("isfresh", 0));
                        intent.putExtra(DATAS_KEY, login);
                        startActivityForResult(intent, 1);
                        startActivity(intent);
                        login = null;
                    } else {
                        login = null;
                        return;
                    }
                }
            }

            @Override
            public void onError(Throwable ex, boolean isOnCallback) {
                toast(getString(R.string.net_error));
                loge(ex.getMessage());

            }

            @Override
            public void onCancelled(CancelledException cex) {
            }

            @Override
            public void onFinished() {
                bing.loginLoginbutton.setEnabled(true);
                if (dialog != null) {
                    dialog.dismiss();

                }
            }
        });
    }

    @Override
    protected void onPause() {
        super.onPause();
        if (cancel != null) {
            cancel.cancel();
        }

    }

    @Override
    public void onFocusChange(View v, boolean hasFocus) {
        switch (v.getId()) {
            case R.id.login_edit_phone:
                if (hasFocus) {
                    bing.loginRelative1.setBackground(getResources().getDrawable(R.mipmap.login_edittext));
                } else {
                    bing.loginRelative1.setBackground(getResources().getDrawable(R.mipmap.login_beforeedit));
                }
                break;
            case R.id.login_edit_pass:
                if (hasFocus) {
                    bing.loginRelative2.setBackground(getResources().getDrawable(R.mipmap.login_edittext));

                } else {
                    bing.loginRelative2.setBackground(getResources().getDrawable(R.mipmap.login_beforeedit));
                }
                break;

        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == HOMEBACKCODE) {
            finish();
        }

    }

    class NameWatcher implements TextWatcher {

        @Override
        public void beforeTextChanged(CharSequence s, int start, int count, int after) {

        }

        @Override
        public void onTextChanged(CharSequence s, int start, int before, int count) {

        }

        @Override
        public void afterTextChanged(Editable s) {
            String text = bing.loginEditPhone.getText().toString();
            if (null != text && !"".equals(text)) {
                isEnable.put("name", true);
            } else {
                isEnable.put("name", false);
            }
            judge();
        }
    }

    class PWatcher implements TextWatcher {

        @Override
        public void beforeTextChanged(CharSequence s, int start, int count, int after) {

        }

        @Override
        public void onTextChanged(CharSequence s, int start, int before, int count) {

        }

        @Override
        public void afterTextChanged(Editable s) {
            String text = bing.loginEditPass.getText().toString();
            if (null != text && !"".equals(text)) {
                isEnable.put("pass", true);
            } else {
                isEnable.put("pass", false);
            }
            judge();

        }
    }

    private void judge() {
        if (isEnable.get("name") && isEnable.get("pass")) {
            bing.loginLoginbutton.setBackgroundResource(R.drawable.selector_tixianbutton);
            bing.loginLoginbutton.setEnabled(true);
        } else {

            bing.loginLoginbutton.setBackgroundResource(R.mipmap.tixain_nonumber);
            bing.loginLoginbutton.setEnabled(false);
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        isEnable = null;
        dialog = null;
        su = null;
        cancel = null;
        mDataEdit = null;
        bing = null;
    }

    //添加自动登录
    //自动登录
    private void autoLogin() {
        if ("".equals(su.showPhone()) || su.showPhone() == null || "".equals(su.showPwd()) || su.showPwd() == null) {
            return;
        } else {
            Intent intent = new Intent(this, HomeActivity.class);
            intent.putExtra("isfresh", getIntent().getIntExtra("isfresh", 0));
            startActivity(intent);
        }
    }
}
