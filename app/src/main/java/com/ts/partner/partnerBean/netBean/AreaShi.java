package com.ts.partner.partnerBean.netBean;

import java.util.List;

/**
 * Created by Administrator on 2017/4/18.
 * 获取城市
 */

public class AreaShi {

    /**
     * flag : Success
     * msg : 获取城市成功
     * data : [{"city_name":"北京市市辖区","city_id":"110100000000"},{"city_name":"北京市市辖县","city_id":"110200000000"}]
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
         * city_name : 北京市市辖区
         * city_id : 110100000000
         */

        private String city_name;
        private String city_id;

        public String getCity_name() {
            return city_name;
        }

        public void setCity_name(String city_name) {
            this.city_name = city_name;
        }

        public String getCity_id() {
            return city_id;
        }

        public void setCity_id(String city_id) {
            this.city_id = city_id;
        }
    }
}
