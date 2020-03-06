package com.web.sales.dao;


import com.web.sales.models.PurchaseOrder;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class PurchaseOrderRepository implements CrudRepository<PurchaseOrder, Integer>{

    @Autowired
    private JdbcTemplate jdbcTemplate;
    
    @Override
    public void save(PurchaseOrder entity) {
        String sql = "insert into purchase_order(order_num,customer_id,product_id,quantity,shipping_cost,sales_date,shipping_date,freight_company) values(?,?,?,?,?,?,?,?)";
            jdbcTemplate.update(sql, entity.getOrderNum(),entity.getCustomerId(),entity.getProductId(),entity.getQuantity(),entity.getShippingCost(),entity.getSalesDate(),entity.getShippingDate(),entity.getFreightCompany());
    }

    @Override
    public Optional<PurchaseOrder> findById(Integer id) {
        String sql = "select * from purchase_order where order_num = ?";
        PurchaseOrder purchaseOrder = jdbcTemplate.queryForObject(sql, new Object[]{id},new BeanPropertyRowMapper<PurchaseOrder>(PurchaseOrder.class));
        return Optional.of(purchaseOrder);
    }

    @Override
    public boolean existsById(Integer id) {
        return findById(id).isPresent();
    }

    @Override
    public Iterable<PurchaseOrder> findAll() {
        String sql = "select * from purchase_order";
        List list = jdbcTemplate.query(sql, new BeanPropertyRowMapper<PurchaseOrder>(PurchaseOrder.class));
        return list;
    }

    @Override
    public void deleteById(Integer id) {
        String sql = "delete from purchase_order where order_num = ?";
        jdbcTemplate.update(sql,id);
        
    }

    @Override
    public void update(PurchaseOrder entity) {
        String sql = "update purchase_order set customer_id = ?,product_id = ?,quantity = ?,shipping_cost = ?,sales_date = ?,shipping_date = ?,freight_company = ? where order_num = ?";
        jdbcTemplate.update(sql, entity.getCustomerId(),entity.getProductId(),entity.getQuantity(),entity.getShippingCost(),entity.getSalesDate(),entity.getShippingDate(),entity.getFreightCompany(),entity.getOrderNum());
        
    }
    
}
