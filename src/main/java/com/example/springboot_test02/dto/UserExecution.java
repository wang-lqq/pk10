package com.example.springboot_test02.dto;

import java.util.List;

import com.example.springboot_test02.bean.User;
import com.example.springboot_test02.enums.UserEnums;

public class UserExecution {
	private int state;
	
	private String stateInfo;
	
	private User user;
	
	private List<User> userList;
	
	private int count;

	public UserExecution() {
	}
	
	
	
	public UserExecution(UserEnums userEnums) {
		this.state = userEnums.getState();
		this.stateInfo = userEnums.getStateInfo();
	}



	public UserExecution(UserEnums userEnums, User user) {
		this.state = userEnums.getState();
		this.stateInfo = userEnums.getStateInfo();
		this.user = user;
	}



	public int getState() {
		return state;
	}

	public void setState(int state) {
		this.state = state;
	}

	public String getStateInfo() {
		return stateInfo;
	}

	public void setStateInfo(String stateInfo) {
		this.stateInfo = stateInfo;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public List<User> getUserList() {
		return userList;
	}

	public void setUserList(List<User> userList) {
		this.userList = userList;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}
	
	
}
