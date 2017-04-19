package com.ts.partner.partnerBean.BendingBean;

/**
 * Created by Administrator on 2017/2/19.
 * 详情界面封装展示订单的信息的activity
 */


public class XiangqingBendingBean {

    String dindanhao;
    String zizhi;
    String headImg;
    String shangbiaomingcheng;
    String zongfeiyong;
    String zongleibie;
    String shangbiao;
    String zhizhao;

//    public XiangqingBendingBean(LoginBean.DataBean.PartnerAllOrderBean order) {
//        dindanhao = order.getOrder_num();
//        headImg = order.getOrder_personal_id_card_pic() == null ? order.getOrder_personal_id_card_pic() : order.getOrder_qiye_yingyezhizhao();
//        zizhi = order.getOrder_qiye_name() == null ? "个人注册" : "企业注册";
//        shangbiaomingcheng = order.getOrder_name();
//        zongfeiyong = order.getOrder_price();
//        String str=order.getOrder_types().replaceAll("\\s*", "").replace("第","    第");
//        zongleibie = str;
//        shangbiao = order.getOrder_pic();
//        zhizhao = order.getOrder_qiye_name() == null ? order.getOrder_qiye_yingyezhizhao() : order.getOrder_personal_getizhizhao();
//    }
//
//    public XiangqingBendingBean(LoginBean.DataBean.PartnerTodayOrderBean order) {
//        dindanhao = order.getOrder_num();
//        headImg = order.getOrder_personal_id_card_pic() == null ? order.getOrder_personal_id_card_pic() : order.getOrder_qiye_yingyezhizhao();
//        zizhi = order.getOrder_qiye_name() == null ? "个人注册" : "企业注册";
//        shangbiaomingcheng = order.getOrder_name();
//        zongfeiyong = order.getOrder_price();
//        String str=order.getOrder_types().replaceAll("\\s*", "").replace("第","   第");
//        zongleibie = str;
//        shangbiao = order.getOrder_pic();
//        zhizhao = order.getOrder_qiye_name() == null ? order.getOrder_qiye_yingyezhizhao() : order.getOrder_personal_getizhizhao();
//
//    }
//
//    public XiangqingBendingBean(LoginBean.DataBean.PartnerYesterdayOrderBean order) {
//        dindanhao = order.getOrder_num();
//        headImg = order.getOrder_personal_id_card_pic() == null ? order.getOrder_personal_id_card_pic() : order.getOrder_qiye_yingyezhizhao();
//        zizhi = order.getOrder_qiye_name() == null ? "个人注册" : "企业注册";
//        shangbiaomingcheng = order.getOrder_name();
//        zongfeiyong = order.getOrder_price();
//        String str=order.getOrder_types().replaceAll("\\s*", "").replace("第","   第");
//        zongleibie = str;
//        shangbiao = order.getOrder_pic();
//        zhizhao = order.getOrder_qiye_name() == null ? order.getOrder_qiye_yingyezhizhao() : order.getOrder_personal_getizhizhao();
//
//    }
//
//    public XiangqingBendingBean(LoginBean.DataBean.PartnerBeforeYesterdayOrderBean order) {
//        dindanhao = order.getOrder_num();
//        headImg = order.getOrder_personal_id_card_pic() == null ? order.getOrder_personal_id_card_pic() : order.getOrder_qiye_yingyezhizhao();
//        zizhi = order.getOrder_qiye_name() == null ? "个人注册" : "企业注册";
//        shangbiaomingcheng = order.getOrder_name();
//        zongfeiyong = order.getOrder_price();
//        String str=order.getOrder_types().replaceAll("\\s*", "").replace("第","   第");
//        zongleibie = str;
//        shangbiao = order.getOrder_pic();
//        zhizhao = order.getOrder_qiye_name() == null ? order.getOrder_qiye_yingyezhizhao() : order.getOrder_personal_getizhizhao();
//    }

    public String getDindanhao() {
        return dindanhao;
    }

    public void setDindanhao(String dindanhao) {
        this.dindanhao = dindanhao;
    }

    public String getZizhi() {
        return zizhi;
    }

    public void setZizhi(String zizhi) {
        this.zizhi = zizhi;
    }

    public String getHeadImg() {
        return headImg;
    }

    public void setHeadImg(String headImg) {
        this.headImg = headImg;
    }

    public String getShangbiaomingcheng() {
        return shangbiaomingcheng;
    }

    public void setShangbiaomingcheng(String shangbiaomingcheng) {
        this.shangbiaomingcheng = shangbiaomingcheng;
    }

    public String getZongfeiyong() {
        return zongfeiyong;
    }

    public void setZongfeiyong(String zongfeiyong) {
        this.zongfeiyong = zongfeiyong;
    }

    public String getZongleibie() {
        return zongleibie;
    }

    public void setZongleibie(String zongleibie) {
        this.zongleibie = zongleibie;
    }

    public String getShangbiao() {
        return shangbiao;
    }

    public void setShangbiao(String shangbiao) {
        this.shangbiao = shangbiao;
    }

    public String getZhizhao() {
        return zhizhao;
    }

    public void setZhizhao(String zhizhao) {
        this.zhizhao = zhizhao;
    }
}
