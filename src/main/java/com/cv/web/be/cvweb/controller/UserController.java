package com.cv.web.be.cvweb.controller;

import com.cv.web.be.cvweb.entity.User;
import com.cv.web.be.cvweb.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

/**
 * Created by zhou_wb on 2017/5/19.
 */
@Controller
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping(value = "/userList")
    public String adminListPage(Model model){
        List<User> users = userService.getUsers();
        Integer size = 0;
        if (users.size() >0){
            size =users.size();
        }
        model.addAttribute("size",size);
        model.addAttribute("users",users);
        return "component/user-list";
    }
}
