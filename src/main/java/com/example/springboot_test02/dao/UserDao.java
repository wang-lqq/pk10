package com.example.springboot_test02.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.example.springboot_test02.bean.User;
@Mapper
public interface UserDao {
	/**
	 * 注册用户
	 * 
	 * @param user
	 * @return
	 */
	int userAdd(User user);
	
	User queryByUsername(String username);
	
	User queryUser(@Param("username") String username,@Param("password") String password);
}
