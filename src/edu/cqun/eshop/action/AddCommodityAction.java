package edu.cqun.eshop.action;
import java.util.List;
import java.util.Map;


import com.opensymphony.xwork2.ActionSupport;

import edu.cqun.eshop.domain.Category;
import edu.cqun.eshop.domain.Commodity;
import edu.cqun.eshop.service.CommodityManagerService;

public class AddCommodityAction extends ActionSupport{
	
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

}
