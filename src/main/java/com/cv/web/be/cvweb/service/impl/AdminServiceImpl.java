package com.cv.web.be.cvweb.service.impl;

import com.cv.web.be.cvweb.config.YmlConfig;
import com.cv.web.be.cvweb.dto.AdminLoginDTO;
import com.cv.web.be.cvweb.entity.Admin;
import com.cv.web.be.cvweb.service.AdminService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.shiro.SecurityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

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

    @Override
    public HttpStatus add(String adminUser, Admin admin) throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();
        HttpHeaders httpHeaders = new HttpHeaders();
        String jsonString = mapper.writeValueAsString(admin);
        MediaType type = MediaType.parseMediaType("application/json; charset=UTF-8");
        httpHeaders.setContentType(type);
        httpHeaders.add("Accept", MediaType.APPLICATION_JSON.toString());
        HttpEntity<String> formEntity = new HttpEntity<String>(jsonString, httpHeaders);
        String url = ymlConfig.getUrl_api_cvbe() + "/adminUser/add?adminName=" + adminUser;
        ResponseEntity<HttpStatus> responseEntity = restTemplate.exchange(url, HttpMethod.POST,formEntity,HttpStatus.class);
        return responseEntity.getBody();
    }

    @Override
    public Admin addRole(String adminUser, Admin admin) {
        return null;
    }

    @Override
    public List<Admin> getAll() {
        String account =(String) SecurityUtils.getSubject().getPrincipal();
        HttpHeaders httpHeaders = new HttpHeaders();
        HttpEntity httpEntity = new HttpEntity(null,httpHeaders);
        String url = ymlConfig.getUrl_api_cvbe() + "/adminUser/admins?account=" + account;
        ResponseEntity<List> responseEntity = restTemplate.exchange(url, HttpMethod.GET,httpEntity,List.class);
        return responseEntity.getBody();
    }
}
