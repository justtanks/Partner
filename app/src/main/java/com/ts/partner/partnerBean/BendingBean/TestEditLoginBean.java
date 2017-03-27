package com.ts.partner.partnerBean.BendingBean;

/**
 * Created by Administrator on 2017/2/13.
 * 登录界面保存手机号和密码的databinding使用类
 */

public class TestEditLoginBean {
    String userName;
    String userPassword;

    public TestEditLoginBean(String userName, String userPassword) {
        this.userName = userName;
        this.userPassword = userPassword;
    }

    public TestEditLoginBean() {
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserPassword() {
        return userPassword;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }

    @Override
    public String toString() {
        return "TestEditLoginBean{" +
                "userName='" + userName + '\'' +
                ", userPassword='" + userPassword + '\'' +
                '}';
    }
}
