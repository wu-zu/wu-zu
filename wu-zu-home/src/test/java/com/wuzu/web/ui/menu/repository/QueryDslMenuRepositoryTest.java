package com.wuzu.web.ui.menu.repository;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.mysema.query.types.OrderSpecifier;
import com.mysema.query.types.Predicate;
import com.wuzu.home.annotation.DbTest;
import com.wuzu.web.ui.menu.domain.Menu;
import com.wuzu.web.ui.menu.domain.QMenu;

/**
 * @author Gahngha Ryu
 */
@RunWith(SpringJUnit4ClassRunner.class)
@DbTest
public class QueryDslMenuRepositoryTest {

    @Autowired
    private MenuRepository menuRepository;
    
    @Test
    public void whereAndOrder() {
        
        final int fromDepth = 1;
        final int toDepth = 1;
        
        QMenu qMenu = QMenu.menu;
        
        Predicate predicate = qMenu.depth.between(fromDepth, toDepth);
        OrderSpecifier<Integer> orderSpecifier = qMenu.orderInDepth.asc();
        
        List<Menu> menus = (List<Menu>) menuRepository.findAll(predicate, orderSpecifier);
        
        assertThat(menus.size(), is(5));
        
        // TODO 모든 행에 대한 값 검증 필요 -> DbUnit 도입 필요
    }
}