package com.cv.web.be.cvweb.entity;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.time.LocalDateTime;
import java.util.Objects;

/**
 * Created by zhou_wb on 2017/5/14.
 */
public class CV {

    private Integer id;

    private Integer userId;                     //创建人用户Id

    private String adminName;                    //

    private String basicInfo;                  //基本信息

    private String cvItrams;                    //简历信息

    private String addQuiz;                     //附加信息
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

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getBasicInfo() {
        return basicInfo;
    }

    public void setBasicInfo(String basicInfo) {
        this.basicInfo = basicInfo;
    }

    public String getCvItrams() {
        return cvItrams;
    }

    public void setCvItrams(String cvItrams) {
        this.cvItrams = cvItrams;
    }

    public String getAddQuiz() {
        return addQuiz;
    }

    public void setAddQuiz(String addQuiz) {
        this.addQuiz = addQuiz;
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

    public String getAdminName() {
        return adminName;
    }

    public void setAdminName(String adminName) {
        this.adminName = adminName;
    }
}
