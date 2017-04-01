package com.ts.partner.partnerFragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.ts.partner.R;
import com.ts.partner.partnerBase.BaseFragment;

/**
 * Created by Administrator on 2017/4/1.
 * 代理人综合排序的frament 使用同一套布局
 */

public class ZhongHeFragment extends BaseFragment {
    ListView lv;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.item_waiter_lv,container,false);
        return view;
    }
    private void init(View v){
        lv= (ListView) v.findViewById(R.id.waiter_lv);

    }


}
