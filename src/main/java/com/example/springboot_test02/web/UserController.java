package com.example.springboot_test02.web;


import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.springboot_test02.bean.User;
import com.example.springboot_test02.dto.UserExecution;
import com.example.springboot_test02.enums.UserEnums;
import com.example.springboot_test02.service.UserService;

@Controller
public class UserController {
	@Autowired
	UserService userService;
    
    @PostMapping("/user")
    @ResponseBody
    public Map<String, Object> userAdd(User user) {
    	Map<String, Object> model=new HashMap<String, Object>();
    	//校验
    	if(user==null || user.getUsername()==null || user.getUsername().equals("") ||
    			user.getPassword()==null ||user.getPassword().equals("")) {
    		model.put("success", false);
    		model.put("errMsg", "请输入完整信息");
    		return model;
    	}
    	UserExecution userExecution = userService.userAdd(user);
    	if(userExecution.getStateInfo().equals(UserEnums.SUCCESS.getStateInfo())) {
    		model.put("success", true);
    		model.put("errMsg", userExecution.getStateInfo());
    	}else {
    		model.put("success", false);
    		model.put("errMsg", userExecution.getStateInfo());
    	}
    	return model;
    }
    
    /**
     * 判断用户名是否存在
     * @param user
     * @return
     */
    @GetMapping("/user/judgeusername")
    @ResponseBody
    public Map<String, Object> judgeUsername(@RequestParam(value="username") String username) {
    	Map<String, Object> model=new HashMap<String, Object>();
    	User user=userService.queryByUsername(username);
    	if(user==null) {
    		model.put("success", true);
    	}else {
    		model.put("success", false);
    	}
    	return model;
    }
    
    /**
     * 登录
     * 
     * @param user
     * @return
     */
    @PostMapping("/user/login")
    public String queryUser(@RequestParam(value="username") String username,
    			@RequestParam(value="password") String password,Model model) {
    	//登录
    	User user=userService.queryUser(username, password);
    	if(user==null) {
    		//重定向到注册页面
    		return "redirect:/login";
    	}else {
    		//
    		model.addAttribute("username", user.getUsername());
    		
    		return "index";
    	}
    }
}
