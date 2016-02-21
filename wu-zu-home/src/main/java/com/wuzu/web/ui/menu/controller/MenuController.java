package com.wuzu.web.ui.menu.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @author Gahngha Ryu
 */
@Controller
public class MenuController {
    
    @RequestMapping(path = "/", method = RequestMethod.GET)
    public String index() {
        
        return "index";
    }
    
    @RequestMapping(path = "/{level1}", method = RequestMethod.GET)
    public void menu(@PathVariable String level1) {}
}