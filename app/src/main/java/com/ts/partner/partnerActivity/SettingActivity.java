package com.ts.partner.partnerActivity;

import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.ts.partner.R;
import com.ts.partner.databinding.ActivitySettingBinding;
import com.ts.partner.partnerBase.BaseActivity;

public class SettingActivity extends BaseActivity implements View.OnClickListener {
    ActivitySettingBinding b;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        b= DataBindingUtil.setContentView(this,R.layout.activity_setting);
        init();
    }
    private void init(){
        b.settingBack.setOnClickListener(this);
        b.settingQuitlogin.setOnClickListener(this);
        b.settingRemovegarbage.setOnClickListener(this);
        b.settintIdsafe.setOnClickListener(this);
        this.setResult(LoginActivity.SETTINGBACKCODE);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.setting_back:
                onBackPressed();
                break;
            case R.id.setting_quitlogin:
               quitLog();
                break;
            case R.id.setting_removegarbage:
                toast(getString(R.string.qingliwancheng));
                break;
            case R.id.settint_idsafe:
                toast(getString(R.string.zanweikaitong));
                break;

        }
    }
    //清除数据退出登录
    private void quitLog(){
        Intent intent=new Intent(this,LoginActivity.class);
        startActivity(intent);
        this.finish();
    }
}
