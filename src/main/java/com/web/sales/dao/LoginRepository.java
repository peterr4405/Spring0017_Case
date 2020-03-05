package com.web.sales.dao;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class LoginRepository {

    private JdbcTemplate jdbcTemplate;

    public boolean login(String name, String pass) {

        String sql = "select count(*) from user where name=? and password=?";
        int size = jdbcTemplate.queryForObject(sql, new Object[]{name, pass}, Integer.class);

        return size == 1;
    }

}
