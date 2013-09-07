package edu.cqun.eshop.action;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.ServletResponseAware;
import org.apache.struts2.interceptor.SessionAware;
import org.springframework.beans.factory.annotation.Autowired;

import com.opensymphony.xwork2.ActionSupport;

import edu.cqun.eshop.Iservice.ICommodityManagerService;
import edu.cqun.eshop.Iservice.IUserManagerService;
import edu.cqun.eshop.domain.*;
import edu.cqun.eshop.service.CommodityManagerService;

public class GetCommodityAction extends ActionSupport implements SessionAware,
		ServletRequestAware, ServletResponseAware {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7977697013453779402L;

	@Autowired
	private ICommodityManagerService commodityService;

	private Map att;
	private HttpServletRequest request;
	private HttpServletResponse response;
	private List<Category> category;

	public List<Category> getCategory() {
		return category;
	}

	public void setCategory(List<Category> category) {
		this.category = category;
	}
	

	public String execute() {
		if (commodityService == null) {
			System.out.println("null!!!!!!!");
		}
		category=commodityService.getCategories();
		
		Commodity example = new Commodity();
		att.put("commodities", commodityService.getCommodities(example));
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
