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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * Created by zhou_wb on 2017/5/16.
 */
@Controller
public class AdminController {

    @Autowired
    AdminService adminService;

    @GetMapping(value = "/adminListPage")
    public String adminListPage(Model model){
        List<Admin> admins = adminService.getAll();
        Integer size = 0;
        if (admins.size()>0){
            size = admins.size();
        }
        model.addAttribute("size",size);
        model.addAttribute("admins",admins);
        return "component/admin-list";
    }

    @GetMapping("/getAdminList")
    @ResponseBody
    public List<Admin> adminList(Model model){
        return null;
    }

    @GetMapping("/addAdmin")
    public String addAdminPage(Model model){
        return "component/admin-add";
    }

    @PostMapping("/addAdmin")
    @ResponseBody
    public HttpStatus addAdmin(@RequestBody Admin admin) throws JsonProcessingException {
        String account = (String)SecurityUtils.getSubject().getPrincipal();
        HttpStatus httpStatus = adminService.add(account, admin);
        return httpStatus;
    }


}
