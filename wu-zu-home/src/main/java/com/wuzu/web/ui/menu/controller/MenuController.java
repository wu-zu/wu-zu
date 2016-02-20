package com.wuzu.web.ui.menu.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author Gahngha Ryu
 */
@Controller
public class MenuController {

    @RequestMapping("/{level1}")
    public void menu(@PathVariable String level1) {

//        return level1;
    }
}