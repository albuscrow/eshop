package edu.cqun.eshop.action;

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

public class BuyerDetailAction extends ActionSupport implements SessionAware,
		ServletRequestAware,ServletResponseAware {

	@Autowired
	private IUserManagerService userManagerService;

	private Map att;
    private HttpServletRequest request;
    private HttpServletResponse response;
    private Buyer buyer;
    
    public Buyer getBuyer() {
		return buyer;
	}


	public void setBuyer(Buyer buyer) {
		this.buyer = buyer;
	}


	@Override
    public String execute()  {
    	// TODO Auto-generated method stub
    	buyer = userManagerService.findUserById(Long.parseLong(request.getParameter("buyerId")));
    	att.put("currentBuyer", buyer);
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
