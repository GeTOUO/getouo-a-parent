package com.nh.demo;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author Getouo(梁圣贤) on 2023/5/15
 * @version 1.0
 */
@Controller
public class DefaultController {

    @ResponseBody
    @GetMapping("/")
    public String root() {
        return "nice index";
    }

    @ResponseBody
    @GetMapping("/index")
    public String index() {
        return "客户端8081的机器";
    }

    @ResponseBody
    @GetMapping("/index/next")
    public String indexNext() {
        return "客户端8081的机器另外一个接口";
    }
}

