package com.wuzu.jpa.repository;

import com.wuzu.jpa.domain.MenuVo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QueryDslPredicateExecutor;
import org.springframework.stereotype.Repository;

/**
 * @author Hyungchae Kim
 */
@Repository
public interface MenuRepository  extends JpaRepository<MenuVo, Integer>,QueryDslPredicateExecutor {
}
