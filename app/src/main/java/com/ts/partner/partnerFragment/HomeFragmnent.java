package com.ts.partner.partnerFragment;

import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.mob.commons.SHARESDK;
import com.ts.partner.R;
import com.ts.partner.databinding.HomeBinding;
import com.ts.partner.databinding.HomeFragBinding;
import com.ts.partner.partnerActivity.CardActivity;
import com.ts.partner.partnerActivity.DrawCashActivity;
import com.ts.partner.partnerActivity.HomeActivity;
import com.ts.partner.partnerActivity.LoginActivity;
import com.ts.partner.partnerActivity.OrdersActivity;
import com.ts.partner.partnerBase.BaseFragment;
import com.ts.partner.partnerBase.impl.OnDatasChangeListener;
import com.ts.partner.partnerBean.BendingBean.DatasInMain;
import com.ts.partner.partnerBean.BendingBean.ShowMsgInMineBean;
import com.ts.partner.partnerBean.netBean.LoginBean;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;

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
        datas = logindatas.getData().get(0);
        maida = new DatasInMain(datas);
        homeActivity.setOndatasChangeListener(this);
        b.setDatas(maida);

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

    //    @Subscribe
//    public void onEvent(LoginBean.DataBean datas) {
//        //提现之后刷新数据，直接重新设置数据
//        this.datas = datas;
//        maida = new DatasInMain(datas);
//        b.setDatas(maida);
//    }
    //调用分享
    private void showShare() {
        ShareSDK.initSDK(getContext(), "1b82993cdeee3");
        OnekeyShare oks = new OnekeyShare();
//关闭sso授权
        oks.disableSSOWhenAuthorize();
// title标题，印象笔记、邮箱、信息、微信、人人网和QQ空间等使用
        oks.setTitle("标题");
// titleUrl是标题的网络链接，QQ和QQ空间等使用
        oks.setTitleUrl("http://sharesdk.cn");
// text是分享文本，所有平台都需要这个字段
        oks.setText("我是分享文本");
// imagePath是图片的本地路径，Linked-In以外的平台都支持此参数
//oks.setImagePath("/sdcard/test.jpg");//确保SDcard下面存在此张图片
// url仅在微信（包括好友和朋友圈）中使用
        oks.setUrl("http://sharesdk.cn");
// comment是我对这条分享的评论，仅在人人网和QQ空间使用
        oks.setComment("我是测试评论文本");
// site是分享此内容的网站名称，仅在QQ空间使用
        oks.setSite(getString(R.string.app_name));
// siteUrl是分享此内容的网站地址，仅在QQ空间使用
        oks.setSiteUrl("http://sharesdk.cn");

// 启动分享GUI
        oks.show(getContext());
    }
}
