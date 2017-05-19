package com.cv.web.be.cvweb.service;


import com.cv.web.be.cvweb.entity.CV;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.http.HttpStatus;

import java.awt.print.Pageable;
import java.util.List;

/**
 * Created by zhou_wb on 2017/5/18.
 */
public interface CVService {
    /**
     * 添加简历模板
     */
    HttpStatus add(Integer adminId,CV cv) throws JsonProcessingException;

    /**
     * 删除简历模板
     */
    CV delete(CV cv);

    /**
     * 获取总的简历模板
     */
    List<CV> findAll();

    /**
     * 更新简历模板
     */
    CV update(CV cv);

    /**
     * 根据id获取简历模板
     */
    CV getOne(Integer id);
}
