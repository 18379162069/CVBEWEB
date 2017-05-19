package com.cv.web.be.cvweb.service.impl;

import com.cv.web.be.cvweb.config.YmlConfig;
import com.cv.web.be.cvweb.entity.Admin;
import com.cv.web.be.cvweb.entity.CV;
import com.cv.web.be.cvweb.service.CVService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.awt.print.Pageable;
import java.util.List;

/**
 * Created by zhou_wb on 2017/5/18.
 */
@Service("cvService")
public class CVServiceImpl implements CVService {
    private RestTemplate restTemplate = new RestTemplate();
    @Autowired
    private YmlConfig ymlConfig;
    @Override
    public HttpStatus add(Integer adminId, CV cv) throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();
        HttpHeaders httpHeaders = new HttpHeaders();
        String jsonString = mapper.writeValueAsString(cv);
        MediaType type = MediaType.parseMediaType("application/json; charset=UTF-8");
        httpHeaders.setContentType(type);
        httpHeaders.add("Accept", MediaType.APPLICATION_JSON.toString());
        HttpEntity<String> formEntity = new HttpEntity<String>(jsonString, httpHeaders);
        String url = ymlConfig.getUrl_api_cvbe() + "/cv";
        ResponseEntity<HttpStatus> responseEntity = restTemplate.exchange(url, HttpMethod.POST,formEntity,HttpStatus.class);
        return null;
    }

    @Override
    public CV delete(CV cv) {
        return null;
    }

    @Override
    public List<CV> findAll() {
        HttpHeaders httpHeaders = new HttpHeaders();
        HttpEntity httpEntity = new HttpEntity(null,httpHeaders);
        String url = ymlConfig.getUrl_api_cvbe() + "/cvs";
        ResponseEntity<List> responseEntity = restTemplate.exchange(url, HttpMethod.GET,httpEntity,List.class);
        return responseEntity.getBody();
    }

    @Override
    public CV update(CV cv) {
        return null;
    }

    @Override
    public CV getOne(Integer id) {
        HttpHeaders httpHeaders = new HttpHeaders();
        HttpEntity httpEntity = new HttpEntity(null,httpHeaders);
        String url = ymlConfig.getUrl_api_cvbe() + "/cvs/"+id;
        ResponseEntity<CV> responseEntity = restTemplate.exchange(url, HttpMethod.GET,httpEntity,CV.class);
        return responseEntity.getBody();
    }
}
