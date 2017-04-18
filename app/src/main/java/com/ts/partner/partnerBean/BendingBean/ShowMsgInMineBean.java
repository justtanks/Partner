package com.ts.partner.partnerBean.BendingBean;

import android.databinding.BaseObservable;
import android.databinding.Bindable;

import com.ts.partner.BR;
import com.ts.partner.partnerBean.netBean.LoginDataBean;

import java.io.Serializable;
import java.util.List;

/**
 * Created by Administrator on 2017/2/15.
 * 我的界面中展示和传递信息的bean
 */

public class ShowMsgInMineBean extends BaseObservable implements Serializable {
    String name;
    String headImg;
    String carNum;
    String phone;
    String location;

    public ShowMsgInMineBean(LoginDataBean.DataBean bean) {
        this.phone=bean.getPartner_info().get(0).getPartner_account();
    }
    @Bindable
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
        notifyPropertyChanged(BR.minedatas);
    }
    @Bindable
    public String getHeadImg() {
        return headImg;
    }

    public void setHeadImg(String headImg) {
        this.headImg = headImg;
        notifyPropertyChanged(BR.minedatas);
    }
    @Bindable
    public String getCarNum() {
        return carNum;
    }

    public void setCarNum(String carNum) {
        this.carNum = carNum;
        notifyPropertyChanged(BR.minedatas);
    }
    @Bindable
    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
        notifyPropertyChanged(BR.minedatas);
    }
    @Bindable
    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
        notifyPropertyChanged(BR.minedatas);
    }
}
