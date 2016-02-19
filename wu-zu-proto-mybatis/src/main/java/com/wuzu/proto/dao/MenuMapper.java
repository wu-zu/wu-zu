package com.wuzu.proto.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.wuzu.proto.vo.Menu;

/**
 * @author Gahngha Ryu
 */
@Repository
public interface MenuMapper {

    List<Menu> selectAllMenus();
}