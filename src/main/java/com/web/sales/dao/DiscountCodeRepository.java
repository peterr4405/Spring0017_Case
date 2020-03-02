package com.web.sales.dao;

import com.web.sales.models.DiscountCode;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class DiscountCodeRepository implements CrudRepository<DiscountCode, String>{

    @Autowired
    private JdbcTemplate jdbcTemplate;
    
    @Override
    public void save(DiscountCode entity) {
        String sql = "insert into discount_code(discount_code,rate) values(?,?)";
            jdbcTemplate.update(sql, entity.getDiscountCode(),entity.getRate());
    }

    @Override
    public Optional<DiscountCode> findById(String id) {
        String sql = "select * from discount_code where discount_code = ?";
        DiscountCode discountCode = jdbcTemplate.queryForObject(sql, new Object[]{id},new BeanPropertyRowMapper<DiscountCode>(DiscountCode.class));
        return Optional.of(discountCode);
    }

    @Override
    public boolean existsById(String id) {
        return findById(id).isPresent();
    }

    @Override
    public Iterable<DiscountCode> findAll() {
        String sql = "select * from discount_code";
        List list = jdbcTemplate.query(sql, new BeanPropertyRowMapper<DiscountCode>(DiscountCode.class));
        return list;
    }

    @Override
    public void deleteById(String id) {
        String sql = "delete from discount_code where discount_code = ?";
        jdbcTemplate.update(sql,id);
        
    }

    @Override
    public void update(DiscountCode entity) {
        String sql = "update discount_code set rate = ? where discount_code = ?";
        jdbcTemplate.update(sql,entity.getRate(),entity.getDiscountCode());
        
    }
    
}
