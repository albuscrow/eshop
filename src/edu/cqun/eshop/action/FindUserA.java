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

import edu.cqun.eshop.Iservice.ISystemUserManagerService;
import edu.cqun.eshop.Iservice.IUserManagerService;


public class FindUserA extends ActionSupport  implements SessionAware, ServletRequestAware, ServletResponseAware{

	/**
	 * 取得所有系统用户信息
	 */
	private static final long serialVersionUID = -7977697013453779402L;

	@Autowired
	private ISystemUserManagerService systemUserManagerService;

	private Map att;
    private HttpServletRequest request;
    private HttpServletResponse response;

    
    @Override
	public String execute() {
		String uidr = request.getParameter("userId");
		long uid = Long.parseLong(uidr);
		att.put("user", systemUserManagerService.findUser(uid));
		if(systemUserManagerService.getAllUser().isEmpty())
			return ERROR;
		else
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
