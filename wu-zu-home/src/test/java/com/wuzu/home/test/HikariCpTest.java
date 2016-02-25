package com.wuzu.home.test;

import static org.assertj.core.api.Assertions.assertThat;

import javax.annotation.Resource;
import javax.sql.DataSource;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.wuzu.home.annotation.DbTest;

/**
 * @author Hyungchae Kim
 */
@RunWith(SpringJUnit4ClassRunner.class)
@DbTest
public class HikariCpTest {

    @Resource(name = "dataSource-hikari")
    private DataSource dataSource;
    
    private JdbcTemplate jdbcTemplate;

    @Before
    public void setUp() {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    @Test
    public void dataSourceIsNotNull() {
        assertThat(dataSource).isNotNull();
    }

    @Test
    public void jdbcTemplateIsNotNull() {
        assertThat(jdbcTemplate).isNotNull();
    }
}