package com.ts.partner.partnerFragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import com.ts.partner.BR;
import com.ts.partner.R;
import com.ts.partner.partnerActivity.ShareWaiterActivity;
import com.ts.partner.partnerActivity.WaiterListActivity;
import com.ts.partner.partnerAdapter.simpleAdapter.ListAdapter;
import com.ts.partner.partnerBase.BaseFragment;
import com.ts.partner.partnerBean.netBean.WaitersBean;

import java.util.List;

/**
 * Created by Administrator on 2017/4/1.
 * 代理人综合排序的frament  按照好评进行分组
 */

public class HaopingFragment extends BaseFragment {
    ListView lv;
    WaiterListActivity activity;
    List<WaitersBean.DataBean.WaiterBean> datas;
    ListAdapter<WaitersBean.DataBean.WaiterBean> adapter;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.fragment_waiter,container,false);
        init(view);
        return view;
    }
    private void init(View v){
        lv= (ListView) v.findViewById(R.id.waiter_lv);
        activity= (WaiterListActivity) getActivity();
        datas=activity.getDatas().getData().get(0).getGood_say();
        if(datas!=null&&0!=datas.size()){
            adapter=new ListAdapter<>(activity,datas, BR.waitersdata,R.layout.item_waiter_lv);
            lv.setAdapter(adapter);
        }
        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent=new Intent(activity, ShareWaiterActivity.class);
                if(datas!=null&&datas.size()!=0){
                    intent.putExtra("waiterid",datas.get(position).getId());
                    intent.putExtra("waiterpic",datas.get(position).getWaiter_pic());
                }
                startActivity(intent);
            }
        });

    }
}
