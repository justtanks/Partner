package com.ts.partner.partnerBean.netBean;

import java.util.List;

/**
 * Created by Administrator on 2017/4/18.
 * 获取省份
 */

public class AreaSheng {

    /**
     * flag : Success
     * msg : 获取省份成功
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
         * provice_name : 北京市
         * provice_id : 110
         */

        private String provice_name;
        private String provice_id;

        public String getProvice_name() {
            return provice_name;
        }

        public void setProvice_name(String provice_name) {
            this.provice_name = provice_name;
        }

        public String getProvice_id() {
            return provice_id;
        }

        public void setProvice_id(String provice_id) {
            this.provice_id = provice_id;
        }
    }
}
