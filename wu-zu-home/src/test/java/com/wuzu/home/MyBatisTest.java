package com.wuzu.home;

import java.util.List;

import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.wuzu.home.dao.MenuMapper;
import com.wuzu.home.vo.Menu;

/**
 * @author Gahngha Ryu
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/applicationContext.xml")
public class MyBatisTest {
    
    @Autowired
    private MenuMapper menuMapper;
    
    @Ignore
    @Test
    public void connection() {
        
        List<Menu> allMenus = menuMapper.selectAllMenus();
        
        for (Menu menuVo : allMenus) {
            
            System.out.println(menuVo);
        }
    }
}