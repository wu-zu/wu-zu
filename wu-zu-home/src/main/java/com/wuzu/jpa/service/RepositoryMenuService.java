package com.wuzu.jpa.service;

import com.wuzu.jpa.domain.MenuVo;
import com.wuzu.jpa.domain.QMenuVo;
import com.wuzu.jpa.repository.MenuRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import com.mysema.query.types.Predicate;

/**
 * @author Hyungchae Kim
 */
@Slf4j
@Service
public class RepositoryMenuService implements MenuCrudService {

    private MenuRepository repository;

    @Autowired
    public RepositoryMenuService(MenuRepository repository) {
        this.repository = repository;
    }

    @Transactional
    @Override
    public MenuVo create(MenuVo menuVo) {
        log.info("Creating a new menuVo entry by using information: {}", menuVo);
        MenuVo rtnMenuVo = this.repository.save(menuVo);
        log.info("Creating a new menuVo entry : {}", rtnMenuVo);
        return rtnMenuVo;
    }

    @Transactional
    @Override
    public MenuVo delete(Integer id) {
        log.info("Deleting a menuVo entry with id: {}", id);
        MenuVo deleted = repository.getOne(id);
        log.info("Found menuVo entry: {}", deleted);
        repository.delete(deleted);
        log.info("Deleted menuVo entry: {}", deleted);
        return deleted;
    }

    @Transactional(readOnly = true)
    @Override
    public List<MenuVo> findAll() {
        log.info("Finding all menuVo entries.");
        List<MenuVo> menuVoList = repository.findAll();
        log.info("Found {} menuVo entries", menuVoList.size());
        return menuVoList;
    }

    @Transactional(readOnly = true)
    @Override
    public Iterable<MenuVo> findAll(Predicate predicate) {
        log.info("Finding all menuVo entries.");
        Iterable<MenuVo> menuVo = repository.findAll(predicate);
        log.info("Found {} menuVo entries", menuVo.toString());
        return menuVo;
    }

    @Transactional(readOnly = true)
    @Override
    public MenuVo findById(Integer id) {
        log.info("Finding menuVo entry by using id: {}", id);
        MenuVo menuVo = repository.getOne(id);
        log.info("Found menuVo entry: {}", menuVo);
        return menuVo;
    }

    @Transactional
    @Override
    public MenuVo update(MenuVo menuVo) {
        log.info("Updating the information of a menuVo entry by using information: {}", menuVo);
        MenuVo updated = repository.getOne(menuVo.getId());
        updated.setName(menuVo.getName());
        updated.setOpened(menuVo.isOpened());
        repository.flush();
        log.info("Updated the information of the menuVo entry: {}", updated);
        return updated;
    }
}
