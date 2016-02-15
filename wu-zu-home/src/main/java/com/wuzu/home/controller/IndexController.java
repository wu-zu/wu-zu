package com.wuzu.home.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author Hyungchae Kim
 */
@Controller
public class IndexController {

    @RequestMapping("/")
    public String index() {
        
        return "index";
    }
}