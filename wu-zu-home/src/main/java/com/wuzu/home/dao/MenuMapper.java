package com.wuzu.home.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.wuzu.web.ui.menu.vo.Menu;

/**
 * @author Gahngha Ryu
 */
@Repository
public interface MenuMapper {

    List<Menu> selectAllMenus();
}