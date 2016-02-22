package com.wuzu.proto.test;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.wuzu.proto.annotation.TransactionalDevTest;
import com.wuzu.web.ui.menu.domain.Menu;
import com.wuzu.web.ui.menu.service.MenuService;

/**
 * @author Hyungchae Kim
 */
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
        Menu menu = new Menu();
        menu.setName("folder 3");
        menu.setOpened(true);

        Menu rtnMenuVo = this.menuService.create(menu);
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
        Menu menu = new Menu();
        menu.setId(1);
        menu.setName("file 4");
        menu.setOpened(true);

        Menu rtnMenu = this.menuService.update(menu);

        assertThat(rtnMenu.getName()).isEqualTo("file 4");
        assertThat(rtnMenu.isOpened()).isEqualTo(true);
    }

//    @Test
//    public void findAllQueryDslTest() {
//        QMenu qMenu = QMenu.menu;
//        Predicate predicate = qMenu.isOpened.eq(false);
//        Iterable<Menu> menuVos =  this.menuService.findAll(predicate);
//        assertThat(menuVos).isNotNull().hasSize(3);
//    }
}