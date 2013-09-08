package edu.cqun.eshop.action;

import java.io.IOException;
import java.util.Map;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.ServletResponseAware;
import org.apache.struts2.interceptor.SessionAware;
import org.springframework.beans.factory.annotation.Autowired;

import com.opensymphony.xwork2.ActionSupport;
import com.sun.jmx.snmp.Timestamp;

import edu.cqun.eshop.Iservice.IUserManagerService;
import edu.cqun.eshop.domain.Buyer;
import edu.cqun.eshop.domain.Delivery;
import edu.cqun.eshop.domain.OrderList;
import edu.cqun.eshop.domain.RoleList;
import edu.cqun.eshop.domain.User;


public class MBPA extends ActionSupport  implements SessionAware, ServletRequestAware, ServletResponseAware{

	/**
	 * 修改买家密码
	 */
	private static final long serialVersionUID = -7977697013453779402L;

	@Autowired
	private IUserManagerService userManagerService;

	private Map att;
    private HttpServletRequest request;
    private HttpServletResponse response;

    
    @Override
	public String execute() {
		String buyerIdr = request.getParameter("buyerId");
		long buyerId = Long.parseLong(buyerIdr);
		
		String old_pass = request.getParameter("old_pass");
		String new_pass = request.getParameter("new_pass");
		
		if(userManagerService.modifypassword(buyerId, old_pass, new_pass)){
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
