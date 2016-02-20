package com.wuzu.home.repository;

import com.wuzu.home.domain.Menu;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QueryDslPredicateExecutor;
import org.springframework.stereotype.Repository;


/**
 * @author Hyungchae Kim
 */
@Repository
public interface MenuRepository extends JpaRepository<Menu, Integer>,QueryDslPredicateExecutor {
}
