package edu.cqun.eshop.action;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.ServletResponseAware;
import org.apache.struts2.interceptor.SessionAware;
import org.springframework.beans.factory.annotation.Autowired;

import com.opensymphony.xwork2.ActionSupport;

import edu.cqun.eshop.Iservice.ICommodityManagerService;
import edu.cqun.eshop.Iservice.IImportListManagerService;
import edu.cqun.eshop.Iservice.IOtherPayManagerService;

public class GetOtherPayAction extends ActionSupport implements SessionAware,
ServletRequestAware, ServletResponseAware{

	/**
	 * 
	 */
	private static final long serialVersionUID = -7977697013453779402L;

	@Autowired
	IOtherPayManagerService iOtherPayManagerService;

	private Map att;
	private HttpServletRequest request;
	private HttpServletResponse response;

	public String execute() {
//		if (commodityService == null) {
//			System.out.println("null!!!!!!!");
//		}
		att.put("otherPays", iOtherPayManagerService.getAllOtherPay());
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
