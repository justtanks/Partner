package com.ts.partner.partnerFragment;

import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.common.collect.EvictingQueue;
import com.ts.partner.R;
import com.ts.partner.databinding.MineFragmentBinding;
import com.ts.partner.partnerActivity.CardActivity;
import com.ts.partner.partnerActivity.HomeActivity;
import com.ts.partner.partnerActivity.LoginActivity;
import com.ts.partner.partnerBase.BaseFragment;
import com.ts.partner.partnerBase.impl.OnDatasChangeListener;
import com.ts.partner.partnerBean.BendingBean.ShowMsgInMineBean;
import com.ts.partner.partnerBean.netBean.LoginBean;

/**
 * Created by Administrator on 2017/2/25.
 */

public class MineFragment extends BaseFragment implements View.OnClickListener, OnDatasChangeListener {
    MineFragmentBinding b;
    ShowMsgInMineBean data;
    LoginBean.DataBean datas;
    LoginBean logindatas;
    HomeActivity homeActivity;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        b = DataBindingUtil.inflate(inflater, R.layout.fragment_mine, container, false);
        return b.getRoot();
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        homeActivity = (HomeActivity) getActivity();
        b.mineSetting.setOnClickListener(this);
        b.mineMycard.setOnClickListener(this);
        logindatas = homeActivity.getDatas();
        datas = logindatas.getData().get(0);
        data = new ShowMsgInMineBean((datas));
        homeActivity.setOndatasChangeListener(this);
        b.setMinedatas(data);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.mine_mycard:
                Intent intent = new Intent(getActivity(), CardActivity.class);
                intent.putExtra(HomeActivity.MAIN_KEY, data);
                startActivity(intent);
                break;
            case R.id.mine_setting:
                break;
        }
    }


    @Override
    public void onDestroy() {
        super.onDestroy();
    }

    //反应homeactivity 中数据变化
    @Override
    public void onDatasChange(LoginBean datainhome) {
        datas = datainhome.getData().get(0);
        data = new ShowMsgInMineBean((datas));
        b.setMinedatas(data);
    }
}
