package com.ts.partner.partnerBean.netBean;

import java.io.Serializable;
import java.util.List;

/**
 * Created by Administrator on 2017/4/18.
 * 显示银行卡信息接口
 */

public class CardBean implements Serializable{

    /**
     * flag : Success
     * msg : 获取银行卡成功！
     * data : [{"id":"62","pid":"17","bank_name":"农业银行·金穗通宝卡(银联卡)","card_num":"6228480263092311","add_time":"2017-04-18 15:16:25"}]
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

    public static class DataBean implements Serializable{
        /**
         * id : 62
         * pid : 17
         * bank_name : 农业银行·金穗通宝卡(银联卡)
         * card_num : 6228480263092311
         * add_time : 2017-04-18 15:16:25
         */

        private String id;
        private String pid;
        private String bank_name;
        private String card_num;
        private String add_time;

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getPid() {
            return pid;
        }

        public void setPid(String pid) {
            this.pid = pid;
        }

        public String getBank_name() {
            return bank_name;
        }

        public void setBank_name(String bank_name) {
            this.bank_name = bank_name;
        }

        public String getCard_num() {
            return card_num;
        }

        public void setCard_num(String card_num) {
            this.card_num = card_num;
        }

        public String getAdd_time() {
            return add_time;
        }

        public void setAdd_time(String add_time) {
            this.add_time = add_time;
        }
    }
}
