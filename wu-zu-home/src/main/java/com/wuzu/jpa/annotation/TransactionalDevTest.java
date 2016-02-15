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
@ContextConfiguration("/applicationContext-dev.xml")
@ActiveProfiles("dev")
@Transactional
@Sql({"/com/wuzu/jpa/script/create-db.sql","/com/wuzu/jpa/script/insert-data.sql"})
public @interface TransactionalDevTest {}
