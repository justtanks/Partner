package com.ts.partner.partnerFragment;

import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import com.ts.partner.BR;
import com.ts.partner.R;
import com.ts.partner.databinding.TodayBinding;
import com.ts.partner.partnerActivity.LoginActivity;
import com.ts.partner.partnerActivity.XiangqingActivity;
import com.ts.partner.partnerAdapter.simpleAdapter.ListAdapter;
import com.ts.partner.partnerBase.BaseFragment;
import com.ts.partner.partnerBean.BendingBean.DatasInMain;
import com.ts.partner.partnerBean.netBean.LoginBean;

import java.util.List;

/**
 * Created by Administrator on 2017/2/14.
 */

public class TodayOrdersFragment extends BaseFragment implements AdapterView.OnItemClickListener{
    TodayBinding b;
    List<LoginBean.DataBean.PartnerTodayOrderBean> allOrderdatas;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
//        View view=inflater.inflate(R.layout.fragment_order_today,container,false);
//        ListView listView= (ListView) view.findViewById(R.id.fragment_order_listview);
//        return view;
        b= DataBindingUtil.inflate(inflater,R.layout.fragment_order_today,container,false);
        LoginBean bean= (LoginBean) getActivity().getIntent().getSerializableExtra(LoginActivity.DATAS_KEY);
        DatasInMain data=new DatasInMain(bean.getData().get(0));
        b.setDatas(data);
        allOrderdatas=bean.getData().get(0).getPartner_today_order();
        if(null!=allOrderdatas&&allOrderdatas.size()!=0){
            ListAdapter<LoginBean.DataBean.PartnerTodayOrderBean> adapter=new ListAdapter<>(getActivity(),allOrderdatas, BR.todayoders,R.layout.item_today_lv);
            b.todayLv.setAdapter(adapter);
        }
        b.todayLv.setOnItemClickListener(this);
        return  b.getRoot();
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        Intent intent=new Intent(getActivity(), XiangqingActivity.class);
        intent.putExtra("id",2);
        intent.putExtra("datas",allOrderdatas.get(position));
        startActivity(intent);
    }
}
