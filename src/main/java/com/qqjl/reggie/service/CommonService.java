package com.qqjl.reggie.service;

import com.qqjl.reggie.common.R;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;

/**
 * @author QQJL
 * @since 2022/4/22 18:58
 */
public interface CommonService {
    R<String> upload(MultipartFile file);

    void download(String name, HttpServletResponse response);
}
