package com.cv.web.be.cvweb.service;

import com.cv.web.be.cvweb.dto.AdminLoginDTO;
import com.cv.web.be.cvweb.entity.Admin;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.http.HttpStatus;

import java.util.List;

/**
 * Created by zhou_wb on 2017/5/15.
 */
public interface AdminService {

    /**
     *根据管理员账号获取管理员信息
     * @author zhou_wb
     * @version 1.0
     * @date 2017年5月15日
     */
    Admin findLoginDtoByAccount(String account);

    /**
     * 添加管理员
     */
    HttpStatus add(String adminUser,Admin admin) throws JsonProcessingException;

    /**
     * 添加角色
     */
    Admin addRole(String adminUser,Admin admin);

    /**
     * 获取所有管理员信息
     */
    List<Admin> getAll();
}
