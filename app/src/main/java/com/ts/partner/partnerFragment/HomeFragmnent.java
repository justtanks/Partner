package com.ts.partner.partnerFragment;

import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.gson.Gson;
import com.mob.commons.SHARESDK;
import com.ts.partner.R;
import com.ts.partner.databinding.HomeBinding;
import com.ts.partner.databinding.HomeFragBinding;
import com.ts.partner.partnerActivity.CardActivity;
import com.ts.partner.partnerActivity.DrawCashActivity;
import com.ts.partner.partnerActivity.HomeActivity;
import com.ts.partner.partnerActivity.LoginActivity;
import com.ts.partner.partnerActivity.OrdersActivity;
import com.ts.partner.partnerBase.BaseData;
import com.ts.partner.partnerBase.BaseFragment;
import com.ts.partner.partnerBase.impl.OnDatasChangeListener;
import com.ts.partner.partnerBean.BendingBean.DatasInMain;
import com.ts.partner.partnerBean.BendingBean.ShowMsgInMineBean;
import com.ts.partner.partnerBean.netBean.LoginBean;
import com.ts.partner.partnerBean.netBean.NetError;
import com.ts.partner.partnerUtils.NetUtils;
import com.ts.partner.partnerUtils.SystemUtil;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.xutils.common.Callback;

import java.util.HashMap;
import java.util.Map;

import cn.sharesdk.framework.ShareSDK;
import cn.sharesdk.onekeyshare.OnekeyShare;

/**
 * Created by Administrator on 2017/2/25.
 * home fragment 现在测试分享功能
 */

public class HomeFragmnent extends BaseFragment implements View.OnClickListener, OnDatasChangeListener {
    HomeFragBinding b;
    LoginBean logindatas;
    LoginBean.DataBean datas;
    DatasInMain maida;
    HomeActivity homeActivity;
   SystemUtil su=new SystemUtil(getContext());
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        b = DataBindingUtil.inflate(inflater, R.layout.activity_main, container, false);
        init();
        return b.getRoot();
    }

    private void init() {
        b.mainDingdanmingxi.setOnClickListener(this);
        b.mainTixian.setOnClickListener(this);
        homeActivity = (HomeActivity) getActivity();
        logindatas = homeActivity.getDatas();
        if(logindatas!=null){
            datas = logindatas.getData().get(0);
            maida = new DatasInMain(datas);
            b.setDatas(maida);
        }
        homeActivity.setOndatasChangeListener(this);

    }

    @Override
    public void onDestroy() {
        super.onDestroy();
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.main_dingdanmingxi:
                justToOrders();
                break;
            case R.id.main_tixian:
                jumpToMyCard();
//                  showShare();
                break;

        }
    }

    //跳转到提现界面
    private void jumpToMyCard() {
        //判断是否有银行卡 没有就先添加银行卡
        if (datas.getPartner_bank_card()==null||datas.getPartner_bank_card().size() == 0) {
            toast("请先添加银行卡");
            Intent intent = new Intent(homeActivity, CardActivity.class);
            startActivity(intent);
            return;
        }
        Intent intent = new Intent(homeActivity, DrawCashActivity.class);
        intent.putExtra("datas", datas);
        startActivity(intent);
    }

    private void justToOrders() {
        Intent intent = new Intent(homeActivity, OrdersActivity.class);
        intent.putExtra(LoginActivity.DATAS_KEY, logindatas);
        startActivity(intent);
    }

    //每次homeactivity 返回数据变化后执行
    @Override
    public void onDatasChange(LoginBean data) {
        datas = data.getData().get(0);
        maida = new DatasInMain(datas);
        b.setDatas(maida);
    }

    //检查登录 然后到setting 界面退出登录
//    private void checkLogin() {
//        Map<String, String> params = new HashMap<>();
//        params.put("partner_tel",su.showPhone() );
//        params.put("partner_password", su.showPwd());
//       NetUtils.Get(BaseData.LOGIN, params, new Callback.CommonCallback<String>() {
//            @Override
//            public void onSuccess(String result) {
//                Gson gson = new Gson();
//                String cutResult = result.substring(0, 19);
//                if (cutResult.contains("Error")) {
//                   //跳转到
//                    return;
//                } else {
//                    LoginBean login = gson.fromJson(result, LoginBean.class);
//                    if ("Success".equals(login.getFlag())) {
//                        su.saveUid(Integer.parseInt(login.getData().get(0).getPartner_id()));
//                        su.savePhone(login.getData().get(0).getPartner_account());
//                        su.savePwd(login.getData().get(0).getPartner_password());
//                        Intent intent = new Intent(LoginActivity.this, HomeActivity.class);
//                        intent.putExtra(DATAS_KEY, login);
//                        startActivityForResult(intent, 1);
//                        startActivity(intent);
//                        login = null;
//                    } else {
//                        login = null;
//                        return;
//                    }
//
//
//                }
//
//            }
//
//            @Override
//            public void onError(Throwable ex, boolean isOnCallback) {
//                toast(getString(R.string.net_error));
//
//            }
//
//            @Override
//            public void onCancelled(CancelledException cex) {
//            }
//
//            @Override
//            public void onFinished() {
//
//            }
//        });
//
//    }


}
