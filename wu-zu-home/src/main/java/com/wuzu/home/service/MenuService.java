package com.wuzu.home.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wuzu.home.dao.MenuMapper;
import com.wuzu.web.ui.menu.vo.Menu;

/**
 * @author Gahngha Ryu
 */
@Service
public class MenuService {

    @Autowired
    private MenuMapper menuMapper;

    public List<Menu> selectAllMenus() {
        
        return menuMapper.selectAllMenus();
    }
}