package com.ts.partner.partnerBean.netBean;

import java.io.Serializable;
import java.util.List;

/**
 * Created by Administrator on 2017/2/28.
 * 调用获取分享信息的接口获取的数据
 */

public class ShareMesBean implements Serializable{

    private String flag;
    private int num;
    private List<MsgBean> msg;
    private List<?> data;

    public String getFlag() {
        return flag;
    }

    public void setFlag(String flag) {
        this.flag = flag;
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public List<MsgBean> getMsg() {
        return msg;
    }

    public void setMsg(List<MsgBean> msg) {
        this.msg = msg;
    }

    public List<?> getData() {
        return data;
    }

    public void setData(List<?> data) {
        this.data = data;
    }

    public static class MsgBean implements Serializable {
        /**
         * spread_id : 1
         * spread_title : 虽是隔夜酒仍然定酒驾 驾驶证记12分吊扣6个月
         * spread_pic : http://oss.jiaolianmishu.com/zhaosheng/zhaosheng/kaoshi/pc/upload/school_news/41bc819e3bd8f4a4f8a1b8a8db5eab85.jpg
         * spread_href : http://121.199.32.4:8088/index.php/Home/Partner/title/title_id/1
         * spread_time : 2017-02-28 10:10:41
         */

        private String spread_id;
        private String spread_title;
        private String spread_pic;
        private String spread_href;
        private String spread_time;

        public String getSpread_id() {
            return spread_id;
        }

        public void setSpread_id(String spread_id) {
            this.spread_id = spread_id;
        }

        public String getSpread_title() {
            return spread_title;
        }

        public void setSpread_title(String spread_title) {
            this.spread_title = spread_title;
        }

        public String getSpread_pic() {
            return spread_pic;
        }

        public void setSpread_pic(String spread_pic) {
            this.spread_pic = spread_pic;
        }

        public String getSpread_href() {
            return spread_href;
        }

        public void setSpread_href(String spread_href) {
            this.spread_href = spread_href;
        }

        public String getSpread_time() {
            return spread_time;
        }

        public void setSpread_time(String spread_time) {
            this.spread_time = spread_time;
        }
    }
}
