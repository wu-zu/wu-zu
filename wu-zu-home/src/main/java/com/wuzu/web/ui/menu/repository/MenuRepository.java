package com.wuzu.web.ui.menu.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QueryDslPredicateExecutor;
import org.springframework.stereotype.Repository;

import com.wuzu.web.ui.menu.domain.Menu;

/**
 * @author Hyungchae Kim
 */
@Repository
public interface MenuRepository extends JpaRepository<Menu, Integer>, QueryDslPredicateExecutor<Menu> {}