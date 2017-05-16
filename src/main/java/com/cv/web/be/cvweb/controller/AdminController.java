package com.cv.web.be.cvweb.controller;

import com.cv.web.be.cvweb.entity.Admin;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * Created by zhou_wb on 2017/5/16.
 */
@Controller
public class AdminController {



    @GetMapping(value = "/adminListPage")
    public String login(Model model){
        return "component/admin-list";
    }

    @GetMapping("/getAdminList")
    @ResponseBody
    public List<Admin> adminList(Model model){
        return null;
    }

}
