package com.ym.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;

@Controller
public class HelloController {
   private final static Logger logger = LoggerFactory.getLogger(HelloController.class);
    @ResponseBody
    @RequestMapping("/hello")
    public Map<String,Object> hello(@RequestParam("name") String name){
        logger.info("访问/hello");
        System.out.println("name:"+name);
        Map<String,Object> map = new HashMap<String, Object>();
        map.put("name",name);
        return map;
    }
}
