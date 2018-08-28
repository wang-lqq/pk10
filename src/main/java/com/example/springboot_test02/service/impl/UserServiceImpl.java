package com.example.springboot_test02.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.springboot_test02.bean.User;
import com.example.springboot_test02.dao.UserDao;
import com.example.springboot_test02.dto.UserExecution;
import com.example.springboot_test02.enums.UserEnums;
import com.example.springboot_test02.service.UserService;

@Service
public class UserServiceImpl implements UserService {
	@Autowired
	UserDao userDao;

	@Override
	public UserExecution userAdd(User user) {
		// 1.判断用户名是否存在2.注册用户
		// 判断用户名是否存在
		try {
			User u = userDao.queryByUsername(user.getUsername());
			if (u == null) {
				// 注册用户
				int effectedNum = userDao.userAdd(user);
				if (effectedNum > 0) {
					return new UserExecution(UserEnums.SUCCESS, user);
				} else {
					return new UserExecution(UserEnums.ERROR_SYSTEM);
				}
			} else {
				// 用户民存在
				return new UserExecution(UserEnums.REPEAT_UASERNAME);
			}
		} catch (Exception e) {
			e.printStackTrace();
			return new UserExecution(UserEnums.ERROR_SYSTEM);
		}
	}

	@Override
	public User queryByUsername(String username) {
		return userDao.queryByUsername(username);
	}

	@Override
	public User queryUser(String username, String password) {
		return userDao.queryUser(username, password);
	}
}
