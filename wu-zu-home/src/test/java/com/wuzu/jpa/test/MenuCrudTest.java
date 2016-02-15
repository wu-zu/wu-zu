package com.wuzu.jpa.test;

import com.wuzu.jpa.annotation.TransactionalDevTest;
import com.wuzu.jpa.domain.MenuVo;
import com.wuzu.jpa.domain.QMenuVo;
import com.wuzu.jpa.service.MenuCrudService;
import lombok.extern.slf4j.Slf4j;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.mysema.query.types.Predicate;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * @author Hyungchae Kim
 */
@Slf4j
@RunWith(SpringJUnit4ClassRunner.class)
@TransactionalDevTest
public class MenuCrudTest {

    @Autowired
    public MenuCrudService menuService;

    @Before
    public void setUp() {}

    @Test
    public void menuServiceIsNotNullTest() {
        assertThat(this.menuService).isNotNull();
    }

    @Test
    public void createTest() {
        MenuVo menuVo = new MenuVo();
        menuVo.setName("folder 3");
        menuVo.setOpened(true);

        MenuVo rtnMenuVo = this.menuService.create(menuVo);
        assertThat(rtnMenuVo.getName()).isEqualTo("folder 3");
        assertThat(rtnMenuVo.isOpened()).isEqualTo(true);

        assertThat(this.menuService.findAll()).isNotNull().hasSize(6);
    }

    @Test
    public void deleteTest() {
        MenuVo rtnMenuVo = this.menuService.delete(1);

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
        MenuVo rtnMenuVo = this.menuService.findById(2);

        assertThat(rtnMenuVo.getName()).isEqualTo("file 2");
        assertThat(rtnMenuVo.isOpened()).isEqualTo(true);
    }
    @Test
    public void updateTest() {
        MenuVo menuVo = new MenuVo();
        menuVo.setId(1);
        menuVo.setName("file 4");
        menuVo.setOpened(true);

        MenuVo rtnMenuVo = this.menuService.update(menuVo);

        assertThat(rtnMenuVo.getName()).isEqualTo("file 4");
        assertThat(rtnMenuVo.isOpened()).isEqualTo(true);
    }

    @Test
    public void findAllQueryDslTest() {
        QMenuVo qMenuVo = QMenuVo.menuVo;
        Predicate predicate = qMenuVo.isOpened.eq(false);
        Iterable<MenuVo> menuVos =  this.menuService.findAll(predicate);
        assertThat(menuVos).isNotNull().hasSize(3);
    }
}