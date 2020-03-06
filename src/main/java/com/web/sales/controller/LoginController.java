package com.web.sales.controller;

import com.web.sales.models.User;
import com.web.sales.services.LoginService;
import javax.websocket.server.PathParam;
import org.springframework.stereotype.Controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

@Controller
@RequestMapping("/login")
public class LoginController {

    @Autowired
    private LoginService service;

   
    @PostMapping("/check")
    public String LoginorNot(@PathParam("User") User user) {
        String name = user.getName();
        String pass = user.getPassword();

        if (service.exists(name, pass)) {

        } else {

        }

        return "redirect:./login.jsp";

    }

}
