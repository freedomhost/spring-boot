package mmc.edu.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Arrays;
import java.util.Map;

@Controller
public class HelloController {

//    @RequestMapping({"/","/index.html"})
//    public String index(){
//        return "index";
//    }

    @RequestMapping("/peo")
    public String people(Map<String,Object> map){
        map.put("peo","<h1>你好，人类</h1>");
        map.put("users", Arrays.asList("a","b","c"));
        return "people";
    }
}
