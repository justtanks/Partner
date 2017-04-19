package com.ts.partner.partnerBase.impl;

import com.ts.partner.partnerBean.netBean.OrdersBean;

/**
 * Created by Administrator on 2017/4/19.
 * 重用订单变化fragment 使用的接口
 */

public interface OnOrderChanger {
    public void onOrderchange(OrdersBean.DataBean orders);
}
