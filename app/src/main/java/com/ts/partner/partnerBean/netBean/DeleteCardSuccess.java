package com.ts.partner.partnerBean.netBean;

/**
 * Created by Administrator on 2017/4/13.
 */

public class DeleteCardSuccess {

    /**
     * flag : Success
     * msg : 删除成功
     * data : 1
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
