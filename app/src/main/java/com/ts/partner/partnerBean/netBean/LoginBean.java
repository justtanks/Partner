package com.ts.partner.partnerBean.netBean;

import android.os.Parcelable;

import com.ts.partner.partnerBase.BaseOrders;

import java.io.Serializable;
import java.util.List;

/**
 * Created by Administrator on 2017/2/13.
 */

public class LoginBean implements Serializable {

    /**
     * flag : Success
     * msg : 密码正确
     * data : [{"partner_id":"3","partner_name":null,"partner_belong_provice":"山东省","partner_belong_city":"德州市","partner_account":"18266142739","partner_password":"123456","partner_register":"2017-02-13 10:42:59","partner_examine":"0","partner_all_order":[{"id":"86","order_num":"1486687262","who_put_order":"18266142739","order_name":"123","order_pic":"/Uploads/2017-02-10/589d0c1e1e587.png","order_types":"第29类　　食品第30类　　方便食品第31类　　饲料种籽第32类　　啤酒饮料第33类　　酒第35类　　广告销售第43类　　餐饮住宿第37类　　建筑修理第40类　　材料加工第42类　　科技服务","order_price":"10450","order_wait_taking":"0","order_wait_pay":"0","order_time":"2017-02-10 08:41:02","order_always_person":null,"order_qiye_name":"山东驾行科技有限公司","order_qiye_address":"山东省德州市德城区","order_qiye_phone":"18266142121","order_ask_who":"走走走","order_ask_phone":"12345678911","order_ask_mail":"154496959@qq.com","order_qiye_yingyezhizhao":"/Uploads/2017-02-10/589d0c1e1e77b.png","order_always_personal":"","order_personal_name":"","order_personal_id_card":"","order_personal_tel":"","order_personal_ask_preson":"","order_personal_ask_tel":"","order_personal_id_card_pic":"/Uploads/2017-02-10/","order_personal_getizhizhao":"/Uploads/2017-02-10/","order_type":"智能商标注册","belong_provice":"山东省","belong_city":"德州市","order_date_day":"2017-02-11"},{"id":"87","order_num":"1486687307","who_put_order":"18266142739","order_name":"123","order_pic":"/Uploads/2017-02-10/589d0c4bb0796.png","order_types":"第09类　　科学仪器第35类　　广告销售第36类　　金融物管第38类　　通讯服务第41类　　教育娱乐第42类　　科技服务","order_price":"6600","order_wait_taking":"0","order_wait_pay":"0","order_time":"2017-02-10 08:41:47","order_always_person":null,"order_qiye_name":"山东驾行科技有限公司","order_qiye_address":"山东省德州市德城区","order_qiye_phone":"18266142121","order_ask_who":"走走走","order_ask_phone":"12345678911","order_ask_mail":"154496959@qq.com","order_qiye_yingyezhizhao":"/Uploads/2017-02-10/589d0c4bb0a88.png","order_always_personal":"","order_personal_name":"","order_personal_id_card":"","order_personal_tel":"","order_personal_ask_preson":"","order_personal_ask_tel":"","order_personal_id_card_pic":"/Uploads/2017-02-10/","order_personal_getizhizhao":"/Uploads/2017-02-10/","order_type":"智能商标注册","belong_provice":"山东省","belong_city":"德州市","order_date_day":"2017-02-12"},{"id":"88","order_num":"1486687867","who_put_order":"18266142739","order_name":"123","order_pic":"/Uploads/2017-02-10/589d0e7b0938c.png","order_types":"第35类　　广告销售第37类　　建筑修理第40类　　材料加工第42类　　科技服务","order_price":"4400","order_wait_taking":"0","order_wait_pay":"0","order_time":"2017-02-10 08:51:07","order_always_person":null,"order_qiye_name":"山东驾行科技有限公司","order_qiye_address":"山东省德州市德城区","order_qiye_phone":"18266142121","order_ask_who":"走走走","order_ask_phone":"12345678911","order_ask_mail":"154496959@qq.com","order_qiye_yingyezhizhao":"/Uploads/2017-02-10/589d0e7b09661.png","order_always_personal":"","order_personal_name":"","order_personal_id_card":"","order_personal_tel":"","order_personal_ask_preson":"","order_personal_ask_tel":"","order_personal_id_card_pic":"/Uploads/2017-02-10/","order_personal_getizhizhao":"/Uploads/2017-02-10/","order_type":"智能商标注册","belong_provice":"山东省","belong_city":"德州市","order_date_day":"2017-02-13"},{"id":"89","order_num":"1486687902","who_put_order":"18266142739","order_name":"123","order_pic":"/Uploads/2017-02-10/589d0e9e54793.png","order_types":"第29类　　食品第30类　　方便食品第31类　　饲料种籽第32类　　啤酒饮料第33类　　酒第35类　　广告销售第40类　　材料加工","order_price":"7150","order_wait_taking":"0","order_wait_pay":"0","order_time":"2017-02-10 08:51:42","order_always_person":null,"order_qiye_name":"","order_qiye_address":"","order_qiye_phone":"","order_ask_who":"","order_ask_phone":"","order_ask_mail":"","order_qiye_yingyezhizhao":"/Uploads/2017-02-10/","order_always_personal":"123","order_personal_name":"123","order_personal_id_card":"123","order_personal_tel":"123","order_personal_ask_preson":"123","order_personal_ask_tel":"123","order_personal_id_card_pic":"/Uploads/2017-02-10/589d0e9e549c7.png","order_personal_getizhizhao":"/Uploads/2017-02-10/589d0e9e54b4b.png","order_type":"智能商标注册","belong_provice":"山东省","belong_city":"德州市","order_date_day":"2017-02-13"}],"partner_today_order":[{"id":"88","order_num":"1486687867","who_put_order":"18266142739","order_name":"123","order_pic":"/Uploads/2017-02-10/589d0e7b0938c.png","order_types":"第35类　　广告销售第37类　　建筑修理第40类　　材料加工第42类　　科技服务","order_price":"4400","order_wait_taking":"0","order_wait_pay":"0","order_time":"2017-02-10 08:51:07","order_always_person":null,"order_qiye_name":"山东驾行科技有限公司","order_qiye_address":"山东省德州市德城区","order_qiye_phone":"18266142121","order_ask_who":"走走走","order_ask_phone":"12345678911","order_ask_mail":"154496959@qq.com","order_qiye_yingyezhizhao":"/Uploads/2017-02-10/589d0e7b09661.png","order_always_personal":"","order_personal_name":"","order_personal_id_card":"","order_personal_tel":"","order_personal_ask_preson":"","order_personal_ask_tel":"","order_personal_id_card_pic":"/Uploads/2017-02-10/","order_personal_getizhizhao":"/Uploads/2017-02-10/","order_type":"智能商标注册","belong_provice":"山东省","belong_city":"德州市","order_date_day":"2017-02-13"},{"id":"89","order_num":"1486687902","who_put_order":"18266142739","order_name":"123","order_pic":"/Uploads/2017-02-10/589d0e9e54793.png","order_types":"第29类　　食品第30类　　方便食品第31类　　饲料种籽第32类　　啤酒饮料第33类　　酒第35类　　广告销售第40类　　材料加工","order_price":"7150","order_wait_taking":"0","order_wait_pay":"0","order_time":"2017-02-10 08:51:42","order_always_person":null,"order_qiye_name":"","order_qiye_address":"","order_qiye_phone":"","order_ask_who":"","order_ask_phone":"","order_ask_mail":"","order_qiye_yingyezhizhao":"/Uploads/2017-02-10/","order_always_personal":"123","order_personal_name":"123","order_personal_id_card":"123","order_personal_tel":"123","order_personal_ask_preson":"123","order_personal_ask_tel":"123","order_personal_id_card_pic":"/Uploads/2017-02-10/589d0e9e549c7.png","order_personal_getizhizhao":"/Uploads/2017-02-10/589d0e9e54b4b.png","order_type":"智能商标注册","belong_provice":"山东省","belong_city":"德州市","order_date_day":"2017-02-13"}],"partner_today_order_count":"2","partner_today_order_money":"11550","partner_yesterday_order":[{"id":"87","order_num":"1486687307","who_put_order":"18266142739","order_name":"123","order_pic":"/Uploads/2017-02-10/589d0c4bb0796.png","order_types":"第09类　　科学仪器第35类　　广告销售第36类　　金融物管第38类　　通讯服务第41类　　教育娱乐第42类　　科技服务","order_price":"6600","order_wait_taking":"0","order_wait_pay":"0","order_time":"2017-02-10 08:41:47","order_always_person":null,"order_qiye_name":"山东驾行科技有限公司","order_qiye_address":"山东省德州市德城区","order_qiye_phone":"18266142121","order_ask_who":"走走走","order_ask_phone":"12345678911","order_ask_mail":"154496959@qq.com","order_qiye_yingyezhizhao":"/Uploads/2017-02-10/589d0c4bb0a88.png","order_always_personal":"","order_personal_name":"","order_personal_id_card":"","order_personal_tel":"","order_personal_ask_preson":"","order_personal_ask_tel":"","order_personal_id_card_pic":"/Uploads/2017-02-10/","order_personal_getizhizhao":"/Uploads/2017-02-10/","order_type":"智能商标注册","belong_provice":"山东省","belong_city":"德州市","order_date_day":"2017-02-12"}],"partner_yesterday_order_count":"1","partner_yesterday_order_money":"6600","partner_before_yesterday_order":[{"id":"86","order_num":"1486687262","who_put_order":"18266142739","order_name":"123","order_pic":"/Uploads/2017-02-10/589d0c1e1e587.png","order_types":"第29类　　食品第30类　　方便食品第31类　　饲料种籽第32类　　啤酒饮料第33类　　酒第35类　　广告销售第43类　　餐饮住宿第37类　　建筑修理第40类　　材料加工第42类　　科技服务","order_price":"10450","order_wait_taking":"0","order_wait_pay":"0","order_time":"2017-02-10 08:41:02","order_always_person":null,"order_qiye_name":"山东驾行科技有限公司","order_qiye_address":"山东省德州市德城区","order_qiye_phone":"18266142121","order_ask_who":"走走走","order_ask_phone":"12345678911","order_ask_mail":"154496959@qq.com","order_qiye_yingyezhizhao":"/Uploads/2017-02-10/589d0c1e1e77b.png","order_always_personal":"","order_personal_name":"","order_personal_id_card":"","order_personal_tel":"","order_personal_ask_preson":"","order_personal_ask_tel":"","order_personal_id_card_pic":"/Uploads/2017-02-10/","order_personal_getizhizhao":"/Uploads/2017-02-10/","order_type":"智能商标注册","belong_provice":"山东省","belong_city":"德州市","order_date_day":"2017-02-11"}],"partner_before_yesterday_order_count":"1","partner_before_yesterday_order_money":"10450"}]
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

    public static class DataBean implements Serializable {
        /**
         * partner_id : 3
         * partner_name : null
         * partner_belong_provice : 山东省
         * partner_belong_city : 德州市
         * partner_account : 18266142739
         * partner_password : 123456
         * partner_register : 2017-02-13 10:42:59
         * partner_examine : 0
         * partner_all_order : [{"id":"86","order_num":"1486687262","who_put_order":"18266142739","order_name":"123","order_pic":"/Uploads/2017-02-10/589d0c1e1e587.png","order_types":"第29类　　食品第30类　　方便食品第31类　　饲料种籽第32类　　啤酒饮料第33类　　酒第35类　　广告销售第43类　　餐饮住宿第37类　　建筑修理第40类　　材料加工第42类　　科技服务","order_price":"10450","order_wait_taking":"0","order_wait_pay":"0","order_time":"2017-02-10 08:41:02","order_always_person":null,"order_qiye_name":"山东驾行科技有限公司","order_qiye_address":"山东省德州市德城区","order_qiye_phone":"18266142121","order_ask_who":"走走走","order_ask_phone":"12345678911","order_ask_mail":"154496959@qq.com","order_qiye_yingyezhizhao":"/Uploads/2017-02-10/589d0c1e1e77b.png","order_always_personal":"","order_personal_name":"","order_personal_id_card":"","order_personal_tel":"","order_personal_ask_preson":"","order_personal_ask_tel":"","order_personal_id_card_pic":"/Uploads/2017-02-10/","order_personal_getizhizhao":"/Uploads/2017-02-10/","order_type":"智能商标注册","belong_provice":"山东省","belong_city":"德州市","order_date_day":"2017-02-11"},{"id":"87","order_num":"1486687307","who_put_order":"18266142739","order_name":"123","order_pic":"/Uploads/2017-02-10/589d0c4bb0796.png","order_types":"第09类　　科学仪器第35类　　广告销售第36类　　金融物管第38类　　通讯服务第41类　　教育娱乐第42类　　科技服务","order_price":"6600","order_wait_taking":"0","order_wait_pay":"0","order_time":"2017-02-10 08:41:47","order_always_person":null,"order_qiye_name":"山东驾行科技有限公司","order_qiye_address":"山东省德州市德城区","order_qiye_phone":"18266142121","order_ask_who":"走走走","order_ask_phone":"12345678911","order_ask_mail":"154496959@qq.com","order_qiye_yingyezhizhao":"/Uploads/2017-02-10/589d0c4bb0a88.png","order_always_personal":"","order_personal_name":"","order_personal_id_card":"","order_personal_tel":"","order_personal_ask_preson":"","order_personal_ask_tel":"","order_personal_id_card_pic":"/Uploads/2017-02-10/","order_personal_getizhizhao":"/Uploads/2017-02-10/","order_type":"智能商标注册","belong_provice":"山东省","belong_city":"德州市","order_date_day":"2017-02-12"},{"id":"88","order_num":"1486687867","who_put_order":"18266142739","order_name":"123","order_pic":"/Uploads/2017-02-10/589d0e7b0938c.png","order_types":"第35类　　广告销售第37类　　建筑修理第40类　　材料加工第42类　　科技服务","order_price":"4400","order_wait_taking":"0","order_wait_pay":"0","order_time":"2017-02-10 08:51:07","order_always_person":null,"order_qiye_name":"山东驾行科技有限公司","order_qiye_address":"山东省德州市德城区","order_qiye_phone":"18266142121","order_ask_who":"走走走","order_ask_phone":"12345678911","order_ask_mail":"154496959@qq.com","order_qiye_yingyezhizhao":"/Uploads/2017-02-10/589d0e7b09661.png","order_always_personal":"","order_personal_name":"","order_personal_id_card":"","order_personal_tel":"","order_personal_ask_preson":"","order_personal_ask_tel":"","order_personal_id_card_pic":"/Uploads/2017-02-10/","order_personal_getizhizhao":"/Uploads/2017-02-10/","order_type":"智能商标注册","belong_provice":"山东省","belong_city":"德州市","order_date_day":"2017-02-13"},{"id":"89","order_num":"1486687902","who_put_order":"18266142739","order_name":"123","order_pic":"/Uploads/2017-02-10/589d0e9e54793.png","order_types":"第29类　　食品第30类　　方便食品第31类　　饲料种籽第32类　　啤酒饮料第33类　　酒第35类　　广告销售第40类　　材料加工","order_price":"7150","order_wait_taking":"0","order_wait_pay":"0","order_time":"2017-02-10 08:51:42","order_always_person":null,"order_qiye_name":"","order_qiye_address":"","order_qiye_phone":"","order_ask_who":"","order_ask_phone":"","order_ask_mail":"","order_qiye_yingyezhizhao":"/Uploads/2017-02-10/","order_always_personal":"123","order_personal_name":"123","order_personal_id_card":"123","order_personal_tel":"123","order_personal_ask_preson":"123","order_personal_ask_tel":"123","order_personal_id_card_pic":"/Uploads/2017-02-10/589d0e9e549c7.png","order_personal_getizhizhao":"/Uploads/2017-02-10/589d0e9e54b4b.png","order_type":"智能商标注册","belong_provice":"山东省","belong_city":"德州市","order_date_day":"2017-02-13"}]
         * partner_today_order : [{"id":"88","order_num":"1486687867","who_put_order":"18266142739","order_name":"123","order_pic":"/Uploads/2017-02-10/589d0e7b0938c.png","order_types":"第35类　　广告销售第37类　　建筑修理第40类　　材料加工第42类　　科技服务","order_price":"4400","order_wait_taking":"0","order_wait_pay":"0","order_time":"2017-02-10 08:51:07","order_always_person":null,"order_qiye_name":"山东驾行科技有限公司","order_qiye_address":"山东省德州市德城区","order_qiye_phone":"18266142121","order_ask_who":"走走走","order_ask_phone":"12345678911","order_ask_mail":"154496959@qq.com","order_qiye_yingyezhizhao":"/Uploads/2017-02-10/589d0e7b09661.png","order_always_personal":"","order_personal_name":"","order_personal_id_card":"","order_personal_tel":"","order_personal_ask_preson":"","order_personal_ask_tel":"","order_personal_id_card_pic":"/Uploads/2017-02-10/","order_personal_getizhizhao":"/Uploads/2017-02-10/","order_type":"智能商标注册","belong_provice":"山东省","belong_city":"德州市","order_date_day":"2017-02-13"},{"id":"89","order_num":"1486687902","who_put_order":"18266142739","order_name":"123","order_pic":"/Uploads/2017-02-10/589d0e9e54793.png","order_types":"第29类　　食品第30类　　方便食品第31类　　饲料种籽第32类　　啤酒饮料第33类　　酒第35类　　广告销售第40类　　材料加工","order_price":"7150","order_wait_taking":"0","order_wait_pay":"0","order_time":"2017-02-10 08:51:42","order_always_person":null,"order_qiye_name":"","order_qiye_address":"","order_qiye_phone":"","order_ask_who":"","order_ask_phone":"","order_ask_mail":"","order_qiye_yingyezhizhao":"/Uploads/2017-02-10/","order_always_personal":"123","order_personal_name":"123","order_personal_id_card":"123","order_personal_tel":"123","order_personal_ask_preson":"123","order_personal_ask_tel":"123","order_personal_id_card_pic":"/Uploads/2017-02-10/589d0e9e549c7.png","order_personal_getizhizhao":"/Uploads/2017-02-10/589d0e9e54b4b.png","order_type":"智能商标注册","belong_provice":"山东省","belong_city":"德州市","order_date_day":"2017-02-13"}]
         * partner_today_order_count : 2
         * partner_today_order_money : 11550
         * partner_yesterday_order : [{"id":"87","order_num":"1486687307","who_put_order":"18266142739","order_name":"123","order_pic":"/Uploads/2017-02-10/589d0c4bb0796.png","order_types":"第09类　　科学仪器第35类　　广告销售第36类　　金融物管第38类　　通讯服务第41类　　教育娱乐第42类　　科技服务","order_price":"6600","order_wait_taking":"0","order_wait_pay":"0","order_time":"2017-02-10 08:41:47","order_always_person":null,"order_qiye_name":"山东驾行科技有限公司","order_qiye_address":"山东省德州市德城区","order_qiye_phone":"18266142121","order_ask_who":"走走走","order_ask_phone":"12345678911","order_ask_mail":"154496959@qq.com","order_qiye_yingyezhizhao":"/Uploads/2017-02-10/589d0c4bb0a88.png","order_always_personal":"","order_personal_name":"","order_personal_id_card":"","order_personal_tel":"","order_personal_ask_preson":"","order_personal_ask_tel":"","order_personal_id_card_pic":"/Uploads/2017-02-10/","order_personal_getizhizhao":"/Uploads/2017-02-10/","order_type":"智能商标注册","belong_provice":"山东省","belong_city":"德州市","order_date_day":"2017-02-12"}]
         * partner_yesterday_order_count : 1
         * partner_yesterday_order_money : 6600
         * partner_before_yesterday_order : [{"id":"86","order_num":"1486687262","who_put_order":"18266142739","order_name":"123","order_pic":"/Uploads/2017-02-10/589d0c1e1e587.png","order_types":"第29类　　食品第30类　　方便食品第31类　　饲料种籽第32类　　啤酒饮料第33类　　酒第35类　　广告销售第43类　　餐饮住宿第37类　　建筑修理第40类　　材料加工第42类　　科技服务","order_price":"10450","order_wait_taking":"0","order_wait_pay":"0","order_time":"2017-02-10 08:41:02","order_always_person":null,"order_qiye_name":"山东驾行科技有限公司","order_qiye_address":"山东省德州市德城区","order_qiye_phone":"18266142121","order_ask_who":"走走走","order_ask_phone":"12345678911","order_ask_mail":"154496959@qq.com","order_qiye_yingyezhizhao":"/Uploads/2017-02-10/589d0c1e1e77b.png","order_always_personal":"","order_personal_name":"","order_personal_id_card":"","order_personal_tel":"","order_personal_ask_preson":"","order_personal_ask_tel":"","order_personal_id_card_pic":"/Uploads/2017-02-10/","order_personal_getizhizhao":"/Uploads/2017-02-10/","order_type":"智能商标注册","belong_provice":"山东省","belong_city":"德州市","order_date_day":"2017-02-11"}]
         * partner_before_yesterday_order_count : 1
         * partner_before_yesterday_order_money : 10450
         */
        /**
         * partner_all_money : 33000
         */

        private String partner_id;
        private String partner_name;
        private String partner_belong_provice;
        private String partner_belong_city;
        private String partner_account;
        private String partner_password;
        private String partner_register;
        private String partner_examine;
        private String partner_all_money;
        private int partner_account_balance;


        private String partner_today_order_count;
        private String partner_today_order_money;
        private String partner_yesterday_order_count;
        private String partner_yesterday_order_money;
        private String partner_before_yesterday_order_count;
        private String partner_before_yesterday_order_money;
        private List<PartnerBankCardBean> partner_bank_card;

        public List<PartnerBankCardBean> getPartner_bank_card() {
            return partner_bank_card;
        }

        public void setPartner_bank_card(List<PartnerBankCardBean> partner_bank_card) {
            this.partner_bank_card = partner_bank_card;
        }

        private List<PartnerAllOrderBean> partner_all_order;
        private List<PartnerTodayOrderBean> partner_today_order;
        private List<PartnerYesterdayOrderBean> partner_yesterday_order;
        private List<PartnerBeforeYesterdayOrderBean> partner_before_yesterday_order;

        public String getPartner_id() {
            return partner_id;
        }

        public int getPartner_account_balance() {
            return partner_account_balance;
        }

        public void setPartner_account_balance(int partner_account_balance) {
            this.partner_account_balance = partner_account_balance;
        }

        public void setPartner_id(String partner_id) {
            this.partner_id = partner_id;
        }

        public String getPartner_name() {
            return partner_name;
        }

        public void setPartner_name(String partner_name) {
            this.partner_name = partner_name;
        }

        public String getPartner_belong_provice() {
            return partner_belong_provice;
        }

        public void setPartner_belong_provice(String partner_belong_provice) {
            this.partner_belong_provice = partner_belong_provice;
        }

        public String getPartner_all_money() {
            return partner_all_money;
        }

        public void setPartner_all_money(String partner_all_money) {
            this.partner_all_money = partner_all_money;
        }

        public String getPartner_belong_city() {
            return partner_belong_city;
        }

        public void setPartner_belong_city(String partner_belong_city) {
            this.partner_belong_city = partner_belong_city;
        }

        public String getPartner_account() {
            return partner_account;
        }

        public void setPartner_account(String partner_account) {
            this.partner_account = partner_account;
        }

        public String getPartner_password() {
            return partner_password;
        }

        public void setPartner_password(String partner_password) {
            this.partner_password = partner_password;
        }

        public String getPartner_register() {
            return partner_register;
        }

        public void setPartner_register(String partner_register) {
            this.partner_register = partner_register;
        }

        public String getPartner_examine() {
            return partner_examine;
        }

        public void setPartner_examine(String partner_examine) {
            this.partner_examine = partner_examine;
        }

        public String getPartner_today_order_count() {
            return partner_today_order_count;
        }

        public void setPartner_today_order_count(String partner_today_order_count) {
            this.partner_today_order_count = partner_today_order_count;
        }

        public String getPartner_today_order_money() {
            return partner_today_order_money;
        }

        public void setPartner_today_order_money(String partner_today_order_money) {
            this.partner_today_order_money = partner_today_order_money;
        }

        public String getPartner_yesterday_order_count() {
            return partner_yesterday_order_count;
        }

        public void setPartner_yesterday_order_count(String partner_yesterday_order_count) {
            this.partner_yesterday_order_count = partner_yesterday_order_count;
        }

        public String getPartner_yesterday_order_money() {
            return partner_yesterday_order_money;
        }

        public void setPartner_yesterday_order_money(String partner_yesterday_order_money) {
            this.partner_yesterday_order_money = partner_yesterday_order_money;
        }

        public String getPartner_before_yesterday_order_count() {
            return partner_before_yesterday_order_count;
        }

        public void setPartner_before_yesterday_order_count(String partner_before_yesterday_order_count) {
            this.partner_before_yesterday_order_count = partner_before_yesterday_order_count;
        }

        public String getPartner_before_yesterday_order_money() {
            return partner_before_yesterday_order_money;
        }

        public void setPartner_before_yesterday_order_money(String partner_before_yesterday_order_money) {
            this.partner_before_yesterday_order_money = partner_before_yesterday_order_money;
        }

        public List<PartnerAllOrderBean> getPartner_all_order() {
            return partner_all_order;
        }

        public void setPartner_all_order(List<PartnerAllOrderBean> partner_all_order) {
            this.partner_all_order = partner_all_order;
        }

        public List<PartnerTodayOrderBean> getPartner_today_order() {
            return partner_today_order;
        }

        public void setPartner_today_order(List<PartnerTodayOrderBean> partner_today_order) {
            this.partner_today_order = partner_today_order;
        }

        public List<PartnerYesterdayOrderBean> getPartner_yesterday_order() {
            return partner_yesterday_order;
        }

        public void setPartner_yesterday_order(List<PartnerYesterdayOrderBean> partner_yesterday_order) {
            this.partner_yesterday_order = partner_yesterday_order;
        }

        public List<PartnerBeforeYesterdayOrderBean> getPartner_before_yesterday_order() {
            return partner_before_yesterday_order;
        }

        public void setPartner_before_yesterday_order(List<PartnerBeforeYesterdayOrderBean> partner_before_yesterday_order) {
            this.partner_before_yesterday_order = partner_before_yesterday_order;
        }

        public static class PartnerBankCardBean implements Serializable {
            /**
             * id : 2
             * pid : 3
             * bank_name : 工商银行
             * card_num : 1234
             * add_time : 2017-02-15 10:42:38
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

        public static class PartnerAllOrderBean extends BaseOrders implements Serializable {
            /**
             * id : 86
             * order_num : 1486687262
             * who_put_order : 18266142739
             * order_name : 123
             * order_pic : /Uploads/2017-02-10/589d0c1e1e587.png
             * order_types : 第29类　　食品第30类　　方便食品第31类　　饲料种籽第32类　　啤酒饮料第33类　　酒第35类　　广告销售第43类　　餐饮住宿第37类　　建筑修理第40类　　材料加工第42类　　科技服务
             * order_price : 10450
             * order_wait_taking : 0
             * order_wait_pay : 0
             * order_time : 2017-02-10 08:41:02
             * order_always_person : null
             * order_qiye_name : 山东驾行科技有限公司
             * order_qiye_address : 山东省德州市德城区
             * order_qiye_phone : 18266142121
             * order_ask_who : 走走走
             * order_ask_phone : 12345678911
             * order_ask_mail : 154496959@qq.com
             * order_qiye_yingyezhizhao : /Uploads/2017-02-10/589d0c1e1e77b.png
             * order_always_personal :
             * order_personal_name :
             * order_personal_id_card :
             * order_personal_tel :
             * order_personal_ask_preson :
             * order_personal_ask_tel :
             * order_personal_id_card_pic : /Uploads/2017-02-10/
             * order_personal_getizhizhao : /Uploads/2017-02-10/
             * order_type : 智能商标注册
             * belong_provice : 山东省
             * belong_city : 德州市
             * order_date_day : 2017-02-11
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
            private String order_always_person;
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
            private String order_date_day;

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

            public String getOrder_always_person() {
                return order_always_person;
            }

            public void setOrder_always_person(String order_always_person) {
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

            public String getOrder_date_day() {
                return order_date_day;
            }

            public void setOrder_date_day(String order_date_day) {
                this.order_date_day = order_date_day;
            }
        }

        public static class PartnerTodayOrderBean extends BaseOrders implements Serializable {
            /**
             * id : 88
             * order_num : 1486687867
             * who_put_order : 18266142739
             * order_name : 123
             * order_pic : /Uploads/2017-02-10/589d0e7b0938c.png
             * order_types : 第35类　　广告销售第37类　　建筑修理第40类　　材料加工第42类　　科技服务
             * order_price : 4400
             * order_wait_taking : 0
             * order_wait_pay : 0
             * order_time : 2017-02-10 08:51:07
             * order_always_person : null
             * order_qiye_name : 山东驾行科技有限公司
             * order_qiye_address : 山东省德州市德城区
             * order_qiye_phone : 18266142121
             * order_ask_who : 走走走
             * order_ask_phone : 12345678911
             * order_ask_mail : 154496959@qq.com
             * order_qiye_yingyezhizhao : /Uploads/2017-02-10/589d0e7b09661.png
             * order_always_personal :
             * order_personal_name :
             * order_personal_id_card :
             * order_personal_tel :
             * order_personal_ask_preson :
             * order_personal_ask_tel :
             * order_personal_id_card_pic : /Uploads/2017-02-10/
             * order_personal_getizhizhao : /Uploads/2017-02-10/
             * order_type : 智能商标注册
             * belong_provice : 山东省
             * belong_city : 德州市
             * order_date_day : 2017-02-13
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
            private String order_always_person;
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
            private String order_date_day;

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

            public void setOrder_always_person(String order_always_person) {
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

            public String getOrder_date_day() {
                return order_date_day;
            }

            public void setOrder_date_day(String order_date_day) {
                this.order_date_day = order_date_day;
            }
        }

        public static class PartnerYesterdayOrderBean extends BaseOrders implements Serializable {
            /**
             * id : 87
             * order_num : 1486687307
             * who_put_order : 18266142739
             * order_name : 123
             * order_pic : /Uploads/2017-02-10/589d0c4bb0796.png
             * order_types : 第09类　　科学仪器第35类　　广告销售第36类　　金融物管第38类　　通讯服务第41类　　教育娱乐第42类　　科技服务
             * order_price : 6600
             * order_wait_taking : 0
             * order_wait_pay : 0
             * order_time : 2017-02-10 08:41:47
             * order_always_person : null
             * order_qiye_name : 山东驾行科技有限公司
             * order_qiye_address : 山东省德州市德城区
             * order_qiye_phone : 18266142121
             * order_ask_who : 走走走
             * order_ask_phone : 12345678911
             * order_ask_mail : 154496959@qq.com
             * order_qiye_yingyezhizhao : /Uploads/2017-02-10/589d0c4bb0a88.png
             * order_always_personal :
             * order_personal_name :
             * order_personal_id_card :
             * order_personal_tel :
             * order_personal_ask_preson :
             * order_personal_ask_tel :
             * order_personal_id_card_pic : /Uploads/2017-02-10/
             * order_personal_getizhizhao : /Uploads/2017-02-10/
             * order_type : 智能商标注册
             * belong_provice : 山东省
             * belong_city : 德州市
             * order_date_day : 2017-02-12
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
            private String order_always_person;
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
            private String order_date_day;

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

            public String getOrder_always_person() {
                return order_always_person;
            }

            public void setOrder_always_person(String order_always_person) {
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

            public String getOrder_date_day() {
                return order_date_day;
            }

            public void setOrder_date_day(String order_date_day) {
                this.order_date_day = order_date_day;
            }
        }

        public static class PartnerBeforeYesterdayOrderBean extends BaseOrders implements Serializable {
            /**
             * id : 86
             * order_num : 1486687262
             * who_put_order : 18266142739
             * order_name : 123
             * order_pic : /Uploads/2017-02-10/589d0c1e1e587.png
             * order_types : 第29类　　食品第30类　　方便食品第31类　　饲料种籽第32类　　啤酒饮料第33类　　酒第35类　　广告销售第43类　　餐饮住宿第37类　　建筑修理第40类　　材料加工第42类　　科技服务
             * order_price : 10450
             * order_wait_taking : 0
             * order_wait_pay : 0
             * order_time : 2017-02-10 08:41:02
             * order_always_person : null
             * order_qiye_name : 山东驾行科技有限公司
             * order_qiye_address : 山东省德州市德城区
             * order_qiye_phone : 18266142121
             * order_ask_who : 走走走
             * order_ask_phone : 12345678911
             * order_ask_mail : 154496959@qq.com
             * order_qiye_yingyezhizhao : /Uploads/2017-02-10/589d0c1e1e77b.png
             * order_always_personal :
             * order_personal_name :
             * order_personal_id_card :
             * order_personal_tel :
             * order_personal_ask_preson :
             * order_personal_ask_tel :
             * order_personal_id_card_pic : /Uploads/2017-02-10/
             * order_personal_getizhizhao : /Uploads/2017-02-10/
             * order_type : 智能商标注册
             * belong_provice : 山东省
             * belong_city : 德州市
             * order_date_day : 2017-02-11
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
            private String order_date_day;

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

            public String getOrder_date_day() {
                return order_date_day;
            }

            public void setOrder_date_day(String order_date_day) {
                this.order_date_day = order_date_day;
            }
        }
    }
}
