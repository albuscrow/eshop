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

import edu.cqun.eshop.Iservice.IPayWayManagerService;
import edu.cqun.eshop.Iservice.ISystemUserManagerService;


public class DPWAction extends ActionSupport  implements SessionAware, ServletRequestAware, ServletResponseAware{

	/**
	 * 删除付款方式
	 */
	private static final long serialVersionUID = -7977697013453779402L;

	@Autowired
	private IPayWayManagerService payWayManagerService;

	private Map att;
    private HttpServletRequest request;
    private HttpServletResponse response;

    
    @Override
	public String execute() {
		String payIdr = request.getParameter("payId");
		long payId = Long.parseLong(payIdr);
		
		if(payWayManagerService.deletePay(payId)){
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
