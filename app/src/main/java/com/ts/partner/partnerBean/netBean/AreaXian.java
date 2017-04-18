package com.ts.partner.partnerBean.netBean;

import java.util.List;

/**
 * Created by Administrator on 2017/4/18.
 * 获取市县
 */

public class AreaXian {

    /**
     * flag : Success
     * msg : 获取区县成功
     * data : [{"county_name":"东城区","county_id":"110101000000"},{"county_name":"西城区","county_id":"110102000000"},{"county_name":"朝阳区","county_id":"110105000000"},{"county_name":"丰台区","county_id":"110106000000"},{"county_name":"石景山区","county_id":"110107000000"},{"county_name":"海淀区","county_id":"110108000000"},{"county_name":"门头沟区","county_id":"110109000000"},{"county_name":"房山区","county_id":"110111000000"},{"county_name":"通州区","county_id":"110112000000"},{"county_name":"顺义区","county_id":"110113000000"},{"county_name":"昌平区","county_id":"110114000000"},{"county_name":"大兴区","county_id":"110115000000"},{"county_name":"怀柔区","county_id":"110116000000"},{"county_name":"平谷区","county_id":"110117000000"}]
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
         * county_name : 东城区
         * county_id : 110101000000
         */

        private String county_name;
        private String county_id;

        public String getCounty_name() {
            return county_name;
        }

        public void setCounty_name(String county_name) {
            this.county_name = county_name;
        }

        public String getCounty_id() {
            return county_id;
        }

        public void setCounty_id(String county_id) {
            this.county_id = county_id;
        }
    }
}
