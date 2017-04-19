package com.ts.partner.partnerFragment;

import android.app.ProgressDialog;
import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.gson.Gson;
import com.ts.partner.R;
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
import com.ts.partner.partnerBean.netBean.CardBean;
import com.ts.partner.partnerBean.netBean.LoginDataBean;
import com.ts.partner.partnerBean.netBean.NetError;
import com.ts.partner.partnerBean.netBean.OrdersBean;
import com.ts.partner.partnerUtils.NetUtils;
import com.ts.partner.partnerUtils.SystemUtil;

import org.xutils.common.Callback;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Administrator on 2017/2/25.
 * home fragment  首页fragment
 */

public class HomeFragmnent extends BaseFragment implements View.OnClickListener, OnDatasChangeListener {
    HomeFragBinding b;
    LoginDataBean logindatas;
    LoginDataBean.DataBean datas;
    DatasInMain maida;
    HomeActivity homeActivity;
    SystemUtil su ;
    ProgressDialog dialog;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        b = DataBindingUtil.inflate(inflater, R.layout.activity_main, container, false);
        init();
        return b.getRoot();
    }

    private void init() {
        su = new SystemUtil(getActivity());
        b.mainDingdanmingxi.setOnClickListener(this);
        b.mainTixian.setOnClickListener(this);
        homeActivity = (HomeActivity) getActivity();
        logindatas = homeActivity.getDatas();
        if (logindatas != null) {
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
                getCardFromNet();
//                  showShare();
                break;

        }
    }

    //判断是否有银行卡 没有就先添加银行卡
    private void jumpToMyCard(CardBean card) {
        if (card.getData().size()==0) {
            toast("请先添加银行卡");
            Intent intent = new Intent(homeActivity, CardActivity.class);
            startActivity(intent);
            return;
        }
        Intent intent = new Intent(homeActivity, DrawCashActivity.class);
        intent.putExtra("datas", datas);
        intent.putExtra("cards",card);
        startActivity(intent);
    }

    private void justToOrders() {

          dialog=ProgressDialog.show(getContext(),"","正在获取订单信息");
          dialog.show();
          Map<String,Object>param=new HashMap<>();
         param.put("partner_id",su.showUid()+"");
          NetUtils.Post(BaseData.GETORDERS, param, new Callback.CommonCallback<String>() {
              @Override
              public void onSuccess(String result) {
                  if(result.substring(0,18).contains("Error")){
                      NetError error=new Gson().fromJson(result,NetError.class);
                      toast(error.getMsg());
                  }else {
                      OrdersBean orders=new Gson().fromJson(result,OrdersBean.class);
                      Intent intent = new Intent(homeActivity, OrdersActivity.class);
                      intent.putExtra(LoginActivity.DATAS_KEY, orders);
                      Log.e("log",result);
                      startActivity(intent);
                  }
              }

              @Override
              public void onError(Throwable ex, boolean isOnCallback) {
                      toast(getString( R.string.net_error));
                      loge(ex.getMessage());
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

    //每次homeactivity 返回数据变化后执行
    @Override
    public void onDatasChange(LoginDataBean data) {
        datas = data.getData().get(0);
        maida = new DatasInMain(datas);
        b.setDatas(maida);
    }

    /*
     从网络获取到所有的银行卡信息 也就是每次都访问银行卡信息
     每次都从网络获取银行样卡信息
     partner_id
     */
    private void getCardFromNet() {
        dialog=ProgressDialog.show(getContext(),"","正在请求银行卡信息");
        dialog.show();
        Map<String, Object> param = new HashMap<>();
        param.put("partner_id", su.showUid());
        NetUtils.Post(BaseData.GETCARDS, param, new Callback.CommonCallback<String>() {
            @Override
            public void onSuccess(String result) {
                if (result.substring(0, 18).contains("Error")) {
                    return;
                } else {
                    CardBean card = new Gson().fromJson(result, CardBean.class);
                   jumpToMyCard(card);
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
                dialog.dismiss();
            }
        });
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
