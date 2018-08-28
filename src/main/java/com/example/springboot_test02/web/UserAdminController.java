package com.example.springboot_test02.web;

import java.util.HashMap;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
@Controller
public class UserAdminController {
	/**
     * 
     * @param map
     * @return
     */
    @RequestMapping("/register")
    public String helloHtml(HashMap<String, Object> map) {
        return "register";
    }
    
    
    /**
     * 
     * @param map
     * @return
     */
    @RequestMapping("/login")
    public String login(){
        return "login";
    }
    
    /**
     * 
     * @param map
     * @return
     */
    @RequestMapping("/index")
    public String index(){
        return "index";
    }
}
