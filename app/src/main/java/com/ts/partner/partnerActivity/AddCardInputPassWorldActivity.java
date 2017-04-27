package com.ts.partner.partnerActivity;
import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.NotificationCompat;

import com.google.gson.Gson;
import com.ts.partner.R;
import com.ts.partner.partnerBase.BaseActivity;
import com.ts.partner.partnerBase.BaseData;
import com.ts.partner.partnerBean.netBean.AddCardBean;
import com.ts.partner.partnerBean.netBean.NetError;
import com.ts.partner.partnerUtils.NetUtils;
import com.ts.partner.partnerUtils.SystemUtil;
import com.ts.partner.partnerViews.PwdEditText;

import org.xutils.common.Callback;

import java.util.HashMap;
import java.util.Map;
/*
添加完银行卡之后 确认密码
 */
public class AddCardInputPassWorldActivity extends BaseActivity {

    PwdEditText editText;
    String cardnum="";
    String cardcity;
    SystemUtil su=new SystemUtil(this);
    ProgressDialog waitDialog=null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_card_input_pass_world);
        editText = (PwdEditText) this.findViewById(R.id.input_passpet_pwd);
        cardnum=getIntent().getStringExtra("cardnum");
        cardcity=getIntent().getStringExtra("cardcity");
        editText.setOnInputFinishListener(new PwdEditText.OnInputFinishListener() {
            @Override
            public void onInputFinish(String password) {
                 addCardToNet(password);

            }
        });
    }
  //partner_id/3/bank_name/银行名称/bank_card_num/123/withdrawals_password/123456
    private void addCardToNet(String pass) {
        if(cardcity!=null&&cardnum!=null&&pass!=null){
            waitDialog=ProgressDialog.show(this,"","正在添加银行卡");
            waitDialog.show();
            Map<String,Object> parms=new HashMap<>();
             parms.put("partner_id",su.showUid());
            parms.put("bank_name",cardcity);
            parms.put("bank_card_num",cardnum);
            parms.put("withdrawals_password",pass);
            NetUtils.Post(BaseData.ADDBANKCARD, parms, new Callback.CommonCallback<String>() {
                @Override
                public void onSuccess(String result) {
                    Gson gson=new Gson();
                    if(result.substring(0,18).contains("Success")){
                        AddCardBean bean=gson.fromJson(result,AddCardBean.class);
                        if("Success".equals(bean.getFlag())){
                            Intent intent=new Intent(AddCardInputPassWorldActivity.this,AddcardDoneActivity.class);
                            startActivity(intent);
                        }
                    }else {
                        NetError error=gson.fromJson(result,NetError.class);
                        toast(error.getMsg());
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
                    waitDialog.dismiss();

                }
            });

        }

    }
}
