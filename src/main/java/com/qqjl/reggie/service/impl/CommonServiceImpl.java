package com.qqjl.reggie.service.impl;

import com.qqjl.reggie.common.R;
import com.qqjl.reggie.service.CommonService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.UUID;

/**
 * @author QQJL
 * @since 2022/4/22 18:58
 */
@Service
public class CommonServiceImpl implements CommonService {

    @Value("${reggie.path}")
    private String basePath;

    @Override
    public R<String> upload(MultipartFile file) {
        // 原始文件名
        String originalFilename = file.getOriginalFilename();
        String suffix = originalFilename.substring(originalFilename.lastIndexOf("."));

        // 使用UUID重新生成文件名，防止文件名重复
        String fileName = UUID.randomUUID().toString() + suffix;

        // 创建一个目录对象
        File dir = new File(basePath);
        // 判断目录是否存在
        if (!dir.exists()) {
            // 目录不存在则创建
            dir.mkdirs();
        }

        try {
            file.transferTo(new File(basePath + fileName));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return R.success(fileName);
    }

    @Override
    public void download(String name, HttpServletResponse response) {
        try {
            // 输入流，读取文件内容
            FileInputStream inputStream = new FileInputStream(new File(basePath + name));
            // 输出流，写回浏览器
            ServletOutputStream outputStream = response.getOutputStream();
            response.setContentType("image/jpeg");
            int len = 0;
            byte[] bytes = new byte[1024];
            while ((len = inputStream.read(bytes)) != -1) {
                outputStream.write(bytes, 0, len);
                outputStream.flush();
            }
            inputStream.close();
            outputStream.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
