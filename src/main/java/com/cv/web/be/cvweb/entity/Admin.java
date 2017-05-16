package com.cv.web.be.cvweb.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.hibernate.validator.constraints.NotEmpty;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;

/**
 * Created by zhou_wb on 2017/5/13.
 */

public class Admin implements Serializable{

    private Integer id;          //管理员Id

    @NotEmpty(message = "管理员正式姓名不能为空")
    private String realName;     //管理员正式姓名

    private String department;   //部门

    private String email;        //管理员邮箱

    private String mobile;       //管理员手机号

    private String pwd;           //管理员密码

    private String salt;          //盐

    private boolean isLocked;      //账号是否锁定

    @JsonFormat(pattern = "yyyyMMddHHmmss")
    private LocalDateTime createdOn;  //创建时间

    @JsonFormat(pattern = "yyyyMMddHHmmss")
    private LocalDateTime updatedOn;  //更新时间

    private List<AdminRole> adminRoles;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getRealName() {
        return realName;
    }

    public void setRealName(String realName) {
        this.realName = realName;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
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

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    public String getSalt() {
        return salt;
    }

    public void setSalt(String salt) {
        this.salt = salt;
    }

    public boolean isLocked() {
        return isLocked;
    }

    public void setIsLocked(boolean isLocked) {
        this.isLocked = isLocked;
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

    public List<AdminRole> getAdminRoles() {
        return adminRoles;
    }

    public void setAdminRoles(List<AdminRole> adminRoles) {
        this.adminRoles = adminRoles;
    }

    public String getAccount(){
        if (this.email != null){
            return this.email;
        }

        if (this.mobile != null) {
            return this.mobile;
        }
        return null;
    }

}
