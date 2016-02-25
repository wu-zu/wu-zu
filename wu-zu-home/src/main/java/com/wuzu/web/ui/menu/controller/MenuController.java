package com.wuzu.web.ui.menu.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.wuzu.web.ui.menu.domain.Menu;
import com.wuzu.web.ui.menu.service.MenuService;

import lombok.extern.slf4j.Slf4j;

/**
 * @author Gahngha Ryu
 */
@Slf4j
@Controller
public class MenuController {
    
    @Autowired
    private MenuService menuService;
    
    
    @RequestMapping(path = "/", method = RequestMethod.GET)
    public String index(Model model) {
        
        List<Menu> allMenus = menuService.findAll();
        log.debug("allMenus : {}" + allMenus);
        
        List<Menu> menus = menuService.getMenus(1, 1);
        log.debug("menus : {}" + menus);
        
        model.addAttribute("menus", menus);
        
        return "index";
    }
    
    @RequestMapping(path = "/{depth1}", method = RequestMethod.GET)
    public void menuOfDepth1(@PathVariable String depth1) {}
    
    @RequestMapping(path = "/menus/depth1", method = RequestMethod.GET)
    public List<Menu> menusOfDepth1() {
        
        return menuService.getMenus(1, 1);
    }
}