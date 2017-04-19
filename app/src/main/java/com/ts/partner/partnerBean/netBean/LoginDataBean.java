package com.ts.partner.partnerBean.netBean;

import java.io.Serializable;
import java.util.List;

/**
 * Created by Administrator on 2017/4/18.
 * 登录之后数据
 */

public class LoginDataBean implements Serializable{

    /**
     * flag : Success
     * msg : 登录成功！
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
        private List<AgentCountyBean> agent_county;
        private List<PartnerInfosBean> partner_infos;
        private List<AllOrderBean> all_order;
        private List<OrderBean> today_order;
        private List<MoneyBean> today_money;
        private List<OrderBean> yesterday_order;
        private List<MoneyBean> yesterday_money;
        private List<PartnerInfoBean> partner_info;

        public List<AgentCountyBean> getAgent_county() {
            return agent_county;
        }

        public void setAgent_county(List<AgentCountyBean> agent_county) {
            this.agent_county = agent_county;
        }

        public List<PartnerInfosBean> getPartner_infos() {
            return partner_infos;
        }

        public void setPartner_infos(List<PartnerInfosBean> partner_infos) {
            this.partner_infos = partner_infos;
        }

        public List<AllOrderBean> getAll_order() {
            return all_order;
        }

        public void setAll_order(List<AllOrderBean> all_order) {
            this.all_order = all_order;
        }

        public List<OrderBean> getToday_order() {
            return today_order;
        }

        public void setToday_order(List<OrderBean> today_order) {
            this.today_order = today_order;
        }

        public List<MoneyBean> getToday_money() {
            return today_money;
        }

        public void setToday_money(List<MoneyBean> today_money) {
            this.today_money = today_money;
        }

        public List<OrderBean> getYesterday_order() {
            return yesterday_order;
        }

        public void setYesterday_order(List<OrderBean> yesterday_order) {
            this.yesterday_order = yesterday_order;
        }

        public List<MoneyBean> getYesterday_money() {
            return yesterday_money;
        }

        public void setYesterday_money(List<MoneyBean> yesterday_money) {
            this.yesterday_money = yesterday_money;
        }

        public List<PartnerInfoBean> getPartner_info() {
            return partner_info;
        }

        public void setPartner_info(List<PartnerInfoBean> partner_info) {
            this.partner_info = partner_info;
        }

        public static class AgentCountyBean implements Serializable{
            /**
             * agent : 德城区
             * county_id : 371402000000
             */

            private String agent;
            private String county_id;

            public String getAgent() {
                return agent;
            }

            public void setAgent(String agent) {
                this.agent = agent;
            }

            public String getCounty_id() {
                return county_id;
            }

            public void setCounty_id(String county_id) {
                this.county_id = county_id;
            }
        }

        public static class PartnerInfosBean implements Serializable{
            /**
             * partner_income : 0
             * partner_balance : 200
             */

            private int partner_income;
            private int partner_balance;

            public int getPartner_income() {
                return partner_income;
            }

            public void setPartner_income(int partner_income) {
                this.partner_income = partner_income;
            }

            public int getPartner_balance() {
                return partner_balance;
            }

            public void setPartner_balance(int partner_balance) {
                this.partner_balance = partner_balance;
            }
        }

        public static class AllOrderBean implements Serializable{
            /**
             * city_id : 371402000000
             * city_county : 2
             */

            private String city_id;
            private String city_county;

            public String getCity_id() {
                return city_id;
            }

            public void setCity_id(String city_id) {
                this.city_id = city_id;
            }

            public String getCity_county() {
                return city_county;
            }

            public void setCity_county(String city_county) {
                this.city_county = city_county;
            }
        }

        public static class OrderBean implements Serializable{
            /**
             * city_county : 0
             */

            private int city_county;

            public int getCity_county() {
                return city_county;
            }

            public void setCity_county(int city_county) {
                this.city_county = city_county;
            }
        }

        public static class MoneyBean implements Serializable{
            /**
             * money : 100
             */

            private int money;

            public int getMoney() {
                return money;
            }

            public void setMoney(int money) {
                this.money = money;
            }
        }

        public static class PartnerInfoBean implements Serializable{
            /**
             * id : 17
             * partner_account : 18266142739
             * id_renzheng : 1
             * register_date : 2017-04-17 09:21:07
             */

            private String id;
            private String partner_account;
            private String id_renzheng;
            private String register_date;

            public String getId() {
                return id;
            }

            public void setId(String id) {
                this.id = id;
            }

            public String getPartner_account() {
                return partner_account;
            }

            public void setPartner_account(String partner_account) {
                this.partner_account = partner_account;
            }

            public String getId_renzheng() {
                return id_renzheng;
            }

            public void setId_renzheng(String id_renzheng) {
                this.id_renzheng = id_renzheng;
            }

            public String getRegister_date() {
                return register_date;
            }

            public void setRegister_date(String register_date) {
                this.register_date = register_date;
            }
        }
    }
}
