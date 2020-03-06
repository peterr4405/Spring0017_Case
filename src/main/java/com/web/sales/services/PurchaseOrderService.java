package com.web.sales.services;

import com.web.sales.dao.PurchaseOrderRepository;
import com.web.sales.models.PurchaseOrder;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PurchaseOrderService {
    
    @Autowired
    private PurchaseOrderRepository dao;
    
    public List<PurchaseOrder> queryAll(){
        List<PurchaseOrder> list = new ArrayList<>();
        dao.findAll().forEach(data -> list.add(data));
       return list;
    }
    
    public void add(PurchaseOrder purchaseOrder){
        dao.save(purchaseOrder);
    }
    
    public PurchaseOrder get(Integer id){
        return dao.findById(id).get();
    }
    
    public boolean exists(Integer id){
        return dao.existsById(id);
    }
    
    public void delete(Integer id){
        dao.deleteById(id);
    }
    
    public void update(PurchaseOrder purchaseOrder){
        dao.update(purchaseOrder);
    }
    
}
