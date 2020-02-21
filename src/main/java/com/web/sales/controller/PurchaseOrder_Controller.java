package com.web.sales.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/purchase_order")
public class PurchaseOrder_Controller {
    
    @RequestMapping("/input")
    public String input(){
        return "purchase_order";
    }
    
}
