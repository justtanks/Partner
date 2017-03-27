package com.ts.partner.partnerBean.netBean;

/**
 * Created by Administrator on 2017/2/15.
 */

public class IsHadPasswordBean {

    /**
     * flag : Success
     * msg : 未设置提现密码
     * data : 2
     * num : 1
     */

    private String flag;
    private String msg;
    private int data;
    private int num;

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

    public int getData() {
        return data;
    }

    public void setData(int data) {
        this.data = data;
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }
}
