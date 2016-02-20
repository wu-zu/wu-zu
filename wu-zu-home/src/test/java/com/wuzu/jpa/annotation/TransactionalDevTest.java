package com.wuzu.jpa.annotation;

import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.transaction.annotation.Transactional;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @author Hyungchae Kim
 */
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@ContextConfiguration("/com/wuzu/spring/config/context-dev.xml")
@ActiveProfiles("dev")
@Transactional
@Sql({"/com/wuzu/jpa/sql/create-db.sql","/com/wuzu/jpa/sql/insert-data.sql"})
public @interface TransactionalDevTest {}