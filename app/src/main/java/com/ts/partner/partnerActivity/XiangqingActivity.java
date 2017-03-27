package com.ts.partner.partnerActivity;

import android.app.Activity;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.view.View;

import com.ts.partner.R;
import com.ts.partner.databinding.XiangqingBinding;
import com.ts.partner.partnerBean.BendingBean.XiangqingBendingBean;
import com.ts.partner.partnerBean.netBean.LoginBean;

/**
 * 详情界面activity
 */
public class XiangqingActivity extends Activity {
    XiangqingBinding b;
    XiangqingBendingBean bean;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        b = DataBindingUtil.setContentView(this, R.layout.activity_xiangqing);
        init();
    }
   //昨日 前日 和所有 的实体类是不同的，所以需要根据传过来的id判断解析成不同的数据
    private void init() {
        b.dingdanxiangqingBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });
        int x = getIntent().getIntExtra("id", -1);
        switch (x) {
            case -1:
                break;
            case 1:
                bean = new XiangqingBendingBean((LoginBean.DataBean.PartnerAllOrderBean) getIntent().getSerializableExtra("datas"));
                break;
            case 2:
                bean = new XiangqingBendingBean((LoginBean.DataBean.PartnerTodayOrderBean) getIntent().getSerializableExtra("datas"));
                break;
            case 3:
                bean = new XiangqingBendingBean((LoginBean.DataBean.PartnerYesterdayOrderBean) getIntent().getSerializableExtra("datas"));
                break;
            case 4:
                bean = new XiangqingBendingBean((LoginBean.DataBean.PartnerBeforeYesterdayOrderBean) getIntent().getSerializableExtra("datas"));
                break;
            default:
                break;
        }
        if (bean != null) {
            b.setXiangqing(bean);
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        bean = null;
        b = null;
    }
}
