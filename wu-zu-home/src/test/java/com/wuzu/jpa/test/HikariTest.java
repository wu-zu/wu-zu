package com.wuzu.jpa.test;

import com.wuzu.jpa.annotation.TransactionalDevTest;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.jdbc.JdbcTestUtils;

import javax.annotation.Resource;
import javax.sql.DataSource;

import static org.assertj.core.api.Assertions.*;

/**
 * @author HyungChae Kim
 */
@RunWith(SpringJUnit4ClassRunner.class)
@TransactionalDevTest
public class HikariTest {

    private JdbcTemplate jdbcTemplate;

    @Resource(name = "hikariDataSource")
    private DataSource dataSource;

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

    @Test
    public void countRowsInMenuTable() {
        assertThat(JdbcTestUtils.countRowsInTable(this.jdbcTemplate, "MENU")).isNotNull().isEqualTo(5);
    }

}
