package com.cv.web.be.cvweb.controller;

import com.cv.web.be.cvweb.entity.Admin;
import com.cv.web.be.cvweb.service.AdminService;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.apache.shiro.SecurityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * Created by zhou_wb on 2017/5/16.
 */
@Controller
public class FeedBackController {

    @Autowired
    AdminService adminService;

    @GetMapping("/feedBackList")
    public String  adminList(Model model){
        return "component/feedback-list";
    }



}
