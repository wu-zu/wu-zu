package com.wuzu.jpa.service;

import com.wuzu.jpa.domain.MenuVo;

import java.util.List;
import com.mysema.query.types.Predicate;
import com.wuzu.jpa.domain.QMenuVo;

/**
 * @author Hyungchae Kim
 */
public interface MenuCrudService {

    MenuVo create(MenuVo menuVo);

    MenuVo delete(Integer id);

    List<MenuVo> findAll();

    Iterable<MenuVo> findAll(Predicate predicate);

    MenuVo findById(Integer id);

    MenuVo update(MenuVo menuVo);

}
