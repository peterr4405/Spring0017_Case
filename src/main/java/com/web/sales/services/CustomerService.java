package com.web.sales.services;

import com.web.sales.dao.CustomerRepository;
import com.web.sales.models.Customer;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CustomerService {
    
    @Autowired
    private CustomerRepository dao;
    
    public List<Customer> queryAll(){
        List<Customer> list = new ArrayList<>();
        dao.findAll().forEach(data -> list.add(data));
       return list;
    }
    
    public void add(Customer customer){
        dao.save(customer);
    }
    
    public Customer get(Integer id){
        return dao.findById(id).get();
    }
    
    public boolean exists(Integer id){
        return dao.existsById(id);
    }
    
    public void delete(Integer id){
        dao.deleteById(id);
    }
    
    public void update(Customer customer){
        dao.update(customer);
    }
    
}
