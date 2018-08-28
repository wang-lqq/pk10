package com.example.springboot_test02.service;

import org.apache.ibatis.annotations.Param;

import com.example.springboot_test02.bean.User;
import com.example.springboot_test02.dto.UserExecution;

public interface UserService {
	/**
	 * 注册用户
	 * 1.判断用户名是否存在2.注册用户
	 * 
	 * @param user
	 * @return
	 */
	UserExecution userAdd(User user);
	
	User queryByUsername(String username);
	
	User queryUser(String username,String password);
}
