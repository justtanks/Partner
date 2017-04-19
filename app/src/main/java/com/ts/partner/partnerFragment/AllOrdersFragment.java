package com.ts.partner.partnerFragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;

import com.ts.partner.BR;
import com.ts.partner.R;
import com.ts.partner.partnerAdapter.simpleAdapter.ListAdapter;
import com.ts.partner.partnerBase.BaseFragment;
import com.ts.partner.partnerBase.impl.OnOrderChanger;
import com.ts.partner.partnerBean.netBean.OrdersBean;

import java.util.List;

/**
 * Created by Administrator on 2017/2/14.
 */

public class AllOrdersFragment extends BaseFragment implements AdapterView.OnItemClickListener,OnOrderChanger {
    List<OrdersBean.DataBean> orders;
    View rootView;
    ListView lv;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        rootView = inflater.inflate( R.layout.fragment_orders_all, container, false);
        lv= (ListView) rootView.findViewById(R.id.allday_lv);
        return rootView;
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
//        Intent intent=new Intent(getActivity(), XiangqingActivity.class);
//        intent.putExtra("id",1);
//        intent.putExtra("datas",allOrderdatas.get(position));
//        startActivity(intent);
    }
    //activity 向所有的order界面发送数据的接口
    @Override
    public void onOrderchange(OrdersBean.DataBean orders) {
        List<OrdersBean.DataBean.OrderListBean> allorder=orders.getOrder_list();
        if(null!=allorder&&allorder.size()!=0){
            ListAdapter<OrdersBean.DataBean.OrderListBean> adapter=
                    new ListAdapter<>(getActivity(),allorder, BR.orderstype,R.layout.item_allorder);
            lv.setAdapter(adapter);
        }
    }
}
