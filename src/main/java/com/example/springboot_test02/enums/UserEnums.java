package com.example.springboot_test02.enums;

import com.alibaba.druid.sql.visitor.functions.If;

public enum UserEnums {
	SUCCESS(1000,"操作成功"),REPEAT_UASERNAME(-1001,"用户名存在"),ERROR_SYSTEM(-1002,"系统错误");
	
	private int state;
	
	private String stateInfo;

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

	private UserEnums(int state, String stateInfo) {
		this.state = state;
		this.stateInfo = stateInfo;
	}
	
	// 普通方法
    public static UserEnums getName(int state) {
        for (UserEnums userEnums : UserEnums.values()) {
	        if (userEnums.getState() == state) {
	            return userEnums;
	        }
        }
        return null;
    }
	
}
