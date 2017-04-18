package com.ts.partner.partnerBean.netBean;

import java.util.List;

/**
 * Created by Administrator on 2017/3/31.
 */

public class GetversionBean {


    /**
     * flag : Success
     * msg : 版本号
     * data : [{"number":"2.0"}]
     * num : 1
     */

    private String flag;
    private String msg;
    private int num;
    private List<DataBean> data;

    public String getFlag() {
        return flag;
    }

    public void setFlag(String flag) {
        this.flag = flag;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public List<DataBean> getData() {
        return data;
    }

    public void setData(List<DataBean> data) {
        this.data = data;
    }

    public static class DataBean {
        /**
         * number : 2.0
         */

        private float number;

        public float getNumber() {
            return number;
        }

        public void setNumber(float number) {
            this.number = number;
        }
    }
}
