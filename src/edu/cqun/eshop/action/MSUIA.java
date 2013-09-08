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


public class MSUIA extends ActionSupport  implements SessionAware, ServletRequestAware, ServletResponseAware{

	/**
	 * 修改系统用户基本信息
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
		
		String roleidr = request.getParameter("role_id");
		long roleid = Long.parseLong(roleidr);
		
		String username = request.getParameter("username");
		
		String name = request.getParameter("name");
		
		if(systemUserManagerService.modifySystemUserInfo(uid, roleid, username,name)){
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
