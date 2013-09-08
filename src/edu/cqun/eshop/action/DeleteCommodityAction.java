package edu.cqun.eshop.action;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.ServletResponseAware;
import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;

public class DeleteCommodityAction extends ActionSupport implements SessionAware,
		ServletRequestAware, ServletResponseAware{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1332656397617449886L;
	
	private Map att;
	private HttpServletRequest request;
	private HttpServletResponse response;
	
	private String commodityId;
	
	public String getCommodityId() {
		return commodityId;
	}

	public void setCommodityId(String commodityId) {
		this.commodityId = commodityId;
	}

	public String execute() {
	
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


	