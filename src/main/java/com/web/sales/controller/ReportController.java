package com.web.sales.controller;

import com.web.sales.models.ReportCustomer;
import com.web.sales.models.ReportProduct;
import com.web.sales.services.ReportService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/report")
public class ReportController {

    @Autowired
    private ReportService service;

    @RequestMapping("/")
    public String input(Model model) {

        List<ReportCustomer> list_c = service.queryCustomers();
        List<ReportProduct> list_p = service.queryProducts();
        model.addAttribute("list_c", list_c);
        model.addAttribute("list_p", list_p);

        return "report";
    }

}
