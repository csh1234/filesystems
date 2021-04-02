package com.example.demo.controller;

import com.example.demo.enums.ResultEnums;
import com.example.demo.response.Response;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;

@Controller
@Slf4j
public class FileController {

    @Value("${upload.filePath}")
    private String filePath;

    @RequestMapping(value = "/upload")
    @ResponseBody
    public Response imports(@RequestParam("file") MultipartFile file) {

        Response response = new Response();
        if (file.isEmpty()) {
            log.warn("MultipartFile is null {}", "上传的文件为空");
            response.setFail(ResultEnums.EMPTY.getMsg(), null);
            return response;
        }
        // 获取文件名
        String fileName = file.getOriginalFilename();
        log.info("上传的文件名为： {}",fileName);
        File dest = new File(filePath + fileName);
        // 检测是否存在目录
        if (!dest.getParentFile().exists()) {
            dest.getParentFile().mkdirs();
        }
        try {
            file.transferTo(dest);
            response.setMsg(ResultEnums.SUCCESS.getMsg());
        } catch (IllegalStateException e) {
            log.error("IllegalStateException is : {}", e.getMessage());
            response.setFail(ResultEnums.FAIL.getMsg(), null);
            return response;
        } catch (IOException e) {
            log.error("IOException is : {}", e.getMessage());
            response.setFail(ResultEnums.FAIL.getMsg(), null);
            return response;
        }
        return response;
    }


    /**
     * 首页
     * @return
     */
    @GetMapping(value = "/index")
    public String index (){
        return "index";
    }
}
