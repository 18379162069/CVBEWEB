package com.cv.web.be.cvweb.service.impl;

import com.cv.web.be.cvweb.config.YmlConfig;
import com.cv.web.be.cvweb.dto.AdminLoginDTO;
import com.cv.web.be.cvweb.entity.Admin;
import com.cv.web.be.cvweb.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

/**
 * Created by zhou_wb on 2017/5/15.
 */
@Service("adminService")
public class AdminServiceImpl implements AdminService{

    private RestTemplate restTemplate = new RestTemplate();
    @Autowired
    private YmlConfig ymlConfig;
    @Override
    public Admin findLoginDtoByAccount(String account) {
        HttpHeaders httpHeaders = new HttpHeaders();
        HttpEntity httpEntity = new HttpEntity(null,httpHeaders);
        String url = ymlConfig.getUrl_api_cvbe() + "/adminUser/id?account=" + account;
        ResponseEntity<Admin> responseEntity = restTemplate.exchange(url, HttpMethod.GET,httpEntity,Admin.class);
        return responseEntity.getBody();
    }
}
