package com.ts.partner.partnerBean.netBean;

import com.ts.partner.partnerBase.BaseOrders;

import java.io.Serializable;
import java.util.List;

/**
 * Created by Administrator on 2017/2/14.
 * 订单工厂类  貌似很鸡肋 因为经常修改的是loginbean 而且可能不会很固定，所以需要改变些东西
 */

public class OrdersFactory {
    LoginBean loginBean;
    public OrdersFactory( LoginBean loginBean) {
        this.loginBean=loginBean;
    }
    public   List<? extends BaseOrders> getOrders(int id){
        switch (id){
            case 0:
                return loginBean.getData().get(0).getPartner_all_order();
            case  1:
            return loginBean.getData().get(0).getPartner_today_order();
            case 2:
                return loginBean.getData().get(0).getPartner_yesterday_order();
            case  3 :
                return  loginBean.getData().get(0).getPartner_before_yesterday_order();
            default:
                return null;
        }
    }

}
