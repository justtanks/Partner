package com.ts.partner.partnerActivity;

import android.app.Activity;
import android.app.FragmentManager;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.view.View;

import com.ts.partner.R;
import com.ts.partner.databinding.XiangqingBinding;
import com.ts.partner.partnerBean.BendingBean.XiangQingBindData;
import com.ts.partner.partnerBean.netBean.OrdersBean;

/**
 * 详情界面activity
 */
public class XiangqingActivity extends Activity {
    XiangqingBinding b;
    OrdersBean.DataBean.OrderListBean datas;
    XiangQingBindData xiang;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        b = DataBindingUtil.setContentView(this, R.layout.activity_xiangqing);
        datas= (OrdersBean.DataBean.OrderListBean) getIntent().getSerializableExtra("alldermes");
        xiang=new XiangQingBindData(datas);
        b.setAllorders(xiang);
        b.dingdanxiangqingBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });
    }


    @Override
    protected void onDestroy() {
        super.onDestroy();
        b = null;
    }
}
