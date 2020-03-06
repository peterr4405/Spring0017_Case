package com.web.sales.dao;

import com.web.sales.models.Customer;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class CustomerRepository implements CrudRepository<Customer, Integer>{

    @Autowired
    private JdbcTemplate jdbcTemplate;
    
    @Override
    public void save(Customer entity) {
        String sql = "insert into customer(customer_id,discount_code ,zip, name,addressline1,addressline2, city,state,phone,fax, email, credit_limit) values(?,?,?,?,?,?,?,?,?,?,?,?)";
            jdbcTemplate.update(sql, entity.getCustomerId(),entity.getDiscountCode(),entity.getZip(),entity.getName(),entity.getAddressline1(),entity.getAddressline2(),entity.getCity(),entity.getState(),entity.getPhone(),entity.getFax(),entity.getEmail(),entity.getCreditLimit());
    }

    @Override
    public Optional<Customer> findById(Integer id) {
        String sql = "select * from customer where customer_id = ?";
        Customer customer = jdbcTemplate.queryForObject(sql, new Object[]{id},new BeanPropertyRowMapper<Customer>(Customer.class));
        return Optional.of(customer);
    }

    @Override
    public boolean existsById(Integer id) {
        return findById(id).isPresent();
    }

    @Override
    public Iterable<Customer> findAll() {
        String sql = "select * from customer";
        List list = jdbcTemplate.query(sql, new BeanPropertyRowMapper<Customer>(Customer.class));
        return list;
    }

    @Override
    public void deleteById(Integer id) {
        String sql = "delete from Customer where customer_id = ?";
        jdbcTemplate.update(sql,id);
        
    }

    @Override
    public void update(Customer entity) {
        String sql = "update Customer set discount_code = ?,zip = ?,name = ?,addressline1 = ?,addressline2 = ?,city = ?,state = ?,phone = ?,fax = ?,email = ?,credit_limit = ? where customer_id = ?";
        jdbcTemplate.update(sql, entity.getDiscountCode(),entity.getZip(),entity.getName(),entity.getAddressline1(),entity.getAddressline2(),entity.getCity(),entity.getState(),entity.getPhone(),entity.getFax(),entity.getEmail(),entity.getCreditLimit(),entity.getCustomerId());
        
    }
    
}
