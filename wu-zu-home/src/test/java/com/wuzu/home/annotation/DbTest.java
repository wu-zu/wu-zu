package com.wuzu.home.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author Hyungchae Kim
 */
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@ContextConfiguration("/com/wuzu/home/config/spring/context-home.xml")
@ActiveProfiles("local")
@Transactional
@Sql({"/com/wuzu/home/sql/hsql/schema.sql", "/com/wuzu/home/sql/hsql/init-data.sql"})
public @interface DbTest {}