package com.cv.web.be.cvweb.controller;

import com.cv.web.be.cvweb.entity.CV;
import com.cv.web.be.cvweb.service.CVService;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.shiro.SecurityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by zhou_wb on 2017/5/17.
 */
@Controller
public class CVController {

    @Autowired
    CVService cvService;


    @GetMapping(value = "/cv")
    public String login(Model model){
        return "component/cv";
    }

    @GetMapping(value = "/cv/cvpre1")
    public String cvpre(Model model){

        Map map =(Map) SecurityUtils.getSubject().getSession().getAttribute("map");
        model.addAttribute("map",map);
        return "component/cvpre";
    }

    @GetMapping(value = "/cv/cvpre2")
    public String cvpre2(Model model) throws IOException {

        CV cv = cvService.getOne(5);
        Map<String,Object> map = new HashMap<>();
        ObjectMapper mapper = new ObjectMapper();
        if (cv.getBasicInfo() != null){
            Map m2 = mapper.readValue(cv.getBasicInfo(), Map.class);
            map.putAll(m2);
        }
        if (cv.getCvItrams() != null){
            Map m2 = mapper.readValue(cv.getCvItrams(),Map.class);
            map.putAll(m2);
        }
        if (cv.getAddQuiz() != null){
            Map m2 = mapper.readValue(cv.getAddQuiz(),Map.class);
            map.putAll(m2);
        }

        SecurityUtils.getSubject().getSession().setAttribute("map",map);
        model.addAttribute("map",map);
        return "component/cvpre";
    }

    @GetMapping(value = "/cv-list")
    public String cvlist(Model model){
        List<CV> cvs = cvService.findAll();
        Integer size = 0;
        if (cvs.size() > 0){
            size = cvs.size();
            model.addAttribute("size",size);
        }

        model.addAttribute("cvs",cvs);
        return "component/cv-list";
    }

    @PostMapping(value = "/cv/add")
    //@RequiresPermissions(value = "add")
    @ResponseBody
    public HttpStatus cvAdd(@RequestBody CV cv,Model model) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        String name =(String) SecurityUtils.getSubject().getPrincipal();
        cv.setAdminName(name);
        return  cvService.add(5, cv);
    }

    @PostMapping(value = "/cv/cvpre")
    @ResponseBody
    public Map cvPre(@RequestBody CV cv, Model model) throws IOException {
        Map<String,Object> map = new HashMap<>();
        ObjectMapper mapper = new ObjectMapper();
        if (cv.getBasicInfo() != null){
            Map m2 = mapper.readValue(cv.getBasicInfo(), Map.class);
            map.putAll(m2);
        }
        if (cv.getCvItrams() != null){
            Map m2 = mapper.readValue(cv.getCvItrams(),Map.class);
            map.putAll(m2);
        }
        if (cv.getAddQuiz() != null){
            Map m2 = mapper.readValue(cv.getAddQuiz(),Map.class);
            map.putAll(m2);
        }

        SecurityUtils.getSubject().getSession().setAttribute("map",map);
        return map;
    }

    @GetMapping(value = "/cvs")
    @ResponseBody
    public List<CV> getList(Model model) throws IOException {
        return  null;
    }
}
