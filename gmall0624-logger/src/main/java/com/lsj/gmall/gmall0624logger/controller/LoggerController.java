package com.lsj.gmall.gmall0624logger.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;



@RestController  //如果不加Rest则会报404    会把success当成网页
@Slf4j
public class LoggerController {
    @PostMapping("log")

    public String log(@RequestParam("logString") String logString){
        System.out.println(logString);
        //TODO  补时间戳
        JSONObject jsonObject = JSON.parseObject(logString);
        jsonObject.put("ts",System.currentTimeMillis());
        //TODO 落盘日志文件
        String jsonString = jsonObject.toJSONString();
        log.info(jsonString);
        //TODO 发送kafka

            return "success";
    }
}
