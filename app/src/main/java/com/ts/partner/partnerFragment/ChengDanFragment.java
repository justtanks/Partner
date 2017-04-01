package com.ts.partner.partnerFragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.ts.partner.R;
import com.ts.partner.partnerBase.BaseFragment;

/**
 * Created by Administrator on 2017/4/1.
 * 代理人综合排序的frament
 */

public class ChengDanFragment extends BaseFragment {
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.item_waiter_lv,container,false);
        return view;
    }
}
