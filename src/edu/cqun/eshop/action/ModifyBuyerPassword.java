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

import edu.cqun.eshop.Iservice.IUserManagerService;
import edu.cqun.eshop.domain.Buyer;
import edu.cqun.eshop.service.UserManagerService;

public class ModifyBuyerPassword extends ActionSupport implements SessionAware,
ServletRequestAware,ServletResponseAware{
	
	private Map att;
    private HttpServletRequest request;
    private HttpServletResponse response;
    
    private String password;
    
    public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Autowired
    private IUserManagerService userManagerService;
    
    @Override
    public String execute() {
    	Buyer currentBuyer = (Buyer) att.get("currentBuyer");
    	try {
    		userManagerService.modifypassword(currentBuyer.getBuyerId(), currentBuyer.getPassword(), password);
    		response.setContentType("text/html;charset=utf-8");
    		response.getWriter().write("success!");
		} catch (Exception e) {
			try {
				response.getWriter().write("fail!");
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
    	return null;
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
