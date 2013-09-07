package edu.cqun.eshop.forwordAction;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.ServletResponseAware;
import org.apache.struts2.interceptor.SessionAware;
import org.springframework.beans.factory.annotation.Autowired;

import com.opensymphony.xwork2.ActionSupport;

import edu.cqun.eshop.Iservice.ICommodityManagerService;

public class Main extends ActionSupport implements SessionAware,
		ServletRequestAware, ServletResponseAware {
	
	private Map att;
    private HttpServletRequest request;
    private HttpServletResponse response;
    
    @Autowired
    private ICommodityManagerService commodityManagerService;
    
    @Override
    public String execute()  {
    	att.put("commodities", commodityManagerService.getAllCommodities());
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
