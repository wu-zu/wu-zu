package com.wuzu.web.ui.menu.service;

import com.mysema.query.types.Predicate;
import com.wuzu.home.domain.Menu;

import java.util.List;

/**
 * @author Hyungchae Kim
 */
public interface MenuCrudService {

    Menu create(Menu menu);

    Menu delete(Integer id);

    List<Menu> findAll();

    Iterable<Menu> findAll(Predicate predicate);

    Menu findById(Integer id);

    Menu update(Menu menu);
}