package edu.cqun.eshop.action;

import com.opensymphony.xwork2.ActionSupport;

public class TestStruts extends ActionSupport{
	private String name;
	private String password;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String execute(){
		name = "hello," + name + "!";
		return SUCCESS;
	}

}
