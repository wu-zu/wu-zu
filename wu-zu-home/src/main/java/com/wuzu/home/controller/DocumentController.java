package com.wuzu.home.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.wuzu.web.ui.menu.domain.Menu;

/**
 * @author Gahngha Ryu
 */
@Controller
@RequestMapping("/energy")
public class DocumentController {
    
    @RequestMapping(path = "/menu", method = RequestMethod.GET)
    @ResponseBody
    public List<Menu> allMenus() {
        
//        return menuService.selectAllMenus();
        return null;
    }
    
//    @ExceptionHandler
//    public ModelAndView handleException(Exception e) {
//        
//        e.printStackTrace();
//        
//        return null;
//    }
}