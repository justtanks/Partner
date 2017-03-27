package com.ts.partner.partnerActivity;

import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.view.View;

import com.google.gson.Gson;
import com.ts.partner.R;
import com.ts.partner.databinding.CardBinding;
import com.ts.partner.partnerAdapter.CardListviewAdatper;
import com.ts.partner.partnerBase.BaseActivity;
import com.ts.partner.partnerBase.BaseData;
import com.ts.partner.partnerBean.BendingBean.ShowMsgInMineBean;
import com.ts.partner.partnerBean.netBean.IsHadPasswordBean;
import com.ts.partner.partnerBean.netBean.LoginBean;
import com.ts.partner.partnerUtils.NetUtils;
import com.ts.partner.partnerUtils.SystemUtil;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.xutils.common.Callback;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CardActivity extends BaseActivity implements View.OnClickListener{
    /*
    我的银行卡界面
     */
    private CardBinding bingding;
    ShowMsgInMineBean carddata;
    CardListviewAdatper adatper;
    SystemUtil su=new SystemUtil(this);
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        init();
    }

    private void init(){
        EventBus.getDefault().register(this);
        bingding= DataBindingUtil.setContentView(this,R.layout.activity_card);
        bingding.cardAddnewcard.setOnClickListener(this);
        bingding.cardBacktext.setOnClickListener(this);
        carddata= (ShowMsgInMineBean) getIntent().getSerializableExtra(HomeActivity.MAIN_KEY);
        if(carddata!=null&&carddata.getCars()!=null){
            adatper=new CardListviewAdatper(this,carddata.getCars());
            bingding.cardLv.setAdapter(adatper);
        }
//
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.card_backtext:
                onBackPressed();
                break;
            case R.id.card_addnewcard:
                addCard();
                break;
        }
    }
    //添加银行卡
    private void addCard(){
        su.saveModle1(2);
        Map<String,Object> params=new HashMap<>();
        params.put("partner_id",su.showUid()+"");
        NetUtils.Post(BaseData.ISHADPASS, params, new Callback.CommonCallback<String>() {
            @Override
            public void onSuccess(String result) {
                Gson gson=new Gson();
                IsHadPasswordBean bean=gson.fromJson(result,IsHadPasswordBean.class);
                if(bean.getData()==1){
                    //已经设置密码
                    Intent intent=new Intent(CardActivity.this,AddcardStep1Activity.class);
                    startActivity(intent);
                }else if(bean.getData()==2){
                 //未设置密码
                    Intent intent=new Intent(CardActivity.this,AddpassWordActivity.class);
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
    @Subscribe
    public void onEventList(LoginBean datas) {
            adatper.setDatas(datas.getData().get(0).getPartner_bank_card());
            adatper.notifyDataSetChanged();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        EventBus.getDefault().unregister(this);
        su=null;
        adatper=null;
        carddata=null;
        bingding=null;
    }
}
