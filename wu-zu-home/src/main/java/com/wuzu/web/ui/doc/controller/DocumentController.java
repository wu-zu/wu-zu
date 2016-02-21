package com.wuzu.web.ui.doc.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.wuzu.web.ui.menu.domain.Menu;
import com.wuzu.web.ui.menu.service.MenuService;

import lombok.extern.slf4j.Slf4j;

/**
 * @author Gahngha Ryu
 */
@Slf4j
@Controller
@RequestMapping(path = "/energy")
public class DocumentController {
    
    @Autowired
    private MenuService menuService;
    
    @RequestMapping(path = "/documents", method = RequestMethod.GET)
    @ResponseBody
    public Menu documents() {
        
//        return menuService.findRoot();
        
        Menu menu = menuService.findById(1);
        
        List<Menu> menus = menuService.findAll();
        
        System.out.println(menus);
        
        return menu;
    }
}