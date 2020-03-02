package com.web.sales.dao;


import com.web.sales.models.MicroMarket;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class MicroMarketRepository implements CrudRepository<MicroMarket, String>{

    @Autowired
    private JdbcTemplate jdbcTemplate;
    
    @Override
    public void save(MicroMarket entity) {
        String sql = "insert into Micro_Market(zip_code,radius,area_length,area_width) values(?,?,?,?)";
            jdbcTemplate.update(sql, entity.getZipCode(),entity.getRadius(),entity.getAreaLength(),entity.getAreaWidth());
    }

    @Override
    public Optional<MicroMarket> findById(String id) {
        String sql = "select * from Micro_Market where zip_code = ?";
        MicroMarket microMarket = jdbcTemplate.queryForObject(sql, new Object[]{id},new BeanPropertyRowMapper<MicroMarket>(MicroMarket.class));
        return Optional.of(microMarket);
    }

    @Override
    public boolean existsById(String id) {
        return findById(id).isPresent();
    }

    @Override
    public Iterable<MicroMarket> findAll() {
        String sql = "select * from micro_market";
        List list = jdbcTemplate.query(sql, new BeanPropertyRowMapper<MicroMarket>(MicroMarket.class));
        return list;
    }

    @Override
    public void deleteById(String id) {
        String sql = "delete from micro_market where zip_code = ?";
        jdbcTemplate.update(sql,id);
        
    }

    @Override
    public void update(MicroMarket entity) {
        String sql = "update micro_market set radius = ?, area_length = ?, area_width = ? where zip_code = ?";
        jdbcTemplate.update(sql,entity.getRadius(),entity.getAreaLength(),entity.getAreaWidth(),entity.getZipCode());
        
    }
    
}
