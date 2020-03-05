package com.web.sales.services;

import com.web.sales.dao.LoginRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LoginService {
    
    @Autowired
    private LoginRepository dao;
    
   public boolean exists(String name,String pass){
        return dao.login(name, pass);
    }
    
    
}
