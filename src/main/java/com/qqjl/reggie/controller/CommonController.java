package com.qqjl.reggie.controller;

import com.qqjl.reggie.common.R;
import com.qqjl.reggie.service.CommonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;

/**
 * 文件上传和下载
 *
 * @author QQJL
 * @since 2022/4/22 18:56
 */
@RestController
@RequestMapping("/common")
public class CommonController {

    @Autowired
    private CommonService commonService;

    @PostMapping("/upload")
    public R<String> upload(MultipartFile file) {
        return commonService.upload(file);
    }

    @GetMapping("/download")
    public void download(String name, HttpServletResponse response) {
        commonService.download(name, response);
    }
}
