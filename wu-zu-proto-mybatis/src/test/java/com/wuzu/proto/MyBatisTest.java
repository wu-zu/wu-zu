package com.wuzu.proto;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.not;
import static org.hamcrest.CoreMatchers.nullValue;
import static org.junit.Assert.assertThat;

import org.apache.ibatis.session.SqlSession;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * @author Gahngha Ryu
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("/com/wuzu/proto/config/spring/applicationContext.xml")
public class MyBatisTest {
    
    @Autowired
    private SqlSession sqlSession;
    
    @Ignore // TODO 류강하 : 메모리 디비로 변경할 것!
    @Test
    public void connection() {

        assertThat(sqlSession.getConnection(), is(not(nullValue())));
    }
}