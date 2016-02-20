package com.wuzu.proto;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.not;
import static org.hamcrest.CoreMatchers.nullValue;
import static org.junit.Assert.assertThat;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.wuzu.proto.dao.MenuMapper;
import com.wuzu.proto.vo.Menu;

/**
 * @author Gahngha Ryu
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("/com/wuzu/proto/config/spring/context-proto.xml")
public class MyBatisTest {
    
    @Autowired
    private SqlSession sqlSession;
    
    @Autowired
    private MenuMapper menuMapper;
    
    @Test
    public void connection() {

        assertThat(sqlSession.getConnection(), is(not(nullValue())));
    }
    
    @Test
    public void countMenus() {
        
        List<Menu> menus = menuMapper.selectAllMenus();

        assertThat(menus.size(), is(5));
    }
}