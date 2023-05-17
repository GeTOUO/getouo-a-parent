package com.nh.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @author Getouo(梁圣贤) on 2023/5/15
 * @version 1.0
 */
@Controller
public class DefaultController {

    @GetMapping("/")
    public String root() {
        return "redirect:/index";
    }

    @GetMapping("/index")
    public String index() {
        return "index";
    }
}

