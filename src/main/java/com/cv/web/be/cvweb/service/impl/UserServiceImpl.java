package com.cv.web.be.cvweb.service.impl;

import com.cv.web.be.cvweb.config.YmlConfig;
import com.cv.web.be.cvweb.entity.Admin;
import com.cv.web.be.cvweb.entity.User;
import com.cv.web.be.cvweb.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

/**
 * Created by zhou_wb on 2017/5/19.
 */
@Service("userService")
public class UserServiceImpl implements UserService{
    private RestTemplate restTemplate = new RestTemplate();
    @Autowired
    private YmlConfig ymlConfig;
    @Override
    public void delete(Integer userId) {


    }

    @Override
    public User locked(Integer userId, Boolean bool) {
        HttpHeaders httpHeaders = new HttpHeaders();
        HttpEntity httpEntity = new HttpEntity(null,httpHeaders);
        String url = ymlConfig.getUrl_api_cvbe() + "/users/{userId}/islocked?status=" + bool;
        ResponseEntity<User> responseEntity = restTemplate.exchange(url, HttpMethod.PUT,httpEntity,User.class);
        return responseEntity.getBody();
    }

    @Override
    public User modifyPwd(Integer userId, String pwd) {
        HttpHeaders httpHeaders = new HttpHeaders();
        HttpEntity httpEntity = new HttpEntity(null,httpHeaders);
        String url = ymlConfig.getUrl_api_cvbe() + "/users/{userId}/pwd?status=" + pwd;
        ResponseEntity<User> responseEntity = restTemplate.exchange(url, HttpMethod.PUT,httpEntity,User.class);
        return responseEntity.getBody();
    }

    @Override
    public List<User> getUsers() {
        HttpHeaders httpHeaders = new HttpHeaders();
        HttpEntity httpEntity = new HttpEntity(null,httpHeaders);
        String url = ymlConfig.getUrl_api_cvbe() + "/users";
        ResponseEntity<List> responseEntity = restTemplate.exchange(url, HttpMethod.GET,httpEntity,List.class);
        return responseEntity.getBody();
    }
}
