package com.wuzu.web.ui.menu.service;

import java.util.List;

import com.mysema.query.types.Predicate;
import com.wuzu.web.ui.menu.domain.Menu;

/**
 * @author Hyungchae Kim
 * @author Gahngha Ryu
 */
public interface MenuService {

    Menu create(Menu menu);

    Menu delete(Integer id);

    List<Menu> findAll();

    Iterable<Menu> findAll(Predicate predicate);

    Menu findById(Integer id);

    Menu update(Menu menu);
    
    List<Menu> getMenus(int fromDepth, int toDepth);
    
    Menu findRoot();
}