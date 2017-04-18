package com.ts.partner.partnerFragment;

import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;

import com.ts.partner.BR;
import com.ts.partner.R;
import com.ts.partner.databinding.AlldayBinding;
import com.ts.partner.partnerActivity.LoginActivity;
import com.ts.partner.partnerActivity.XiangqingActivity;
import com.ts.partner.partnerAdapter.simpleAdapter.ListAdapter;
import com.ts.partner.partnerBase.BaseFragment;
import com.ts.partner.partnerBean.BendingBean.DatasInMain;

import java.util.List;

/**
 * Created by Administrator on 2017/2/14.
 */

public class AllOrdersFragment extends BaseFragment implements AdapterView.OnItemClickListener {
    AlldayBinding b;
    List<LoginBean.DataBean.PartnerAllOrderBean> allOrderdatas;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
//        View view=inflater.inflate(R.layout.fragment_orders_all,container,false);
//        ListView listView= (ListView) view.findViewById(R.id.fragment_order_listview);
//        return view;
        b = DataBindingUtil.inflate(inflater, R.layout.fragment_orders_all, container, false);
        LoginBean bean = (LoginBean) getActivity().getIntent().getSerializableExtra(LoginActivity.DATAS_KEY);
        DatasInMain data = new DatasInMain(bean.getData().get(0));
        b.setDatas(data);
        allOrderdatas  = bean.getData().get(0).getPartner_all_order();
        if (null != allOrderdatas && allOrderdatas.size() != 0) {
            ListAdapter<LoginBean.DataBean.PartnerAllOrderBean> adapter = new ListAdapter<>(getActivity(), allOrderdatas, BR.allorder, R.layout.item_allorder);
            b.alldayLv.setAdapter(adapter);
        }
        b.alldayLv.setOnItemClickListener(this);
        return b.getRoot();
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        Intent intent=new Intent(getActivity(), XiangqingActivity.class);
        intent.putExtra("id",1);
        intent.putExtra("datas",allOrderdatas.get(position));
        startActivity(intent);
    }
}
