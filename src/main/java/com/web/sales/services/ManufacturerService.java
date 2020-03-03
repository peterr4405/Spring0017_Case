package com.web.sales.services;


import com.web.sales.dao.ManufacturerrRepository;
import com.web.sales.models.Manufacturer;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ManufacturerService {
    
    @Autowired
    private ManufacturerrRepository dao;
    
    public List<Manufacturer> queryAll(){
        List<Manufacturer> list = new ArrayList<>();
        dao.findAll().forEach(data -> list.add(data));
       return list;
    }
    
    public void add(Manufacturer manufacturer){
        dao.save(manufacturer);
    }
    
    public Manufacturer get(Integer id){
        return dao.findById(id).get();
    }
    
    public boolean exists(Integer id){
        return dao.existsById(id);
    }
    
    public void delete(Integer id){
        dao.deleteById(id);
    }
    
    public void update(Manufacturer manufacturer){
        dao.update(manufacturer);
    }
    
}
