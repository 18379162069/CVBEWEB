package com.cv.web.be.cvweb.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * Created by zhou_wb on 2017/5/14.
 */

public class User implements Serializable{


    private Integer id;


    private String pwd;        //用户密码


    private String realName;   //真实姓名


    private String email;      //用户邮箱


    private String mobile;     //用户手机


    private boolean isLocked;  //用户是否锁定

    private String source;     //用户来源


    @JsonFormat(pattern = "yyyyMMddHHmmss")

    private LocalDateTime createdOn;  //创建时间


    @JsonFormat(pattern = "yyyyMMddHHmmss")

    private LocalDateTime updatedOn;  //更新时间

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    public String getRealName() {
        return realName;
    }

    public void setRealName(String realName) {
        this.realName = realName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public boolean isLocked() {
        return isLocked;
    }

    public void setIsLocked(boolean isLocked) {
        this.isLocked = isLocked;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public LocalDateTime getCreatedOn() {
        return createdOn;
    }

    public void setCreatedOn(LocalDateTime createdOn) {
        this.createdOn = createdOn;
    }

    public LocalDateTime getUpdatedOn() {
        return updatedOn;
    }

    public void setUpdatedOn(LocalDateTime updatedOn) {
        this.updatedOn = updatedOn;
    }
}
