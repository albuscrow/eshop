package edu.cqun.eshop.forwordAction;

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

public class UserLoginAction extends ActionSupport implements SessionAware,
		ServletRequestAware, ServletResponseAware {

	private Map att;
	private HttpServletRequest request;
	private HttpServletResponse response;
	
	@Autowired
	private IUserManagerService userManagerService;
	
	
	@Override
	public String execute()  {
		Buyer buyer = new Buyer();
		buyer.setUser(request.getParameter("username"));
		buyer.setPassword(request.getParameter("password"));
		response.setContentType("text/html;charset=utf-8");
		try {
			if (userManagerService.checkLogin(buyer)) {
				Buyer value = userManagerService.findUser(buyer).get(0);
				att.put("buyer", value);
				att.put("flag", "yes");
				response.getWriter().write("success:"+buyer.getUser());
			}else{
				response.getWriter().write("fail");
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	
	@Override
	public void setServletResponse(HttpServletResponse arg0) {
		response = arg0;
	}

	@Override
	public void setServletRequest(HttpServletRequest arg0) {
		request = arg0;
	}

	@Override
	public void setSession(Map<String, Object> arg0) {
		att = arg0;
	}

}
