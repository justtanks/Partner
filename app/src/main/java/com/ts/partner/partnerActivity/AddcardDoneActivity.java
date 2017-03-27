package com.ts.partner.partnerActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.google.gson.Gson;
import com.ts.partner.R;
import com.ts.partner.partnerBase.BaseActivity;
import com.ts.partner.partnerBase.BaseData;
import com.ts.partner.partnerBean.netBean.LoginBean;
import com.ts.partner.partnerBean.netBean.NetError;
import com.ts.partner.partnerUtils.NetUtils;
import com.ts.partner.partnerUtils.SystemUtil;

import org.greenrobot.eventbus.EventBus;
import org.xutils.common.Callback;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
添加银行卡成功的activity
 */
public class AddcardDoneActivity extends BaseActivity {
    Button done;
    SystemUtil su = new SystemUtil(this);
    ProgressDialog dialog;
    int processid;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_addcard_done);
        done = (Button) this.findViewById(R.id.carddone_complete);
        processid=su.showModle();
        done.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                update();
            }
        });
    }

    @Override
    public void onBackPressed() {
        update();
    }

    /*
    同步关于银行卡的信息
     */
    Callback.Cancelable cancel;
    //18253487693

    private void update() {
        dialog = ProgressDialog.show(this, "", "同步信息中");
        dialog.show();
        Map<String, String> params = new HashMap<>();
        params.put("partner_tel", su.showPhone());
        params.put("partner_password", su.showPwd());
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
                    LoginBean login = gson.fromJson(result, LoginBean.class);
                    if ("Success".equals(login.getFlag())) {
                        EventBus.getDefault().post(login);
                        switch (processid){
                            case 0:
                                toast("bug");
                                break;
                            case 1:
                                Intent intent=new Intent(AddcardDoneActivity.this,ChoiseCardActivity.class);
                                startActivity(intent);
                                break;
                            case 2:
                                Intent intent1 = new Intent(AddcardDoneActivity.this, CardActivity.class);
                                startActivity(intent1);
                                break;
                        }

                    } else {
                        login = null;
                        return;
                    }


                }

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
                dialog.dismiss();
            }
        });
    }
}
