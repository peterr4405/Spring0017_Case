package com.web.sales.dao;

import com.web.sales.models.ProductCode;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class ProductCodeRepository implements CrudRepository<ProductCode, String>{

    @Autowired
    private JdbcTemplate jdbcTemplate;
    
    @Override
    public void save(ProductCode entity) {
        String sql = "insert into product_code(prod_code,discount_code,description) values(?,?,?)";
            jdbcTemplate.update(sql, entity.getProdCode(),entity.getDiscountCode(),entity.getDescription());
    }

    @Override
    public Optional<ProductCode> findById(String id) {
        String sql = "select * from product_code where prod_code = ?";
        ProductCode productCode = jdbcTemplate.queryForObject(sql, new Object[]{id},new BeanPropertyRowMapper<ProductCode>(ProductCode.class));
        return Optional.of(productCode);
    }

    @Override
    public boolean existsById(String id) {
        return findById(id).isPresent();
    }

    @Override
    public Iterable<ProductCode> findAll() {
        String sql = "select * from product_code";
        List list = jdbcTemplate.query(sql, new BeanPropertyRowMapper<ProductCode>(ProductCode.class));
        return list;
    }

    @Override
    public void deleteById(String id) {
        String sql = "delete from product_code where prod_code = ?";
        jdbcTemplate.update(sql,id);
        
    }

    @Override
    public void update(ProductCode entity) {
        String sql = "update product_code set discount_code = ?, description = ? where prod_code = ?";
        jdbcTemplate.update(sql,entity.getDiscountCode(),entity.getDescription(),entity.getProdCode());
        
    }
    
}
