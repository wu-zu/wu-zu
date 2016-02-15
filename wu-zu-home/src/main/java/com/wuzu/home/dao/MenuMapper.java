package com.wuzu.home.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.wuzu.home.vo.Menu;

/**
 * @author Gahngha Ryu
 */
@Repository
public interface MenuMapper {

    List<Menu> selectAllMenus();
}