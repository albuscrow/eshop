package edu.cqun.eshop.action;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ActionSupport;

import edu.cqun.eshop.domain.User;

@Controller
public class TestStruts extends ActionSupport{
	private User user;
	
	@Autowired
	

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
