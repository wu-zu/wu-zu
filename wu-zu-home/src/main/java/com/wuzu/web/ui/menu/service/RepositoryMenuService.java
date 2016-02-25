package com.wuzu.web.ui.menu.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mysema.query.types.OrderSpecifier;
import com.mysema.query.types.Predicate;
import com.wuzu.web.ui.menu.domain.Menu;
import com.wuzu.web.ui.menu.domain.QMenu;
import com.wuzu.web.ui.menu.repository.MenuRepository;

import lombok.extern.slf4j.Slf4j;

/**
 * @author Hyungchae Kim
 * @author Gahngha Ryu
 */
@Slf4j
@Service
public class RepositoryMenuService implements MenuService {
    
    private MenuRepository menuRepository;

    @Autowired
    public RepositoryMenuService(@Qualifier("menuRepository") MenuRepository repository) {
        this.menuRepository = repository;
    }

    @Transactional
    @Override
    public Menu create(Menu menu) {
        log.info("Creating a new menu entry by using information: {}", menu);
        Menu rtnMenu = this.menuRepository.save(menu);
        log.info("Creating a new menu entry : {}", rtnMenu);
        return rtnMenu;
    }

    @Transactional
    @Override
    public Menu delete(Integer id) {
        log.info("Deleting a menu entry with id: {}", id);
        Menu deleted = menuRepository.getOne(id);
        log.info("Found menu entry: {}", deleted);
        menuRepository.delete(deleted);
        log.info("Deleted menu entry: {}", deleted);
        return deleted;
    }

    @Transactional(readOnly = true)
    @Override
    public List<Menu> findAll() {
        log.info("Finding all menu entries.");
        List<Menu> MenuList = menuRepository.findAll();
        log.info("Found {} menu entries", MenuList.size());
        return MenuList;
    }

    @Transactional(readOnly = true)
    @Override
    public Iterable<Menu> findAll(Predicate predicate) {
        log.info("Finding all menu entries.");
        Iterable<Menu> Menu = menuRepository.findAll(predicate);
        log.info("Found {} menu entries", Menu.toString());
        return Menu;
    }

    @Transactional(readOnly = true)
    @Override
    public Menu findById(Integer id) {
        log.info("Finding menu entry by using id: {}", id);
        Menu Menu = menuRepository.getOne(id);
        log.info("Found menu entry: {}", Menu);
        return Menu;
    }

    @Transactional
    @Override
    public Menu update(Menu menu) {
        log.info("Updating the information of a menu entry by using information: {}", menu);
        Menu updated = menuRepository.getOne(menu.getId());
        updated.setName(menu.getName());
        updated.setOpened(menu.isOpened());
        menuRepository.flush();
        log.info("Updated the information of the menu entry: {}", updated);
        return updated;
    }
    
    @Override
    public Menu findRoot() {
        
        QMenu qMenu = QMenu.menu;
        Predicate predicate = qMenu.type.stringValue().eq("R");
        
        Menu menu = (Menu) menuRepository.findOne(predicate);
        log.debug("menu id : {}", menu.getId());
        
        return menu;
    }

    @Override
    public List<Menu> getMenus(int fromDepth, int toDepth) {
        
        QMenu qMenu = QMenu.menu;
        
        Predicate predicate = qMenu.depth.between(fromDepth, toDepth);
        OrderSpecifier<Integer> orderSpecifier = qMenu.orderInDepth.asc();
        
        return (List<Menu>) menuRepository.findAll(predicate, orderSpecifier);
    }
}