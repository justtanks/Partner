package com.ts.partner.partnerFragment;

import android.app.ProgressDialog;
import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.gson.Gson;
import com.ts.partner.R;
import com.ts.partner.databinding.MineFragmentBinding;
import com.ts.partner.partnerActivity.CardActivity;
import com.ts.partner.partnerActivity.HomeActivity;
import com.ts.partner.partnerActivity.PushAreaActivity;
import com.ts.partner.partnerActivity.SettingActivity;
import com.ts.partner.partnerActivity.WaiterListActivity;
import com.ts.partner.partnerBase.BaseData;
import com.ts.partner.partnerBase.BaseFragment;
import com.ts.partner.partnerBase.impl.OnDatasChangeListener;
import com.ts.partner.partnerBean.BendingBean.ShowMsgInMineBean;
import com.ts.partner.partnerBean.netBean.CardBean;
import com.ts.partner.partnerBean.netBean.LoginDataBean;
import com.ts.partner.partnerBean.netBean.NetError;
import com.ts.partner.partnerBean.netBean.WaitersBean;
import com.ts.partner.partnerUtils.NetUtils;
import com.ts.partner.partnerUtils.SystemUtil;

import org.xutils.common.Callback;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ExecutionException;

/**
 * Created by Administrator on 2017/2/25.
 * 首页中我的信息界面
 */
public class MineFragment extends BaseFragment implements View.OnClickListener {
    MineFragmentBinding b;
    ShowMsgInMineBean data;
    LoginDataBean.DataBean datas;
    LoginDataBean logindatas;
    HomeActivity homeActivity;
    ProgressDialog dialog;
    SystemUtil su;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        b = DataBindingUtil.inflate(inflater, R.layout.fragment_mine, container, false);
        su = new SystemUtil(getActivity());
        return b.getRoot();
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        homeActivity = (HomeActivity) getActivity();
        b.mineSetting.setOnClickListener(this);
        b.mineMycard.setOnClickListener(this);
        b.mineDailiren.setOnClickListener(this);
        b.mineArea.setOnClickListener(this);
        logindatas = homeActivity.getDatas();
        datas = logindatas.getData().get(0);
        data = new ShowMsgInMineBean((datas));
        b.setMinedatas(data);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.mine_mycard:
                getCardFromNet();
                break;
            case R.id.mine_setting:
                toSetting();
                break;
            case R.id.mine_dailiren:
                toDailiren();
                break;
            case R.id.mine_area:
                toArea();
                break;
        }
    }

    //跳到提交申请地区界面
    private void toArea() {
        Intent intent = new Intent(getActivity(), PushAreaActivity.class);
        startActivity(intent);
    }

    //跳转到设置界面
    private void toSetting() {
        Intent intent = new Intent(getActivity(), SettingActivity.class);
        startActivity(intent);
    }
 /*
  跳转到代理人名片列表界面
  */

    private void toDailiren() {
        dialog = ProgressDialog.show(getActivity(), "", "正在获取代理人列表");
        dialog.show();
        NetUtils.Get(BaseData.DAILILIEBIAO, new HashMap<String, String>() {
        }, new Callback.CommonCallback<String>() {
            @Override
            public void onSuccess(String result) {
                Gson gson = new Gson();
                if (result.substring(0, 18).contains("Error")) {
                    NetError err = gson.fromJson(result, NetError.class);
                    toast(err.getMsg());
                } else {
                    WaitersBean bean = gson.fromJson(result, WaitersBean.class);
                    Intent intent = new Intent(getActivity(), WaiterListActivity.class);
                    intent.putExtra("waiters", bean);
                    startActivity(intent);
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

    private void getCardFromNet() {
        try {
            dialog = ProgressDialog.show(getActivity(), "", "正在获取银行卡信息");
            dialog.show();
            Map<String, Object> param = new HashMap<>();
            param.put("partner_id", su.showUid());
            NetUtils.Post(BaseData.GETCARDS, param, new Callback.CommonCallback<String>() {
                @Override
                public void onSuccess(String result) {
                    if (result.substring(0, 18).contains("Error")) {
                        NetError error=new Gson().fromJson(result,NetError.class);
                        if(error.getMsg().equals("0")){
                            Intent intent = new Intent(getActivity(), CardActivity.class);
                            startActivity(intent);
                        }else {
                            toast("您还没有进行认证，无法获取银行卡信息");
                        }
                        return;
                    } else {
                        CardBean card = new Gson().fromJson(result, CardBean.class);
                        Intent intent = new Intent(getActivity(), CardActivity.class);
                        intent.putExtra(HomeActivity.MAIN_KEY, card);
                        startActivity(intent);
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
        } catch (Exception e) {
            loge(e.getMessage());
            dialog.dismiss();
            toast("软件出现问题，请联系开发者");
        }
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
    }

}
