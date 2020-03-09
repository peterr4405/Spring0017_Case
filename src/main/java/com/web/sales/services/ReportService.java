package com.web.sales.services;

import com.web.sales.dao.ReportRepository;
import com.web.sales.models.ReportCustomer;
import com.web.sales.models.ReportProduct;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ReportService {

    @Autowired
    private ReportRepository dao;

    public List<ReportCustomer> queryCustomers() {
        List<ReportCustomer> list = new ArrayList<>();
        dao.getCustomers().forEach(data -> list.add(data));
        return list;
    }

    public List<ReportProduct> queryProducts() {
        List<ReportProduct> list = new ArrayList<>();
        dao.getProducts().forEach(data -> list.add(data));
        return list;
    }

    public ReportCustomer getCustomer(Integer id) {
        return dao.C_findById(id).get();
    }

    public ReportProduct getProduct(Integer id) {
        return dao.P_findById(id).get();
    }

    public boolean c_exists(Integer id) {
        return dao.C_existsById(id);
    }

    public boolean p_exists(Integer id) {
        return dao.P_existsById(id);
    }

}
