package com.cv.web.be.cvweb.controller;

import com.cv.web.be.cvweb.entity.Admin;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * Created by zhou_wb on 2017/5/19.
 */
@Controller
public class ADController {

    @GetMapping("/bannerList")
    public String  adminList(Model model){
        return "component/banner-list";
    }
}
