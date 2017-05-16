package com.cv.web.be.cvweb.service;

import com.cv.web.be.cvweb.dto.AdminLoginDTO;
import com.cv.web.be.cvweb.entity.Admin;

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
}
