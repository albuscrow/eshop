package edu.cqun.eshop.action;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.ServletResponseAware;
import org.apache.struts2.interceptor.SessionAware;


import com.opensymphony.xwork2.ActionSupport;

import edu.cqun.eshop.domain.Category;
import edu.cqun.eshop.domain.Commodity;
import edu.cqun.eshop.service.CommodityManagerService;

public class AddCommodityAction extends ActionSupport implements SessionAware,
ServletRequestAware, ServletResponseAware {
	
	private CommodityManagerService commodityService;
	private Commodity newCommodity;
	private List<Category> category;

	Map att;

	public List<Category> getCategory() {
		return category;
	}

	public void setCategory(List<Category> category) {
		this.category = category;
	}
	
	public String execute() {
		category=commodityService.getCategories();
		return SUCCESS;
	}

	@Override
	public void setServletResponse(HttpServletResponse arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setServletRequest(HttpServletRequest arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setSession(Map<String, Object> arg0) {
		// TODO Auto-generated method stub
		
	}

}
