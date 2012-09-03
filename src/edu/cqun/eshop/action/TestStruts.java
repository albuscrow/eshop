package edu.cqun.eshop.action;

import com.opensymphony.xwork2.ActionSupport;

import edu.cqun.eshop.domain.User;

public class TestStruts extends ActionSupport{
	private User user;

	public User getUser() {
		return user;
	}



	public void setUser(User user) {
		this.user = user;
	}



	public String execute(){
		//name = "hello," + name + "!";
		return SUCCESS;
	}

}
