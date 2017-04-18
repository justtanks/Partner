package com.ts.partner.partnerBean.netBean;

import java.util.List;

/**
 * Created by Administrator on 2017/4/17.
 * 按照地区划分的所有订单
 */

public class OrdersActivity {

    /**
     * flag : Success
     * msg : 获取成功！
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
         * city_name : 德城区
         * order_list : [{"id":"386","order_num":"1492398406","who_put_order":"18266142739","order_name":"测试1","order_pic":"/Uploads/2017-04-17/58f431465ed2d.jpg","order_types":"第29类　　食品第30类　　方便食品第31类　　饲料种籽第32类　　啤酒饮料第33类　　酒第35类　　广告销售第40类　　材料加工","order_price":"4179","order_wait_taking":"0","order_wait_pay":"0","order_time":"2017-04-17 11:06:46","order_always_person":null,"order_qiye_name":"山东驾行科技有限公司","order_qiye_address":"山东省德州市德城区","order_qiye_phone":"18266142121","order_ask_who":"朱堃罡","order_ask_phone":"18266142739","order_ask_mail":"154496959@qq.com","order_qiye_yingyezhizhao":"/Uploads/2017-04-17/58f431465f246.PDF","order_always_personal":"","order_personal_name":"","order_personal_id_card":"","order_personal_tel":"","order_personal_ask_preson":"","order_personal_ask_tel":"","order_personal_id_card_pic":"/Uploads/2017-04-17/","order_personal_getizhizhao":"/Uploads/2017-04-17/","order_type":"智能商标注册","belong_provice":"山东省","belong_city":"371400000000","belong_county":"371402000000","order_date_day":"2017-04-17","order_acceptance_type":null,"hetong1":"/Uploads/2017-04-17/58f431465fb2d.PDF","hetong2":"/Uploads/2017-04-17/","weituoshu1":"/Uploads/2017-04-17/58f431466046e.PDF","weituoshu2":"/Uploads/2017-04-17/"},{"id":"387","order_num":"1492398630","who_put_order":"18266142739","order_name":"测试2","order_pic":"/Uploads/2017-04-17/58f4322678766.jpg","order_types":"第29类　　食品第30类　　方便食品第31类　　饲料种籽第32类　　啤酒饮料第33类　　酒第35类　　广告销售第40类　　材料加工","order_price":"4179","order_wait_taking":"0","order_wait_pay":"0","order_time":"2017-04-17 11:10:30","order_always_person":null,"order_qiye_name":"","order_qiye_address":"","order_qiye_phone":"","order_ask_who":"","order_ask_phone":"","order_ask_mail":"","order_qiye_yingyezhizhao":"/Uploads/2017-04-17/","order_always_personal":"朱堃罡","order_personal_name":"朱堃罡","order_personal_id_card":"371402199208062615","order_personal_tel":"18266142739","order_personal_ask_preson":"朱堃罡","order_personal_ask_tel":"18266142739","order_personal_id_card_pic":"/Uploads/2017-04-17/58f4322678c89.PDF","order_personal_getizhizhao":"/Uploads/2017-04-17/58f43226791ac.PDF","order_type":"智能商标注册","belong_provice":"山东省","belong_city":"371400000000","belong_county":"371402000000","order_date_day":"2017-04-17","order_acceptance_type":null,"hetong1":"/Uploads/2017-04-17/","hetong2":"/Uploads/2017-04-17/58f4322679b5f.PDF","weituoshu1":"/Uploads/2017-04-17/","weituoshu2":"/Uploads/2017-04-17/58f432267a4be.PDF"}]
         */

        private String city_name;
        private List<OrderListBean> order_list;

        public String getCity_name() {
            return city_name;
        }

        public void setCity_name(String city_name) {
            this.city_name = city_name;
        }

        public List<OrderListBean> getOrder_list() {
            return order_list;
        }

        public void setOrder_list(List<OrderListBean> order_list) {
            this.order_list = order_list;
        }

        public static class OrderListBean {
            /**
             * id : 386
             * order_num : 1492398406
             * who_put_order : 18266142739
             * order_name : 测试1
             * order_pic : /Uploads/2017-04-17/58f431465ed2d.jpg
             * order_types : 第29类　　食品第30类　　方便食品第31类　　饲料种籽第32类　　啤酒饮料第33类　　酒第35类　　广告销售第40类　　材料加工
             * order_price : 4179
             * order_wait_taking : 0
             * order_wait_pay : 0
             * order_time : 2017-04-17 11:06:46
             * order_always_person : null
             * order_qiye_name : 山东驾行科技有限公司
             * order_qiye_address : 山东省德州市德城区
             * order_qiye_phone : 18266142121
             * order_ask_who : 朱堃罡
             * order_ask_phone : 18266142739
             * order_ask_mail : 154496959@qq.com
             * order_qiye_yingyezhizhao : /Uploads/2017-04-17/58f431465f246.PDF
             * order_always_personal :
             * order_personal_name :
             * order_personal_id_card :
             * order_personal_tel :
             * order_personal_ask_preson :
             * order_personal_ask_tel :
             * order_personal_id_card_pic : /Uploads/2017-04-17/
             * order_personal_getizhizhao : /Uploads/2017-04-17/
             * order_type : 智能商标注册
             * belong_provice : 山东省
             * belong_city : 371400000000
             * belong_county : 371402000000
             * order_date_day : 2017-04-17
             * order_acceptance_type : null
             * hetong1 : /Uploads/2017-04-17/58f431465fb2d.PDF
             * hetong2 : /Uploads/2017-04-17/
             * weituoshu1 : /Uploads/2017-04-17/58f431466046e.PDF
             * weituoshu2 : /Uploads/2017-04-17/
             */

            private String id;
            private String order_num;
            private String who_put_order;
            private String order_name;
            private String order_pic;
            private String order_types;
            private String order_price;
            private String order_wait_taking;
            private String order_wait_pay;
            private String order_time;
            private Object order_always_person;
            private String order_qiye_name;
            private String order_qiye_address;
            private String order_qiye_phone;
            private String order_ask_who;
            private String order_ask_phone;
            private String order_ask_mail;
            private String order_qiye_yingyezhizhao;
            private String order_always_personal;
            private String order_personal_name;
            private String order_personal_id_card;
            private String order_personal_tel;
            private String order_personal_ask_preson;
            private String order_personal_ask_tel;
            private String order_personal_id_card_pic;
            private String order_personal_getizhizhao;
            private String order_type;
            private String belong_provice;
            private String belong_city;
            private String belong_county;
            private String order_date_day;
            private Object order_acceptance_type;
            private String hetong1;
            private String hetong2;
            private String weituoshu1;
            private String weituoshu2;

            public String getId() {
                return id;
            }

            public void setId(String id) {
                this.id = id;
            }

            public String getOrder_num() {
                return order_num;
            }

            public void setOrder_num(String order_num) {
                this.order_num = order_num;
            }

            public String getWho_put_order() {
                return who_put_order;
            }

            public void setWho_put_order(String who_put_order) {
                this.who_put_order = who_put_order;
            }

            public String getOrder_name() {
                return order_name;
            }

            public void setOrder_name(String order_name) {
                this.order_name = order_name;
            }

            public String getOrder_pic() {
                return order_pic;
            }

            public void setOrder_pic(String order_pic) {
                this.order_pic = order_pic;
            }

            public String getOrder_types() {
                return order_types;
            }

            public void setOrder_types(String order_types) {
                this.order_types = order_types;
            }

            public String getOrder_price() {
                return order_price;
            }

            public void setOrder_price(String order_price) {
                this.order_price = order_price;
            }

            public String getOrder_wait_taking() {
                return order_wait_taking;
            }

            public void setOrder_wait_taking(String order_wait_taking) {
                this.order_wait_taking = order_wait_taking;
            }

            public String getOrder_wait_pay() {
                return order_wait_pay;
            }

            public void setOrder_wait_pay(String order_wait_pay) {
                this.order_wait_pay = order_wait_pay;
            }

            public String getOrder_time() {
                return order_time;
            }

            public void setOrder_time(String order_time) {
                this.order_time = order_time;
            }

            public Object getOrder_always_person() {
                return order_always_person;
            }

            public void setOrder_always_person(Object order_always_person) {
                this.order_always_person = order_always_person;
            }

            public String getOrder_qiye_name() {
                return order_qiye_name;
            }

            public void setOrder_qiye_name(String order_qiye_name) {
                this.order_qiye_name = order_qiye_name;
            }

            public String getOrder_qiye_address() {
                return order_qiye_address;
            }

            public void setOrder_qiye_address(String order_qiye_address) {
                this.order_qiye_address = order_qiye_address;
            }

            public String getOrder_qiye_phone() {
                return order_qiye_phone;
            }

            public void setOrder_qiye_phone(String order_qiye_phone) {
                this.order_qiye_phone = order_qiye_phone;
            }

            public String getOrder_ask_who() {
                return order_ask_who;
            }

            public void setOrder_ask_who(String order_ask_who) {
                this.order_ask_who = order_ask_who;
            }

            public String getOrder_ask_phone() {
                return order_ask_phone;
            }

            public void setOrder_ask_phone(String order_ask_phone) {
                this.order_ask_phone = order_ask_phone;
            }

            public String getOrder_ask_mail() {
                return order_ask_mail;
            }

            public void setOrder_ask_mail(String order_ask_mail) {
                this.order_ask_mail = order_ask_mail;
            }

            public String getOrder_qiye_yingyezhizhao() {
                return order_qiye_yingyezhizhao;
            }

            public void setOrder_qiye_yingyezhizhao(String order_qiye_yingyezhizhao) {
                this.order_qiye_yingyezhizhao = order_qiye_yingyezhizhao;
            }

            public String getOrder_always_personal() {
                return order_always_personal;
            }

            public void setOrder_always_personal(String order_always_personal) {
                this.order_always_personal = order_always_personal;
            }

            public String getOrder_personal_name() {
                return order_personal_name;
            }

            public void setOrder_personal_name(String order_personal_name) {
                this.order_personal_name = order_personal_name;
            }

            public String getOrder_personal_id_card() {
                return order_personal_id_card;
            }

            public void setOrder_personal_id_card(String order_personal_id_card) {
                this.order_personal_id_card = order_personal_id_card;
            }

            public String getOrder_personal_tel() {
                return order_personal_tel;
            }

            public void setOrder_personal_tel(String order_personal_tel) {
                this.order_personal_tel = order_personal_tel;
            }

            public String getOrder_personal_ask_preson() {
                return order_personal_ask_preson;
            }

            public void setOrder_personal_ask_preson(String order_personal_ask_preson) {
                this.order_personal_ask_preson = order_personal_ask_preson;
            }

            public String getOrder_personal_ask_tel() {
                return order_personal_ask_tel;
            }

            public void setOrder_personal_ask_tel(String order_personal_ask_tel) {
                this.order_personal_ask_tel = order_personal_ask_tel;
            }

            public String getOrder_personal_id_card_pic() {
                return order_personal_id_card_pic;
            }

            public void setOrder_personal_id_card_pic(String order_personal_id_card_pic) {
                this.order_personal_id_card_pic = order_personal_id_card_pic;
            }

            public String getOrder_personal_getizhizhao() {
                return order_personal_getizhizhao;
            }

            public void setOrder_personal_getizhizhao(String order_personal_getizhizhao) {
                this.order_personal_getizhizhao = order_personal_getizhizhao;
            }

            public String getOrder_type() {
                return order_type;
            }

            public void setOrder_type(String order_type) {
                this.order_type = order_type;
            }

            public String getBelong_provice() {
                return belong_provice;
            }

            public void setBelong_provice(String belong_provice) {
                this.belong_provice = belong_provice;
            }

            public String getBelong_city() {
                return belong_city;
            }

            public void setBelong_city(String belong_city) {
                this.belong_city = belong_city;
            }

            public String getBelong_county() {
                return belong_county;
            }

            public void setBelong_county(String belong_county) {
                this.belong_county = belong_county;
            }

            public String getOrder_date_day() {
                return order_date_day;
            }

            public void setOrder_date_day(String order_date_day) {
                this.order_date_day = order_date_day;
            }

            public Object getOrder_acceptance_type() {
                return order_acceptance_type;
            }

            public void setOrder_acceptance_type(Object order_acceptance_type) {
                this.order_acceptance_type = order_acceptance_type;
            }

            public String getHetong1() {
                return hetong1;
            }

            public void setHetong1(String hetong1) {
                this.hetong1 = hetong1;
            }

            public String getHetong2() {
                return hetong2;
            }

            public void setHetong2(String hetong2) {
                this.hetong2 = hetong2;
            }

            public String getWeituoshu1() {
                return weituoshu1;
            }

            public void setWeituoshu1(String weituoshu1) {
                this.weituoshu1 = weituoshu1;
            }

            public String getWeituoshu2() {
                return weituoshu2;
            }

            public void setWeituoshu2(String weituoshu2) {
                this.weituoshu2 = weituoshu2;
            }
        }
    }
}
