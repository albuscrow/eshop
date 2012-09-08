package edu.cqun.eshop.action;

import java.sql.Timestamp;
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
import edu.cqun.eshop.domain.Category;
import edu.cqun.eshop.domain.Commodity;

public class ModifyCommodityAction extends ActionSupport implements SessionAware,
ServletRequestAware, ServletResponseAware {
	@Autowired
	private ICommodityManagerService commodityService;
	private Commodity newCommodity;
	private List<Category> category;
	
	private Map att;
	private HttpServletRequest request;
	private HttpServletResponse response;
	
	private String name;
	private String price;
	private String discountprice;
	private String sales;
	private String rest;
	private String isRecommend;
	private String brand;
	private String categoryId;
	private String origin;
	private String regdate;
	private String introduction;
	private long currentid;
	private Commodity currentCommodity;

	public List<Category> getCategory() {
		return category;
	}
	
	public void setCategory(List<Category> category) {
		this.category = category;
	}
	
	@Override
	public String execute() {
		currentCommodity= (Commodity) att.get("current");
		currentid=currentCommodity.getCommodityId();
		name = request.getParameter("name");
		price = request.getParameter("price");
		discountprice = request.getParameter("discountprice");
		sales = request.getParameter("sales");
		rest = request.getParameter("rest");
		isRecommend = request.getParameter("isRecommend");
		brand = request.getParameter("brand");
		categoryId = request.getParameter("categorySelect");
		origin = request.getParameter("origin");
		regdate = request.getParameter("regdate");
		introduction = request.getParameter("introduction");
		
		try {
			double _price=Double.parseDouble(price);
			double _discountprice=Double.parseDouble(discountprice);
			Integer _sales=Integer.parseInt(sales);
			long _rest=Long.parseLong(rest);
			boolean _isRecommend=Boolean.parseBoolean(isRecommend);
			Timestamp _regdate=Timestamp.valueOf(regdate+" "+"00:00:00");
			long _categoryId=Long.parseLong(categoryId);
			boolean isSale=false;
			Category _category=new Category();
			
			if (_price < _discountprice) {
				isSale=true;
			}
			List<Category> categorylist=commodityService.getCategories();
			for (Category category : categorylist) {
				if (category.getCategoryId()==_categoryId) {
					_category=category;
				}
			}
			newCommodity=new Commodity();	
			newCommodity.setCommodityId(currentid);
			newCommodity.setName(name);
			newCommodity.setPrice(_price);
			newCommodity.setDiscountPrice(_discountprice);
			newCommodity.setSales(_sales);
			newCommodity.setRest(_rest);
			newCommodity.setIsRecommend(_isRecommend);
			newCommodity.setBrand(brand);
			newCommodity.setOrigin(origin);
			newCommodity.setIntroduction(introduction);
			newCommodity.setRegisterDate(_regdate);
			newCommodity.setCategory(_category);
			newCommodity.setIsSale(isSale);
			
			commodityService.modifyCommodity(newCommodity);
			
			att.put("commodities", commodityService.getAllCommodities());
			return SUCCESS;
		} catch (NumberFormatException e) {
			e.printStackTrace();
		}
		return "fail";
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

	

