package com.wuzu.web.ui.menu.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mysema.query.types.Predicate;
import com.wuzu.web.ui.menu.domain.Menu;
import com.wuzu.web.ui.menu.domain.QMenu;
import com.wuzu.web.ui.menu.repository.MenuRepository;

import lombok.extern.slf4j.Slf4j;

/**
 * @author Hyungchae Kim
 */
@Slf4j
@Service
public class RepositoryMenuService implements MenuService {

    private MenuRepository repository;

    @Autowired
    public RepositoryMenuService(@Qualifier("menuRepository") MenuRepository repository) {
        this.repository = repository;
    }

    @Transactional
    @Override
    public Menu create(Menu menu) {
        log.info("Creating a new menu entry by using information: {}", menu);
        Menu rtnMenu = this.repository.save(menu);
        log.info("Creating a new menu entry : {}", rtnMenu);
        return rtnMenu;
    }

    @Transactional
    @Override
    public Menu delete(Integer id) {
        log.info("Deleting a menu entry with id: {}", id);
        Menu deleted = repository.getOne(id);
        log.info("Found menu entry: {}", deleted);
        repository.delete(deleted);
        log.info("Deleted menu entry: {}", deleted);
        return deleted;
    }

    @Transactional(readOnly = true)
    @Override
    public List<Menu> findAll() {
        log.info("Finding all menu entries.");
        List<Menu> MenuList = repository.findAll();
        log.info("Found {} menu entries", MenuList.size());
        return MenuList;
    }

    @Transactional(readOnly = true)
    @Override
    public Iterable<Menu> findAll(Predicate predicate) {
        log.info("Finding all menu entries.");
        Iterable<Menu> Menu = repository.findAll(predicate);
        log.info("Found {} menu entries", Menu.toString());
        return Menu;
    }

    @Transactional(readOnly = true)
    @Override
    public Menu findById(Integer id) {
        log.info("Finding menu entry by using id: {}", id);
        Menu Menu = repository.getOne(id);
        log.info("Found menu entry: {}", Menu);
        return Menu;
    }

    @Transactional
    @Override
    public Menu update(Menu menu) {
        log.info("Updating the information of a menu entry by using information: {}", menu);
        Menu updated = repository.getOne(menu.getId());
        updated.setName(menu.getName());
        updated.setOpened(menu.isOpened());
        repository.flush();
        log.info("Updated the information of the menu entry: {}", updated);
        return updated;
    }
    
    @Override
    public Menu findRoot() {
        
        QMenu qMenu = QMenu.menu;
        Predicate predicate = qMenu.type.eq("R");
        
        Menu menu = (Menu) repository.findOne(predicate);
        log.debug("menu id : {}", menu.getId());
        
        return menu;
    }
}