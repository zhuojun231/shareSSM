package com.yu.controller;

import com.google.gson.Gson;
import com.yu.model.CSKDemoData;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * @ClassName CSKTest
 * @Description TODO
 * @Author yuzhuojun
 * Date 2020/9/27 16:37
 *  穿梭框后台传递json数据 前台ajax接收
 */
@Controller
@RequestMapping("/test")
public class CSKTestController {
    @RequestMapping("/cskTest")
    @ResponseBody
    public String testCSK(){
        List<CSKDemoData> cskList = new ArrayList<>();
        for(int i=0;i<15;i++){
            CSKDemoData cskBean = new CSKDemoData();
            Random rand = new Random();
            int randNum = rand.nextInt(100);
            cskBean.setFlag(false);
            cskBean.setImportUnitId(i+randNum+"");
            cskBean.setImportUnitName("测试"+i);
            cskList.add(cskBean);
        }
        System.out.println(cskList.size());
        Gson gson = new Gson();
        String jsonStr = gson.toJson(cskList);
        return jsonStr;
    }
}
