package com.wuzu.home.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.wuzu.home.service.MenuService;
import com.wuzu.home.vo.Menu;

/**
 * @author Gahngha Ryu
 */
@Controller
@RequestMapping("/energy")
public class DocumentController {
    
    @Autowired
    private MenuService menuService;
    
    @RequestMapping(path = "/menu", method = RequestMethod.GET)
    @ResponseBody
    public List<Menu> allMenus() {
        
        return menuService.selectAllMenus();
    }
    
//    @ExceptionHandler
//    public ModelAndView handleException(Exception e) {
//        
//        e.printStackTrace();
//        
//        return null;
//    }
}