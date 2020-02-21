package com.web.sales.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/product")
public class Product_Controller {
    
    @RequestMapping("/input")
    public String input(){
        return "product";
    }
    
}
