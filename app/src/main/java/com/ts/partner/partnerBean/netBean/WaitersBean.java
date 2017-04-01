package com.ts.partner.partnerBean.netBean;

import java.io.Serializable;
import java.util.List;

/**
 * Created by Administrator on 2017/4/1.
 *  返回所有的代理人信息
 */

public class WaitersBean implements Serializable {

    /**
     * flag : Success
     * msg : 获取列表成功
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
        private List<WaiterBean> zonghe;
        private List<WaiterBean> good_say;
        private List<WaiterBean> orders;

        public List<WaiterBean> getZonghe() {
            return zonghe;
        }

        public void setZonghe(List<WaiterBean> zonghe) {
            this.zonghe = zonghe;
        }

        public List<WaiterBean> getGood_say() {
            return good_say;
        }

        public void setGood_say(List<WaiterBean> good_say) {
            this.good_say = good_say;
        }

        public List<WaiterBean> getOrders() {
            return orders;
        }

        public void setOrders(List<WaiterBean> orders) {
            this.orders = orders;
        }

        public static class WaiterBean implements Serializable{
            /**
             * id : 71
             * waiter_name : 刘超
             * waiter_password : 870916
             * waiter_sex : 1
             * waiter_id_card : 371121198801072978
             * waiter_phone_number : 13365443879
             * waiter_pic : /Uploads/touxiang/18605345315.jpg
             * waiter_address : 山东省德州市
             * waiter_work_time : 1
             * waiter_good_work : 1
             * good_say : 0
             * is_renzheng : 1
             * waiter_qq : 154496959
             * withdraw_password : 123456
             */

            private String id;
            private String waiter_name;
            private String waiter_password;
            private String waiter_sex;
            private String waiter_id_card;
            private String waiter_phone_number;
            private String waiter_pic;
            private String waiter_address;
            private String waiter_work_time;
            private String waiter_good_work;
            private String good_say;
            private String is_renzheng;
            private String waiter_qq;
            private String withdraw_password;

            public String getId() {
                return id;
            }

            public void setId(String id) {
                this.id = id;
            }

            public String getWaiter_name() {
                return waiter_name;
            }

            public void setWaiter_name(String waiter_name) {
                this.waiter_name = waiter_name;
            }

            public String getWaiter_password() {
                return waiter_password;
            }

            public void setWaiter_password(String waiter_password) {
                this.waiter_password = waiter_password;
            }

            public String getWaiter_sex() {
                return waiter_sex;
            }

            public void setWaiter_sex(String waiter_sex) {
                this.waiter_sex = waiter_sex;
            }

            public String getWaiter_id_card() {
                return waiter_id_card;
            }

            public void setWaiter_id_card(String waiter_id_card) {
                this.waiter_id_card = waiter_id_card;
            }

            public String getWaiter_phone_number() {
                return waiter_phone_number;
            }

            public void setWaiter_phone_number(String waiter_phone_number) {
                this.waiter_phone_number = waiter_phone_number;
            }

            public String getWaiter_pic() {
                return waiter_pic;
            }

            public void setWaiter_pic(String waiter_pic) {
                this.waiter_pic = waiter_pic;
            }

            public String getWaiter_address() {
                return waiter_address;
            }

            public void setWaiter_address(String waiter_address) {
                this.waiter_address = waiter_address;
            }

            public String getWaiter_work_time() {
                return waiter_work_time;
            }

            public void setWaiter_work_time(String waiter_work_time) {
                this.waiter_work_time = waiter_work_time;
            }

            public String getWaiter_good_work() {
                return waiter_good_work;
            }

            public void setWaiter_good_work(String waiter_good_work) {
                this.waiter_good_work = waiter_good_work;
            }

            public String getGood_say() {
                return good_say;
            }

            public void setGood_say(String good_say) {
                this.good_say = good_say;
            }

            public String getIs_renzheng() {
                return is_renzheng;
            }

            public void setIs_renzheng(String is_renzheng) {
                this.is_renzheng = is_renzheng;
            }

            public String getWaiter_qq() {
                return waiter_qq;
            }

            public void setWaiter_qq(String waiter_qq) {
                this.waiter_qq = waiter_qq;
            }

            public String getWithdraw_password() {
                return withdraw_password;
            }

            public void setWithdraw_password(String withdraw_password) {
                this.withdraw_password = withdraw_password;
            }
        }


    }
}
