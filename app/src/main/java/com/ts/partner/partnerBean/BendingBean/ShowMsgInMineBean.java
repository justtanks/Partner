package com.ts.partner.partnerBean.BendingBean;

import android.databinding.BaseObservable;
import android.databinding.Bindable;

import com.ts.partner.BR;
import com.ts.partner.partnerBase.BaseData;
import com.ts.partner.partnerBean.netBean.LoginBean;

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
    List<LoginBean.DataBean.PartnerBankCardBean> cars;

    public ShowMsgInMineBean(LoginBean.DataBean bean) {
        this.name=bean.getPartner_name();
        this.cars=bean.getPartner_bank_card();
        if(this.cars==null||this.cars.size()==0){
            this.carNum="0";
        }else{
            this.carNum=this.cars.size()+"" ;
        }
        this.phone=bean.getPartner_account();
        this.location=bean.getPartner_belong_city();

    }

    public List<LoginBean.DataBean.PartnerBankCardBean> getCars() {
        return cars;
    }

    public void setCars(List<LoginBean.DataBean.PartnerBankCardBean> cars) {
        this.cars = cars;
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

    @Override
    public String toString() {
        return "ShowMsgInMineBean{" +
                "name='" + name + '\'' +
                ", headImg='" + headImg + '\'' +
                ", carNum='" + carNum + '\'' +
                ", phone='" + phone + '\'' +
                ", location='" + location + '\'' +
                ", cars=" + cars +
                '}';
    }
}
