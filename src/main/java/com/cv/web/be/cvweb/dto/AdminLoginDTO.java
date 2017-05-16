package com.cv.web.be.cvweb.dto;

import org.hibernate.validator.constraints.NotEmpty;

/**
 * Created by zhou_wb on 2017/5/13.
 */
public class AdminLoginDTO {

    @NotEmpty(message = "登录帐号不能为空")
    private String account;             //登陆账号

    @NotEmpty(message = "密码不能为空")
    private String pwd;

    @NotEmpty(message = "登陆来源不能为空")
    private String  resource;

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    public String getResource() {
        return resource;
    }

    public void setResource(String resource) {
        this.resource = resource;
    }
}
