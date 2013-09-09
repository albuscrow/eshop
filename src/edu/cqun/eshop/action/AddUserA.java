package edu.cqun.eshop.action;

import java.io.IOException;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.ServletResponseAware;
import org.apache.struts2.interceptor.SessionAware;
import org.springframework.beans.factory.annotation.Autowired;

import com.opensymphony.xwork2.ActionSupport;

import edu.cqun.eshop.Iservice.ISystemUserManagerService;
import edu.cqun.eshop.domain.RoleList;
import edu.cqun.eshop.domain.User;


public class AddUserA extends ActionSupport  implements SessionAware, ServletRequestAware, ServletResponseAware{

	/**
	 * 增加新的系统用户
	 */
	private static final long serialVersionUID = -7977697013453779402L;

	@Autowired
	private ISystemUserManagerService systemUserManagerService;

	private Map att;
    private HttpServletRequest request;
    private HttpServletResponse response;

    
    @Override
	public String execute() {
		String username = request.getParameter("username");
		String name = request.getParameter("name");
		String pass=request.getParameter("pass");
		
		User user = new User();
		user.setName(name);
		user.setUser(username);
		user.setPassword(pass);
			
		if(systemUserManagerService.addSystemUser(user)){
			return SUCCESS;
		}
	    else{
		     return ERROR;
		} 
    	//return SUCCESS;
	}

	@Override
	public void setServletResponse(HttpServletResponse arg0) {
		this.response = arg0;
	}

	@Override
	public void setServletRequest(HttpServletRequest arg0) {
		this.request = arg0;
	}

	@Override
	public void setSession(Map<String, Object> arg0) {
		this.att = arg0;
	}
}
