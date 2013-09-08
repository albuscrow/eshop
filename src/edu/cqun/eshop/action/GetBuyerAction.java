package edu.cqun.eshop.action;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.ServletResponseAware;
import org.apache.struts2.interceptor.SessionAware;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ActionSupport;

import edu.cqun.eshop.Iservice.IUserManagerService;


public class GetBuyerAction extends ActionSupport  implements SessionAware, ServletRequestAware, ServletResponseAware{

	/**
	 * 查出所有买家
	 */
	private static final long serialVersionUID = -7977697013453779402L;

	@Autowired
	private IUserManagerService userManagerService;

	private Map att;
    private HttpServletRequest request;
    private HttpServletResponse response;

    
    @Override
	public String execute() {
		att.put("buyers", userManagerService.getAllUser());
		
		return SUCCESS;
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
