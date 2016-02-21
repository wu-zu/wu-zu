package com.wuzu.jpa.test;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.mysema.query.types.Predicate;
import com.wuzu.jpa.annotation.TransactionalDevTest;
import com.wuzu.web.ui.menu.domain.Menu;
import com.wuzu.web.ui.menu.domain.QMenu;
import com.wuzu.web.ui.menu.service.MenuService;

import lombok.extern.slf4j.Slf4j;

/**
 * @author Hyungchae Kim
 */
@Slf4j
@RunWith(SpringJUnit4ClassRunner.class)
@TransactionalDevTest
public class MenuCrudTest {

    @Autowired
    public MenuService menuService;

    @Before
    public void setUp() {}

    @Test
    public void menuServiceIsNotNullTest() {
        assertThat(this.menuService).isNotNull();
    }

    @Test
    public void createTest() {
        Menu menuVo = new Menu();
        menuVo.setName("folder 3");
        menuVo.setOpened(true);

        Menu rtnMenuVo = this.menuService.create(menuVo);
        assertThat(rtnMenuVo.getName()).isEqualTo("folder 3");
        assertThat(rtnMenuVo.isOpened()).isEqualTo(true);

        assertThat(this.menuService.findAll()).isNotNull().hasSize(6);
    }

    @Test
    public void deleteTest() {
        Menu rtnMenuVo = this.menuService.delete(1);

        assertThat(rtnMenuVo.getName()).isEqualTo("file 1");
        assertThat(rtnMenuVo.isOpened()).isEqualTo(false);

        assertThat(this.menuService.findAll()).isNotNull().hasSize(4);
    }

    @Test
    public void findAllTest() {
        assertThat(this.menuService.findAll()).isNotNull().hasSize(5);
    }

    @Test
    public void findByIdTest() {
        Menu rtnMenuVo = this.menuService.findById(2);

        assertThat(rtnMenuVo.getName()).isEqualTo("file 2");
        assertThat(rtnMenuVo.isOpened()).isEqualTo(true);
    }
    @Test
    public void updateTest() {
        Menu menuVo = new Menu();
        menuVo.setId(1);
        menuVo.setName("file 4");
        menuVo.setOpened(true);

        Menu rtnMenuVo = this.menuService.update(menuVo);

        assertThat(rtnMenuVo.getName()).isEqualTo("file 4");
        assertThat(rtnMenuVo.isOpened()).isEqualTo(true);
    }

    @Test
    public void findAllQueryDslTest() {
        QMenu qMenu = QMenu.menu;
        Predicate predicate = qMenu.isOpened.eq(false);
        Iterable<Menu> menuVos =  this.menuService.findAll(predicate);
        assertThat(menuVos).isNotNull().hasSize(3);
    }
}