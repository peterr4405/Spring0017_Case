package com.web.sales.dao;

import com.web.sales.models.ReportCustomer;
import com.web.sales.models.ReportProduct;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class ReportRepository {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public Iterable<ReportCustomer> getCustomers() {
        String sql = "SELECT * FROM REPORT_CUSTOMER";
        List list = jdbcTemplate.query(sql, new BeanPropertyRowMapper<ReportCustomer>(ReportCustomer.class));
        return list;

    }

    public Iterable<ReportProduct> getProducts() {
        String sql = "SELECT * FROM REPORT_PRODUCT ";
        List list = jdbcTemplate.query(sql, new BeanPropertyRowMapper<ReportProduct>(ReportProduct.class));
        return list;

    }

    public Optional<ReportCustomer> C_findById(Integer id) {
        String sql = "select * from REPORT_CUSTOMER where customer_id = ?";
        ReportCustomer r_customer = jdbcTemplate.queryForObject(sql, new Object[]{id}, new BeanPropertyRowMapper<ReportCustomer>(ReportCustomer.class));
        return Optional.of(r_customer);
    }

    public Optional<ReportProduct> P_findById(Integer id) {
        String sql = "SELECT * FROM REPORT_PRODUCT where product_id = ?";
        ReportProduct r_product = jdbcTemplate.queryForObject(sql, new Object[]{id}, new BeanPropertyRowMapper<ReportProduct>(ReportProduct.class));
        return Optional.of(r_product);
    }

    public boolean C_existsById(Integer id) {
        return C_findById(id).isPresent();
    }

    public boolean P_existsById(Integer id) {
        return P_findById(id).isPresent();
    }

}
