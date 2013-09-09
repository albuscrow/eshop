package edu.cqun.eshop.action;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
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
	private String goodsId;
	private String goodsName;
	private String categorySelect;

	public String getCategorySelect() {
		return categorySelect;
	}

	public void setCategorySelect(String categorySelect) {
		this.categorySelect = categorySelect;
	}

	private  List<Commodity> allCommodities;
	
	public String getGoodsId() {
		System.out.println("*****************************"+goodsId+":"+goodsName+"*****************************");
		return goodsId;
	}

	public void setGoodsId(String goodsId) {
		this.goodsId = goodsId;
	}

	public String getGoodsName() {
		System.out.println("*****************************"+goodsId+":"+goodsName+"*****************************");
		return goodsName;
	}

	public void setGoodsName(String goodsName) {
		this.goodsName = goodsName;
	}


	public List<Category> getCategory() {
		return category;
	}

	public void setCategory(List<Category> category) {
		this.category = category;
	}
	
	@Override
	public String execute() {
		category = commodityService.getCategories();
		allCommodities = commodityService.getAllCommodities();
		List<Commodity> result = new ArrayList<Commodity>();

//		Commodity example = new Commodity();
//		if (goodsId != null && !goodsId.equals("")) {
//			long commodityId = Long.parseLong(goodsId);
//			System.out.println("+++++=================" + commodityId+ "+++++==================");
//			example.setCommodityId(commodityId);
//		}
//
//		if (goodsName != null & goodsName != "") {
//			example.setName(goodsName);
//		}
//		att.put("commodities", commodityService.getCommodities(example));

//		goodsName = request.getParameter("goodsName");
//		if (goodsName != null & goodsName != "") {
//			example.setName(goodsName);
//		}
//		List<Commodity> result1 = commodityService.getCommodities(example);
//		if(goodsId.equals("")) goodsId=null;
//		if(goodsName.equals("")) goodsName=null;
		if ((goodsId == null) && (goodsName == null) && (categorySelect == "all" ||categorySelect == null)) {
			result = allCommodities;
		} else if (goodsId != null && !goodsId.equals("")) {
			Long commodityId = Long.parseLong(goodsId);
			result.add(commodityService.getCommodityById(commodityId));
		} else {
			for (Commodity commodity : allCommodities) {
				String commodityName = commodity.getName();
				if (commodityName.contains(goodsName)) {
					if (categorySelect.equals("all") ) {
						result.add(commodity);
					}else if(categorySelect.equals(commodity.getCategory().getCategoryId().toString()) ){
						result.add(commodity);
					}
				}
			}
		}

		att.put("commodities", result);
		att.put("category", category);

		System.out.println("_________________________________________________________");
		for (Commodity commodity : result) {
			System.out.println(commodity.getName());
		}
		System.out.println("_________________________________________________________");

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
