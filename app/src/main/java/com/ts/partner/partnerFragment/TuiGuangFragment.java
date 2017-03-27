package com.ts.partner.partnerFragment;

import android.content.Intent;
import android.content.pm.InstrumentationInfo;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.widget.SwipeRefreshLayout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;

import com.ts.partner.BR;
import com.ts.partner.R;
import com.ts.partner.databinding.TuiguangBinding;
import com.ts.partner.partnerActivity.HomeActivity;
import com.ts.partner.partnerActivity.ShareMesActivity;
import com.ts.partner.partnerAdapter.simpleAdapter.ListAdapter;
import com.ts.partner.partnerBase.BaseFragment;
import com.ts.partner.partnerBase.impl.OnShareMsgChangeListener;
import com.ts.partner.partnerBean.netBean.LoginBean;
import com.ts.partner.partnerBean.netBean.ShareMesBean;

/**
 * Created by Administrator on 2017/2/25.
 * home
 */

public class TuiGuangFragment extends BaseFragment implements SwipeRefreshLayout.OnRefreshListener, OnShareMsgChangeListener {
    HomeActivity activity;
    TuiguangBinding b;
    private static ShareMesBean datas = new ShareMesBean();
    ListAdapter<ShareMesBean.MsgBean> adapter;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        b = DataBindingUtil.inflate(inflater, R.layout.fragment_tuiguang, container, false);
        init();
        initFresh();
        return b.getRoot();
    }

    private void init() {
        activity = (HomeActivity) getActivity();
        activity.setOnShareMsgChangeListenr(this);
        datas = activity.getShareDatas();
        if (datas != null && datas.getMsg() != null && datas.getMsg().size() != 0) {
            View view = LayoutInflater.from(activity).inflate(R.layout.item_sharelv_headview, null);
            view.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                }
            });
            b.tuiguangLv.addHeaderView(view);
            adapter = new ListAdapter<>(activity, datas.getMsg(), BR.msgbean, R.layout.item_share_lv);
            b.tuiguangLv.setAdapter(adapter);
        }
        b.tuiguangLv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(activity, ShareMesActivity.class);
                intent.putExtra("sharedata", datas.getMsg().get(position - 1));
                startActivity(intent);
            }
        });

    }

    //设置刷新组建
    private void initFresh() {
        b.tuiguangRefresh.setOnRefreshListener(this);
        // 设置下拉圆圈上的颜色，蓝色、绿色、橙色、红色
        b.tuiguangRefresh.setColorSchemeResources(android.R.color.holo_blue_bright, android.R.color.holo_green_light,
                android.R.color.holo_orange_light, android.R.color.holo_red_light);
        b.tuiguangRefresh.setDistanceToTriggerSync(400);// 设置手指在屏幕下拉多少距离会触发下拉刷新
        b.tuiguangRefresh.setSize(SwipeRefreshLayout.DEFAULT); // 设置圆圈的大小

    }

    //刷新行为，向activity发送消息更新信息，然后通过回调将信息重新展示
    @Override
    public void onRefresh() {
        activity.getShareMsg();
    }

    @Override
    public void onMsgChange(ShareMesBean datas) {
        if(datas!=null){
            adapter.setDatas(datas.getMsg());
            b.tuiguangRefresh.setRefreshing(false);
            toast(getString(R.string.gengxinchenggong)
            );
        }else {
            b.tuiguangRefresh.setRefreshing(false);
            toast(getString(R.string.failtorefresh));
        }

    }
}
