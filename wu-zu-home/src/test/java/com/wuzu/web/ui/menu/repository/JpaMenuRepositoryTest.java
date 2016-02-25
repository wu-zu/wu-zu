package com.wuzu.web.ui.menu.repository;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.wuzu.home.annotation.DbTest;
import com.wuzu.web.ui.menu.domain.Menu;

/**
 * @author Gahngha Ryu
 */
@RunWith(SpringJUnit4ClassRunner.class)
@DbTest
public class JpaMenuRepositoryTest {
    
    @Autowired
    private MenuRepository menuRepository;
    
    private static final int ROOT_ID = 1;
    private static int COUNT_OF_MENUS;
    
    @Before
    public void setUp() {
        
        COUNT_OF_MENUS = (int) menuRepository.count();
    }
    
    
    // Select
    @Test
    public void count() {
        
        assertThat(menuRepository.count(), is(6L));
    }
    
    @Test
    public void findAll() {
        
        List<Menu> allMenus = menuRepository.findAll();
        
        assertThat(allMenus.size(), is(6));
        
        // TODO 모든 행에 대한 값 검증 필요 -> DbUnit 도입 필요
    }

    @Test
    public void getOne() {
        
        Menu rootMenu = menuRepository.getOne(ROOT_ID);
        
        assertRootMenu(rootMenu);
    }
    
    @Test
    public void exists() {

        assertTrue( menuRepository.exists(ROOT_ID) );
    }
    
    
    // Insert
    @Test
    public void saveForInsert() {
        
        Menu oneMenu = new Menu();
        oneMenu.setName("추후 생길 메뉴");
        oneMenu.setType(Menu.Type.LEAF);
        oneMenu.setParentId(ROOT_ID);
        oneMenu.setDepth(1);
        oneMenu.setOrderInDepth(COUNT_OF_MENUS + 1);
        oneMenu.setUri("somewhere");
        
        menuRepository.save(oneMenu);
        
        List<Menu> allMenus = menuRepository.findAll();
        assertThat(allMenus.size(), is(COUNT_OF_MENUS + 1));
        
        assertRootMenu(allMenus.get(0));
        
        Menu oneMenuStored = allMenus.get(COUNT_OF_MENUS);
        assertThat(oneMenuStored.getId(), is(COUNT_OF_MENUS + 1));
        assertThat(oneMenuStored.getName(), is("추후 생길 메뉴"));
        assertThat(oneMenuStored.getType(), is(Menu.Type.LEAF));
        assertThat(oneMenuStored.getParentId(), is(ROOT_ID));
        assertThat(oneMenuStored.getDepth(), is(1));
        assertThat(oneMenuStored.getOrderInDepth(), is(COUNT_OF_MENUS + 1));
        assertThat(oneMenuStored.getUri(), is("somewhere"));
    }
    
    
    // Update
    @Test
    public void saveForUpdate() {
        
        Menu leafMenu = menuRepository.getOne(2);
        
        leafMenu.setName("지구");
        
        Menu leafMenuStored = menuRepository.getOne(2);
        assertThat(leafMenuStored.getId(), is(2));
        assertThat(leafMenuStored.getName(), is("지구"));
        assertThat(leafMenuStored.getType(), is(Menu.Type.LEAF));
        assertThat(leafMenuStored.getParentId(), is(ROOT_ID));
        assertThat(leafMenuStored.getDepth(), is(1));
        assertThat(leafMenuStored.getOrderInDepth(), is(1));
        assertThat(leafMenuStored.getUri(), is("wuzu"));
        
        Menu rootMenu = menuRepository.getOne(ROOT_ID);
        assertRootMenu(rootMenu);
        
        // TODO 모든 행에 대한 값 검증 필요 -> DbUnit 도입 필요
    }
    
    
    // Delete
    @Test
    public void deleteAll() {
        
        menuRepository.deleteAll();
        
        List<Menu> allMenus = menuRepository.findAll();

        assertTrue(allMenus.isEmpty());
    }
    
    @Test
    public void deleteById() {
        
        menuRepository.delete(ROOT_ID);
        
        List<Menu> allMenus = menuRepository.findAll();
        
        assertThat(allMenus.size(), is(COUNT_OF_MENUS - 1));
        
        // TODO 모든 행에 대한 값 검증 필요 -> DbUnit 도입 필요
    }
    
    @Test
    public void deleteByEntity() {
        
        Menu rootMenu = menuRepository.getOne(ROOT_ID);
        
        menuRepository.delete(rootMenu);
        
        List<Menu> allMenus = menuRepository.findAll();
        
        assertThat(allMenus.size(), is(COUNT_OF_MENUS - 1));
        
        // TODO 모든 행에 대한 값 검증 필요 -> DbUnit 도입 필요
    }
    
    
    // Utility
    private void assertRootMenu(Menu rootMenu) {
        
        assertThat(rootMenu.getId(), is(1));
        assertThat(rootMenu.getName(), is("Site's home"));
        assertThat(rootMenu.getType(), is(Menu.Type.ROOT));
        assertThat(rootMenu.getParentId(), is(0));
        assertThat(rootMenu.getDepth(), is(0));
        assertThat(rootMenu.getOrderInDepth(), is(1));
        assertThat(rootMenu.getUri(), is(""));
    }
}