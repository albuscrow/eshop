package edu.cqun.eshop.forwordAction;

import java.sql.Timestamp;
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

public class Regester extends ActionSupport implements SessionAware,
ServletRequestAware, ServletResponseAware{
	
	private Map att;
	private HttpServletRequest request;
	private HttpServletResponse response;
	
	@Autowired
	private IUserManagerService userManagerService;
	
	private Buyer buyer;

	public Buyer getBuyer() {
		return buyer;
	}

	public void setBuyer(Buyer buyer) {
		this.buyer = buyer;
	}
	
	@Override
	public String execute() {
		Timestamp d = new Timestamp(System.currentTimeMillis());
		buyer.setRegisterDate(d);
		if(userManagerService.regester(buyer)){
			att.put("flag", "yes");
			att.put("buyer", buyer);
			return SUCCESS;
		}else{
			att.put("error","用户已存在");
			return ERROR;
		}
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
